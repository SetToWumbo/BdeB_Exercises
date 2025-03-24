//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[][] tab1 = new String[15][8];
        zero(tab1);
        afficherTab(tab1);


    }
//NE PAS MODIFIER CETTE METHODE
    public static void afficherTab(String[][] tab) {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j]);
            }
            System.out.print("\n");
        }
    }
// Methode de reference pour mettre un zero dans le tableau
    public static void zero(String[][] tab) {
        for (int i = 0; i < tab.length; i++) { // position de la rangee
            for (int j = 0; j < tab[i].length; j++) { // position de la colonne
                if (i == 0 || i == tab.length /2 || i == tab.length - 1 || j == 0 || j == tab[i].length - 1) {
                    tab[i][j] = "*";
                } else {
                    tab[i][j] = " ";
                }
            }
        }
    }
}
