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

import fr.recette.models.Category;
import fr.recette.services.CategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping()
	public List<Category> getAll(){
		return this.service.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Category add(@RequestBody Category categorie) {
		return this.service.add(categorie);
	}
	
	@PutMapping("/{id}")
	public Category update(@RequestBody Category categorie, @PathVariable String id) {
		Category lCategorie = this.findById(id);
		categorie.setId(lCategorie.getId());
		return this.service.update(categorie);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
	@GetMapping("/categorie/{id}")
	public Category findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/categorie/nom/{nom}")
	public Category findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}
}
