package lab2;

import java.util.Objects;

/**
 *
 * @author Roxana Dobrica
 */
public class Location {

    private String name;
    private LocationType type;
    private float x, y;

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param type
     */
    public void setType(LocationType type) {
        this.type = type;
    }

    /**
     *
     * @param x
     * @param y
     */
    public void setCoord(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return the type
     */
    public LocationType getType() {
        return type;
    }

    /**
     *
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     *
     * @param name
     * @param type
     * @param x
     * @param y
     */
    public Location(String name, LocationType type, float x, float y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", type=" + type + ", x=" + x + ", y=" + y + '}';
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + Float.floatToIntBits(this.x);
        hash = 67 * hash + Float.floatToIntBits(this.y);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (Float.floatToIntBits(this.x) != Float.floatToIntBits(other.x)) {
            return false;
        }
        if (Float.floatToIntBits(this.y) != Float.floatToIntBits(other.y)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.type, other.type);
    }

}
