import classes.Baignoire;
import classes.Robinet;

public class Main {

    public static void main(String[] args) {

        Baignoire baignoire = new Baignoire(1000, 10);
        Robinet robinet = new Robinet(baignoire, 50);

        Thread threadBaignoire = new Thread(baignoire);
        Thread threadRobinet = new Thread(robinet);

        threadRobinet.start();
        threadBaignoire.start();
    }
}
