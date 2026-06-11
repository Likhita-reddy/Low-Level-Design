public class ParkingSlot {
    private String id;
    private VehicleType vehicleType;
    private Status status;

    public ParkingSlot(String id, VehicleType vehicleType, Status status) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isAvailable(){
        return status == Status.AVAILABLE;
    }

    public void occupy(){
        status = Status.UNAVAILABLE;
    }

    public void release(){
        status = Status.AVAILABLE;
    }

    @Override
    public String toString() {
        return "ParkingSlot{" +
                "id='" + id + '\'' +
                ", vehicleType=" + vehicleType +
                ", status=" + status +
                '}';
    }
}
