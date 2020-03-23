package com.wipro.wipromvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.wipromvc.entity.Pokemon;
import com.wipro.wipromvc.services.PokemonServices;

@RestController
@CrossOrigin
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	PokemonServices pokemonservices;

	@GetMapping
	@CrossOrigin
	public Iterable<Pokemon> GetTrainner() {
		return pokemonservices.searchall();
	}

	@PostMapping
	@RequestMapping("/{idtreinador}")
	public Pokemon addpokemon(@PathVariable int idtreinador, @RequestBody Pokemon pokemon) {
		pokemonservices.randomServicesPokemon(pokemon);
		return pokemonservices.addpokemonttotrainner(idtreinador, pokemon);
	}

}
