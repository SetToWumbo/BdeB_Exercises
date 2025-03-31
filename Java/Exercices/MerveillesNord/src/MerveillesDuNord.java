import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

public class MerveillesDuNord{


    public static void main(String[] args) {
        Random random = new Random();
        LinkedBlockingQueue<Paysage> merveilles = new LinkedBlockingQueue<>();
        merveilles.offer(new Foret(random.nextLong(), "Foret", random.nextFloat(), random.nextFloat(), Region.ACADIENNE));
        merveilles.offer(new Plage(random.nextLong(), "Plage", random.nextFloat(), random.nextFloat(), TypeDeSable.ORGANIQUE));
        merveilles.offer(new Lac(random.nextLong(), "Lac", random.nextFloat(), random.nextFloat(), random.nextInt()));
        System.out.println(merveilles.toString());
        if(!merveilles.isEmpty()){
            while(!merveilles.isEmpty()){
                merveilles.poll().afficher();
                System.out.println();
            }
        }
    }

}
