import java.util.Scanner;

public class Main {
    public static int ROW = 6;
    public static int COLUMN = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jeton[][] planJeu = new Jeton[ROW][COLUMN];
        Player player1 = new Player(Jeton.ROUGE);
        Player player2 = new Player(Jeton.JAUNE);

        System.out.print("Joueur 1: quel est votre nom? : ");
        player1.setNom(scanner.nextLine());
        System.out.print("Joueur 2: quel est votre nom? : ");
        player2.setNom(scanner.nextLine());

        for (int row = 0; row < planJeu.length; row++) {
            for (int col = 0; col < COLUMN; col++) {
                planJeu[row][col] = Jeton.VIDE;
            }
        }

        int tour = 0;
        Player gagnant = null;
        Player quiJoue = player2;
        afficherJeu(planJeu);
        do {
            tour++;
            quiJoue = (quiJoue == player1) ? player2 : player1;
            System.out.println("C'est le tour de " + quiJoue.getNom());
            int[] posJoué = placerJeton(quiJoue, planJeu);
            afficherJeu(planJeu);
            if (tour > 6) {
                gagnant = quiJoue.joueurGagnant(posJoué, planJeu);
            }
        } while (gagnant == null);
        System.out.println(gagnant.nom + " a gagné la partie!");
    }

    public static int[] placerJeton(Player quiJoue, Jeton[][] planJeu) {
        int colonne = saisirChoix(planJeu);
        int[] pos = new int[2];
        for (int row = 0; row < planJeu.length; row++) {
            pos[0] = row;
            pos[1] = colonne;
            if (planJeu[row][colonne] != Jeton.VIDE) {
                pos[0]--;
                return pos;
            }
            if (row > 0) {
                planJeu[row - 1][colonne] = Jeton.VIDE;
            }
            planJeu[row][colonne] = quiJoue.jeton;
        }
        return pos;
    }

    public static void afficherJeu(Jeton[][] planJeu) {

        for (int row = 0; row < planJeu.length; row++) {

            for (int col = 0; col < planJeu[0].length; col++) {
                System.out.print("|");
                System.out.print(planJeu[row][col].type);
                System.out.print("|");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static int saisirChoix(Jeton[][] planJeu) {
        Scanner scanner = new Scanner(System.in);
        int colonne;
        do {
            do {
                System.out.print("Dans quelle colonne voulez-vous mettre un jeton? [1 a 7] : ");
                try {
                    colonne = Integer.parseInt(scanner.nextLine().trim()) - 1;
                } catch (NumberFormatException e) {
                    System.out.println("Avez-vous saisi un nombre?");
                    colonne = -1;
                } catch (Exception e) {
                    System.out.println(e);
                    colonne = -1;
                }
                if (colonne < 0 || colonne > 6) {
                    System.out.println("Erreur d'entree - saisir un nombre entre 1 et 7");
                }
            } while (colonne < 0 || colonne > 6);

            if (planJeu[0][colonne] != Jeton.VIDE) {
                System.out.println("La colonne est pleine! vous ne pouvez pas y mettre un jeton.\nEssayez de nouveau.");
            }

        } while (planJeu[0][colonne] != Jeton.VIDE);
        return colonne;
    }


}