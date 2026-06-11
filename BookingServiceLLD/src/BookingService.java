import java.util.List;
import java.util.Optional;

public class BookingService {
    static int counter=0;

    String generateBookingId(){
        return "BKG"+(++counter);
    }

    public Optional<Booking> bookSeat(Show show, Seat seat, User user){
        if(seat.isBooked()){
            System.out.println("Seat is not available");
            return Optional.empty();
        }

        Booking booking = new Booking(generateBookingId(), user, show, List.of(seat));
        user.addBooking(booking);
        seat.setStatus(Status.BOOKED);
        return Optional.of(booking);
    }

    public void cancelBooking(Booking booking){
        User user = booking.getUser();
        Show show = booking.getShow();
        List<Seat> seats = booking.getSeats();
        for(Seat s : seats){
            s.setStatus(Status.AVAILABLE);
        }
        user.removeBooking(booking);
    }

    public void displayAvailableSeats(Show show){
        List<Seat> availableSeats = show.returnAvailableSeats();
        for(Seat seat: availableSeats){
            System.out.println(seat);
        }
    }

    public void displaySeats(Show show){
        List<Seat> allSeats = show.getSeats();
        for(Seat seat: allSeats){
            System.out.println(seat);
        }
    }
}
