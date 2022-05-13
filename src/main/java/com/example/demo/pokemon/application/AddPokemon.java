package com.example.demo.pokemon.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.service.PokemonService;

/**
 * @author Ibrahim Mattus Neto
 *
 */
@Service
public class AddPokemon {
//	private static PokemonService pokeService = new PokemonService();
	
	@Autowired
	private PokemonService pokeService;
	
	/** Add new pokemon to the list
	 * @param parameter, it should contain the number, name, types and pre evolution of a pokemon
	 * @return
	 */
	public boolean addPokemon(Pokemon poke) {
		return pokeService.addPokemon(poke);
	}
	
}
