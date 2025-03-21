import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Player {
    public Jeton jeton;
    public String nom;

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

    public static Player remplirTab(int[] pos, Jeton[][] planJeu) {
        int H = 0;
        int V = 0;
        int D1 = 0;
        int D2 = 0;
        Jeton jeton = Jeton.ROUGE;
        int y;
        int x;
        int y2;
        for (int offset = -3; offset <= 3; offset++) {
            x = pos[1] + offset;
            y = pos[0] + offset;
            y2 = pos[0] - offset;

            if (y >= 0 && y < planJeu.length) {
                // axe vertical
                planJeu[y][pos[1]] = jeton;

            }
            if (x >= 0 && x < planJeu[pos[0]].length) {
                // axe horizontal
                planJeu[pos[0]][x] = jeton;

            }
            if (x >= 0 && x < planJeu[pos[0]].length) {
                // Diagonale gauche droite vers le bas
                if (y >= 0 && y < planJeu.length) {
                    planJeu[y][x] = jeton;

                }
                if (y2 >= 0 && y2 < planJeu.length) {
                    // Diagonale gauche droite vers le haut
                    planJeu[y2][x] = jeton;

                }
            }
        }
        return null;
    }

    Player(Jeton jeton) {
        this.jeton = jeton;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    /**
     *Vérifie la zone autour du jeton qui vient d'être placé pour évaluer si le joueur a gagné la partie ou non.
     *
     * @param pos     position du jeton qui a été joué (pos[0] = position verticale, pos[1] = position horizontale)
     * @param planJeu plan du jeu Connect 4 dans lequel le jeton a été placé
     */
    public Player joueurGagnant(int[] pos, Jeton[][] planJeu) {
        int[] consecutifs = {0, 0, 0, 0};
        int y, x, y2;
        for (int offset = -3; offset <= 3; offset++) {
            x = pos[1] + offset;
            y = pos[0] + offset;
            y2 = pos[0] - offset;
            // axe vertical
            if (y >= 0 && y < planJeu.length) {
                if (planJeu[y][pos[1]] == jeton) {
                    consecutifs[0]++;
                    if (consecutifs[0] == 4) {
                        return this;
                    }
                } else {
                    consecutifs[0] = 0;
                }
            }

            // axe horizontal
            if (x >= 0 && x < planJeu[pos[0]].length) {
                if (planJeu[pos[0]][x] == jeton) {
                    consecutifs[1]++;
                    if (consecutifs[1] == 4) {
                        return this;
                    }
                } else {
                    consecutifs[1] = 0;
                }

            //axe D1
                if (y >= 0 && y < planJeu.length) {
                    if (planJeu[y][x] == jeton) {
                        consecutifs[2]++;
                        if (consecutifs[2] == 4) {
                            return this;
                        }
                    } else {
                        consecutifs[2] = 0;
                    }
                }

                //axe D2
                if (y2 >= 0 && y2 < planJeu.length) {
                    if (planJeu[y2][x] == jeton) {
                        consecutifs[3]++;
                        if (consecutifs[3] == 4) {
                            return this;
                        }
                    } else {
                        consecutifs[3] = 0;
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

