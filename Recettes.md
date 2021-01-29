# Recettes

Collectionner des recettes avec leurs ingrédients et  pourvoir les classer par catégories.

## Entités

Recette:

- nom
- ingrédients (objet)
- catégories (objet)
- description

Ingrédient:

- nom
- quantité
- unité

Catégorie:

- nom

## Architecture

### Controllers

Décide des actions à prendre en fonction de la requête entrante (REST).

### Models

Représentation d'un objet métier.

### Services

Manipulation de l'objet métier.

### Repositories

S'occupe de la persistance de nos objets métiers. 



