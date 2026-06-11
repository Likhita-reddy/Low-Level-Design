public class Truck extends Vehicle{
    public Truck(String id) {
        super(id);
    }

    @Override
    boolean canPark(ParkingSlot parkingSlot) {
        return parkingSlot.getVehicleType().equals(VehicleType.TRUCK);
    }

    @Override
    double calculateFee(long hours) {
        return (double) hours * 15;
    }
}
