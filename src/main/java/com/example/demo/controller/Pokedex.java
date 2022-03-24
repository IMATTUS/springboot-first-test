package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pokemon;
import com.example.demo.entities.enums.PokemonType;

@RestController
@RequestMapping(value="/pokedex",method = RequestMethod.GET,produces="application/json")
public class Pokedex {
	
	@GetMapping
	public String listaPokemon() {
		
		List<Pokemon> pokemon = new ArrayList<>();
		
		geraPokedex(pokemon);
		
		return pokemon.toString();
	}

	
	public void geraPokedex(List<Pokemon> pokemon) {
		
		Pokemon p = new Pokemon(1,"Bulbasaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		p = new Pokemon(2,"Ivysaur") ;
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size()-2).addEvolution(2);
		p = new Pokemon(3,"Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size()-2).addEvolution(3);
		

		p = new Pokemon(4,"Charmander") ;
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		
		p = new Pokemon(5,"Charmeleon") ;
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		pokemon.get(pokemon.size()-2).addEvolution(5);
		
		p = new Pokemon(6,"CHARIZARD") ;
		p.addType(PokemonType.valueOf("FIRE"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size()-2).addEvolution(6);
		
	}

}
