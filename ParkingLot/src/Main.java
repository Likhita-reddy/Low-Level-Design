import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main{
    public static void main(String args[]){
        ParkingLot parkingLot = new ParkingLot(new ArrayList<>(),new HashMap<>());

        Vehicle vehicle1 = new Car("1");
        Vehicle vehicle2 = new Bike("2");
        Vehicle vehicle3 = new Truck("3");

        ParkingSlot slot1 = new ParkingSlot("A1", VehicleType.CAR, Status.AVAILABLE);
        ParkingSlot slot2 = new ParkingSlot("B1", VehicleType.BIKE, Status.AVAILABLE);
        ParkingSlot slot3 = new ParkingSlot("C1", VehicleType.TRUCK, Status.AVAILABLE);

        parkingLot.setParkingSlots(List.of(slot1,slot2,slot3));

        ParkingTicket ticket = parkingLot.park(vehicle1);
        System.out.println(ticket);

        System.out.println(parkingLot.getParkingSlots());

        parkingLot.park(vehicle1);

        parkingLot.unpark(ticket);

        parkingLot.park(vehicle1);
    }
}