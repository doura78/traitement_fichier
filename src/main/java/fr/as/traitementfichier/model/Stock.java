package fr.as.traitementfichier.model;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private List<Produit> produits = new ArrayList<>();

    //Ajouter produit au stock
    public void ajouterProduit(Produit produit){
        produits.add(produit);
    }

    //Retourne liste des produits
    public List<Produit> getProduits(){
        return produits;
    }
}



