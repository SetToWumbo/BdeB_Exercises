import java.util.ArrayList;

public class Facture {
    private static int numFacture = 0;
    private final int numCaisse;
    private ArrayList<Produit> produitsFactures;

    public Facture(int numCaisse, Produit produit) {
        this.numCaisse = numCaisse;
        produitsFactures = new ArrayList<>();
        ajouter(produit);
    }

    public void ajouter(Produit produit) {
        produitsFactures.add(produit);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String header = "Caisse %2$-32s Facture %0s\n";
        String lineItem = "%s";

        sb.append(String.format(header, numCaisse, numFacture));
        sb.append("-------------------------------------------------");


        return sb.toString();
    }

    public static void main(String[] args) {
        Produit patate = new Produit("Patate", 25.89);
        Facture facture = new Facture(3, patate);

        System.out.println(facture.toString());

    }
}