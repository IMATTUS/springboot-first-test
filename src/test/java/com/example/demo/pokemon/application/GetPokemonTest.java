package com.example.demo.pokemon.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.entities.PokemonType;
import com.example.demo.pokemon.service.PokemonService;

class GetPokemonTest {

	@InjectMocks
	GetPokemonTest getPokemonTest;
	
	@Mock
	PokemonService pokemonService;
	
	@Test
	final void testFindAll() {
		List<Pokemon> pokemon = new ArrayList<Pokemon>();
		int pokeNumber = 0;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		
		p = new Pokemon(++pokeNumber, "Ivysaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		
		p.addEvolvedFrom(pokemon.get(pokemon.size()-1));
		pokemon.add(p);
		
		p = new Pokemon(++pokeNumber, "Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		p.addEvolvedFrom(pokemon.get(pokemon.size()-1));
		pokemon.add(p);
			
		when(pokemonService.findAll()).thenReturn(pokemon);
		
		List<Pokemon> empList = pokemonService.findAll();
		
		assertEquals(3, empList.size());
		verify(pokemonService,times(1)).findAll();
	}

	@Test
	final void testFindAllByName() {
//		fail("Not yet implemented"); // TODO
		List<Pokemon> listPoke = new ArrayList<Pokemon>();
		int pokeNumber = 0;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		listPoke.add(p);
		
		p = new Pokemon(++pokeNumber, "Ivysaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		
		p.addEvolvedFrom(listPoke.get(listPoke.size()-1));
		listPoke.add(p);
		
		p = new Pokemon(++pokeNumber, "Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		p.addEvolvedFrom(listPoke.get(listPoke.size()-1));
		listPoke.add(p);

		when(pokemonService
				.findAll(listPoke, "saur"))
		.thenReturn(listPoke);
		
		List<Pokemon> empList = 
				pokemonService.findAll(listPoke,"saur");
		
		assertEquals(3, empList.size());
		verify(pokemonService,times(1))
		.findAll(listPoke,"saur");
	}

	@Test
	final void testFindAllEvolution() {
//		fail("Not yet implemented"); // TODO
		List<Pokemon> listPoke = new ArrayList<Pokemon>();
		int pokeNumber = 1;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p = new Pokemon(++pokeNumber, "Ivysaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		
		listPoke.add(p);
		
		p = new Pokemon(++pokeNumber, "Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		p.addEvolvedFrom(listPoke.get(listPoke.size()-1));
		listPoke.add(p);

		when(pokemonService
				.findAll(listPoke, true))
		.thenReturn(listPoke);
		
		List<Pokemon> empList = 
				pokemonService
				.findAll(listPoke,true);
		
		assertEquals(2, empList.size());
		verify(pokemonService,times(1))
		.findAll(listPoke,true);
		
	}

	@Test
	final void testFindAllByNameAndEvolution() {
//		fail("Not yet implemented"); // TODO
		List<Pokemon> listPoke = new ArrayList<Pokemon>();
		int pokeNumber = 5;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p = new Pokemon(++pokeNumber, "Charizard");
		p.addType(PokemonType.valueOf("FIRE"));
		p.addType(PokemonType.valueOf("FLYING"));
		listPoke.add(p);

		when(pokemonService
				.findAll(listPoke, "zard",true))
		.thenReturn(listPoke);
		
		List<Pokemon> empList = 
				pokemonService
				.findAll(listPoke,"zard",true);
		
		assertEquals(1, empList.size());
		verify(pokemonService,times(1))
		.findAll(listPoke,"zard",true);
	}

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void closing() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}
	
}
