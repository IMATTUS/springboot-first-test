package com.example.demo.pokemon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
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

	@Autowired
	private AddPokemon addPokemon;
	
	@Autowired
	private GetPokemon getPokemon;
	
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

		
//		GetPokemon pokeApp = new GetPokemon();

		pokedex = getPokemon.findAll();
		if (parameter.size() == 0) {
			json = mapper.writeValueAsString(pokedex.toArray());
		}

		if (parameter.get("name") != null && parameter.get("evolve") == null) {
			pokedex = getPokemon.findAll(pokedex, parameter.get("name"));
			json = mapper.writeValueAsString(pokedex.toArray());
		}
		if (parameter.get("evolve") != null && parameter.get("name") == null ) {
			pokedex = getPokemon.findAll(pokedex, true);
			json = mapper.writeValueAsString(pokedex.toArray());
		}
		if (parameter.get("evolve") != null && parameter.get("name") != null ) {
			pokedex = getPokemon.findAll(pokedex, parameter.get("name"),true);
			json = mapper.writeValueAsString(pokedex.toArray());
		}

//		return pokedex.toString();
		return json;

	}
	
	@RequestMapping(value = "/pokemons", method = RequestMethod.POST, consumes = "application/json",
			produces = "application/json")
//	public String trataRequisicaoPost(@RequestBody String body) throws JsonProcessingException {
	public ResponseEntity<?> create(@RequestBody String body) throws JsonProcessingException {
//		Map<String, Object> body
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
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = null;
		
		Pokemon poke = mapper.readValue(body, Pokemon.class);
		
		//XXX receber json, não funciona com "parameter"
		//XXX passar apenas objeto do dominio-> Pokemon
		
//		AddPokemon pokeApp = new AddPokemon();
		
		if(!body.isEmpty()) {
//			sb.append(addPokemon.addPokemon(poke));
		    if(addPokemon.addPokemon(poke)) {
		        return new ResponseEntity<>(HttpStatus.CREATED);
		        
		    } 
		} 
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	
		
//		json = mapper.writeValueAsString(sb.toString());
//		
//		//XXX Retornar status code 201
//		return json;
	}

}
