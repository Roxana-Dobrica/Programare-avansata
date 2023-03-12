package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class GasStation extends LocationType{
    private float gasPrice;

    /**
     *
     * @param gasPrice
     */
    public void setGasPrice(float gasPrice) {
        this.gasPrice = gasPrice;
    }

    /**
     *
     * @return the gasPrice
     */
    public float getGasPrice() {
        return gasPrice;
    }
    
    /**
     *
     * @param gasPrice
     * @param age
     */
    public GasStation(float gasPrice, int age)
    {
        this.gasPrice = gasPrice;
        this.setAge(age);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "GasStation{" + "gasPrice=" + gasPrice + '}';
    }
    
    
}
