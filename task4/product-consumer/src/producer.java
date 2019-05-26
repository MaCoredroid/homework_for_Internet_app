import java.sql.Timestamp;
import java.util.List;

public class producer {
    private int threshold;
    private int timeout;
    private List<consumer> container;
    public producer(int threshold,int timeout)
    {
        this.threshold=threshold;
        this.timeout=timeout;
    }
    public int addConsumer(int number)
    {
        for(int i=0;i<number;i++)
        {
            consumer temp = new consumer(new Timestamp(System.currentTimeMillis()));
            container.add(temp);
        }
        return container.size();
    }

}
