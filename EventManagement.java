import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {
    private List<Event> aHostedEvents = new ArrayList<>();

    /*
    Method to host a new concert event
     */
    public void addConcertEvent(String name, Location location, LocalDate date, Double pricePerPerson,
                                Integer numOfTickets, String artist, List<VIP> vips){
        assert name != null && location != null && date != null && pricePerPerson != null
                && numOfTickets != null && artist != null && vips!= null;
        aHostedEvents.add(Concert.getConcert(name, location, date, pricePerPerson, numOfTickets, artist, vips));

    }

    /*
    Alternative add Concert Event method when the Event is coming soon
     */
    public void addConcertEvent(String name, LocalDate date, String artist, List<VIP> vips){
        assert name != null && date != null && artist != null && vips!= null;
        aHostedEvents.add(Concert.getConcert(name, date, artist, vips));

    }

    /*
    Method to host a new Gala event
     */
    public void addGalaEvent(String name, Location location,
                             LocalDate date, Double pricePerPerson, Integer numOfTickets, List<VIP> vips){
        assert name != null && location != null && date != null
                && pricePerPerson != null && numOfTickets != null && vips!= null;
        aHostedEvents.add(Gala.getGala(name, location, date, pricePerPerson, numOfTickets, vips));
    }

    public void addGalaEvent(String name, LocalDate date, String artist, List<VIP> vips){
        assert name != null && date != null && artist != null && vips!= null;
        aHostedEvents.add(Gala.getGala(name, date, artist, vips));
    }

    /*
    Method to host a new Screening event
     */
    public void addScreeningEvent(String name, Location location, LocalDate date,
                                  Double pricePerPerson, Integer numOfTickets, Ratings rating){
        assert name != null && location != null && date != null
                && pricePerPerson != null && numOfTickets != null && rating!= null;
        aHostedEvents.add(Screening.getScreening(name, location, date, pricePerPerson, numOfTickets, rating));
    }

    public void addScreeningEvent(String name, LocalDate date,
                                  Ratings rating){
        assert name != null && date != null && rating!= null;
        aHostedEvents.add(Screening.getScreening(name, date, rating));
    }

    /*
    Method to host a new Workshop event
     */
    public void addWorkshopEvent(){

    }

    /*
    Return the list of hosted events on EventBrite.
    This method assumes that Events are immutable.
     */
    public ArrayList<Event> getHostedEvents(){
        return new ArrayList<Event>(aHostedEvents);
    }
}
