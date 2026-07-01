package fr.as.traitementfichier.repository;

import fr.as.traitementfichier.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OpenFoodFactsFileReader {
    public Stock lireFichier(Path cheminFichier) throws IOException {
        Stock stock = new Stock();

        List<String> lignes = Files.readAllLines(cheminFichier);

        for (int i = 1; i < lignes.size(); i++) {
            String ligne = lignes.get(i);

            String[] tokens = ligne.split("\\|", -1);

            if (tokens.length < 30) {
                continue;
            }

            try {
                Produit produit = new Produit(
                        new Categorie(tokens[0].trim()),
                        new Marque(tokens[1].trim()),
                        tokens[2].trim(),
                        tokens[3].trim(),
                        parseValeurDouble(tokens[5]),
                        parseValeurDouble(tokens[6]),
                        parseValeurDouble(tokens[7]),
                        parseValeurDouble(tokens[8]),
                        parseValeurDouble(tokens[9]),
                        parseValeurDouble(tokens[10]),
                        parseIngredients(tokens[4]),
                        parseAdditifs(tokens[29]),
                        parseAllergenes(tokens[28])
                );

                stock.ajouterProduit(produit);
            } catch (Exception e) {
                System.out.println("Ligne ignorée : " + i);
            }
        }
        return stock;
    }

    /**
     * Convertit une valeur texte en double.
     * Retourne 0 si la valeur est vide.
     */

    private double parseValeurDouble(String valeur) {
        if (valeur == null || valeur.trim().isBlank()) {
            return 0.0;
        }

        try {
            return Double.parseDouble(valeur.trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    // Transforme une chaîne en liste d'ingrédients.
    private List<Ingredient> parseIngredients(String valeur) {
        List<Ingredient> ingredients = new ArrayList<>();

        if (valeur == null || valeur.isBlank()) {
            return ingredients;
        }

        String[] elements = valeur.split(",");

        for (String element : elements) {
            String texte = element.trim();
            if (!texte.isEmpty()) {
                ingredients.add(new Ingredient(texte));
            }
        }

        return ingredients;
    }

    // Transforme une chaîne en liste d'additifs.
    private List<Additif> parseAdditifs(String valeur) {
        List<Additif> additifs = new ArrayList<>();

        if (valeur == null || valeur.isBlank()) {
            return additifs;
        }

        String[] elements = valeur.split(",");

        for (String element : elements) {
            String texte = element.trim();
            if (!texte.isEmpty()) {
                additifs.add(new Additif(texte));
            }
        }

        return additifs;
    }

    // Transforme une chaîne en liste d'allergènes.
    private List<Allergene> parseAllergenes(String valeur) {
        List<Allergene> allergenes = new ArrayList<>();

        if (valeur == null || valeur.isBlank()) {
            return allergenes;
        }

        String[] elements = valeur.split(",");

        for (String element : elements) {
            String texte = element.trim();
            if (!texte.isEmpty()) {
                allergenes.add(new Allergene(texte));
            }
        }

        return allergenes;
    }

}
