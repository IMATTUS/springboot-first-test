package com.example.demo;

import java.util.List;

//XXX Application
public class PokemonApp {
	private static PokemonServer pokeServer = new PokemonServer();

	public List<Pokemon> getAll() {

		return pokeServer.getAll();
	}

	public List<Pokemon> getAllNamed(List<Pokemon> pokemon, String nome) {

		return pokeServer.getAllNamed(pokemon, nome);
	}

	public List<Pokemon> getAllEvolution(List<Pokemon> pokemon) {

		return pokeServer.getAllEvolution(pokemon);
	}
}
