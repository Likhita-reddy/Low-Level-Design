public abstract class Vehicle {
    private String id;

    public Vehicle(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    abstract boolean canPark(ParkingSlot parkingSlot);

    abstract double calculateFee(long hours);

}
