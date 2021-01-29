package fr.recette.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.recette.models.Category;
import fr.recette.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String> {
	public List<Recette> findByNomLike(String nom);
	public List<Recette> findByCategories(Category categorie);
}
