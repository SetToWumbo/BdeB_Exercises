import java.util.ArrayList;

public class Facture {
    private static int sequence = 0;
    private final int numFacture;
    private final int numCaisse;
    private ArrayList<Produit> produitsFactures;

    public Facture(int numCaisse, Produit produit) {
        this.numCaisse = numCaisse;
        numFacture = ++sequence;
        produitsFactures = new ArrayList<>();
        ajouter(produit);
    }

    public void ajouter(Produit produit) {
        produitsFactures.add(produit);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        String header = "Caisse %1$d%2$28s%3$3d\n";
        sb.append(String.format(header, numCaisse,"Facture", numFacture));
        sb.append("---------------------------------------\n");
        for (Produit p : produitsFactures) {
            sb.append(p.toString());
            total += p.getPrix();
        }
        sb.append("---------------------------------------\n");
        sb.append(String.format("%-30s $%7.2f","Total", total));
        return sb.toString();
    }
}