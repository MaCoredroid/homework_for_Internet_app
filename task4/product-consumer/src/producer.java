import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class producer extends TimerTask {
    private int threshold;
    private int timeout;
    private Timer alarm;
    private boolean overload=false;
    private List<consumer> container;
    public producer (int threshold,int timeout)
    {
        this.threshold=threshold;
        this.timeout=timeout;
    }
    public int addConsumer(int number)//add task
    {
        if(container!=null) {
            for (int i = 0; i < number; i++) {
                consumer temp = new consumer(new Timestamp(System.currentTimeMillis()));
               container.add(temp);

            }
            return container.size();
        }
        return 0;
    }

    @Override
    public void run()
    {
        if (container != null) {
            if (container.size() >= threshold) {
                //deal with the newer tasks first
                this.overload = true;
            } else {
                //deal with the older task first
                this.overload = false;
            }
            for (consumer temp : container) {
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                if (timestamp.getTime() - temp.getTimestamp().getTime() >= timeout) {
                    container.remove(temp);
                }
            }
            System.out.println("There remains " + container.size() + "consumers");
        }
    }
}
