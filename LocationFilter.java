public class LocationFilter implements Filter {

    private final Location loc;

    //  Location filter
    public LocationFilter(Location loc){
        assert loc != null;
        this.loc = loc;
    }

    /**
     * Filter strategy based on the location
     * @param e The event to be checked on
     * @return  The result that whether the location of the event is present and is at the same location
     */
    @Override
    public boolean filter(Event e) {
        return e.getLocation().isPresent() && e.getLocation().get().equals(loc);
    }
}
