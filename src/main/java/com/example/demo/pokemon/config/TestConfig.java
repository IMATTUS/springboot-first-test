package com.example.demo.pokemon.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.pokemon.entities.Pokemon;
import com.example.demo.pokemon.entities.PokemonType;
import com.example.demo.pokemon.repository.BillsPC;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private BillsPC bpc;
	
	@Override
	public void run(String... args) throws Exception {
		
//		Category cat1 = new Category(null, "Electronics");
//		Category cat2 = new Category(null, "Books");
//		Category cat3 = new Category(null, "Computers");
//		
//		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
//		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
//		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
//		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
//		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
//		
//		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
//		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
//		
//		p1.getCategories().add(cat2);
//		p2.getCategories().add(cat1);
//		p2.getCategories().add(cat3);
//		p3.getCategories().add(cat3);
//		p4.getCategories().add(cat3);
//		p5.getCategories().add(cat2);
//		
//		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		List<Pokemon> pokemon = new ArrayList<>();
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
		
		Collections.reverse(pokemon);
		bpc.saveAll(pokemon);
		
	}

}
