package com.example.demo.pokemon.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.entities.PokemonType;

//XXX Repository
/** Represents the repository for pokemon
 * @author Ibrahim Mattus Neto
 *
 */
public class BillsPC {

	private static List<Pokemon> pokemon = new ArrayList<>();

	/** Will get a list of all the 151 Pokemons
	 * @return the full list of Pokemons
	 */
	public List<Pokemon> getAll() {
		if(pokemon.isEmpty()) {
			setPokemon();
		}
		pokemon.sort((p1,p2) -> p1.getNumber().compareTo(p2.getNumber()));
		return pokemon;
	}

	
	/** Crates a list of all Pokemon that has evolutions, based on the list provided
	 * @param pokemon the list of pokemont to filter from
	 * @param evolve boolean indicating if we should check for evolution on not.
	 * @return
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, boolean evolve) {
		List<Pokemon> pokeFilter = new ArrayList<>();

		for (Pokemon poke : pokemon) {

			if(pokeFilter.contains(poke)==false && poke.hasEvolution()) {
				pokeFilter.add(poke);
			}
			
		}
		pokeFilter.sort((p1,p2) -> p1.getNumber().compareTo(p2.getNumber()));
		return pokeFilter;
	}

	/** List all pokemon that contains the string 'nome' in its name
	 * @param pokemon the list of Pokemon to check and filter from
	 * @param name the string to check if the pokemon name contains it
	 * @return the list with the filter pokemon
	 */
	public List<Pokemon> getAll(List<Pokemon> pokemon, String name) {
		
		List<Pokemon> pokeFilter = new ArrayList<>();
		for (Pokemon poke : pokemon) {
			if (poke.getName().toUpperCase().indexOf(name.toUpperCase()) != -1) {
				pokeFilter.add(poke);
			}
		}
		pokeFilter.sort((p1,p2) -> p1.getNumber().compareTo(p2.getNumber()));
		return pokeFilter;
	}

	/** Add new pokemon to the list
	 * @param parameter, it should contain the number, name, types and pre evolution of a pokemon
	 * @return
	 */
	public boolean addPokemon(Pokemon poke) {
		if(pokemon.isEmpty()) {
			setPokemon();
		}
		
//		Pokemon p = new Pokemon();
//		for (String param : parameter.keySet()) {
//			if(param.equals("number")) {
//				p.setNumber(Integer.parseInt(parameter.get(param)));
//			}
//			if(param.equals("name")) {
//				p.setName(parameter.get(param));
//			}
//			if(param.contains("type")) {
//				p.addType(PokemonType.valueOf(parameter.get(param)));
//			}
//		}
		
		if(poke.getName() == null || poke.getNumber() == null || poke.getType().isEmpty()) {
			return false;
		}
		
		if(pokemon.contains(poke) == false) {
			pokemon.add(poke);
//			addEvolution(poke,parameter.get("evolveFrom"));
			return true;
		}
		return false;
		
	}
	
	/** Will add the pokemon to the evolution list of its pre evolution
	 * @param poke
	 * @param parameter
	 */
	private void addEvolution(Pokemon poke, String evolveFrom) {
		if(evolveFrom != null) {
			Pokemon p2 = findPreEvolution(evolveFrom);
			if(p2 != null) {
				p2.addEvolution(poke);
			}
		}
	}
	
	/** Will find the pre evolution of the given pokemon
	 * @param poke
	 * @param pokePreEvolutionName
	 * @return
	 */
	private Pokemon findPreEvolution(String pokePreEvolutionName) {
		Pokemon pokePreEvolution = pokemon.stream()
				.filter(p -> pokePreEvolutionName.equals(p.getName()))
				.findFirst()
				.orElse(null);
		return pokePreEvolution;
		
	}

	/** 
	 * Create the full list of pokemon, hardcoded for now.
	 */
	private void setPokemon() {
		pokemon.clear();
		
		int pokeNumber = 0;

		Pokemon p = new Pokemon(++pokeNumber, "Bulbasaur");

		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Ivysaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);
		p = new Pokemon(++pokeNumber, "Venusaur");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Charmander");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Charmeleon");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Charizard");
		p.addType(PokemonType.valueOf("FIRE"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Squirtle");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Wartortle");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Blastoise");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Caterpie");
		p.addType(PokemonType.valueOf("BUG"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Metapod");
		p.addType(PokemonType.valueOf("BUG"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Butterfree");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Weedle");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Kakuna");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Beedrill");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Pidgey");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Pidgeotto");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Pidgeot");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Rattata");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Raticate");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Spearow");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Fearow");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Ekans");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Arbok");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Pikachu");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Raichu");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Sandshrew");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Sandslash");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Nidoran♀");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Nidorina");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Nidoqueen");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Nidoran♂");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Nidorino");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Nidoking");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Clefairy");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Clefable");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Vulpix");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Ninetales");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Jigglypuff");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Wigglytuff");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Zubat");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Golbat");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Oddish");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Gloom");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Vileplume");
		p.addType(PokemonType.valueOf("POISON"));
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Paras");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Parasect");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Venonat");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Venomoth");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Diglett");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Dugtrio");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Meowth");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Persian");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Psyduck");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Golduck");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Mankey");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Primeape");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Growlithe");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Arcanine");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Poliwag");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Poliwhirl");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Poliwrath");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Abra");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Kadabra");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Alakazam");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Machop");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Machoke");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Machamp");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Bellsprout");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Weepinbell");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Victreebel");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Tentacool");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Tentacruel");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Geodude");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Graveler");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Golem");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Ponyta");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Rapidash");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Slowpoke");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Slowbro");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Magnemite");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Magneton");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Farfetch'd");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Doduo");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Dodrio");
		p.addType(PokemonType.valueOf("NORMAL"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Seel");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Dewgong");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("ICE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Grimer");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Muk");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Shellder");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Cloyster");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("ICE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Gastly");
		p.addType(PokemonType.valueOf("GHOST"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Haunter");
		p.addType(PokemonType.valueOf("GHOST"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Gengar");
		p.addType(PokemonType.valueOf("GHOST"));
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Onix");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Drowzee");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Hypno");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Krabby");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Kingler");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Voltorb");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Electrode");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Exeggcute");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Exeggutor");
		p.addType(PokemonType.valueOf("GRASS"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Cubone");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Marowak");
		p.addType(PokemonType.valueOf("GROUND"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Hitmonlee");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Hitmonchan");
		p.addType(PokemonType.valueOf("FIGHTING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Lickitung");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Koffing");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Weezing");
		p.addType(PokemonType.valueOf("POISON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Rhyhorn");
		p.addType(PokemonType.valueOf("GROUND"));
		p.addType(PokemonType.valueOf("ROCK"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Rhydon");
		p.addType(PokemonType.valueOf("GROUND"));
		p.addType(PokemonType.valueOf("ROCK"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Chansey");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Tangela");
		p.addType(PokemonType.valueOf("GRASS"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Kangaskhan");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Horsea");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Seadra");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Goldeen");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Seaking");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Staryu");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Starmie");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Mr. Mime");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Scyther");
		p.addType(PokemonType.valueOf("BUG"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Jynx");
		p.addType(PokemonType.valueOf("ICE"));
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Electabuzz");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Magmar");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Pinsir");
		p.addType(PokemonType.valueOf("BUG"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Tauros");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Magikarp");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Gyarados");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Lapras");
		p.addType(PokemonType.valueOf("WATER"));
		p.addType(PokemonType.valueOf("ICE"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Ditto");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Eevee");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Vaporeon");
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Jolteon");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 3).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Flareon");
		p.addType(PokemonType.valueOf("FIRE"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 4).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Porygon");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Omanyte");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Omastar");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Kabuto");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Kabutops");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("WATER"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Aerodactyl");
		p.addType(PokemonType.valueOf("ROCK"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Snorlax");
		p.addType(PokemonType.valueOf("NORMAL"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Articuno");
		p.addType(PokemonType.valueOf("ICE"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Zapdos");
		p.addType(PokemonType.valueOf("ELECTRIC"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Moltres");
		p.addType(PokemonType.valueOf("FIRE"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Dratini");
		p.addType(PokemonType.valueOf("DRAGON"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Dragonair");
		p.addType(PokemonType.valueOf("DRAGON"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Dragonite");
		p.addType(PokemonType.valueOf("DRAGON"));
		p.addType(PokemonType.valueOf("FLYING"));
		pokemon.add(p);
		pokemon.get(pokemon.size() - 2).addEvolution(p);

		p = new Pokemon(++pokeNumber, "Mewtwo");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);

		p = new Pokemon(++pokeNumber, "Mew");
		p.addType(PokemonType.valueOf("PSYCHIC"));
		pokemon.add(p);
	}
}
