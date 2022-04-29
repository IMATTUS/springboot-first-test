package com.example.demo.pokemon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pokemon.application.AddPokemon;
import com.example.demo.pokemon.application.GetPokemon;
import com.example.demo.pokemon.entities.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//XXX Controller

/**
 * @author Ibrahim Mattus Neto
 *
 */
@RestController
public class Pokedex {

	private static List<Pokemon> pokedex = new ArrayList<>();
	
	/** Will interpret the request in /pokedex and will provide the appropriate response
	 * @param parameter the get query string
	 * @return the response to the request on /pokedex
	 * @throws JsonProcessingException
	 */
	
	@RequestMapping(value = "/pokemons", method = RequestMethod.GET, produces = "application/json")
	public String trataRequisicao(@RequestParam Map<String, String> parameter) throws JsonProcessingException {

//		if I need to loop through the parameters I can use the for below
//		keeping for reference.
//		for (String param : parameter.keySet()) {
//			// param will have the name of the parameter
//			// ex: http://localhost:8080/pokedex?name=Bulbasaur
//			// parameter is 'name' and content is 'Bulbasaur'
//			// ex: http://localhost:8080/pokedex?evolve
//			// parameter is 'evolve'
//			parameter.get(param); // returns the content of param
//			// if there is no key/name of field it returns null
//		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = null;

		
		GetPokemon pokeApp = new GetPokemon();

		pokedex = pokeApp.getAll();
		if (parameter.size() == 0) {
			json = mapper.writeValueAsString(pokedex.toArray());
		}

		if (parameter.get("name") != null) {
			pokedex = pokeApp.getAll(pokedex, parameter.get("name"));
			json = mapper.writeValueAsString(pokedex.toArray());
		}
		if (parameter.get("evolve") != null) {
			pokedex = pokeApp.getAll(pokedex, true);
			json = mapper.writeValueAsString(pokedex.toArray());
		}

//		return pokedex.toString();
		return json;

	}
	
	@RequestMapping(value = "/pokemons", method = RequestMethod.POST, produces = "application/json")
	public String trataRequisicaoPost(@RequestParam Map<String, String> parameter) throws JsonProcessingException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("");
		
//		for (String param : parameter.keySet()) {
//		// param will have the name of the parameter
//		// ex: http://localhost:8080/pokedex?name=Bulbasaur
//		// parameter is 'name' and content is 'Bulbasaur'
//		// ex: http://localhost:8080/pokedex?evolve
//		// parameter is 'evolve'
//		parameter.get(param); // returns the content of param
//		sb.append(param + " - " + parameter.get(param) + "\n");
//		
//		// if there is no key/name of field it returns null
//		}
		
		AddPokemon pokeApp = new AddPokemon();
		if(!parameter.isEmpty()) {
			sb.append(pokeApp.addPokemon(parameter));
		} 
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = null;
		json = mapper.writeValueAsString(sb.toString());
		
		return json;
	}

}
