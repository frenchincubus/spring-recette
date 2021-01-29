package fr.recette.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.recette.models.Ingredient;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {

}
