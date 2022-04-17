public class PriceRangeFilter implements Filter {

    private final double l;
    private final double r;

    //Constructor with price range      l: left end      r: right end
    public PriceRangeFilter(double l, double r) {
        assert l >= 0 && l<= r; //Some condition for the range to meet
        this.l= l;
        this.r= r;
    }


    /**
     *  Filter Strategy based on the price range
     * @param e     The event to be checked on
     * @return  The result that whether the price of the event is present and falls into the price range
     */
    @Override
    public boolean filter(Event e) {
        return e.getPrice().isPresent() && e.getPrice().get()>= l && e.getPrice().get()<= r;
    }
}
