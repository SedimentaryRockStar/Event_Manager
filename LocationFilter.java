public class LocationFilter implements Filter{

    private final Location loc;

    //  Location filter
    public LocationFilter(Location loc){
        assert loc != null;
        this.loc = loc;
    }

    /**
     * Filter strategy based on the location
     * @param e The event to be checked on
     * @return  The result that whether the location of the event is present and falls into the price range
     */
    @Override
    public boolean filter(Event e) {
        return e.getLocation().isPresent() && e.getLocation().get().equals(loc);
    }
}
