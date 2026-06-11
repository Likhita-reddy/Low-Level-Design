public class RiderNotifier implements RideObserver{
    @Override
    public void update(Ride ride) {
        System.out.println("Ride created and driver assigned");
    }
}
