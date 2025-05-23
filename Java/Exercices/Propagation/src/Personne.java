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
        dureeInf = virus.getDureeInf();
        etat = Etat.INFECTEE;
        System.out.println("personne infectee");
    }

    public void exposer(Virus virus) {
        if (etat == Etat.SUSCEPTIBLE && virus.infecte()) {
            infecter(virus);
        }
    }

    public void evoluer() {
        dureeInf--;
        if (virus.tue()) {
            etat = Etat.DECEDEE;
            System.out.println("personne decedee");
        } else {
            if (etat == Etat.INFECTEE && dureeInf == 0) {
                etat = Etat.RETABLIE;
                System.out.println("personne retablie!");
            }
        }
    }

    public Etat getEtat() {
        return etat;
    }

    public Virus getVirus() {
        return virus;
    }

}