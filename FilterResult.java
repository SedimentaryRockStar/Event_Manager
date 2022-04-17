import java.util.ArrayList;
import java.util.List;

public class FilterResult {

    private final List<Event> aFilteredEvents;



    // Private constructor in case the abuse of the construction of the object
    private FilterResult(List<Event> aFilteredEvents) {
        this.aFilteredEvents= aFilteredEvents;
    }


    public static FilterResult getFilterResult(Filter f, List<Event> eventsToFilter) {
        List<Event> filteredEvents = new ArrayList<>();
        for(Event event : eventsToFilter){
            if(f.filter(event)) filteredEvents.add(event);
        }
        return new FilterResult(filteredEvents);
    }

    public List<Event> getFilteredEvents() {
        assert aFilteredEvents!= null;
        return List.copyOf(this.aFilteredEvents);
    }
}
