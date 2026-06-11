public class DriverNotifier implements RideObserver{
    @Override
    public void update(Ride ride) {
        System.out.println("Ride created and meet your rider");
    }
}
