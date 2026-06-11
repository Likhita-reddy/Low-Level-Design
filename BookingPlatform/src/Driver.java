public class Driver {
    private String id;
    private String name;
    private Location currentLocation;
    private boolean available;
    private Vehicle vehicle;

    public Driver(String id, String name, Location currentLocation, boolean available, Vehicle vehicle) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = available;
        this.vehicle = vehicle;
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

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable(){
        return available;
    }

    public void markUnavailable(){
        available = false;
    }

    public void markAvailable(){
        available = true;
    }


}
