import java.util.ArrayList;
import java.util.List;

public class Rider {
    private String id;
    private String name;
    private Location currentLocation;
    private boolean activeRide;
    private List<Ride> rideHistory;

    public Rider(String id, String name, Location currentLocation) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.activeRide = false;
        this.rideHistory = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isActiveRide() {
        return activeRide;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }

    public boolean isRideActive(){
        return activeRide;
    }

    public void markActiveRide(){
        activeRide = true;
    }

    public void completeRide(){
        activeRide = false;
    }

    public void addRideHistory(Ride ride){
        rideHistory.add(ride);
    }

}
