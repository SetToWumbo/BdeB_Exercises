public class Montagne extends Paysage {

    private int altitude;

    public Montagne(long superficie, String nom, float latitude, float longitude, int altitude) {
        super(superficie, nom, latitude, longitude);
        this.altitude = altitude;
    }

    public void afficher() {
        super.afficher();
        System.out.print(" altitude: " + altitude);
    }
}