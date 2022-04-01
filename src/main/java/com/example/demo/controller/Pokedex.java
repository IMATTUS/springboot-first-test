package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.application.PokemonApp;
import com.example.demo.entities.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//XXX Controller

@RestController
@RequestMapping(value = "/pokedex", method = RequestMethod.GET, produces = "application/json")
public class Pokedex {

	@GetMapping
	public String trataRequisicao(@RequestParam Map<String, String> parametros) throws JsonProcessingException {

		for (String parametro : parametros.keySet()) {
			// parametro terá o nome do parametro
			// ex: http://localhost:8080/pokedex?nome=Bulbasaur
			// parametro é 'nome' e o conteudo é 'Bulbasaur'
			parametros.get(parametro); // retorna o conteudo do parametro
			// se não tem a chave/nome do campo retorna null
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = null;

		List<Pokemon> pokedex = new ArrayList<>();
		PokemonApp pokeApp = new PokemonApp();

		pokedex = pokeApp.getAll();
		if (parametros.size() == 0) {
			json = mapper.writeValueAsString(pokedex.toArray());
		}

		if (parametros.get("nome") != null) {
			pokedex = pokeApp.getAllNamed(pokedex, parametros.get("nome"));
			json = mapper.writeValueAsString(pokedex.toArray());
		}
		if (parametros.get("evolui") != null) {
			pokedex = pokeApp.getAllEvolution(pokedex);
			json = mapper.writeValueAsString(pokedex.toArray());
		}

//		return pokedex.toString();
		return json;

	}

}
