import java.util.Random;

public class Personnage {
    private final int PDV_DEF = 100;
    private final int EN_DEF = 150;
    private final int NIV_DEF = 0;
    private final int D_DEF = 10;
    private final int A_DEF = 5;
    private String nom;

    protected int pointsDeVie;
    protected int energie;
    protected int niveau;
    protected int defense;
    protected int attaque;
    private Random random = new Random();

    public Personnage() {
        pointsDeVie = PDV_DEF;
        energie = EN_DEF;
        niveau = NIV_DEF;
        defense = D_DEF;
        attaque = A_DEF;
    }

    public Personnage(String nom, int pointsDeVie, int energie, int niveau) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
        this.energie = energie;
        this.niveau = niveau;
        this.defense = niveau * 10;
        this.attaque = niveau * 5;
    }

    protected int userEnergie(int montant) {
        return Math.max((energie - montant), 0);
    }

    protected void deplacer(int nbDeCases) {
        energie = userEnergie(2 * nbDeCases);
    }

    protected int attaquer() {
        energie = userEnergie(5);
        return random.nextInt(1, niveau + 1);
    }

    protected int attaquer(double mult) {
        userEnergie(5);
        return (int) (random.nextInt(1, niveau + 1) * mult);
    }

    protected int defendre(int attaque) {
        if (attaque > defense) {
            energie = userEnergie(10);
            return attaque - defense;
        } else {
            return 0;
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getNom(){
        return nom;
    }



}