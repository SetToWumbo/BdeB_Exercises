import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player {

    public Jeton jeton;
    public String nom;

    Player(Jeton jeton) {
        this.jeton = jeton;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Player joueurGagnant(int[] pos, Jeton[][] planJeu) {
        Jeton[][] directions = new Jeton[4][];
        Jeton[] jetons;
        int[]depart = pos;
        for (int direction = 0; direction < directions.length; direction++) {
            directions[direction] = switch (direction) {
                case 0:
                    jetons = new Jeton[6];
                    jetons[pos[1]] = planJeu[pos[0]][pos[1]];
                    for(int i = 0; i < pos[1]; i++){
                        if(pos[0] - i < 0 || pos[1] - i < 0){

                        }
                    }

                    while(depart[0] != 0 && depart[1] != 0){

                    }
                case 1:

                case 2:
                    jetons = planJeu[pos[0]];
                case 3:
                    jetons = new Jeton[planJeu[0].length];
                    for (int row = 0; row < planJeu.length; row++) {
                        jetons[row] = planJeu[row][pos[1]];
                    }
            };
        }
        return null;
    }

    public Jeton getJeton(int[] pos, Jeton[][]planJeu){
        return planJeu[pos[0]][pos[1]];
    }
}

