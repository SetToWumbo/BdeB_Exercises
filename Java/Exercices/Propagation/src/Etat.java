public enum Etat {
    SUSCEPTIBLE( "\u001B[37m"+  "S" + "\u001B[0m"),
    INFECTEE( "\u001B[31m"+  "I" + "\u001B[0m"),
    RETABLIE ( "\u001B[34m"+  "R" + "\u001B[0m"),
    DECEDEE( "\u001B[30m"+  "D" + "\u001B[0m"),;

    public final String tag;
     Etat(String tag){
       this.tag = tag;
    }
}