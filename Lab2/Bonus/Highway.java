package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class Highway extends RoadType {

    private int numOfLanes;

    public void setNumOfLanes(int numOfLanes) {
        this.numOfLanes = numOfLanes;
    }

    public int getNumOfLanes() {
        return numOfLanes;
    }

    public Highway(String material, int numOfLanes) {
        this.setMaterial(material);
        this.numOfLanes = numOfLanes;
    }

    @Override
    public String toString() {
        return "Highway{" + "numOfLanes=" + numOfLanes + '}';
    }
}
