import java.util.Stack;

public class Panier {

    private Stack<Produit> articles;

    public void ajouter(Produit produit) {
        articles.add(produit);
    }

    public Produit retirer() {
        return articles.pop();
    }

}