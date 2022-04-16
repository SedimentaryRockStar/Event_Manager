import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gala extends AbstractEvent{

    // An arraylist to contain all the galas we have created to achieve Flyweight
    private final static List<Gala> gals = new ArrayList<>();

    private final List<VIP> aVips= new ArrayList<>();



    private Gala(String name, Location location, LocalDate date, Double pricePerPerson, Integer numOfTickets) {
        super(name, location, date, pricePerPerson, numOfTickets);
    }

    private Gala(String name, LocalDate date) {
        super(name, date);
    }

    @Override
    public boolean checkLocValid(Location loc) {
        return false;
    }


    /**
     * Add a single VIP to the VIP list
     * @pre param v cannot be null
     * @param v the VIP to be added
     */

    public void addVip(VIP v){
        assert v!= null;
        this.aVips.add(v);
    }

    /**
     *
     * @param i At the index we want to remove
     */
    public void deleteVip(int i){
        assert i>= 0 && i< this.aVips.size();
        this.aVips.remove(i);
    }
}
