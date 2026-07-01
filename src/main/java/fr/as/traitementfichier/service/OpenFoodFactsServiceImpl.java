package fr.as.traitementfichier.service;

import fr.as.traitementfichier.exception.OpenFoodFactsException;
import fr.as.traitementfichier.model.*;

import java.util.*;


public class OpenFoodFactsServiceImpl implements OpenFoodFactsService {

    /** Stock des produits. */
    private Stock stock;

    public OpenFoodFactsServiceImpl(Stock stock) {
        if (stock == null) {
            throw new OpenFoodFactsException("Le stock ne peut pas être null.");
        }
        this.stock = stock;
    }

    @Override
    public List<Produit> rechercherMeilleursProduitsParMarque(String marque) {
        verifierTexte(marque, "La marque est obligatoire.");

        return stock.getProduits().stream()
                .filter(produit -> produit.getMarque() != null)
                .filter(produit -> produit.getMarque().getNom().equalsIgnoreCase(marque.trim()))
                .sorted(Comparator.comparing(Produit::getNutritionGradeFr))
                .limit(10)
                .toList();
    }

    @Override
    public List<Produit> rechercherMeilleursProduitsParCategorie(String categorie) {
        verifierTexte(categorie, "La catégorie est obligatoire.");

        return stock.getProduits().stream()
                .filter(produit -> produit.getCategorie() != null)
                .filter(produit -> produit.getCategorie().getLibelle().equalsIgnoreCase(categorie.trim()))
                .sorted(Comparator.comparing(Produit::getNutritionGradeFr))
                .limit(10)
                .toList();
    }

    @Override
    public List<Produit> rechercherMeilleursProduitsParMarqueEtCategorie(String marque, String categorie) {
        verifierTexte(marque, "La marque est obligatoire.");
        verifierTexte(categorie, "La catégorie est obligatoire.");

        return stock.getProduits().stream()
                .filter(produit -> produit.getMarque() != null && produit.getCategorie() != null)
                .filter(produit -> produit.getMarque().getNom().equalsIgnoreCase(marque.trim()))
                .filter(produit -> produit.getCategorie().getLibelle().equalsIgnoreCase(categorie.trim()))
                .sorted(Comparator.comparing(Produit::getNutritionGradeFr))
                .limit(10)
                .toList();
    }

    @Override
    public Map<String, Integer> recupererAllergenesLesPlusCourants(int limite) {
        Map<String, Integer> compteur = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Allergene allergene : produit.getAllergenes()) {
                String libelle = allergene.getLibelle();
                compteur.put(libelle, compteur.getOrDefault(libelle, 0) + 1);
            }
        }

        return trierCompteur(compteur, limite);
    }

    @Override
    public Map<String, Integer> recupererAdditifsLesPlusCourants(int limite) {
        Map<String, Integer> compteur = new HashMap<>();

        for (Produit produit : stock.getProduits()) {
            for (Additif additif : produit.getAdditifs()) {
                String libelle = additif.getLibelle();
                compteur.put(libelle, compteur.getOrDefault(libelle, 0) + 1);
            }
        }

        return trierCompteur(compteur, limite);
    }

    /**
     * Vérifie qu'un texte n'est pas vide.
     */
    private void verifierTexte(String texte, String message) {
        if (texte == null || texte.isBlank()) {
            throw new OpenFoodFactsException(message);
        }
    }

    /**
     * Trie un compteur par ordre décroissant.
     */
    private Map<String, Integer> trierCompteur(Map<String, Integer> compteur, int limite) {
        Map<String, Integer> resultat = new LinkedHashMap<>();

        compteur.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limite)
                .forEach(entry -> resultat.put(entry.getKey(), entry.getValue()));

        return resultat;
    }
}