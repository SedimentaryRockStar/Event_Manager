public class PriceLocFilter implements Filter{


    private final double l;
    private final double r;
    private final Location loc;

    public PriceLocFilter(double l, double r, Location loc) {
        assert l >= 0 && l<= r && loc != null;
        this.l = l;
        this.r = r;
        this.loc = loc;
    }


    /**
     * The filter strategy based on the price range and the location
     * @param e     The event to be calculated on
     * @return The result that whether the price of the event is present and falls into the price range
     *     and The result that whether the location of the event is present and is at the same location
     */
    @Override
    public boolean filter(Event e) {
        return e.getPrice().isPresent() && e.getPrice().get()>= l && e.getPrice().get()<= r &&
                e.getLocation().isPresent() && e.getLocation().get().equals(loc);
    }
}
