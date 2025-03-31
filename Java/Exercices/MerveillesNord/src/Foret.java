enum Region {
    ACADIENNE("Acadienne"),
    BOREALE("Boréale"),
    CAROLINIENNE("Carolinienne"),
    COTIERE("Cotière"),
    COLOMBIA("Colombia"),
    GRANDS_LACS("Grands-Lacs et du Saint-Laurent"),
    MONTAGNARDE("Montagnarde"),
    SUBALPINE("Subalpine");

    private String nom;

    Region(String nom) {
        this.nom = nom;
    }
}

public class Foret extends Paysage {
    private Region region;

    public Foret(long superficie, String nom, float latitude, float longitude, Region region) {
        super(superficie, nom, latitude, longitude);
        this.region = region;
    }


    public void afficher() {
        super.afficher();
        System.out.print(" region: " + region);
    }
}