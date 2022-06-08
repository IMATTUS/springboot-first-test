package com.example.demo.pokemon.application;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.entities.PokemonType;
import com.example.demo.pokemon.service.PokemonService;

class AddPokemonTest {

	
	@InjectMocks
	AddPokemonTest addPokemonTest;
	
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
	final void testAddPokemon() {
		int pokeNumber = 0;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		
		
		when(pokemonService.addPokemon(p))
		.thenReturn(true);
		
		boolean retorno = pokemonService.addPokemon(p);
		
		assertEquals(true, retorno);
		verify(pokemonService,times(1))
		.addPokemon(p);
		
	}

}
