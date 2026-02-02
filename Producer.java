import java.util.concurrent.Semaphore;
import java.util.Random;


class Producer extends Thread {
    private Box box;
    private Semaphore vuoto;
    private Semaphore pieno;
    private Random n = new Random();

    public Producer(Box b, Semaphore vuoto, Semaphore pieno) {
        this.box = b;
        this.vuoto = vuoto;
        this.pieno = pieno;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                vuoto.acquire();
                Thread.sleep(2000);
                int n = this.n.nextInt(100);
                box.inserisci(n);
                pieno.release();
            } catch (InterruptedException e) {
                System.out.println("Errore");
            }
        }
    }
}