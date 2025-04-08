public class Billet {
    protected static final String TITRE = "SIX FINGERS DRUMMER BAND - 2025 BEATEN PATH TO INSANITY WORLD TOUR\n";
    private static int sequence = 32625;
    private final int numeroSerie;
    private final Spectacle spectacle;
    private final int prix;

    public Billet(Spectacle spectacle, int prix) {
        this.spectacle = spectacle;
        this.prix = prix;
        this.numeroSerie = sequence++;
    }

    @Override
    public String toString() {
        return TITRE + spectacle.getDate() + " - " + spectacle.getVille().toString() +
                 " - Billet " + String.format("%08d", numeroSerie) + " - $" + prix;
    }
}