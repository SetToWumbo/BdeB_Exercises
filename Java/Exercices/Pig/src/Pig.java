import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String saisie = "";
        do {
            do {
                System.out.print("[N]ouvelle partie  [Q]uitter ? ");
                saisie = scanner.nextLine().trim().toUpperCase();
            } while (!saisie.equals("Q") && !saisie.equals("N"));
            if (saisie.equals("N")) {
                System.out.println("***** Jeu de Pig! *****\n");
                Partie partie = new Partie();
                int compteur = 0;
                Joueur gagnant = null;
                do {
                    System.out.println("\n" + partie.sommaire());
                    partie.jouerTour(partie.getJoueurs()[compteur % partie.getJoueurs().length]);
                    compteur++;
                    gagnant = partie.estGagnant();
                } while (gagnant == null);
                System.out.println(gagnant.getNom() + " a gagne la partie!");
                System.out.println();
            }
        } while (saisie.equals("N"));
        System.out.println("Au revoir.");
    }
}