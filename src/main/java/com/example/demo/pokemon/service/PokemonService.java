package com.example.demo.pokemon.service;

import java.util.List;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.repository.BillsPC;

//XXX Server 
public class PokemonService {
	private static BillsPC bpc = new BillsPC();

	public List<Pokemon> getAll() {
		return bpc.getAll();
	}

	public List<Pokemon> getAll(List<Pokemon> pokemon, String nome) {
		return bpc.getAll(pokemon, nome);
	}

	public List<Pokemon> getAll(List<Pokemon> pokemon, boolean evoluir) {
		return bpc.getAll(pokemon, evoluir);
	}
}
