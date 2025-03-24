import java.util.Scanner;

public class Partie {
    private final int MIN_JOUEURS = 2;
    private final int MAX_JOUEURS = 5;
    private final int MIN_POINTS = 10;
    private final int MAX_POINTS = 100;
    private Joueur[] joueurs;
    private int pointsVictoire;

    public Partie() {
        int nbJoueurs = saisirMontantIncl("Nombre [2, 5] de Joueurs? : ", MIN_JOUEURS, MAX_JOUEURS);
        joueurs = new Joueur[nbJoueurs];
        pointsVictoire = saisirMontantIncl("Points [10, 100] pour la victoire?", MIN_POINTS, MAX_POINTS);

        Scanner scanner = new Scanner(System.in);
        boolean estDuplique;
        for (int i = 0; i < joueurs.length; i++) {
            String nom;
            do {
                System.out.print("Saisir le nom du Joueur " + (i + 1) + "? : ");
                nom = scanner.nextLine().trim();
                estDuplique = false;
                for (Joueur joueur : joueurs) {
                    if (joueur == null) {
                        break;
                    } else if (joueur.getNom().equals(nom)) {
                        System.out.println(nom + " est deja dans la partie.");
                        estDuplique = true;
                        break;
                    }
                }
            } while (estDuplique);
            joueurs[i] = new Joueur(nom);
        }
    }

    /**
     * Deroulement d'un tour de la partie.
     */
    public void jouer() {
        Scanner scanner = new Scanner(System.in);
        String saisie = "";
        Joueur joueur;
        int compteur = 0;
        int points = 0;
        int faceDe = 0;

        do {
            System.out.println(sommaire());
            do {
                joueur = joueurs[compteur % joueurs.length];
                do {
                    System.out.print(joueur.getNom());
                    System.out.print(": [R]ouler le dé ou [S]auvegarder vos points? ");
                    saisie = scanner.nextLine().toUpperCase();
                } while (!saisie.equals("R") && !saisie.equals("S"));
                switch (saisie) {
                    case "R":
                        faceDe = De.rouler();
                        if (faceDe == 1) {
                            System.out.println(joueur.getNom() + " roule un 1!");
                            points = 0;
                            compteur++;
                            break;
                        } else {
                            System.out.print(joueur.getNom() + " roule un " + faceDe + ". ");
                            points += faceDe;
                            System.out.print("Jusqu'a maintenant dans ce tour : " + points);
                            System.out.println();
                        }
                        break;
                    case "S":
                        joueur.setPoints(joueur.getPoints() + points);
                        points = 0;
                        if (joueur.getPoints() >= pointsVictoire) {
                            System.out.println(joueur.getNom() + " a gagne la partie!!");
                            System.out.println();
                            return;
                        } else {
                            compteur++;
                            break;
                        }
                }
            } while (faceDe != 1 && saisie.equals("R"));
        } while (true);
    }

    /**
     * Construit les stats de la partie à afficher
     *
     * @return String contenant les stats de la partie
     */
    public String sommaire() {
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
     * Demande à l'utilisateur de saisir un numéro compris entre deux valeurs inclusivement.
     *
     * @param min Valeur minimum
     * @param max Valeur maximum
     * @return Numero saisi par l'utilisateur
     */
    private int saisirMontantIncl(String question, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int num = min - 1;
        do {
            System.out.println(question);
            String saisie = scanner.nextLine();
            try {
                num = Integer.parseInt(saisie);
            } catch (Exception e) {
            }
        } while (num < min || num > max);
        return num;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }
}