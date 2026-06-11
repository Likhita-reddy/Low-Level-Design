import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class BookingPlatform {
    Map<String, Rider> riders;
    Map<String, Driver> drivers;
    SearchStrategy strategy;
    List<RideObserver> observers;

    public BookingPlatform(SearchStrategy strategy) {
        this.riders = new HashMap<>();
        this.drivers = new HashMap<>();
        this.strategy = strategy;
    }

    public Optional<Ride> requestRide(RideRequest request){
        if(!request.isValidRequest()){
            System.out.println("Source and Destination are same!");
            return Optional.empty();
        }
        if(request.getRider().isRideActive()){
            System.out.println("Request ride only once");
            return Optional.empty();
        }

        List<Driver> availableDrivers = drivers.values().stream()
                .filter(Driver::isAvailable)
                .toList();

        //search strategy //available drivers
        Driver driver = strategy.searchDriver(availableDrivers, request);
        if(driver == null){
            System.out.println("No drivers found");
            return Optional.empty();
        }
        Ride ride = new Ride(request, driver, LocalDateTime.now(), LocalDateTime.now().plusMinutes(30));
        driver.markUnavailable();
        request.getRider().markActiveRide();
        notifyObservers(ride);
        return Optional.of(ride);
    }

    public void startRide(Ride ride){
        ride.startRide();
    }

    public void completeRide(Ride ride){
        if(!ride.isStarted()){
            System.out.println("Ride not started yet");
            return;
        }
        if(!ride.isReached()){
            System.out.println("Destination not reached");
            return;
        }
        ride.completeRide();
        ride.getDriver().markAvailable();
        ride.getRideRequest().getRider().completeRide();
        ride.getRideRequest().getRider().addRideHistory(ride);
    }

    public void registerDriver(Driver driver){
        if(drivers.containsKey(driver.getId())){
            System.out.println("Driver already registered");
            return;
        }
        drivers.put(driver.getId(), driver);
    }

    public void registerRider(Rider rider){
        if(riders.containsKey(rider.getId())){
            System.out.println("Rider already registered");
            return;
        }
        riders.put(rider.getId(), rider);
    }

    public List<Ride> showRideHistory(Rider rider){
        return rider.getRideHistory();
    }

    public void notifyObservers(Ride ride){
        for(RideObserver observer:observers){
            observer.update(ride);
        }
    }

    public void addObserver(RideObserver observer){
        observers.add(observer);
    }
}
