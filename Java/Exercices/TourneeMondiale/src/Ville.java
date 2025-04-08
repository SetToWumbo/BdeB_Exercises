public class Ville{
    private final String nom;
    private final String pays;

    public Ville(String nom, String pays){
        this.nom = nom;
        this.pays = pays;
    }

    public String toString(){
        return nom +" (" + pays +")";
    }
}