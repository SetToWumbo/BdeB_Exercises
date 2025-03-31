import java.util.Stack;

public class Panier {
    private Stack<Produit> panier = new Stack<>();

    private void ajouter(Produit produit) {
        panier.add(produit);
    }

    private Produit retirer() {
        return panier.pop();
    }
}