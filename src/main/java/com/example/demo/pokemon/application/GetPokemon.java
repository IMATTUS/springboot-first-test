package com.example.demo.pokemon.application;

import java.util.List;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.service.PokemonService;

//XXX Application
public class GetPokemon {
	private static PokemonService pokeServer = new PokemonService();

	public List<Pokemon> getAll() {

		return pokeServer.getAll();
	}

	public List<Pokemon> getAll(List<Pokemon> pokemon, String nome) {

		return pokeServer.getAll(pokemon, nome);
	}

	public List<Pokemon> getAll(List<Pokemon> pokemon, boolean evoluir) {

		return pokeServer.getAll(pokemon, evoluir);
	}
}
