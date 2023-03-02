package lab2;
import java.lang.Math;

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

    public void setLocation1(Location location1){
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
    
    public float getLength(){
       return length; 
    }
    
    public void calculateLength()
    {
        length = (float)Math.sqrt(Math.pow(location1.getX() - location2.getX(),2) + Math.pow(location1.getY() -location2.getY(), 2));
    }

    public Road(RoadType type, float speedLimit, Location location1, Location location2) {
        this.type = type;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
        length = (float)Math.sqrt(Math.pow(location1.getX() - location2.getX(),2) + Math.pow(location1.getY() -location2.getY(), 2));
    }

    @Override
    public String toString() {
        return "Road{" + "type=" + type + ", length=" + length + ", speedLimit=" + speedLimit + ", location1=" + location1 + ", location2=" + location2 + '}';
    }

    
}
