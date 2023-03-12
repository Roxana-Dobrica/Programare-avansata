package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class Airport extends LocationType {

    private int numOfTerminals;
    private int numOfEmployees;

    /**
     *
     * @param numOfTerminals
     */
    public void setNumOfTerminals(int numOfTerminals) {
        this.numOfTerminals = numOfTerminals;
    }

    /**
     *
     * @param numOfEmployees
     */
    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    /**
     *
     * @return the numOfTerminals
     */
    public int getNumOfTerminals() {
        return numOfTerminals;
    }

    /**
     *
     * @return the numOfEmployees
     */
    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    /**
     *
     * @param numOfTerminals
     * @param numOfEmployees
     * @param age
     */
    public Airport(int numOfTerminals, int numOfEmployees, int age) {
        this.numOfTerminals = numOfTerminals;
        this.numOfEmployees = numOfEmployees;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return "Airport{" + "numOfTerminals=" + numOfTerminals + ", numOfEmployees=" + numOfEmployees + '}';
    }
}
