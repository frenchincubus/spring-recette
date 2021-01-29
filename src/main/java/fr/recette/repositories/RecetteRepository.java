package fr.recette.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.recette.models.Recette;

public interface RecetteRepository extends MongoRepository<Recette, String> {
	public List<Recette> findByNomLike(String nom);
}
