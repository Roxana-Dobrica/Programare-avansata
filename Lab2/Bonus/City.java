package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
class City extends LocationType {

    private int population;
    private float surface;

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setSurface(float surface) {
        this.surface = surface;
    }

    public int getPopulation() {
        return population;
    }

    public float getSurface() {
        return surface;
    }

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
