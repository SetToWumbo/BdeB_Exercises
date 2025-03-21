import java.util.Scanner;

public class Partie {
    private final int MIN_JOUEURS = 2;
    private final int MAX_JOUEURS = 5;
    private final int MIN_POINTS = 10;
    private final int MAX_POINTS = 100;
    private Joueur[] joueurs;
    private int pointsVictoire;

    public static void main(String[] args) {
        Partie partie = new Partie();
    }

    public Partie() {
        int nbJoueurs = 0;
        do {
            System.out.print("Nombre [2, 5] de Joueurs? : ");
            nbJoueurs = saisirMontant(MIN_JOUEURS, MAX_JOUEURS);
            joueurs = new Joueur[nbJoueurs];
        } while (nbJoueurs < MIN_JOUEURS || nbJoueurs > MAX_JOUEURS);
        do {
            System.out.print("Points pour la victoire? [10,100] : ");
            pointsVictoire = saisirMontant(MIN_POINTS, MAX_POINTS);
        } while (pointsVictoire < MIN_POINTS || pointsVictoire > MAX_POINTS);

        for (int i = 0; i < joueurs.length; i++) {
            Scanner scanner = new Scanner(System.in);
            String nom;
            boolean estDuplique;
            do {
                System.out.print("Saisir le nom du Joueur " + (i + 1) + "? : ");
                estDuplique = false;
                nom = scanner.nextLine().trim();
                for (Joueur joueur : joueurs) {
                    if (joueur != null && joueur.getNom().equals(nom)) {
                        System.out.println(nom + " est deja dans la partie.");
                        estDuplique = true;
                    }
                }
            } while (estDuplique);
            joueurs[i] = new Joueur(nom);
        }
    }

    public void jouer(Joueur joueur) {
        Scanner scanner = new Scanner(System.in);
        String saisie;
        int points = 0;
        int faceDe;
        do {
            System.out.print(joueur.getNom());
            System.out.print(" [R]ouler le de  [S]auvegarder vos points? ");
            saisie = scanner.nextLine().toUpperCase();
        } while (!saisie.equals("R") && !saisie.equals("S"));
        switch (saisie) {
            case "R":
                faceDe = De.rouler();
                if (faceDe == 1) {
                    System.out.println(joueur.getNom() + " roule un 1!");
                    return;
                } else{
                    System.out.println(joueur.getNom() + " roule un " + faceDe);
                }
        }
    }

    /**
     * Construit les stats de la partie par joueur
     *
     * @return String contenant les stats de la partie
     */
    private String sommaire() {
        StringBuilder sb = new StringBuilder();
        sb.append("SOMMAIRE: ");
        for (Joueur joueur : joueurs) {
            sb.append(joueur.getNom());
            sb.append(" ");
            sb.append(joueur.getPoints());
            sb.append(" pts  ");
        }
        return sb.toString();
    }


    /**
     * Permet de saisir un numéro entre deux valeurs inclusivement.
     * Retourne min - 1 en cas d'entree invalide.
     *
     * @param min Balise minimum
     * @param max Balise maximum
     * @return Saisie de l'utilisateur, ou min - 1
     */
    private int saisirMontant(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        String saisie;
        int num = min - 1;
        saisie = scanner.nextLine();
        try {
            num = Integer.parseInt(saisie);
        } catch (Exception e) {
        }
        return num;
    }
}