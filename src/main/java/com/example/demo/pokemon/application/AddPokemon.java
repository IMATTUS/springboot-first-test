package com.example.demo.pokemon.application;

import java.util.Map;

import com.example.demo.pokemon.service.PokemonService;

public class AddPokemon {
	private static PokemonService pokeService = new PokemonService();
	
	public boolean addPokemon(Map<String, String> parameter) {
		return pokeService.addPokemon(parameter);
	}

}
