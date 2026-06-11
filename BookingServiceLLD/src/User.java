import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
    String id;
    String name;
    Map<String, Booking> bookings;

    public User(String id, String name){
        this.id = id;
        this.name = name;
        this.bookings = new HashMap<>();
    }

    Map<String, Booking> getBookings(){
        return bookings;
    }

    void addBooking(Booking booking){
        this.bookings.put(booking.getId(), booking);
    }

    void removeBooking(Booking booking){
        this.bookings.remove(booking.getId());
    }

    public String toString(){
        return "UserId: "+id+" name: "+name;
    }
}
