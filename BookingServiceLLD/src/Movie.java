import java.util.ArrayList;
import java.util.List;

public class Movie {
    public String id;
    public String name;
    List<Show> shows;

    public Movie(String id, String name, List<Show> shows){
        this.id = id;
        this.name = name;
        this.shows = new ArrayList<>(shows);
    }
}
