import java.util.ArrayList;
import java.util.List;

public class Show {
    public String id;
    List<Seat> seats;

    public Show(String id, List<Seat> seats){
        this.id = id;
        this.seats = new ArrayList<>(seats);
    }

    List<Seat> returnAvailableSeats(){
        List<Seat> availableSeats = new ArrayList<>();
        for(Seat s : seats){
            if(s.isAvailable()){
                availableSeats.add(s);
            }
        }
        return availableSeats;
    }

    List<Seat> getSeats(){
        return new ArrayList<>(seats);
    }

    public String toString(){
        return "ShowId: "+id+" Seats: "+seats;
    }
}
