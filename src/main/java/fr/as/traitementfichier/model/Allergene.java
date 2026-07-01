package fr.as.traitementfichier.model;

import java.util.Objects;

public class Allergene {

        private String libelle;

        public Allergene(String libelle) {
            this.libelle = libelle;
        }

        public String getLibelle() {
            return libelle;
        }

        @Override
        public boolean equals(Object object) {
            if (!(object instanceof Allergene allergene)) return false;
            return Objects.equals(libelle, allergene.libelle);
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
