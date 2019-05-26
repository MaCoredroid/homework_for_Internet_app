import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        Timer time = new Timer();
        producer p = new producer(50, 1000);
        time.schedule(p, 0, 10);
        p.addConsumer(50);
    }
}
