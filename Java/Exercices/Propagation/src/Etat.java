public enum Etat {
    SUSCEPTIBLE(  "S" ),
    INFECTEE(   "\u001B[31m"+  "I" + "\u001B[0m"),
    RETABLIE (   "R"),
    DECEDEE(   "D"),;

    public final String tag;
     Etat(String tag){
       this.tag = tag;
    }
}