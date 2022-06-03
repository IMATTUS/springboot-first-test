package com.example.demo.pokemon.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//XXX Domain

/** Represents a Pokemon
 * @author Ibrahim Mattus Neto
 *
 */
@Entity
@Table(name="tb_pokemon")
public class Pokemon {
	
	@Id
	private Integer id;
	private String name;
	
	@ElementCollection(targetClass = PokemonType.class)
	@CollectionTable
	@Enumerated(EnumType.STRING)
	private List<PokemonType> type = new ArrayList<>();
	
	@OneToOne()
	private Pokemon evolvedFrom;

	/** Basic contructor for Pokemon Class
	 */
	public Pokemon() {

	}

	/** Contructor for Pokemon Class
	 * @param number the number in the pokedex
	 * @param name the name of the Pokemon
	 */
	public Pokemon(Integer number, String name) {
		this.id = number;
		this.name = name;

	}

	/** Gets the number in the pokedex
	 * @return the number that the pokemon has in the pokedex
	 */
	public Integer getNumber() {
		return id;
	}

	/** Sets the number of the Pokemon in the pokedex
	 * @param number the number in the pokedex
	 */
	public void setNumber(Integer number) {
		this.id = number;
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
	public Pokemon getEvolvedFrom() {
		return evolvedFrom;
	}

	/** Adds pokemon to the evolution list
	 * @param pokemon
	 */
	public void addEvolvedFrom(Pokemon pokemon) {
		evolvedFrom = pokemon;
	}

	/** Removes pokemon from the evolution list
	 * @param pokemon
	 */
	public void removeEvolveFrom() {
//	public void removeEvolution(Pokemon pokemon) {
		evolvedFrom = null;
	}

	/** Overriding toString implementation
	 */
	@Override
	public String toString() {
		return "Pokemon [number=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
//	public boolean hasEvolution() {
//		if(this.evolvedFrom == null) {
//			return false;
//		}else {
//			return true;
//		}
//	}

	@Override
	public int hashCode() {
		return Objects.hash(name, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return Objects.equals(name, other.name) && Objects.equals(id, other.id);
	}

	
	
}
