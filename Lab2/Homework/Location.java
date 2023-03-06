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

    public void setName(String name) {
        this.name = name;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public void setCoord(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public LocationType getType() {
        return type;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Location(String name, LocationType type, float x, float y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", type=" + type + ", x=" + x + ", y=" + y + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
        return this.type == other.type;
    }
 
}
