package lab2bonus;

import java.lang.Math;
import java.util.Objects;

/**
 *
 * @author Roxana Dobrica
 */
public class Road {

    private RoadType type;
    private float length;
    private float speedLimit;
    private Location location1;
    private Location location2;

    public void setType(RoadType type) {
        this.type = type;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    public RoadType getType() {
        return type;
    }

    public Location getLocation1() {
        return location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public float getSpeedLimit() {
        return speedLimit;
    }

    public float getLength() {
        return length;
    }

    public void calculateLength() {
        length = (float) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }

    public Road(RoadType type, float speedLimit, Location location1, Location location2) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
        length = (float) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }

    public Road(RoadType type, float speedLimit, Location location1, Location location2, float distance) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
        length = (float) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
        if (distance > length) {
            length = distance;
        }
    }

    @Override
    public String toString() {
        return "Road{" + "type=" + type + ", length=" + length + ", speedLimit=" + speedLimit + ", location1=" + location1 + ", location2=" + location2 + '}';
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
        final Road other = (Road) obj;
        if (Float.floatToIntBits(this.length) != Float.floatToIntBits(other.length)) {
            return false;
        }
        if (Float.floatToIntBits(this.speedLimit) != Float.floatToIntBits(other.speedLimit)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        if (!Objects.equals(this.location1, other.location1)) {
            return false;
        }
        return Objects.equals(this.location2, other.location2);
    }

}
