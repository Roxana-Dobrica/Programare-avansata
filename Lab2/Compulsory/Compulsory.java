package lab2;

/**
 *
 * @author Roxana Dobrica
 */
public class Compulsory{

    public static void main(String[] args) {
        Location location1 = new Location("New York", LocationType.CITY, 123.59f, 87.451f);
        Location location2 = new Location("MOL", LocationType.GAS_STATION, 201.12f, 203.34f);
        Location location3 = new Location("Palas", LocationType.MALL, 45.789f, 60.59f);
        Location location4 = new Location("Ion Creanga", LocationType.SCHOOL, 78.23f, 81.55f);
        Location location5 = new Location("Henri Coanda", LocationType.AIRPORT, 102.11f, 180.21f);
        
        Road road1 = new Road(RoadType.COUNTRY, 50f, location3, location4);
        Road road2 = new Road(RoadType.EXPRESS, 90f, location5, location1);
        Road road3 = new Road(RoadType.HIGHWAY, 120f, location2, location4);
        
        
        location1.setName("Los Angeles");
        location2.setCoord(202.57f, 204.89f);
        System.out.println(location1);
        System.out.println(location2);
        System.out.println(location3);
        System.out.println(location4);
        System.out.println(location5);
        
        System.out.println(road1);
        System.out.println(road2);
        System.out.println(road3);
        
        System.out.println(location1.getName());
        System.out.println(location3.getType());
        System.out.println(road2.getLocation1());
        System.out.println(road1.getLength());
        System.out.println(road3.getSpeedLimit());
    }
}
