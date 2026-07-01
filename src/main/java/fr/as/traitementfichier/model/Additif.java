package fr.as.traitementfichier.model;

import java.util.Objects;

public class Additif {

    private String libelle;

    public Additif(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Additif additif)) return false;
        return Objects.equals(libelle, additif.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libelle);
    }

    @Override
    public String toString() {
        return libelle;
    }
}
