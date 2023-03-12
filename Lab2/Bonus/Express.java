package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class Express extends RoadType {

    private int numOfTrafficLights;

    public void setNumOfTrafficLights(int numOfTrafficLights) {
        this.numOfTrafficLights = numOfTrafficLights;
    }

    public int getNumOfTrafficLights() {
        return numOfTrafficLights;
    }

    public Express(String material, int numOfTrafficLights) {
        this.setMaterial(material);
        this.numOfTrafficLights = numOfTrafficLights;
    }

    @Override
    public String toString() {
        return "Express{" + "numOfTrafficLights=" + numOfTrafficLights + '}';
    }
}
