import java.time.LocalDateTime;

public class Ride {
    private RideRequest rideRequest;
    private Driver driver;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private RideStatus status;

    public Ride(RideRequest rideRequest, Driver driver, LocalDateTime startTime, LocalDateTime endTime) {
        this.rideRequest = rideRequest;
        this.driver = driver;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = RideStatus.REQUESTED;
    }

    public RideRequest getRideRequest() {
        return rideRequest;
    }

    public Driver getDriver() {
        return driver;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void startRide(){
        status = RideStatus.STARTED;
    }

    public void completeRide(){
        status = RideStatus.COMPLETED;
    }

    public boolean isStarted(){
        return status == RideStatus.STARTED;
    }

    public boolean isReached(){
        return true;
    }
}
