package com.example.demo.pokemon.application;

import java.util.Map;

import com.example.demo.pokemon.service.PokemonService;

/**
 * @author Ibrahim Mattus Neto
 *
 */
public class AddPokemon {
	private static PokemonService pokeService = new PokemonService();
	
	/** Add new pokemon to the list
	 * @param parameter, it should contain the number, name, types and pre evolution of a pokemon
	 * @return
	 */
	public boolean addPokemon(Map<String, String> parameter) {
		return pokeService.addPokemon(parameter);
	}

}
