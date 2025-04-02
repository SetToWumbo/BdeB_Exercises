import java.util.EmptyStackException;

public class Caisse {
    private int numCaisse;

    public Caisse(int numCaisse) {
        this.numCaisse = numCaisse;
    }

    //    figure out if the cart is empty or not yet, exit if cart is empty
//    add product to receipt list
    public Facture facturer(Panier panier) {
        Produit produit;
        try {
            produit = panier.retirer();
        } catch (EmptyStackException e) {
            System.out.println("Le panier que vous tentez de facturer est vide!");
            return null;
        }

        Facture facture = new Facture(numCaisse, produit);

        do {
            try {
                produit = panier.retirer();
            } catch (EmptyStackException e) {
                System.out.println("Facturation completee.");
                return facture;
            }
            facture.ajouter(produit);
        } while (produit != null);
        return facture;
    }
}