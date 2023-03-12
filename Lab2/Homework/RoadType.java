package lab2;

/**
 *
 * @author Roxana Dobrica
 */
abstract class RoadType {
    private String material;

    /**
     *
     * @param material
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     *
     * @return the material
     */
    public String getMaterial() {
        return material;
    }
}
