import java.util.Iterator;

public class VIPVisitor implements Visitor{


    private int totalVIPs;

    public VIPVisitor(){
        this.totalVIPs= 0;
    }

    /**
     * @param fr
     */
    @Override
    public void visitFilteredResult(FilterResult fr) {
        for(Iterator<Event> it = fr.getFilteredEvents(); it.hasNext();){
            it.next().accept(this);
        }
    }

    //Following is the way to calculate the num of VIPs separately


    /**
     * @param c
     */
    @Override
    public void visitConcert(Concert c) {
        this.totalVIPs+= c.getVips().size();
    }

    /**
     * Workshop does not have VIPs, so do nothing
     * @param w
     */
    @Override
    public void visitWorkshop(Workshop w) {
    }

    /**
     * @param g
     */
    @Override
    public void visitGala(Gala g) {
        this.totalVIPs+= g.getVips().size();
    }

    /**
     * Screening does not have VIPs, so do nothing
     * @param s
     */
    @Override
    public void visitScreening(Screening s) {

    }

    /**
     * Visit every event in the Festival to count the num of VIPs
     * @param f
     */
    @Override
    public void visitFestival(Festival f) {
        for(Event e: f.getEvent()){
            e.accept(this);
        }
    }

    public int getTotalVIPs() {
        return totalVIPs;
    }
}
