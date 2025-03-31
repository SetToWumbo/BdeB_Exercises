public class Lac extends Paysage{
    private int profondeur;

    public Lac(long superficie, String nom, float latitude, float longitude, int profondeur){
        super(superficie, nom, latitude, longitude);
        this.profondeur = profondeur;
    }
    public void afficher(){
        super.afficher();
        System.out.print(" profondeur: " + profondeur);
    }
}