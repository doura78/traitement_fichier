package fr.as.traitementfichier.model;

import java.util.Objects;

public class Marque {
    private String nom;

    public Marque(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Marque marque)) return false;
        return Objects.equals(nom, marque.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return nom;
    }
}
