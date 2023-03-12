package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class Country extends RoadType{
    private int numOfVillages;
    
    /**
     *
     * @param numOfVillages
     */
    public void setNumOfVillages(int numOfVillages)
    {
        this.numOfVillages = numOfVillages;
    }
    
    /**
     *
     * @return the numOfVillages
     */
    public int getNumOfVillages()
    {
        return numOfVillages;
    }
    
    /**
     *
     * @param material
     * @param numOfVillages
     */
    public Country(String material, int numOfVillages)
    {
        this.setMaterial(material);
        this.numOfVillages = numOfVillages;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Country{" + "numOfVillages=" + numOfVillages + '}';
    }
}
