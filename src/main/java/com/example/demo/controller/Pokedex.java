package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pokemon;
import com.example.demo.entities.enums.PokemonType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@RestController
@RequestMapping(value = "/pokedex", method = RequestMethod.GET, produces = "application/json")
public class Pokedex {

	@GetMapping
	public String listaPokemon(@RequestParam Map<String, String> parametros) throws JsonProcessingException {

		List<Pokemon> pokedex = new ArrayList<>();

		geraPokedex(pokedex);

		for (String parametro : parametros.keySet()) {
			// parametro terá o nome do parametro
			// ex: http://localhost:8080/pokedex?nome=Bulbasaur
			// parametro é 'nome' e o conteudo é 'Bulbasaur'
			parametros.get(parametro); // retorna o conteudo do parametro
			// se não tem a chave/nome do campo retorna null
		}

		List<Pokemon> pokemon = pokedex;

		if (parametros.get("nome") != null) {
			pokemon = filtraNome(pokemon, parametros.get("nome"));
		}
		if (parametros.get("evolui") != null) {
			pokemon = filtraEvolucao(pokemon);
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

//		for (Pokemon poke : pokemon) {
//			for (int i = 0; i < poke.getEvolution().size(); i++) {
//				poke.removeEvolution(poke.getEvolution().get(i));
//			}
//
//		}

		String json = mapper.writeValueAsString(pokemon);
		json = mapper.writeValueAsString(pokemon.toArray());

		return json;

//		return pokemon.toString();
	}

	public List<Pokemon> filtraEvolucao(List<Pokemon> pokemon) {
		List<Pokemon> pokeFiltro = new ArrayList<>();
		Pokemon pokeAux;
		
		for (Pokemon poke : pokemon) {

			if (poke.getEvolution().size() > 0) {

//				while (poke.getEvolution().size() > 0) {
				if (pokeFiltro.contains(poke) == false) {
					boolean pokeFind = false;
					
					for (int i = 0; i < pokeFiltro.size(); i++) {
						pokeAux = pokeFiltro.get(i);
						for (int j = 0; j < pokeAux.getEvolution().size(); j++) {
							
							if(pokeAux.equals(poke)) {
								pokeFind = true;
							}

							pokeAux = pokeAux.getEvolution().get(j);
						}
					}
					if (pokeFind == false) {
						pokeFiltro.add(poke);
					}
					for (int i = 0; i < poke.getEvolution().size(); i++) {
						poke = poke.getEvolution().get(i);
						if (poke.getEvolution().size() <= 0) {
							pokeFiltro.add(poke);
						}
					}
				}
			}
		}

		return pokeFiltro;
	}

	public List<Pokemon> filtraNome(List<Pokemon> pokemon, String nome) {
		List<Pokemon> pokeFiltro = new ArrayList<>();
		for (Pokemon poke : pokemon) {
			if (poke.getName().indexOf(nome) != -1) {
				pokeFiltro.add(poke);
			}
		}
		return pokeFiltro;
	}

	public void geraPokedex(List<Pokemon> pokemon) {

		Pokemon p = new Pokemon(1, "Bulbasaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		p = new Pokemon(2, "Ivysaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
//		pokemon.get(pokemon.size()-2).addEvolution(2);
		pokemon.get(pokemon.size() - 2).addEvolution(p);
		p = new Pokemon(3, "Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
//		pokemon.get(pokemon.size()-2).addEvolution(3);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(4, "Charmander");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);

		p = new Pokemon(5, "Charmeleon");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
//		pokemon.get(pokemon.size()-2).addEvolution(5);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(6, "CHARIZARD");
		p.addType(PokemonType.valueOf("FIRE"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
//		pokemon.get(pokemon.size()-2).addEvolution(6);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(7, "Squirtle");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(8, "Wartortle");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(9, "Blastoise");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(10, "Caterpie");
		p.addType(PokemonType.valueOf("BUG"));
		pokemon.add(p);

	}

}
