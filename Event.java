import java.time.LocalDate;
import java.util.Optional;

/*
Representation of a type of Event that can exist
 */
public interface Event {
    //A series of getter method
    String getName();
    LocalDate getDate();
    Optional<Location> getLocation();
    Optional<Double> getPrice();
    Optional<Integer> getNumTickets();


}
