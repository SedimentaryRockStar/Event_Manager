import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Screening extends AbstractEvent{

    // An arraylist to contain all the Workshops we have created to achieve Flyweight
    private static final List<Screening> screenings = new ArrayList<Screening>();


    private final Ratings rating;

    // Private constructors to achieve Flyweight
    private Screening(String name, Location location, LocalDate date,
                        Double pricePerPerson, Integer numOfTickets, Ratings rating) {
        super(name, location, date, pricePerPerson, numOfTickets);
        assert rating!= null;
        this.rating= rating;
    }

    //Alternative private constructor when the Event is Coming Soon
    private Screening(String name, LocalDate date, Ratings rating) {
        super(name, date);
        assert rating!= null;
        this.rating= rating;
    }

    /**
     * This is the standard factory method for getting a Screening object to achieve Flyweight
     * @pre name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && rating!= null
     * @param name The screening name
     * @param location The location of the screening
     * @param date The date the screening is to be held
     * @param pricePerPerson    The ticket price per person
     * @param numOfTickets  Total number of tickets the gala has sold
     * @param rating    The rating of a Screening object
     * @return a Screening object
     */
    public static Screening getScreening(String name, Location location,
                               LocalDate date, Double pricePerPerson, Integer numOfTickets, Ratings rating){
        assert name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && rating!= null;
        for(Screening s: Screening.screenings){
            if(s.getDate().equals(date) && s.getLocation().equals(Optional.of(location))) return s;
        }
        Screening s = new Screening(name, location, date, pricePerPerson, numOfTickets, rating);
        Screening.screenings.add(s);
        return s;
    }

    /**
     *  This is the alternative factory method for getting a Screening object
     * @pre name != null && date != null  && vips!= null
     * @param name      The Screening name
     * @param date      The date the Screening is to be held
     * @return a Screening object
     */

    public static Screening getScreening(String name, LocalDate date, Ratings rating){
        assert name != null && date != null && rating!= null;
        Screening s = new Screening(name, date, rating);
        Screening.screenings.add(s);
        return s;
    }





    /**
     * Method to check whether the input location is valid to be set
     *
     * @param loc The location to be set
     * @return boolean result whether the input is valid to be set
     */
    @Override
    public boolean checkLocValid(Location loc){
        assert loc!= null;
        for(Screening s: Screening.screenings){
            if(this.getName().equals(s.getName()) && s.getLocation().equals(Optional.of(loc))) return false;
        }
        return true;
    }
}
