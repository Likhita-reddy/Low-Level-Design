import java.time.LocalDateTime;

public class RideRequest {
    private String id;
    private Rider rider;
    private Location source;
    private Location destination;
    private LocalDateTime requestTime;

    public RideRequest(String id, Rider rider, Location source, Location destination, LocalDateTime requestTime) {
        this.id = id;
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        this.requestTime = requestTime;
    }

    public String getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public boolean isValidRequest(){
        return source.getDistance(destination) > 0;
    }

}
