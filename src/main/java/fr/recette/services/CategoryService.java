package fr.recette.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.recette.models.Category;
import fr.recette.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> getAll(){
		return this.repository.findAll();
	}
	
	public Category add( Category categorie) {
		return this.repository.insert(categorie);
	}
	
	public Category update(Category categorie) {
		return this.repository.save(categorie);
	}
	
	public void delete(String id) {
		this.repository.deleteById(id);
	}
	
	public Category findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
				);
	}
		
	
	public Category findByNom(String nom) {
		return this.repository.findByNom(nom);
	}
}
