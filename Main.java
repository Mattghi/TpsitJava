import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {
        Box box = new Box();

        Semaphore vuoto = new Semaphore(5);
        Semaphore pieno = new Semaphore(0);

        Producer p = new Producer(box, vuoto, pieno);
        Consumer c = new Consumer(box, vuoto, pieno);

        p.start();
        c.start();
    }
}
