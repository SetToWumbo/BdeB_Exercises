public class Player {

    public Jeton jeton;
    public String nom;
    Player(Jeton jeton){
        this.jeton = jeton;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }
}
