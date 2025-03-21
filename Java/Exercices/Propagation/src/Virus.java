import java.util.Random;

public class Virus {
    private Random random = new Random();
    private String nomVirus;
    private int dureeInf;
    private int dureeCrit;
    private int degCont;
    private int tauxMort;

    public Virus(String nomVirus) {
        this.nomVirus = nomVirus;
        dureeInf = random.nextInt(1, 31);
        dureeCrit = random.nextInt(1, dureeInf + 1);
        degCont = random.nextInt(1, 101);
        tauxMort = random.nextInt(1, 101);
    }

    public int getDureeInf() {
        return dureeInf;
    }

    public int getDureeCrit() {
        return dureeCrit;
    }

    public boolean infecte() {
        return (random.nextInt(1, 101) <= degCont);
    }

    public boolean tue() {
        return (random.nextInt(1, 101) <= degCont);
    }
}
