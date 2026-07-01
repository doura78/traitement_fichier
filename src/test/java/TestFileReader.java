
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestFileReader {
    public static void main(String[] args) throws IOException {


        Path pathFile = Paths.get("C:/Users/sidib/Desktop/Diginamic/CDA/Cours-20260518/Java/J3 & J4/open-food-facts.csv");
        List<String> lines = Files.readAllLines(pathFile);

        for (int i = 1; i < lines.size(); i++) {
            String ligne = lines.get(i);

            String[] tokens = ligne.split("\\|");

            String nom = tokens[2];
            String marque = tokens[1];
            String categorie = tokens[0];



        System.out.println("Ligne : " + ligne);
        System.out.println("Catégorie : " + categorie + " | Marque : " + marque + " | Nom : " + nom);
    }
    System.out.println("Liste produits chargées : " + (lines.size() - 1));
        System.out.println(lines.get(0));
}

}