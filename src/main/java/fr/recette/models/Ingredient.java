package fr.recette.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("ingredient")
public class Ingredient {
	
	private String nom;
	private int quantite;
	private String unite;
	
		public Ingredient() {
	}
	
	public Ingredient(String nom, int quantite, String unite) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.unite = unite;
	}
}
