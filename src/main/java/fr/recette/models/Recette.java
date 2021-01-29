package fr.recette.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("recette")
public class Recette {
	
	@Id
	private int id;
	private String nom;
	private List<Ingredient> ingredients;
	private List<Category> categories;
	private String description;
}
