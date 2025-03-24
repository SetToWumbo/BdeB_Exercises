import java.util.ArrayList;
import java.util.Random;

public class Population {
    private final int LARGEUR = 130;
    private final int HAUTEUR = 15;
    private Personne[][] population = new Personne[HAUTEUR][LARGEUR];
    public int jour = 0;
    int personnes;
    int infectes;
    int retablies;

    public static void main(String[] args) {
        Population population1 = null;
        try {
            population1 = new Population(300);
        } catch (IllegalArgumentException e) {
            System.out.println("Nombre de personnes invalide");
        }
        Virus Boulognia = new Virus("Boulogna H25+", 15, 5, 30, 1);
        population1.infecterPatientZero(Boulognia);
        for(int i = 0; i < 100; i++){
            population1.evoluer();
        }

        ;
    }

    public Population(int nombre) {
        if (nombre > 1 && nombre < (LARGEUR * HAUTEUR) - LARGEUR) {
            Random random = new Random();
            int compteur = nombre;
            int x;
            int y;
            do {
                x = random.nextInt(LARGEUR);
                y = random.nextInt(HAUTEUR);
                if (population[y][x] == null) {
                    population[y][x] = new Personne();
                    compteur--;
                }
            } while (compteur > 0);
            personnes = nombre;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void evoluer() {
        jour++;
        for (int y = 0; y < HAUTEUR; y++) {
            for (Personne personne : population[y]) {
                if (personne != null && personne.getEtat() == Etat.INFECTEE) {
                    personne.evoluer();
                }
            }
        }
        afficher();
        System.out.println("DEPLACEMENT");
        deplacement();
        afficher();
        System.out.println("PROPAGATION");
        propagation();
        afficher();
    }

    public void deplacement() {
        Random random = new Random();
        for (int y = 0; y < HAUTEUR; y++) {
            for (int x = 0; x < LARGEUR; x++) {
                if (population[y][x] != null && population[y][x].getEtat() != Etat.DECEDEE) {
                    int newX = Math.min(Math.max(x + random.nextInt(-1, 2), 0), LARGEUR - 1);
                    int newY = Math.min(Math.max(y + random.nextInt(-1, 2), 0), HAUTEUR - 1);
                    if (population[newY][newX] == null) {
                        population[newY][newX] = population[y][x];
                        population[y][x] = null;
                    }
                }
            }
        }
    }

    public void propagation() {
        for (int y = 0; y < HAUTEUR; y++) {
            for (int x = 0; x < LARGEUR; x++) {
                if (population[y][x] != null && population[y][x].getEtat() == Etat.INFECTEE) {
                    for (int i = -1; i < 2; i++) {

                    }
                    int maxX = (Math.min(x + 1, LARGEUR - 1));
                    int minX = (Math.max(x - 1, 0));
                    int minY = (Math.max(y - 1, 0));
                    int maxY = (Math.min(y + 1, HAUTEUR - 1));
                    for (int i = minY; i <= maxY; i++) {
                        for (int j = minX; j <= maxX; j++) {
                            if (population[i][j] != null && population[i][j].getEtat() == Etat.SUSCEPTIBLE) {
                                System.out.println("essai de propagation depuis la position " + y + " " + x);
                                population[i][j].exposer(population[y][x].getVirus());
//                                population[i][j].infecter(population[y][x].getVirus());
                                System.out.println("position infectee: " + i + " " + j);
                            }
                        }
                    }
                }
            }
        }
    }

    public void infecterPatientZero(Virus virus) {
        int distance = 1;
        int yCentre = HAUTEUR / 2;
        int xCentre = LARGEUR / 2;
        boolean infecte = false;
        do {
            for (int j = Math.max((yCentre - distance), 0); j < Math.min((yCentre + distance), HAUTEUR); j++) {
                for (int i = Math.max((xCentre - distance),0); i < Math.min((xCentre + distance),LARGEUR); i++) {
                    if (population[j][i] != null) {
                        population[j][i].infecter(virus);
                        System.out.println("Position " + j + " " + i + " infectee");
                        return;
                    }
                }
            }
            distance++;
        } while (!infecte);
    }

    public void afficher() {
        StringBuilder sb = new StringBuilder();

        int pop = 0;
        for (int y = 0; y < HAUTEUR; y++) {
            for (int x = 0; x < LARGEUR; x++) {
                if (population[y][x] != null) {
                    System.out.print(population[y][x].getEtat().tag);
                    if (population[y][x].getEtat() != Etat.DECEDEE) {
                        pop++;
                    }
                } else {
                    System.out.print("_");
                }
            }
            System.out.println();

        }

        System.out.println("Jour : " + jour + " Population : " + pop);
        System.out.println();
    }
}