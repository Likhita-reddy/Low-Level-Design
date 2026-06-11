import java.time.LocalDateTime;

public class ParkingTicket {
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private LocalDateTime entryTime;

    public ParkingTicket(Vehicle vehicle, ParkingSlot parkingSlot, LocalDateTime entryTime) {
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }


    @Override
    public String toString() {
        return "ParkingTicket{" +
                "vehicle=" + vehicle +
                ", parkingSlot=" + parkingSlot +
                ", entryTime=" + entryTime +
                '}';
    }
}
