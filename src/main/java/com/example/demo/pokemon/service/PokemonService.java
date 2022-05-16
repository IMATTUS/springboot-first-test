package com.example.demo.pokemon.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.entities.PokemonType;
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
	public List<Pokemon> findAll() {
		return bpc.findAll();
	}

	/** Gets a list of Pokemons that the name contains the string nome
	 * @param pokemon the list of Pokemon to apply the name filter
	 * @param name the name to use as filter
	 * @return a list of Pokemons with the name filtered by the string nome
	 */
//	public List<Pokemon> getAll(List<Pokemon> pokemon, String name) {
//		return bpc.getAll(pokemon, name);
//	}
	
	public Pokemon findAll(Integer id) {
		Optional<Pokemon> obj= bpc.findById(id);
		return obj.get();
	}
	
	public List<Pokemon> findAll(List<Pokemon> pokemon, String name) {
		Optional<List<Pokemon>> obj = bpc.findByNameContaining(name);
		return obj.get();
	}

/*
 * -----------------------------------------------------------------------------------
 */
	
//	private static List<Pokemon> pokemon = new ArrayList<>();
//
//	/** Will get a list of all the 151 Pokemons
//	 * @return the full list of Pokemons
//	 */
//	public List<Pokemon> getAll() {
//		if(pokemon.isEmpty()) {
//			setPokemon();
//		}
//		pokemon.sort((p1,p2) -> p1.getNumber().compareTo(p2.getNumber()));
//		return pokemon;
//	}

	
	/** Crates a list of all Pokemon that has evolutions, based on the list provided
	 * @param pokemon the list of pokemont to filter from
	 * @param evolve boolean indicating if we should check for evolution on not.
	 * @return
	 */
	public List<Pokemon> findAll(List<Pokemon> pokemon, boolean evolve) {
		Optional<List<Pokemon>> obj = bpc.findByEvolvedFromIsNotNull();
		return obj.get();
	}

	public List<Pokemon> findAll(List<Pokemon> pokemon, String name, boolean evolve) {
		Optional<List<Pokemon>> obj = bpc.findByNameContainingAndEvolvedFromIsNotNull(name);
		return obj.get();
	}
	

	/** Add new pokemon to the list
	 * @param parameter, it should contain the number, name, types and pre evolution of a pokemon
	 * @return
	 */
	public boolean addPokemon(Pokemon poke) {
		if(poke.getName() == null || poke.getNumber() == null || poke.getType().isEmpty()) {
			return false;
		}
		
		List<Pokemon> pokemon = findAll();
		
		if(pokemon.contains(poke) == false) {
			if(poke.getEvolvedFrom()!=null) {
				addPokemon(poke.getEvolvedFrom());
			}
//			addEvolution(poke,parameter.get("evolveFrom"));
			pokemon.add(poke);
			bpc.saveAll(Arrays.asList(poke));
			return true;
		}
		return false;
		
	}
//	
//	/** Will add the pokemon to the evolution list of its pre evolution
//	 * @param poke
//	 * @param parameter
//	 */
//	private void addEvolution(Pokemon poke, String evolveFrom) {
//		if(evolveFrom != null) {
//			Pokemon p2 = findPreEvolution(evolveFrom);
//			if(p2 != null) {
//				p2.addEvolution(poke);
//			}
//		}
//	}
//	
//	/** Will find the pre evolution of the given pokemon
//	 * @param poke
//	 * @param pokePreEvolutionName
//	 * @return
//	 */
//	private Pokemon findPreEvolution(String pokePreEvolutionName) {
//		Pokemon pokePreEvolution = pokemon.stream()
//				.filter(p -> pokePreEvolutionName.equals(p.getName()))
//				.findFirst()
//				.orElse(null);
//		return pokePreEvolution;
//		
//	}
//
}
