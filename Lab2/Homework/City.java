package lab2;

/**
 *
 * @author Roxana Dobrica
 */
class City extends LocationType {

    private int population;
    private float surface;

    /**
     *
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     *
     * @param surface
     */
    public void setSurface(float surface) {
        this.surface = surface;
    }

    /**
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     *
     * @return the surface
     */
    public float getSurface() {
        return surface;
    }

    /**
     *
     * @param population
     * @param surface
     * @param age
     */
    public City(int population, float surface, int age) {
        this.population = population;
        this.surface = surface;
        this.setAge(age);
    }

    @Override
    public String toString() {
        return "City{" + "population=" + population + ", surface=" + surface + '}';
    }
}
