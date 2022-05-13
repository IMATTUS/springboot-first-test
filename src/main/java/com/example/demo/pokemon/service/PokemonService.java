package com.example.demo.pokemon.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.repository.BillsPC;

//XXX Server 
/** 
 * @author Ibrahim Mattus Neto
 *
 */
@Service
public class PokemonService {
//	private static BillsPC bpc = new BillsPC();
	@Autowired
	private BillsPC bpc;

	/** Get all the Pokemons in the pokedex, no filters
	 * @return a full list of Pokemons
	 */
	public List<Pokemon> getAll() {
		return bpc.getAll();
	}

	/** Gets a list of Pokemons that the name contains the string nome
	 * @param pokemon the list of Pokemon to apply the name filter
	 * @param name the name to use as filter
	 * @return a list of Pokemons with the name filtered by the string nome
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, String name) {
		return bpc.getAll(pokemon, name);
	}

	/** Gets a list of Pokemons that has evolutions (from basic stage to the last)
	 * @param pokemon the list of Pokemons to filter from
	 * @param evolve boolean indicating if we must filter by evolution or not
	 * @return a list of Pokemons that have evolutions
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, boolean evolve) {
		return bpc.getAll(pokemon, evolve);
	}
	
	/** Add new pokemon to the list
	 * @param parameter, it should contain the number, name, types and pre evolution of a pokemon
	 * @return
	 */
	public boolean addPokemon(Pokemon poke) {
		return bpc.addPokemon(poke);
	}
}
