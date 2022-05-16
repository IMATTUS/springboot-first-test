package com.example.demo.pokemon.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

public enum PokemonType {
	GRASS(1),
	POISON(2),
	FIRE(3),
	FLYING(4),
	WATER(5),
	BUG(6),
	NORMAL(7),
	ELECTRIC(8),
	GROUND(9),
	FIGHTING(10),
	PSYCHIC(11),
	ROCK(12),
	ICE(13),
	GHOST(14),
	DRAGON(15);
	
	private int code;
	
	private PokemonType (int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PokemonType valueof(int code) {
		for(PokemonType value: PokemonType.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
