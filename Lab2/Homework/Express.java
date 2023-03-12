package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class Express extends RoadType {

    private int numOfTrafficLights;

    /**
     *
     * @param numOfTrafficLights
     */
    public void setNumOfTrafficLights(int numOfTrafficLights) {
        this.numOfTrafficLights = numOfTrafficLights;
    }

    /**
     *
     * @return the numOfTrafficLights
     */
    public int getNumOfTrafficLights() {
        return numOfTrafficLights;
    }

    /**
     *
     * @param material
     * @param numOfTrafficLights
     */
    public Express(String material, int numOfTrafficLights) {
        this.setMaterial(material);
        this.numOfTrafficLights = numOfTrafficLights;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Express{" + "numOfTrafficLights=" + numOfTrafficLights + '}';
    }
}
