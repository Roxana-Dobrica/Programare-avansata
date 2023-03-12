package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class Country extends RoadType {

    private int numOfVillages;

    public void setNumOfVillages(int numOfVillages) {
        this.numOfVillages = numOfVillages;
    }

    public int getNumOfVillages() {
        return numOfVillages;
    }

    public Country(String material, int numOfVillages) {
        this.setMaterial(material);
        this.numOfVillages = numOfVillages;
    }

    @Override
    public String toString() {
        return "Country{" + "numOfVillages=" + numOfVillages + '}';
    }
}
