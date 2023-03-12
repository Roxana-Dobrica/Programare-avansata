package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class Highway extends RoadType {
    private int numOfLanes;

    /**
     *
     * @param numOfLanes
     */
    public void setNumOfLanes(int numOfLanes) {
        this.numOfLanes = numOfLanes;
    }

    /**
     *
     * @return the numOfLanes
     */
    public int getNumOfLanes() {
        return numOfLanes;
    }

    /**
     *
     * @param material
     * @param numOfLanes
     */
    public Highway(String material, int numOfLanes) {
        this.setMaterial(material);
        this.numOfLanes = numOfLanes;
    } 

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Highway{" + "numOfLanes=" + numOfLanes + '}';
    }
}
