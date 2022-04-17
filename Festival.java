

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Festival extends AbstractEvent{

    private final static List<Festival> festivals= new ArrayList<>();
    private final List<Event> events= new ArrayList<>();

    protected Festival(String name, Location location, LocalDate date,
                       Double pricePerPerson, Integer numOfTickets, List<Event> events) {
        super(name, location, date, pricePerPerson, numOfTickets);
        assert events!= null;
        this.events.addAll(events); // This could ensure that the events list cannot be changed
    }


    // On Ed the TA said we could assume a Festival does not have all its Events to be Coming Soon

    //Factory getter method for the Festival
    public static Festival getFestival(String name, List<Event> events) {
        assert name != null && events != null;

        double price = 0;
        int ticketsNum = Integer.MAX_VALUE;
        //Initialize to the maximum value to get the minimum ticket number
        Location loc = Location.Multiple;
        boolean locationSet = false;
        LocalDate time = LocalDate.MAX;


        for (Event aEvent : events) {
            if (aEvent.getLocation().isPresent() && !locationSet) {
                loc = aEvent.getLocation().get();
                locationSet = true;
            }//Set the initial Location to be the first non-Coming Soon event

            if (locationSet && aEvent.getLocation().isPresent()
                    && !aEvent.getLocation().get().equals(loc)) {
                loc = Location.Multiple;
            }/* If some non-Coming Soon events have different locations than the initial one,
            denotes that the festival has multiple locations
            */

            if (aEvent.getPrice().isPresent()) {
                price += 0.2 * aEvent.getPrice().get();
            } //Festival ticket price is a subsidized price

            if (aEvent.getNumTickets().isPresent() && aEvent.getNumTickets().get() < ticketsNum) {
                ticketsNum = aEvent.getNumTickets().get();
            } // Festival tickets equals to the minimum

            if (aEvent.getDate().isBefore(time)) {
                time = aEvent.getDate();
            }// Get the former date of the events
        }
        for(Festival f: Festival.festivals){
            if(f.getDate().equals(time) && f.getLocation().equals(Optional.of(loc))) return f;
        }

        Festival f= new Festival(name, loc, time, price,  ticketsNum, events);
        Festival.festivals.add(f);
        return f;
    }

    /**
     * Get the festival events. In order not to get the original events modified, return a copy of the arraylist
     * @return a shallow copy of the events list
     */

    public List<Event> getEvent(){
        return new ArrayList<>(this.events);
    }

    /**
     * A festival cannot change its location spontaneously
     * @param loc The location to be checked
     * @return false    The location of the festival cannot be changed
     */
    @Override
    public boolean checkLocValid(Location loc) {
        return false;
    }

    /**
     * Accept the visitor
     * @param v Visitor to use
     */
    @Override
    public void accept(Visitor v) {
        v.visitFestival(this);
    }








}


