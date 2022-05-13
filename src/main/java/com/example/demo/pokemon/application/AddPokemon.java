package com.example.demo.pokemon.application;

import com.example.demo.pokemon.entities.Pokemon;
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
	public boolean addPokemon(Pokemon poke) {
		return pokeService.addPokemon(poke);
	}
	
}
