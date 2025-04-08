import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BaseDonnee{
    private final ArrayList<Spectacle> spectacles;

    public BaseDonnee(String nomFichier){
        spectacles = chargerSpectacles(nomFichier);
    }

    public ArrayList<Spectacle> chargerSpectacles(String nomFichier){
        ArrayList<String> lignes = lireFichier(nomFichier);

    }

    private ArrayList<String> lireFichier(String nomFichier){
        Path cheminFichier = Paths.get(nomFichier);
        ArrayList<String> lignes;
        try{
            lignes = new ArrayList<>(Files.readAllLines(cheminFichier));
        }catch(Exception e){
            throw new RuntimeException(nomFichier + ": erreur de la lecture du fichier");
        }
        return lignes;
    }
}