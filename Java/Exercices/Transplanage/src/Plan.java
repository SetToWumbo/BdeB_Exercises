public class Plan {
    final static int DIMENSION = 5;
    private char[][] plan = new char[DIMENSION][DIMENSION];

    public char lire(int colonne, int rangee) {
        return plan[rangee][colonne];
    }

    public void ecrire(char lettre, int colonne, int rangee) {
        plan[rangee][colonne] = lettre;
    }

    public static int taille() {
        return DIMENSION * DIMENSION;
    }
}
