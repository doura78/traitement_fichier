package fr.as.traitementfichier.model;

import java.util.Objects;

public class Ingredient {


        private String libelle;

        public Ingredient(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Ingredient ingredient)) return false;
            return Objects.equals(libelle, ingredient.libelle);
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
