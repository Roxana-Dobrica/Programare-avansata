package lab2bonus;


/**
 *
 * @author Roxana Dobrica
 */
public class Airport extends LocationType {

    private int numOfTerminals;
    private int numOfEmployees;

    public void setNumOfTerminals(int numOfTerminals) {
        this.numOfTerminals = numOfTerminals;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfTerminals() {
        return numOfTerminals;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }
    
    public Airport(int numOfTerminals, int numOfEmployees, int age)
    {
        this.numOfTerminals = numOfTerminals;
        this.numOfEmployees = numOfEmployees;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return "Airport{" + "numOfTerminals=" + numOfTerminals + ", numOfEmployees=" + numOfEmployees + '}';
    }
}
