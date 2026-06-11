import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingSlot> parkingSlots;
    Map<String, ParkingTicket> activeTickets;

    public ParkingLot(List<ParkingSlot> parkingSlots, Map<String, ParkingTicket> activeTickets) {
        this.parkingSlots = parkingSlots;
        this.activeTickets = activeTickets;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public Map<String, ParkingTicket> getActiveTickets() {
        return activeTickets;
    }

    public void setActiveTickets(Map<String, ParkingTicket> activeTickets) {
        this.activeTickets = activeTickets;
    }

    public ParkingTicket park(Vehicle vehicle){
        if(activeTickets.containsKey(vehicle.getId())){
            System.out.println("Vehicle already parked");
            return null;
        }
        for(ParkingSlot parkingSlot: parkingSlots){
            /*if(parkingSlot.isAvailable()){
                if(vehicle.getVehicleType().equals(VehicleType.BIKE) && parkingSlot.getVehicleType().equals(vehicle.getVehicleType())){
                    parkingSlot.occupy();
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot, LocalDateTime.now());
                    activeTickets.put(vehicle.getId(), parkingTicket);
                    return parkingTicket;
                } else if(vehicle.getVehicleType().equals(VehicleType.CAR) && parkingSlot.getVehicleType().equals(vehicle.getVehicleType())){
                    parkingSlot.occupy();
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot, LocalDateTime.now());
                    activeTickets.put(vehicle.getId(), parkingTicket);
                    return parkingTicket;
                } else if(vehicle.getVehicleType().equals(VehicleType.TRUCK) && parkingSlot.getVehicleType().equals(vehicle.getVehicleType())){
                    parkingSlot.occupy();
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot, LocalDateTime.now());
                    activeTickets.put(vehicle.getId(), parkingTicket);
                    return parkingTicket;
                } else if(vehicle.getVehicleType().equals(VehicleType.EV) && (parkingSlot.getVehicleType().equals(VehicleType.EV) || parkingSlot.getVehicleType().equals(VehicleType.CAR))){
                    parkingSlot.occupy();
                    ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot, LocalDateTime.now());
                    activeTickets.put(vehicle.getId(), parkingTicket);
                    return parkingTicket;
                }
            }*/
            if(parkingSlot.isAvailable() && vehicle.canPark(parkingSlot)){
                parkingSlot.occupy();
                ParkingTicket parkingTicket = new ParkingTicket(vehicle, parkingSlot, LocalDateTime.now());
                activeTickets.put(vehicle.getId(), parkingTicket);
                return parkingTicket;

            }
        }
        System.out.println("Slot not available");
        return null;
    }

    public void unpark(ParkingTicket ticket){
        if(activeTickets.containsKey(ticket.getVehicle().getId())){
            System.out.println("Total fee: "+calculateFee(ticket));
            ParkingSlot parkingSlot = ticket.getParkingSlot();
            parkingSlot.release();
            activeTickets.remove(ticket.getVehicle().getId());
        } else {
            System.out.println("Invalid ticket");
        }
    }

    public double calculateFee(ParkingTicket ticket){
        //VehicleType vehicleType = ticket.getVehicle().getVehicleType();
        LocalDateTime entryTim = ticket.getEntryTime();
        LocalDateTime exitTime = LocalDateTime.now();
        long hours = java.time.Duration.between(entryTim, exitTime).toHours();
        /*if(vehicleType.equals(VehicleType.BIKE)){
            return 10.0 * hours;
        } else if(vehicleType.equals(VehicleType.CAR)){
            return 20.0 * hours;
        } else if(vehicleType.equals(VehicleType.TRUCK)){
            return 30.0 * hours;
        } else if(vehicleType.equals(VehicleType.EV)){
            return 25.0 * hours;
        }*/
        return ticket.getVehicle().calculateFee(hours);
    }
}
