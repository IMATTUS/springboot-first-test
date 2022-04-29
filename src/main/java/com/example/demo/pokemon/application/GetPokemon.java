package com.example.demo.pokemon.application;

import java.util.List;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.service.PokemonService;

//XXX Application
/**
 * @author Ibrahim Mattus Neto
 *
 */
public class GetPokemon {
	private static PokemonService pokeService = new PokemonService();

	/** Get all the Pokemons in the pokedex, no filters
	 * @return a full list of Pokemons
	 */
	public List<Pokemon> getAll() {

		return pokeService.getAll();
	}

	/** Gets a list of Pokemons that the name contains the string nome
	 * @param pokemon the list of Pokemon to apply the name filter
	 * @param name the name to use as filter
	 * @return a list of Pokemons with the name filtered by the string nome
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, String name) {

		return pokeService.getAll(pokemon, name);
	}

	/** Gets a list of Pokemons that has evolutions (from basic stage to the last)
	 * @param pokemon the list of Pokemons to filter from
	 * @param evolve boolean indicating if we must filter by evolution or not
	 * @return a list of Pokemons that have evolutions
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, boolean evolve) {

		return pokeService.getAll(pokemon, evolve);
	}
}
