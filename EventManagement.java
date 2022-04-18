import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public void addWorkshopEvent(String name, Location location, LocalDate date,
                                 Double pricePerPerson, Integer numOfTickets, List<Workshop> ws){
        assert name != null && location != null && date != null
                && pricePerPerson != null && numOfTickets != null && ws!= null;
        aHostedEvents.add(Workshop.getWorkshop(name, location, date, pricePerPerson, numOfTickets, ws));
    }

    public void addWorkshopEvent(String name, LocalDate date, List<Workshop> ws){
        assert name != null &&  date != null && ws!= null;
        aHostedEvents.add(Workshop.getWorkshop(name, date, ws));
    }

    // Getter Method and Setter methods

    public String getName(int i){
        assert i>= 0 && i< this.aHostedEvents.size();
        return this.aHostedEvents.get(i).getName();
    }

    public LocalDate getDate(int i){
        assert i>= 0 && i< this.aHostedEvents.size();
        return this.aHostedEvents.get(i).getDate();
    }

    public Optional<Location> getLocation(int i){
        assert i>= 0 && i< this.aHostedEvents.size();
        return this.aHostedEvents.get(i).getLocation();
    }

    public Optional<Double> getPrice(int i){
        assert i>= 0 && i< this.aHostedEvents.size();
        return this.aHostedEvents.get(i).getPrice();
    }

    public Optional<Integer> getNumTickets(int i){
        assert i>= 0 && i< this.aHostedEvents.size();
        return this.aHostedEvents.get(i).getNumTickets();
    }

    //Setter methods for fields
    public void setPricePerPerson(int i, double pricePerPerson){
        assert i>= 0 && i< this.aHostedEvents.size();
        this.aHostedEvents.get(i).setPricePerPerson(pricePerPerson);
    }

    public void setNumTickets(int i, int numTickets){
        assert i>= 0 && i< this.aHostedEvents.size();
        this.aHostedEvents.get(i).setNumOfTickets(numTickets);
    }

    public void setLocation(int i, Location location){
        assert i>= 0 && i< this.aHostedEvents.size() && location!= null;
        this.aHostedEvents.get(i).setLocation(location);
    }





    /*
    Return the list of hosted events on EventBrite.
    This method assumes that Events are immutable.
     */
    public ArrayList<Event> getHostedEvents(){
        return new ArrayList<Event>(aHostedEvents);
    }
}
