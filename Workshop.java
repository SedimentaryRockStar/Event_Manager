import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Workshop extends AbstractEvent{

    // An arraylist to contain all the Workshops we have created to achieve Flyweight
    private static final List<Workshop> workshops = new ArrayList<Workshop>();

    // Existing Workshops the participant has to take.
    private final List<Workshop> prereqs= new ArrayList<>();


    // Private constructors to achieve Flyweight

    private Workshop(String name, Location location, LocalDate date, Double pricePerPerson, Integer numOfTickets, List<Workshop> ws) {
        super(name, location, date, pricePerPerson, numOfTickets);
        assert ws!= null;
        prereqs.addAll(ws);
    }

    //Alternative private constructor when the Event is Coming Soon

    private Workshop(String name, LocalDate date, List<Workshop> ws) {
        super(name, date);
        assert ws!= null;
        prereqs.addAll(ws);
    }

    /**
     * This is the standard factory method for getting a Workshop object to achieve Flyweight
     * @pre name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && ws!= null
     * @param name The Workshop name
     * @param location The location of the Workshop
     * @param date The date the Workshop is to be held
     * @param pricePerPerson    The ticket price per person
     * @param numOfTickets  Total number of tickets the Workshop has sold
     * @param ws    The list of Workshop prerequisites
     * @return a Workshop object
     */
    public static Workshop getWorkshop(String name, Location location, LocalDate date, Double pricePerPerson, Integer numOfTickets, List<Workshop> ws){
        assert name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && ws!= null;
        for(Workshop w: Workshop.workshops){
            if(w.getDate().equals(date) && w.getLocation().equals(Optional.of(location))) return w;
        }
        Workshop w= new Workshop(name, location, date, pricePerPerson, numOfTickets, ws);
        Workshop.workshops.add(w);
        return w;
    }


    /**
     *  This is the alternative factory method for getting a Workshop object
     * @pre name != null && date != null && ws!= null
     * @param name      The workshop name
     * @param date      The date the workshop is to be held
     * @param ws    The list of Workshop prerequisites
     * @return a Workshop object
     */


    public static Workshop getWorkshop(String name, LocalDate date, List<Workshop> ws){
        assert name != null && date != null && ws!= null;
        Workshop w= new Workshop(name, date, ws);
        Workshop.workshops.add(w);
        return w;
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
        for(Workshop w: Workshop.workshops){
            if(this.getName().equals(w.getName()) && w.getLocation().equals(Optional.of(loc))) return false;
        }
        return true;
    }

    /**
     * Accept the visitor
     * @param v Visitor
     */
    @Override
    public void accept(Visitor v) {
        v.visitWorkshop(this);

    }


}
