package fr.recette.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import fr.recette.models.Category;

public interface CategoryRepository extends MongoRepository<Category, String> {
	public Category findByNom(String nom);
}
