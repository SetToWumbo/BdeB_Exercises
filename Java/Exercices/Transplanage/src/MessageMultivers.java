import java.io.DataInput;
import java.util.ArrayList;
import java.util.Random;

public class MessageMultivers {
    private static ArrayList<Plan> plans = new ArrayList<>();

    private MessageMultivers(String message, int nbPlans) {
        Random random = new Random();
        for (int i = 0; i < nbPlans; i++) {
            plans.add(new Plan());
        }
        for (Plan plan : plans) {
            for (int i = 0; i < Plan.DIMENSION; i++) {
                for (int j = 0; j < Plan.DIMENSION; j++) {
                    plan.ecrire('-', i, j);
                }
            }
        }

        // Loop through all the chars in sentence, assign given char to random Plan at the current[word][char] position
        int colonne = 0;
        for (int i = 0; i < message.length(); i++) {
            int row = i % Plan.DIMENSION;
            if (message.charAt(i) == ' ') {
            } else {
                plans.get(random.nextInt(plans.size())).ecrire(message.charAt(i), colonne, row);
            }
            if (i % Plan.DIMENSION == Plan.DIMENSION - 1) {
                colonne++;
            }
        }
    }

    public static MessageMultivers encoder(String message, int nbPlans) {
        if (message.length() > Plan.taille()) {
            System.out.println("Le message dépasse notre capacité d'encodage.");
            return null;
        } else {
            return new MessageMultivers(message, nbPlans);
        }

    }

    public String afficherMessage() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < Plan.DIMENSION; row++) {
            for (int z = 0; z < plans.size(); z++) {
                for (int k = 0; k < Plan.DIMENSION; k++) {
                    sb.append(plans.get(z).lire(k, row));
                    sb.append(' ');
                }
                sb.append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }


}