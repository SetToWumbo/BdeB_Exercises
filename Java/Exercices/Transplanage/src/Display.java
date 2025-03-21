import java.util.ArrayList;

public class Display{
    public static void main(String[] args) {
        char[][] tab = new char[9][9];
        ArrayList<String> comment = new ArrayList<>();

        comment.add("Hello");
        comment.add("lol");
        comment.add("toodles");
        comment.add("welcome");
        comment.add("Seeya");
        comment.add("Yo");
        comment.add("Hi");
        comment.add("goodbye");

        System.out.println(comment);
       for(String message : comment){
           comment.add(comment.removeFirst());
       }
        System.out.println(comment);



//        for (int row = 0; row < tab.length; row++) {
//            for (int col = 0; col < tab[row].length; col++) {
//                if (row == 0 || row == tab.length - 1) {
//                    tab[row][col] = '*';
//                }
//                if (row + col == tab[row].length - 1) {
//                    tab[row][col] = '*';
//                }
//            }
//        }
//
//        for (int row = 0; row < tab.length; row++) {
//            for (int col = 0; col < tab[row].length; col++) {
//                System.out.print(tab[row][col]);
//            }
//            System.out.println();
//        }
    }
}


