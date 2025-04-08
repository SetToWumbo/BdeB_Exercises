public class Produit {
    protected final String nom;
    protected final double prix;

    public Produit(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public static void main(String[] args) {
        Produit produit = new Produit("Banane", 5.60);
        ProduitSolde produit2 = new ProduitSolde("Vieille Banane", 5.60, .05);
        ProduitSolde produit3 = new ProduitSolde("Vieille Banane Rouge", 25.60, .05);
        Facture facture1 = new Facture(1, produit);
        facture1.ajouter(produit2);
        facture1.ajouter(produit);
        facture1.ajouter(produit3);
        System.out.println(facture1.toString());
    }
    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%1$-32s", nom));
        sb.append(String.format("$%6.2f\n", prix));
        return sb.toString();
    }
}
