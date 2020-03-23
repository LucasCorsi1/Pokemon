package com.wipro.wipromvc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.wipromvc.entity.Trainner;
import com.wipro.wipromvc.interfaces.TrainnerInterface;
import com.wipro.wipromvc.services.trainnerServices;

@RequestMapping("/train")
@RestController
@CrossOrigin
public class TrainnerController {

	@Autowired
	trainnerServices trainnersevices;
	@Autowired
	TrainnerInterface trainnerinterface;

	
	  @GetMapping public Iterable<Trainner> GetTrainner() { return
	  trainnersevices.searchall(); }
	 
/*
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("train");
		List<Trainner> list =  trainnerinterface.findAll();
		modelAndView.addObject("train", list);
		return modelAndView;
	}*/

	@GetMapping
	@RequestMapping("/{id}")
	public Trainner searchById(@PathVariable int id) {
		return trainnersevices.serachBYID(id);
	}

	@PostMapping
	public Trainner postrainner(@RequestBody Trainner trainner) {
		return trainnersevices.postTrainner(trainner);
	}

	@DeleteMapping
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		return trainnersevices.deletebyid(id);
	}

	@PutMapping
	@RequestMapping("/atualiza/{id}")
	public Trainner update(@PathVariable int id ,@RequestBody Trainner trainner) {
		return trainnersevices.updatebyid(id, trainner);
	}

}
