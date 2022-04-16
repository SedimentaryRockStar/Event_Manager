import java.util.ArrayList;
import java.util.List;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {
    private List<Event> aHostedEvents = new ArrayList<Event>();

    /*
    Method to host a new concert event
     */
    public void addConcertEvent(){

    }

    /*
    Method to host a new Gala event
     */
    public void addGalaEvent(){

    }

    /*
    Method to host a new Screening event
     */
    public void addScreeningEvent(){

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
