package com.example.demo.server;

import java.util.List;

import com.example.demo.entities.Pokemon;
import com.example.demo.repository.BillsPC;

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
