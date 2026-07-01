package fr.as.traitementfichier;

import fr.as.traitementfichier.exception.OpenFoodFactsException;
import fr.as.traitementfichier.model.Produit;
import fr.as.traitementfichier.model.Stock;
import fr.as.traitementfichier.repository.OpenFoodFactsFileReader;
import fr.as.traitementfichier.service.OpenFoodFactsService;
import fr.as.traitementfichier.service.OpenFoodFactsServiceImpl;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class ApplicationOpenFoodFacts {
    public static void main(String[] args) throws OpenFoodFactsException {
        OpenFoodFactsFileReader reader = new OpenFoodFactsFileReader();
        Stock stock;

        try {
            stock = reader.lireFichier(Path.of("src/main/resources/open-food-facts.csv"));
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return;
        }

        OpenFoodFactsService service = new OpenFoodFactsServiceImpl(stock);
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            afficherMenu();
            System.out.print("Votre choix : ");

            try {
                choix = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide.");
                choix = -1;
            }

            switch (choix) {
                case 1 -> rechercherParMarque(service, scanner);
                case 2 -> rechercherParCategorie(service, scanner);
                case 3 -> rechercherParMarqueEtCategorie(service, scanner);
                case 4 -> afficherCompteur(service.recupererAllergenesLesPlusCourants(10));
                case 5 -> afficherCompteur(service.recupererAdditifsLesPlusCourants(10));
                case 0 -> System.out.println("Au revoir");
                default -> System.out.println("Choix invalide");
            }

        } while (choix != 0);
    }

    /**
     * Affiche le menu principal.
     */
    private static void afficherMenu() {
        System.out.println("\n--- MENU OPEN FOOD FACTS ---");
        System.out.println("1. Rechercher les meilleurs produits par marque");
        System.out.println("2. Rechercher les meilleurs produits par catégorie");
        System.out.println("3. Rechercher les meilleurs produits par marque et catégorie");
        System.out.println("4. Afficher les allergènes les plus courants");
        System.out.println("5. Afficher les additifs les plus courants");
        System.out.println("0. Quitter");
    }

    /**
     * Recherche les meilleurs produits pour une marque.
     */
    private static void rechercherParMarque(OpenFoodFactsService service, Scanner scanner) {
        System.out.print("Entrez une marque : ");
        String marque = scanner.nextLine();

        List<Produit> resultats = service.rechercherMeilleursProduitsParMarque(marque);
        afficherProduits(resultats);
    }

    /**
     * Recherche les meilleurs produits pour une catégorie.
     */
    private static void rechercherParCategorie(OpenFoodFactsService service, Scanner scanner) throws OpenFoodFactsException {
        System.out.print("Entrez une catégorie : ");
        String categorie = scanner.nextLine();

        List<Produit> resultats = service.rechercherMeilleursProduitsParCategorie(categorie);
        afficherProduits(resultats);
    }

    /**
     * Recherche les meilleurs produits pour une marque et une catégorie.
     */
    private static void rechercherParMarqueEtCategorie(OpenFoodFactsService service, Scanner scanner) throws OpenFoodFactsException {
        System.out.print("Entrez une marque : ");
        String marque = scanner.nextLine();

        System.out.print("Entrez une catégorie : ");
        String categorie = scanner.nextLine();

        List<Produit> resultats = service.rechercherMeilleursProduitsParMarqueEtCategorie(marque, categorie);
        afficherProduits(resultats);
    }

    /**
     * Affiche une liste de produits.
     */
    private static void afficherProduits(List<Produit> produits) {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit trouvé.");
            return;
        }

        for (Produit produit : produits) {
            System.out.println(produit);
        }
    }

    /**
     * Affiche un compteur trié.
     */
    private static void afficherCompteur(Map<String, Integer> compteur) {
        for (Map.Entry<String, Integer> entry : compteur.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}


