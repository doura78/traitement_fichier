package fr.as.traitementfichier.model;

import java.util.List;
import java.util.Objects;


public class Produit {

    private Categorie categorie;
    private Marque marque;
    private String nom;
    private String nutritionGradeFr;

    private double energie;
    private double graisse;
    private double sucres;
    private double fibres;
    private double proteines;
    private double sel;

    private List<Ingredient> ingredients;
    private List<Additif> additifs;
    private List<Allergene> allergenes;



    public Produit(Categorie categorie, Marque marque, String nom, String nutritionGradeFr, double energie, double graisse, double sucres, double fibres, double proteines, double sel, List<Ingredient> ingredients, List<Additif> additifs, List<Allergene> allergenes) {
        this.categorie = categorie;
        this.marque = marque;
        this.nom = nom;
        this.nutritionGradeFr = nutritionGradeFr;
        this.energie = energie;
        this.graisse = graisse;
        this.sucres = sucres;
        this.fibres = fibres;
        this.proteines = proteines;
        this.sel = sel;
        this.ingredients = ingredients;
        this.additifs = additifs;
        this.allergenes = allergenes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public String getNom() {
        return nom;
    }

    public String getNutritionGradeFr() {
        return nutritionGradeFr;
    }

    public double getEnergie() {
        return energie;
    }

    public double getGraisse() {
        return graisse;
    }

    public double getSucres() {
        return sucres;
    }

    public double getfibres() {
        return fibres;
    }

    public double getProteines() {
        return proteines;
    }

    public double getSel() {
        return sel;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Additif> getAdditifs() {
        return additifs;
    }

    public List<Allergene> getAllergenes() {
        return allergenes;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Produit produit)) return false;
        return Double.compare(energie, produit.energie) == 0 && Double.compare(graisse, produit.graisse) == 0 && Double.compare(sucres, produit.sucres) == 0 && Double.compare(fibres, produit.fibres) == 0 && Double.compare(proteines, produit.proteines) == 0 && Double.compare(sel, produit.sel) == 0 && Objects.equals(categorie, produit.categorie) && Objects.equals(marque, produit.marque) && Objects.equals(nom, produit.nom) && Objects.equals(nutritionGradeFr, produit.nutritionGradeFr) && Objects.equals(ingredients, produit.ingredients) && Objects.equals(additifs, produit.additifs) && Objects.equals(allergenes, produit.allergenes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categorie, marque, nom, nutritionGradeFr, ingredients, energie, graisse, sucres, fibres, proteines, sel, additifs, allergenes);
    }

    @Override
    public String
    toString() {
        return "categorie='" + categorie +
                ", marque='" + marque +
                ", nom='" + nom +
                ", nutritionGradeFr='" + nutritionGradeFr +
                ", ingredients='" + ingredients +
                ", energie=" + energie +
                ", graisse=" + graisse +
                ", sucres=" + sucres +
                ", fibres=" + fibres +
                ", proteines=" + proteines +
                ", sel=" + sel +
                ", additifs='" + additifs +
                ", allergenes='" + allergenes;
    }
}