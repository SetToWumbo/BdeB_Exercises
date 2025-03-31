public class Paysage {
    private long superficie;
    private String nom;
    private float latitude;
    private float longitude;

    public Paysage(long superficie, String nom, float latitude, float longitude){
        this.superficie = superficie;
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void afficher(){
        StringBuilder sb = new StringBuilder();
        sb.append(nom);
        sb.append(" superficie: ");
        sb.append(superficie);
        sb.append(" latitude: ");
        sb.append(latitude);
        sb.append(" longitude: ");
        sb.append(longitude);
        System.out.print(sb.toString());
    }
}
