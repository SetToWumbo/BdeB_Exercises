import java.util.Random;

public class Population {
    private final int LARGEUR = 130;
    private final int HAUTEUR = 15;
    private Personne[][] population = new Personne[HAUTEUR][LARGEUR];

    public static void main(String[] args) {
        try{
            Population population = new Population(300);
            population.afficher();
        }catch(IllegalArgumentException e){
            System.out.println("Nombre de personnes invalide");
        }
    }
    public Population(int nombre) {
        if(nombre > 1 && nombre < (LARGEUR * HAUTEUR) - LARGEUR){
            Random random = new Random();
            int compteur = nombre;
            int x;
            int y;
            do{
                x = random.nextInt(2, LARGEUR);
                y = random.nextInt(2, HAUTEUR);
                if(population[y][x] == null){
                    population[y][x] = new Personne();
                    compteur--;
                }
            }while(compteur > 0);
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void afficher(){
        for(int y = 0; y < HAUTEUR; y++){
            for(int x = 0; x < LARGEUR; x++){
                if(population[y][x] != null){
                    System.out.print(population[y][x].getEtat().tag);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}