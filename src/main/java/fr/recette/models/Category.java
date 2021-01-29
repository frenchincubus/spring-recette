package fr.recette.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("category")
public class Category {
	
	@Id
	private int id;
	private String nom;

	public Category() {}
	
	public Category(String nom) {
		super();
		this.nom = nom;
	}
		
}
