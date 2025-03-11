public class Main {
 public static int ROW = 6;
 public static int COLUMN = 7;
 public static void main(String[] args) {
 Jeton[][] planJeu = new Jeton[ROW][COLUMN];
 Player player1 = new Player(Jeton.ROUGE);
 Player player2 = new Player(Jeton.JAUNE);
     for(int row = 0; row < planJeu.length; row++){
         for(int col= 0; col < COLUMN; col++){
         planJeu[row][col] = Jeton.VIDE;
         }
     }
 afficherJeu(planJeu);
Player gagnant = null;
Player tour = player2;

    tour = (tour == player1) ? player2 : player1;






planJeu[3][5] = Jeton.JAUNE;
     planJeu[3][6] = Jeton.ROUGE;
 afficherJeu(planJeu); }
public static void afficherJeu(Jeton[][] planJeu) {

  for(int row = 0; row < planJeu.length; row++){

   for(int col= 0; col < COLUMN; col++){
       System.out.print("|");
       System.out.print(planJeu[row][col].type);
       System.out.print("|");
   }
      System.out.println();}

    System.out.println();
}
public static int validerChoix(String choix){
    int colonne = 0;
     try{
        colonne = Integer.parseInt(choix);
     }catch(Exception e){
         
     }
     return colonne;
}


}