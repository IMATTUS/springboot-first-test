package com.example.demo.pokemon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pokemon.entities.Pokemon;

//XXX Repository
/** Represents the repository for pokemon
 * @author Ibrahim Mattus Neto
 *
 */
@Repository
public interface BillsPC extends JpaRepository<Pokemon, Integer>{

//	Optional<Pokemon> findByName(String name);
	Optional<List<Pokemon>> findByName(String name);
	Optional<List<Pokemon>> findByNameContaining(String name);
	Optional<List<Pokemon>> findByNameContainingAndEvolvedFromIsNotNull(String name);
	Optional<List<Pokemon>> findByEvolvedFromIsNotNull();

	
}
