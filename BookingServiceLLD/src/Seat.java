public class Seat {
    public String id;
    public Status status;

    public Seat(String id, String showId){
        this.id = id;
        this.status = Status.AVAILABLE;
    }
    public boolean isBooked(){
        return this.status == Status.BOOKED;
    }

    public boolean isAvailable(){
        return this.status == Status.AVAILABLE;
    }

    public void setStatus(Status status){
        this.status = status;
    }

    public String toString(){
        return "SeatId= "+id+" status= "+status;
    }
}
