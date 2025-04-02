public class ProduitSolde extends Produit {
    private double reduction;

    public ProduitSolde(String nom, double prix, double reduction) {
        super(nom, prix);
        this.reduction = reduction;
    }

     public double getPrix() {
        return prix * reduction;
    }


    public static void main(String[] args) {
        ProduitSolde patate = new ProduitSolde("Patate", 7.564, 0.30);
        System.out.println(patate.toString());
    }
    @Override
    public String toString() {
        return String.format("%1$-1s $%2$s -%3$d %4$s\n", nom, prix, (int)(reduction * 100), getPrix());
    }
}