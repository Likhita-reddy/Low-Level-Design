import java.util.List;

public interface SearchStrategy {
    Driver searchDriver(List<Driver> drivers, RideRequest request);
}
