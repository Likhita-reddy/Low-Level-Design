public class Car extends Vehicle{
    public Car(String id) {
        super(id);
    }

    @Override
    boolean canPark(ParkingSlot parkingSlot) {
        return parkingSlot.getVehicleType().equals(VehicleType.CAR);
    }

    @Override
    double calculateFee(long hours) {
        return (double) hours * 10;
    }
}
