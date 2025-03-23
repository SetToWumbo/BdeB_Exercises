import java.util.Scanner;

public class Pig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String saisie = "";
        do {
            do {
                System.out.println("***** Jeu de Pig! *****\n");
                System.out.print("[N]ouvelle partie  [Q]uitter ? ");
                saisie = scanner.nextLine().trim().toUpperCase();
            } while (!saisie.equals("Q") && !saisie.equals("N"));
            if (saisie.equals("N")) {
                Partie partie = new Partie();
                partie.jouer();
            }
        } while (saisie.equals("N"));
        System.out.println("Au revoir.");
    }
}