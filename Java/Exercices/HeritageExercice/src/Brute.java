public class Brute extends Personnage {
    private final int dmgBonus = niveau + 2;
    private final int healthMod = 20;

    public Brute() {
        super();
        attaque += dmgBonus;
        pointsDeVie += healthMod;
    }

    public Brute(int pointsDeVie, int energie, int niveau) {

    }
}