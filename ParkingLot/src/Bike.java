public class Bike extends Vehicle{

    public Bike(String id) {
        super(id);
    }

    @Override
    boolean canPark(ParkingSlot parkingSlot) {
        return parkingSlot.getVehicleType().equals(VehicleType.BIKE);
    }

    @Override
    double calculateFee(long hours) {
        return (double) hours * 5;
    }
}
