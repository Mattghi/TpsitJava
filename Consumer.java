import java.util.concurrent.Semaphore;


class Consumer extends Thread {
    private Box box;
    private Semaphore vuoto;
    private Semaphore pieno;

    public Consumer(Box b, Semaphore vuoto, Semaphore pieno) {
        this.box = b;
        this.vuoto = vuoto;
        this.pieno = pieno;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                pieno.acquire();
                Thread.sleep(3000);
                box.estrai();
                vuoto.release();
            } catch (InterruptedException e) {
                System.out.println("Errore");
            }
        }
    }
}