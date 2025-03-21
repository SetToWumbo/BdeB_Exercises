import java.util.Scanner;

public class Partie {
    private Joueur[] joueurs;
    private int pointsVictoire;

    public Partie() {
        Scanner scanner = new Scanner(System.in);
        int nbJoueurs = 0;
        String saisie;
        do {
            System.out.print("Nombre [2, 5] de joueurs? : ");
            saisie = scanner.nextLine();
            try {
                nbJoueurs = Integer.parseInt(saisie);
            } catch (Exception e) {

            }
            joueurs = new Joueur[nbJoueurs];
        } while (nbJoueurs < 2 || nbJoueurs > 5);
        do {
            System.out.print("Points pour la victoire? [10,100] : ");
            saisie = scanner.nextLine();
            try {
                pointsVictoire = Integer.parseInt(saisie);
            } catch (Exception e) {

            }
        } while (pointsVictoire < 10 || pointsVictoire > 100);


    }
}