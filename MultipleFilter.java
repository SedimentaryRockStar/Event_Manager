import java.util.List;

public class MultipleFilter implements Filter{

    
    private final List<Filter> filterList;

    public MultipleFilter(List<Filter> filterList) {
        this.filterList = filterList;
    }

    /**
     * Multiple filters would operate on a particular event to check whether it is feasible
     * @param e     The event to operate on
     * @return The boolean result of the filtering
     */
    @Override
    public boolean filter(Event e) {
        for(Filter filter : filterList){
            if(!filter.filter(e)) return false;
            //If it fails on one filter, meaning the condition sequence is not met, return false
        }
        return true;
        //All conditions are met,return true
    }
}
