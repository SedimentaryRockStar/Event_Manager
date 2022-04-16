import java.time.LocalDate;
import java.util.Optional;

/*
Representation of a type of Event that can exist
 */
public interface Event {
    //A series of getter method
    public String getName();
    public LocalDate getDate();
    public Optional<Location> getLocation();
    public Optional<Double> getPrice();
    public Optional<Integer> getNumTickets();


}
