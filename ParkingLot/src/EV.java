public class EV extends Vehicle{
    @Override
    boolean canPark(ParkingSlot parkingSlot) {
        return (parkingSlot.getVehicleType().equals(VehicleType.CAR) || parkingSlot.getVehicleType().equals(VehicleType.EV));
    }

    @Override
    double calculateFee(long hours) {
        return (double) hours * 12;
    }
}
