package com.wipro.wipromvc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.wipromvc.entity.Pokemon;
import com.wipro.wipromvc.entity.Trainner;

@Service
public class PokemonServices {

	@Autowired
	private trainnerServices trainnerServices;
	@Autowired
	private PokemonServices pokemonServices;

	public Pokemon addpokemonttotrainner(int idtrainner, Pokemon pokemon) {

		Trainner trainner2 = trainnerServices.serachBYID(idtrainner);
		trainner2.pokemons.add(pokemon);
		trainnerServices.updatebyid(idtrainner,trainner2);
		return pokemon;
	}

	public Iterable<Pokemon> searchall() {
		return pokemonServices.searchall();
	}
	
	public Pokemon randomServicesPokemon(Pokemon pokemon){
		
		Random random = new Random();
		
		pokemon.setLevel(random.nextInt(10));
		int powerinitial=10;
		int powerlevel = pokemon.getLevel() * powerinitial;
		pokemon.setPower(powerlevel);
		
		return pokemon;
	
	}

}
