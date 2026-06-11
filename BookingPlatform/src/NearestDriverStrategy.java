import java.util.List;

public class NearestDriverStrategy implements SearchStrategy {
    @Override
    public Driver searchDriver(List<Driver> drivers, RideRequest request) {
        Driver nearestDriver = null;
        double minDistance = Double.MAX_VALUE;
        for(Driver driver : drivers){
            Location source = request.getSource();
            Location driverLocation = driver.getCurrentLocation();
            double distance = source.getDistance(driverLocation);
            if(distance < minDistance){
                minDistance = distance;
                nearestDriver = driver;
                }
        }
        return nearestDriver;
    }
}
