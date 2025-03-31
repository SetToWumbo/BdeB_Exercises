import java.util.ArrayList;

public class Facture {
    private static int numFacture = 0;
    private static int numCaisse ;
    private ArrayList<Produit> produitsFactures = new ArrayList<>();

    public Facture(Produit produit, int numCaisse) {
        numFacture++;
        this.numCaisse = numCaisse;
    }

    public String toString(int numCaisse) {
        StringBuilder sb = new StringBuilder();
        sb.append("Caisse ");
        sb.append(numCaisse);
        sb.append("                           Facture ");
        sb.append(numFacture);
        sb.append("\n");
        sb.append("-------------------------------");

        double total = 0;
        for (Produit produit : produitsFactures) {
            sb.append(produit.toString());
            sb.append("$\n");
            total += produit.getPrix();
        }

        sb.append("-------------------------------");
        sb.append("Total                            ");
        sb.append(total);
        sb.append(" $");
        return sb.toString();
    }

    ;
}