import java.sql.Timestamp;

public class consumer {
    private Timestamp timestamp;
    public consumer(Timestamp timestamp)
    {
        this.timestamp=timestamp;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }
}
