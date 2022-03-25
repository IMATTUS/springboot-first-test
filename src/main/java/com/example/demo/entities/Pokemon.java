package com.example.demo.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entities.enums.PokemonType;

public class Pokemon {
	
	private Integer number;
	private String name;
	private List<PokemonType> type = new ArrayList<>();
//	private List<Integer> evolution = new ArrayList<>();
	private List<Pokemon> evolution = new ArrayList<>();
	
	public Pokemon() {
		
	}

	public Pokemon(Integer number, String name) {
		this.number = number;
		this.name = name;

	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PokemonType> getType() {
		return type;
	}

	public void addType(PokemonType type) {
		this.type.add(type);
	}
	
	public void removeType(PokemonType type) {
		this.type.remove(type);
	}

	
	public List<Pokemon> getEvolution() {
		return evolution;
	}

	public void addEvolution(Pokemon pokemon) {
		evolution.add(pokemon);
	}
	
	public void removeEvolution(Pokemon pokemon) {
		evolution.remove(pokemon);
	}

	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", type=" + type + "]";
	}



	
	
}
