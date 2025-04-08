import java.util.ArrayList;

public class Magasin{
    public static void main(String[] args) {
        Caisse caisse1 = new Caisse(1);
        Caisse caisse2 = new Caisse(2);
        ArrayList<Produit> liste1 = new ArrayList<>();
        liste1.add(new ProduitSolde("Tres Vieille Banane", 5.35, .5));
        liste1.add(new ProduitSolde("Vieille Banane", 5.35, .2));
        liste1.add(new Produit("Banane", 5.35));
        liste1.add(new Produit("Pomme", 7.45));
        liste1.add(new ProduitSolde("Vieille Pomme", 7.45, .5));
        liste1.add(new ProduitSolde("Tres Vieille Pomme", 7.45, .7));
        liste1.add(new ProduitSolde("Vieille Pomme Rouge", 8.45, .5));
        liste1.add(new Produit("Chaussure",90.45));
        ArrayList<Panier>paniers = new ArrayList<>();
        for(int i = 0; i < 5; i++){
           paniers.add(new Panier());
           
        }

    }



}