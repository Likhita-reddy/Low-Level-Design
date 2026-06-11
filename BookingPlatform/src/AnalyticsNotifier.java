public class AnalyticsNotifier implements RideObserver{
    @Override
    public void update(Ride ride) {
        System.out.println("Analytics updated");
    }
}
