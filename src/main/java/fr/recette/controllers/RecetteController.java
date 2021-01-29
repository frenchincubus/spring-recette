package fr.recette.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.recette.models.Recette;
import fr.recette.services.RecetteService;

@RequestMapping("recettes")
@RestController
public class RecetteController {
	
	@Autowired
	private RecetteService service;

	@GetMapping()
	public List<Recette> getAll(){
		return this.service.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Recette addRecette(@RequestBody Recette recette) {
		return this.service.addRecette(recette);
	}
	
	@PutMapping("/{id}")
	public Recette updateRecette(@RequestBody Recette recette, @PathVariable String id) {
		Recette lRecette = this.findById(id);
		recette.setId(lRecette.getId());
		return this.service.updateRecette(recette);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecette(@PathVariable String id) {
		this.service.deleteRecette(id);
	}
	
	@GetMapping("/recette/{id}")
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/recette/nom/{nom}")
	public List<Recette> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}
}
