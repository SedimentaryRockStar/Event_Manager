import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gala extends AbstractEvent{

    // An arraylist to contain all the galas we have created to achieve Flyweight
    private final static List<Gala> galas = new ArrayList<>();

    private final List<VIP> aVips= new ArrayList<>();


    // Private constructors to achieve Flyweight
    private Gala(String name, Location location,
                 LocalDate date, Double pricePerPerson, Integer numOfTickets, List<VIP> vips) {
        super(name, location, date, pricePerPerson, numOfTickets);
        assert vips!= null;
        aVips.addAll(vips); // Add all the input VIPS into the VIP list
    }
    //Alternative private constructor when the Event is Coming Soon
    private Gala(String name, LocalDate date, List<VIP> vips) {
        super(name, date);
        assert vips!= null;
        aVips.addAll(vips); // Add all the input VIPS into the VIP list
    }

    /**
     * This is the standard factory method for getting a Gala object to achieve Flyweight
     * @pre name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && vips!= null
     * @param name The gala name
     * @param location The location of the gala
     * @param date The date the gala is to be held
     * @param pricePerPerson    The ticket price per person
     * @param numOfTickets  Total number of tickets the gala has sold
     * @param vips      The VIP list we initially have
     * @return a Concert object
     */
    public static Gala getGala(String name, Location location,
                                     LocalDate date, Double pricePerPerson, Integer numOfTickets, List<VIP> vips){
        assert name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && vips!= null;
        for(Gala g : Gala.galas){
            if(g.getDate().equals(date) && g.getLocation().equals(Optional.of(location))) return g;
        }
        Gala g= new Gala(name, location, date, pricePerPerson, numOfTickets, vips);
        Gala.galas.add(g);
        return g;
    }

    /**
     *  This is the alternative factory method for getting a Gala object
     * @pre name != null && date != null  && vips!= null
     * @param name      The concert name
     * @param date      The date the concert is to be held
     * @param artist    The artist who is playing at the concert
     * @param vips      The VIP list we initially have
     * @return a Concert object
     */

    public static Gala getConcert(String name, LocalDate date, String artist, List<VIP> vips){
        assert name != null && date != null && artist != null && vips!= null;
        Gala g= new Gala(name, date, vips);
        Gala.galas.add(g);
        return g;
    }



    /**
     * Method to check whether the input location is valid to be set
     *
     * @param loc The location to be set
     * @return boolean result whether the input is valid to be set
     */
    @Override
    public boolean checkLocValid(Location loc){
        assert loc!= null;
        for(Gala g: Gala.galas){
            if(this.getName().equals(g.getName()) && g.getLocation().equals(Optional.of(loc))) return false;
        }
        return true;
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
     * Remove a VIP at index i from the VIP list
     * @pre index should be within the range of the VIP list    i>= 0 && i< this.aVips.size()
     * @param i At the index we want to remove
     */
    public void deleteVip(int i){
        assert i>= 0 && i< this.aVips.size();
        this.aVips.remove(i);
    }

    /**
     * Getter method for the VIP arraylist
     * @return The copied list of VIPs who is attending the concert
     */
    public List<VIP> getVips(){
        return List.copyOf(aVips);
    }
}
