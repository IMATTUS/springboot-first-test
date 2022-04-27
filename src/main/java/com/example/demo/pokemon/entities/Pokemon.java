package com.example.demo.pokemon.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//XXX Domain

/** Represents a Pokemon
 * @author netoim
 *
 */
public class Pokemon {

	private Integer number;
	private String name;
	private List<PokemonType> type = new ArrayList<>();
	private List<Pokemon> evolution = new ArrayList<>();

	/** Basic contructor for Pokemon Class
	 * 
	 */
	public Pokemon() {

	}

	/** Contructor for Pokemon Class
	 * @param number the number in the pokedex
	 * @param name the name of the Pokemon
	 */
	public Pokemon(Integer number, String name) {
		this.number = number;
		this.name = name;

	}

	/** Gets the number in the pokedex
	 * @return the number that the pokemon has in the pokedex
	 */
	public Integer getNumber() {
		return number;
	}

	/** Sets the number of the Pokemon in the pokedex
	 * @param number the number in the pokedex
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/** Gets the name of the Pokemon
	 * @return the Pokemon name
	 */
	public String getName() {
		return name;
	}

	/** Sets the Pokemon name
	 * @param name the name to be set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** Gets the list of PokemonType for the pokemon
	 * @return the list of PokemonType
	 */
	public List<PokemonType> getType() {
		return type;
	}

	/** Adds PokemonType to the type list
	 * @param type the PokemonType to be added
	 */
	public void addType(PokemonType type) {
		this.type.add(type);
	}

	/** Removes PokemonType from the list of types
	 * @param type the PokemonType to be removed
	 */
	public void removeType(PokemonType type) {
		this.type.remove(type);
	}

	/** Gets the list of evolutions for the pokemon
	 * @return the list of evolutions for the pokemon
	 */
	public List<Pokemon> getEvolution() {
		return evolution;
	}

	/** Adds pokemon to the evolution list
	 * @param pokemon
	 */
	public void addEvolution(Pokemon pokemon) {
		evolution.add(pokemon);
	}

	/** Removes pokemon from the evolution list
	 * @param pokemon
	 */
	public void removeEvolution(Pokemon pokemon) {
		evolution.remove(pokemon);
	}

	/** Overriding toString implementation
	 *
	 */
	@Override
	public String toString() {
		return "Pokemon [number=" + number + ", name=" + name + ", type=" + type + "]";
	}
	
	public boolean hasEvolution() {
		if(this.evolution.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}

}
