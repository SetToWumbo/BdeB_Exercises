enum TypeDeSable {
    FIN_DORE,
    ROUGE,
    GRIS_BRUN,
    NOIR,
    CALCAIRE,
    ORGANIQUE,
    MIXTE;
}

public class Plage extends Paysage {
    private int longueur;
    private TypeDeSable type;

    public Plage(long superficie, String nom, float latitude, float longitude, TypeDeSable type) {
        super(superficie, nom, latitude, longitude);
        this.type = type;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.print(" type de sable: " + type);
    }
}