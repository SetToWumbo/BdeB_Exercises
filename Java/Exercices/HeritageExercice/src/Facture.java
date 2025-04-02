import java.util.ArrayList;

public class Facture {
    private static int numFacture = 0;
    private final int numCaisse;
    private ArrayList<Produit> produitsFactures;

    public Facture(int numCaisse, Produit produit) {
        this.numCaisse = numCaisse;
        produitsFactures = new ArrayList<>();
        produitsFactures.add(produit);
    }

   public void ajouter(Produit produit){
        produitsFactures.add(produit);
   }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caisse ");
        sb.append(numCaisse);
    }
}