package fr.recette.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fr.recette.models.Category;
import fr.recette.models.Recette;
import fr.recette.repositories.RecetteRepository;

@Service
public class RecetteService {

	@Autowired
	private RecetteRepository repository;
	@Autowired
	private CategoryService categoryService;
	
	
	public List<Recette> getAll(){
		return this.repository.findAll();
	}
	
	public Recette addRecette( Recette recette) {
		recette.setCategories(this.setCategorieByNom(recette.getCategories()));
		return this.repository.insert(recette);
	}
	
	public Recette updateRecette(Recette recette) {
		this.setCategorieByNom(recette.getCategories());
		return this.repository.save(recette);
	}
	
	public void deleteRecette(String id) {
		this.repository.deleteById(id);
	}
	
	public Recette findById(String id) {
		return this.repository.findById(id)
				.orElseThrow(
						()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
				);
	}
		
	
	public List<Recette> findByNom(String nom) {
		return this.repository.findByNomLike(nom);
	}
	
	public List<Category> setCategorieByNom(List<Category> categories) {
		List<Category> lCategories = new ArrayList<>();
		if(categories == null )
			categories = null;
		else {
			for (Category categorie : categories) {
				Category lCategory = categoryService.findByNom(categorie.getNom());				
				lCategories.add(lCategory);				
			}
			categories = lCategories;
		}
		return categories;
	}
}
