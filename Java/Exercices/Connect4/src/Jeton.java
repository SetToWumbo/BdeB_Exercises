public enum Jeton {
    ROUGE( "\u001B[31m"+  "*" + "\u001B[0m"),
    JAUNE( "\u001B[33m" + "*" + "\u001B[0m"),
    NOIR("\u001B[30m" + "_" +  "\u001B[0m"),
   VIDE("\u001B[30m"  + "_" + "\u001B[0m");
    public String type;

    Jeton(String type) {
        this.type = type;
    }

}
