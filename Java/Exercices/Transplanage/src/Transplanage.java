import java.util.Scanner;

public class Transplanage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("saisir une chaine de caracteres : ");
        String message = scanner.nextLine();
        System.out.print("Dans combien de plans [min 2] : ");
        int nbPlans = scanner.nextInt();
        MessageMultivers messageEncode = null;
        messageEncode = MessageMultivers.encoder(message, nbPlans);
        System.out.println(messageEncode.afficherMessage());
    }


}