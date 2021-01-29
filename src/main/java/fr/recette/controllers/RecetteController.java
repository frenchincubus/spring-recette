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
import fr.recette.models.Recette;
import fr.recette.services.CategoryService;
import fr.recette.services.RecetteService;

@RequestMapping("recettes")
@RestController
public class RecetteController {
	
	@Autowired
	private RecetteService service;
	@Autowired
	private CategoryService categorieService;

	@GetMapping()
	public List<Recette> getAll(){
		return this.service.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Recette add(@RequestBody Recette recette) {
		return this.service.add(recette);
	}
	
	@PutMapping("/{id}")
	public Recette update(@RequestBody Recette recette, @PathVariable String id) {
		Recette lRecette = this.findById(id);
		recette.setId(lRecette.getId());
		return this.service.update(recette);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}
	
	@GetMapping("/recette/{id}")
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);
	}
	
	@GetMapping("/recette/nom/{nom}")
	public List<Recette> findByNom(@PathVariable String nom) {
		return this.service.findByNom(nom);
	}
	
	/**
	 * Recherche les recettes via le nom d'une catégorie
	 * @param String nom de la catégorie
	 * @return liste des recettes concordantes
	 */
	@GetMapping("/recette/categorie/{nom}")
	public List<Recette> findByCategorieNom(@PathVariable String nom) {
		Category categorie = this.categorieService.findByNom(nom.replace("%20", " "));
		return this.service.findByCategories(categorie);
	}
	
	/**
	 * Recherche les recettes via l'id d'une catégorie
	 * @param String id de la catégorie
	 * @return liste des recettes concordantes
	 */
	@GetMapping("/categories/categorie/{id}")
	public List<Recette> findByCategorieId(@PathVariable String id) {
			Category categorie = this.categorieService.findById(id);
			return this.service.findByCategories(categorie);
	}
}
