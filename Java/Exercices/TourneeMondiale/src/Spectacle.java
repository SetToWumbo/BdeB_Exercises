public class Spectacle{
   private final Ville ville;
   private final String date;

    public Spectacle(Ville ville, String date){
        this.ville = ville;
        this.date = date;
    }

    public String getDate(){
        return date;
    }
    public Ville getVille(){
        return ville;
    }

}