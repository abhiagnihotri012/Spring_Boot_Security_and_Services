package com.neosoft.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.springboot.model.Trainer;
import com.neosoft.springboot.myexception.ResourceNotFoundException;
import com.neosoft.springboot.repository.TrainerRepository;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

	@Autowired
	private TrainerRepository trainerRepository;
	
	@GetMapping
	public List<Trainer> getAllTrainers(){
		return trainerRepository.findAll();
	}
	
	@PostMapping("/add")
	public void addTrainer(@RequestBody Trainer trainer) {
		trainerRepository.save(trainer);
	}
		
	@GetMapping("/and/{firstname}/{lastname}")
	public Trainer getTrainerByFnameAndLname(@PathVariable String firstname, 
			@PathVariable String lastname) {
		return trainerRepository.findByFirstnameAndLastname(firstname, lastname);
	}
	

//	@GetMapping("/{id}")
//	public EntityModel<Trainer> getTrainerByid(@PathVariable long id){
//		Optional<Trainer> trainer = trainerRepository.findById(id);
//		
//		if(!trainer.isPresent()) 
//			throw new ResourceNotFoundException("Trainer","TrId",id);		
//		
//		EntityModel<Trainer> resource = EntityModel.of(trainer.get());
//		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllTrainers());
//		resource.add(linkTo.withRel("all-trainers"));
//		return resource;
//	}	
	
}
