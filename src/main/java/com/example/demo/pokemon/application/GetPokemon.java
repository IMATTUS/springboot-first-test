package com.example.demo.pokemon.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.service.PokemonService;

/**
 * @author Ibrahim Mattus Neto
 *
 */
@Service
public class GetPokemon {
	@Autowired
	private PokemonService pokeService;
	/** Get all the Pokemons in the pokedex, no filters
	 * @return a full list of Pokemons
	 */
	public List<Pokemon> findAll() {
		return pokeService.findAll();
	}

	/** Gets a list of Pokemons that the name contains the string name
	 * @param pokemon the list of Pokemon to apply the name filter
	 * @param name the name to use as filter
	 * @return a list of Pokemons with the name filtered by the string name
	 */
	public List<Pokemon> findAll(List<Pokemon> pokemon, String name) {

		return pokeService.findAll(pokemon, name);
	}

	/** Gets a list of Pokemons that has evolutions
	 * @param pokemon the list of Pokemons to filter from
	 * @param evolve boolean indicating if we must filter by evolution or not
	 * @return a list of Pokemons that have evolutions
	 */
	public List<Pokemon> findAll(List<Pokemon> pokemon, boolean evolve) {

		return pokeService.findAll(pokemon, evolve);
	}
	
	
	/** Gets a list of Pokemons that the name contains the string name and has evolutions
	 * @param pokemon the list of Pokemons to filter from
	 * @param name the name to use as filter
	 * @param evolve boolean indicating if we must filter by evolution or not
	 * @return list of Pokemons that the name contains the string name and has evolutions
	 */
	public List<Pokemon> findAll(List<Pokemon> pokemon, String name, boolean evolve) {
		return pokeService.findAll(pokemon, name, evolve);
	}
}
