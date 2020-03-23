package com.wipro.wipromvc.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.wipromvc.entity.Pokemon;

public interface PokemonInterface extends JpaRepository<Pokemon, Integer> {

}
