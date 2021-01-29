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
	
	public Recette add( Recette recette) {
		recette.setCategories(this.setRecetteCategories(recette.getCategories()));
		return this.repository.insert(recette);
	}
	
	public Recette update(Recette recette) {
		recette.setCategories(this.setRecetteCategories(recette.getCategories()));
		return this.repository.save(recette);
	}
	
	public void delete(String id) {
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
	
	/**
	 * remplace la liste de chaque categorie d'une recette par son nom ou son id
	 * par la liste d'objets de catégorie correspondante
	 * @param List de categories
	 * @return List de catégories
	 */
	public List<Category> setRecetteCategories(List<Category> categories) {
		List<Category> lCategories = new ArrayList<>();
		if(categories == null )
			categories = null;
		else {
			for (Category categorie : categories) {
				Category lCategory;
				if(categorie.getId() == null)
					lCategory = categoryService.findByNom(categorie.getNom());
				else
					lCategory = categoryService.findById(categorie.getId());
				lCategories.add(lCategory);				
			}
			categories = lCategories;
		}
		return categories;
	}
	
	public List<Recette> findByCategories(Category categorie) {
		return this.repository.findByCategories(categorie);
	}
}
