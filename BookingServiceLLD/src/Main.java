import java.util.List;
import java.util.Optional;

public class Main{
    public static void main(String args[]){
        	// Create some seats
            Seat seat1 = new Seat("S1", "Show1");
            Seat seat2 = new Seat("S2", "Show1");
            Seat seat3 = new Seat("S3", "Show1");

            // Create a show with the seats
            Show show1 = new Show("Show1", List.of(seat1, seat2, seat3));

            // Create a movie with the show
            Movie movie1 = new Movie("Movie1", "Inception", List.of(show1));

            // Create a user
            User user1 = new User("U1", "Alice");


            // Book a seat for the user
            BookingService bookingService = new BookingService();

            bookingService.displaySeats(show1);

            Optional<Booking> booking = bookingService.bookSeat(show1, seat1, user1);

            // Display booking details
            if (booking.isPresent()) {
                Booking b = booking.get();
                System.out.println(b);
            } else {
                System.out.println("Booking failed!");
            }

            bookingService.displaySeats(show1);

            bookingService.cancelBooking(booking.get());
            System.out.println("Cancelled booking");

            bookingService.displaySeats(show1);
    }
}