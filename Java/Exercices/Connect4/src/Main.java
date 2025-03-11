import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        afficherJeu(planJeu);
        Player gagnant = null;
        Player quiJoue = player2;
//        do{
        quiJoue = (quiJoue == player1) ? player2 : player1;
        System.out.println("C'est le tour de " + quiJoue.getNom());

        planJeu[3][5] = Jeton.JAUNE;
        planJeu[3][6] = Jeton.ROUGE;
        placerJeton(quiJoue, planJeu);



//        }while(gagnant == null);


    }

    public static boolean placerJeton(Player quiJoue, Jeton[][] planJeu) {
        int colonne = saisirChoix(planJeu);
        for(int row = 0; row < ROW; row++){
            if(planJeu[row][colonne] != Jeton.VIDE ){
                return true;
            }
            planJeu[row][colonne] = quiJoue.jeton;
            afficherJeu(planJeu);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            }catch(Exception e){

                }
        }
        return false;
    }


    public static int saisirChoix(Jeton[][]planJeu) {
        Scanner scanner = new Scanner(System.in);
        int colonne = -1;
        do {
            System.out.print("Dans quelle colonne voulez-vous mettre un jeton? [1 a 7] : ");
            String saisie = scanner.nextLine().trim();
            try {
                colonne = validerChoix(saisie, planJeu);
            } catch (Exception e ) {
                System.out.println(e);
            }
        } while (colonne < 1 || colonne > 7);
        System.out.println(colonne);
        return colonne;
    }

    public static int validerChoix(String choix, Jeton[][]planJeu) {
        int colonne = 0;
        try {
            colonne = Integer.parseInt(choix) - 1;
        } catch (InputMismatchException e) {
            System.out.println("Avez-vous saisi un nombre?");
        }
        if (colonne < 1 || colonne > 7) {
            throw new IllegalArgumentException("Erreur d'entree - saisir un nombre entre 1 et 7");
        }
        if( planJeu[0][colonne] != Jeton.VIDE){
         throw new IllegalArgumentException("La colonne est pleine! vous ne pouvez pas y mettre un jeton.\nEssayez de nouveau.");
        }

        return colonne;
    }

    public static void afficherJeu(Jeton[][] planJeu) {

        for (int row = 0; row < planJeu.length; row++) {

            for (int col = 0; col < COLUMN; col++) {
                System.out.print("|");
                System.out.print(planJeu[row][col].type);
                System.out.print("|");
            }
            System.out.println();
        }

        System.out.println();
    }


}