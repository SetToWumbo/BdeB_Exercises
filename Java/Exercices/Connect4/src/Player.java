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
                    int hor = 0, ver = 0, d1 = 0, d2 = 0;
                    // horizontal:
                    for (int y = Math.max(pos[0] - 3, 0); y < Math.min(pos[0] + 3, planJeu.length); y++) {//start: top row, end: bottom row
                        for (int x = Math.max(pos[1] - 3, 0); x < Math.min(pos[1] + 3, planJeu[pos[0]].length); x++) {//start: left max, right max
                            if (planJeu[pos[0]][x] == jeton) {
                                hor++;
                                if (hor == 4) {
                                    return this;
                                }
                            } else {
                                hor = 0;
                            }
                            if (planJeu[pos[1]][y] == jeton) {
                                ver++;
                                if (ver == 4) {
                                    return this;

                                }
                            }


                        }

                    }

            return null;
        }

    public Jeton getJeton(int[] pos, Jeton[][] planJeu) {
        return planJeu[pos[0]][pos[1]];
    }
}

