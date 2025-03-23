public class Personne {


    private Etat etat;
    private int dureeInf;
    private Virus virus;

    public Personne() {
        etat = Etat.SUSCEPTIBLE;
        dureeInf = 0;
    }

    public void infecter(Virus virus) {
        this.virus = virus;
    }

    public void exposer(Virus virus) {
        if (virus.infecte() && etat == Etat.SUSCEPTIBLE) {
            etat = Etat.INFECTEE;
        }
    }

    public Etat evoluer() {
        dureeInf--;
        if (virus.tue()) {
            return Etat.DECEDEE;
        } else {
            if (dureeInf == 0) {
                return Etat.RETABLIE;
            }
        }
        return etat;
    }

    public Etat getEtat() {
        return etat;
    }

    public Virus getVirus() {
        return virus;
    }

}