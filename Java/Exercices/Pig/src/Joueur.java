public class Joueur {

private final int MIN_POINTS = 0;
    private final String nom;
    private int points;

    Joueur(String nom){
       this.nom = nom;
       this.points = MIN_POINTS;
    }

    public String getNom() {
        return nom;
    }
    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
       this.points = points;
    }
}