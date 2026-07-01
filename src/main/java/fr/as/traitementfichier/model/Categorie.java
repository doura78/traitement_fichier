package fr.as.traitementfichier.model;


import java.util.Objects;

public class Categorie {


        private String libelle;

        public Categorie(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Categorie categorie)) return false;
            return Objects.equals(libelle, categorie.libelle);
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

