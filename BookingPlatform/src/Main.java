import java.time.LocalDateTime;
import java.util.Optional;

public class Main{
    public static void main(String args[]){
        SearchStrategy strategy = new NearestDriverStrategy();
        BookingPlatform platform = new BookingPlatform(strategy);

        Driver d1 = new Driver("1", "Alice", new Location(0, 0), true, new Vehicle("V1", "Car"));
        Driver d2 = new Driver("2", "Bob", new Location(5, 5), true, new Vehicle("V2", "Car"));
        Driver d3 = new Driver("3", "Charlie", new Location(10, 10), true, new Vehicle("V3", "Car"));

        platform.registerDriver(d1);
        platform.registerDriver(d2);
        platform.registerDriver(d3);

        Rider r1 = new Rider("1", "Dave", new Location(1, 1));
        platform.registerRider(r1);

        RideRequest request = new RideRequest("1",r1, new Location(1, 1), new Location(10, 10), LocalDateTime.now());

        Optional<Ride> ride = platform.requestRide(request);
        if(ride.isEmpty()){
            System.out.println("Ride request failed");
            return;
        }
        System.out.println("Ride requested successfully with driver: " + ride.get().getDriver().getName());

        platform.startRide(ride.get());
        platform.completeRide(ride.get());
        System.out.println(platform.showRideHistory(r1));
    }
}