package com.wipro.wipromvc.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.wipromvc.entity.Trainner;

public interface TrainnerInterface extends JpaRepository<Trainner, Integer> {

}
