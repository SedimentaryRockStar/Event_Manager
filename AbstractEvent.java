import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;


/*
Representation of a type of Event that can exist
 */
public abstract class AbstractEvent implements Event{

    private final String name;
    private final LocalDate date;
    private Optional<Location> location;
    private Optional<Double> pricePerPerson;
    private Optional<Integer> numOfTickets;


    /**
     * Constructor for the AbstractEvent
     *
     * @param name
     * @param location
     * @param date
     * @param pricePerPerson
     * @param numOfTickets
     *
     * @pre name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null
     */
    protected AbstractEvent(String name, Location location, LocalDate date, Double pricePerPerson, Integer numOfTickets) {
        assert name != null && location != null && date != null && pricePerPerson != null && numOfTickets != null;
        this.name = name;
        this.location = Optional.of(location);
        this.date = date;
        this.pricePerPerson =Optional.of(pricePerPerson);
        this.numOfTickets = Optional.of(numOfTickets);
    }

    /**
     * Specific alternative constructor for the case when some fields are missing
     *
     * @param name
     * @param date
     *
     * @pre name != null && date != null
     *
     */
    protected AbstractEvent(String name, LocalDate date){
        assert name != null && date != null;
        this.name = name;
        this.location = Optional.empty();
        this.date = date;
        this.pricePerPerson =Optional.empty();
        this.numOfTickets = Optional.empty();
    }


    /*
    The concrete series of getter methods
     */
    @Override
    public String getName(){
        assert name!= null;
        return this.name;
    }
    @Override
    public LocalDate getDate(){
        assert date!= null;
        return this.date;
    }
    @Override
    public Optional<Location> getLocation(){
        return this.location;
    }
    @Override
    public Optional<Double> getPrice(){
        return this.pricePerPerson;
    }
    @Override
    public Optional<Integer> getNumTickets(){
        return this.numOfTickets;
    }


    // Setter methods for mutable fields
    public void setPricePerPerson(double pricePerPerson) {
        assert this.pricePerPerson.equals(Optional.empty());
        this.pricePerPerson = Optional.of(pricePerPerson);
    }

    public void setNumOfTickets(int numOfTickets) {
        assert this.numOfTickets.equals(Optional.empty());
        this.numOfTickets = Optional.of(numOfTickets);
    }


    //Special set Location method as it is discussed on Ed that locations cannot clash
    public void setLocation(Location loc){
        assert checkLocValid(loc) && this.location.equals(Optional.empty());
        //First check whether the input and field are in the valid status
        this.location = Optional.of(loc);
    }

    public abstract boolean checkLocValid(Location loc);

    @Override
    public abstract void accept(Visitor v);


    // Profit calculator for Concrete events
    @Override
    public double getProfit() {
        return (this.numOfTickets.isPresent() && this.pricePerPerson.isPresent())?
                this.numOfTickets.get() * this.pricePerPerson.get(): 0;
    }


    /**
     *
     * @param o input object
     * @return the boolean result whether two events are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEvent that = (AbstractEvent) o;
        return date.equals(that.date) && location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, location);
    }

}
