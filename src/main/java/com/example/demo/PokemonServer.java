package com.example.demo;

import java.util.List;

//XXX Server 
public class PokemonServer {
	private static BillsPC bpc = new BillsPC();

	public List<Pokemon> getAll() {
		return bpc.getAll();
	}

	public List<Pokemon> getAllNamed(List<Pokemon> pokemon, String nome) {
		return bpc.getAllNamed(pokemon, nome);
	}

	public List<Pokemon> getAllEvolution(List<Pokemon> pokemon) {
		return bpc.getAllEvolution(pokemon);
	}
}
