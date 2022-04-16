import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Concert extends AbstractEvent{


    // An arraylist to contain all the concerts we have created to achieve Flyweight
    private static final List<Concert> concerts= new ArrayList<>();

    private  Optional<String> artist;
    private final List<VIP> aVips= new ArrayList<>();


    // Private constructors to achieve Flyweight
    private Concert(String name, Location location, LocalDate date, Double pricePerPerson,
                    Integer numOfTickets, String artist, List<VIP> vips) {
        super(name, location, date, pricePerPerson, numOfTickets);
        assert artist != null && vips!= null;
        this.artist = Optional.of(artist);
        aVips.addAll(vips); // Add all the input VIPS into the VIP list
    }

    //Alternative private constructor when the Event is Coming Soon
    private Concert(String name, LocalDate date, List<VIP> vips) {
        super(name, date);
        assert vips!= null;
        this.artist = Optional.empty();
        aVips.addAll(vips); // Add all the input VIPS into the VIP list
    }

    /**
     * This is the standard factory method for getting a Concert object to achieve Flyweight
     * @pre name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && artist != null && vips!= null
     * @param name The concert name
     * @param location The location of the concert
     * @param date The date the concert is to be held
     * @param pricePerPerson    The ticket price per person
     * @param numOfTickets  Total number of tickets the concert has sold
     * @param artist    The artist who is playing at the concert
     * @param vips      The VIP list we initially have
     * @return a Concert object
     */
    public static Concert getConcert(String name, Location location, LocalDate date, Double pricePerPerson, Integer numOfTickets, String artist, List<VIP> vips){
        assert name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null && artist != null && vips!= null;
        for(Concert c : concerts){
            if(c.getDate().equals(date) && c.getLocation().equals(Optional.of(location))) return c;
        }
        Concert c= new Concert(name, location, date, pricePerPerson, numOfTickets, artist, vips);
        Concert.concerts.add(c);
        return c;
    }

    /**
     *  This is the alternative factory method for getting a Concert object
     * @pre name != null && date != null && artist != null && vips!= null
     * @param name      The concert name
     * @param date      The date the concert is to be held
     * @param artist    The artist who is playing at the concert
     * @param vips      The VIP list we initially have
     * @return a Concert object
     */

    public static Concert getConcert(String name, LocalDate date, String artist, List<VIP> vips){
        assert name != null && date != null && artist != null && vips!= null;
        Concert c= new Concert(name, date, vips);
        Concert.concerts.add(c);
        return c;
    }

    // Get and set the name of the artist who is playing at the concert
    public Optional<String> getArtist(){
        return this.artist;
    }

    public void setArtist(String artist){
        assert artist != null;
        this.artist = Optional.of(artist);
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


    /**
     * Method to check whether the input location is valid to be set
     *
     * @param loc The location to be set
     * @return boolean result whether the input is valid to be set
     */
    @Override
    public boolean checkLocValid(Location loc){
        assert loc!= null;
        for(Concert c: Concert.concerts){
            if(this.getName().equals(c.getName()) && c.getLocation().equals(Optional.of(loc))) return false;
        }
        return true;
    }



    public static void main(String[] args){
        LocalDate d= LocalDate.of(2001, 9, 13);
        Concert c= Concert.getConcert("WWDC", d, "Steve", new ArrayList<>());
        c.setPricePerPerson(12.0);
    }


}
