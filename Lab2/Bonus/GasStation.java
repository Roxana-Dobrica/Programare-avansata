package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class GasStation extends LocationType {

    private float gasPrice;

    public void setGasPrice(float gasPrice) {
        this.gasPrice = gasPrice;
    }

    public float getGasPrice() {
        return gasPrice;
    }

    public GasStation(float gasPrice, int age) {
        this.gasPrice = gasPrice;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return "GasStation{" + "gasPrice=" + gasPrice + '}';
    }

}
