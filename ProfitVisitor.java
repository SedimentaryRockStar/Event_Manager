import java.util.Iterator;

public class ProfitVisitor implements Visitor{


    private double profits= 0;
    private final double concert;
    private final double workshop;
    private final double gala;
    private final double screening;

    public ProfitVisitor(double concert, double workshop, double gala, double screening) {
        this.concert = concert;
        this.workshop = workshop;
        this.gala = gala;
        this.screening = screening;
    }


    /**
     * Visit the FilteredResult to calculate the profit and Iterate through all the events in a FilteredResult object
     *
     * @param fr The FilterResult we want to operate on
     */
    @Override
    public void visitFilteredResult(FilterResult fr) {
        for(Iterator<Event> it= fr.getFilteredEvents(); it.hasNext();){
            it.next().accept(this);
        }
    }

    /**
     * Calculate the profit of a concert
     * @param c The concert to be calculated on
     */
    @Override
    public void visitConcert(Concert c) {
        profits+= concert * c.getProfit();
    }

    /**
     * Calculate the profit of a Workshop
     * @param w The workshop to be calculated on
     */
    @Override
    public void visitWorkshop(Workshop w) {
        profits+= workshop* w.getProfit();
    }

    /**
     * Calculate the profit of a Gala
     * @param g The Gala to be calculated on
     */
    @Override
    public void visitGala(Gala g) {
        profits+= gala * g.getProfit();
    }

    /**
     * Calculate the profit of a screening
     * @param s The screening to be calculated on
     */
    @Override
    public void visitScreening(Screening s) {


    }



    public double getProfit() {
        return this.profits;
    }


}
