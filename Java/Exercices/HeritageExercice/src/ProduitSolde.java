public class ProduitSolde extends Produit {
    private final double reduction;

    public ProduitSolde(String nom, double prix, double reduction) {
        super(nom, prix);
        this.reduction = reduction;
    }

    public double getPrix() {
        return prix * (1 - reduction);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$-21s", nom));
        sb.append(String.format("$%-6.2f-%d%-1% $%6.2f\n", prix, (int) (reduction * 100), getPrix()));
        //String one: name of product
        //String two: right padded combo of all prices to reach a max of padding value
        return sb.toString();
    }
}