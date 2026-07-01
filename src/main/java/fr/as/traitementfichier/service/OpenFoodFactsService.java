package fr.as.traitementfichier.service;

import fr.as.traitementfichier.exception.OpenFoodFactsException;
import fr.as.traitementfichier.model.Produit;

import java.util.List;
import java.util.Map;

public interface OpenFoodFactsService {

    List<Produit> rechercherMeilleursProduitsParMarque(String marque);

    List<Produit> rechercherMeilleursProduitsParCategorie(String categorie) throws OpenFoodFactsException;

    List<Produit> rechercherMeilleursProduitsParMarqueEtCategorie(String marque, String categorie) throws OpenFoodFactsException;

    Map<String, Integer> recupererAllergenesLesPlusCourants(int limite);

    Map<String, Integer> recupererAdditifsLesPlusCourants(int limite);
}
