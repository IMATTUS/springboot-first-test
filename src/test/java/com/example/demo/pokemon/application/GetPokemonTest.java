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
	
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@AfterEach
	public void closing() throws Exception {
		MockitoAnnotations.openMocks(this).close();
	}
	
	@Test
	final void testFindAll() {
//		fail("Not yet implemented"); // TODO
		
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
	final void testFindAllListOfPokemonString() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFindAllListOfPokemonBoolean() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFindAllListOfPokemonStringBoolean() {
		fail("Not yet implemented"); // TODO
	}

}
