package lab2;

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

    /**
     *
     * @param type
     */
    public void setType(RoadType type) {
        this.type = type;
    }

    /**
     *
     * @param location1
     */
    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    /**
     *
     * @param location2
     */
    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    /**
     *
     * @param speedLimit
     */
    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }

    /**
     *
     * @return the type
     */
    public RoadType getType() {
        return type;
    }

    /**
     *
     * @return the location1
     */
    public Location getLocation1() {
        return location1;
    }

    /**
     *
     * @return the location2
     */
    public Location getLocation2() {
        return location2;
    }

    /**
     *
     * @return the speedLimit
     */
    public float getSpeedLimit() {
        return speedLimit;
    }

    /**
     *
     * @return the length
     */
    public float getLength() {
        return length;
    }

    /**
     * calculeaza lungimea unui drum
     */
    public void calculateLength() {
        length = (float) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }

    /**
     *
     * @param type
     * @param speedLimit
     * @param location1
     * @param location2
     */
    public Road(RoadType type, float speedLimit, Location location1, Location location2) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
        length = (float) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }

    
    @Override
    public String toString() {
        return "Road{" + "type=" + type + ", length=" + length + ", speedLimit=" + speedLimit + ", location1=" + location1 + ", location2=" + location2 + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Float.floatToIntBits(this.length);
        hash = 79 * hash + Float.floatToIntBits(this.speedLimit);
        hash = 79 * hash + Objects.hashCode(this.location2);
        return hash;
    }

    /**
     *
     * @param obj
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
        final Road other = (Road) obj;
        if (Float.floatToIntBits(this.length) != Float.floatToIntBits(other.length)) {
            return false;
        }
        if (Float.floatToIntBits(this.speedLimit) != Float.floatToIntBits(other.speedLimit)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.location1, other.location1)) {
            return false;
        }
        return Objects.equals(this.location2, other.location2);
    }

}
