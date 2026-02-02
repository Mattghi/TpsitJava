import java.util.Queue;
import java.util.LinkedList;

class Box {
    private Queue<Integer> Coda = new LinkedList<>();

    public void inserisci(int n) {
        Coda.add(n);
        System.out.println("Producer ha inserito: " + n);
    }

    public int estrai() {
        int n = Coda.poll();
        System.out.println("Consumer ha estratto: " + n);
        return n;
    }

}