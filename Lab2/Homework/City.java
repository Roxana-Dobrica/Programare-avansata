package lab2;

/**
 *
 * @author Roxana
 */
class City extends LocationType{
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
    
}
