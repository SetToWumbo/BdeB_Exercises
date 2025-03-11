public enum Jeton {
    ROUGE( "\u001B[31m"+  "*" + "\u001B[0m"),
    JAUNE( "\u001B[33m" + "*" + "\u001B[0m"),
   VIDE("\u001B[0m" + "_");
    public String type;
    public String colour;

    Jeton(String type) {
        this.type = type;
    }

}
