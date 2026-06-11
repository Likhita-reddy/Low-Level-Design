import java.util.ArrayList;
import java.util.List;

public class Booking {
    String id;
    User user;
    Show show;
    List<Seat> seats;

    public Booking(String id, User user, Show show, List<Seat> seats){
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = new ArrayList<>(seats);
    }

    String getId(){
        return this.id;
    }

    User getUser(){
        return this.user;
    }

    Show getShow(){
        return this.show;
    }

    List<Seat> getSeats(){
        return this.seats;
    }

    @Override
    public String toString(){
        return "BookingId: "+id+" user: "+user+" show: "+show+"seats: "+seats;
    }
}
