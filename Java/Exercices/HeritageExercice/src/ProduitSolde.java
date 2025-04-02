public class ProduitSolde extends Produit {
    private double reduction;

    public ProduitSolde(String nom, double prix, double reduction) {
        super(nom, prix);
        this.reduction = reduction;
    }

    public double getPrix() {
        return prix * reduction;
    }
}