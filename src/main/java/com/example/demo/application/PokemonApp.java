package com.example.demo.application;

import java.util.List;

import com.example.demo.entities.Pokemon;
import com.example.demo.server.PokemonServer;

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
