import classes.Baignoire;
import classes.Robinet;

public class Main {

    public static void main(String[] args) {

        Baignoire baignoire = new Baignoire(1000);
        Robinet robinet = new Robinet(baignoire, 50);

        robinet.debite();
    }
}
