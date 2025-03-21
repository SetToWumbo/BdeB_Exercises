public class Personne{
   private final int DUREE_DEFAUT = 0;

   private Etat etat;
   private int dureeInf = DUREE_DEFAUT;
   private Virus virus;

   public void infecter(Virus virus){
       this.virus = virus;
   }
   public void exposer(Virus virus){
       if(virus.infecte() && etat == Etat.SUSCEPTIBLE){
           etat = Etat.INFECTEE;
       }
   }
    public Etat evoluer(){
       dureeInf--;
       if(virus.tue()){
        return Etat.DECEDEE;
       }else{
          if (dureeInf == 0){
              return Etat.RETABLIE;
          }
       }
       return etat;
    }

}