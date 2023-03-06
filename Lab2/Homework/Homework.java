package lab2;
import java.util.ArrayList;

/**
 *
 * @author Roxana
 */
public class Homework {
    public static void main(String[] args) {
        Location Iasi = new Location("Iasi", new City(300_000, 93.9f, 615), 23.5f, 59.3f );
        Location Brasov = new Location("Brasov", new City(253_200, 267.3f, 620), 78.4f, 102.2f );
        Location Cluj = new Location("Cluj", new City(286_500, 179.5f, 598), 12.5f, 25.3f );
        Location Bucuresti = new Location("Bucuresti", new City(300_000, 93.9f, 615), 70.8f, 52.9f );
        Location Sibiu = new Location("Sibiu", new City(300_000, 93.9f, 615), 17.9f, 29.9f );
        Location NewYork = new Location("New York", new City(8_500_000, 778.2f, 650), 200.9f, 278.3f );
        
        Road road1 = new Road(new Highway("concrete", 4), 120.0f, Iasi, Brasov);
        Road road2 = new Road(new Highway("cement", 4), 120.0f, Brasov, Cluj);
        Road road3 = new Road(new Highway("cement", 4), 120.0f, Sibiu, Cluj);
        Road road4 = new Road(new Highway("cement", 4), 120.0f, Iasi, Bucuresti);   
        
        ArrayList<Location> locations1 = new ArrayList<Location>();
        locations1.add(Iasi);
        locations1.add(Brasov);
        locations1.add(Cluj);
        locations1.add(Bucuresti);
        locations1.add(Sibiu);
        
        ArrayList<Road> roads1 = new ArrayList<Road>();
        roads1.add(road1);
        roads1.add(road2);
        roads1.add(road3);
        roads1.add(road4);
        
        Connection connection1 = new Connection(locations1, roads1);
        connection1.validInstance(NewYork, Iasi);
        connection1.validInstance(Brasov, Cluj);
        connection1.verifyIfLocationExists(Cluj);
        connection1.verifyIfLocationExists(NewYork);
        System.out.println(road1.getLocation1().getName());
        connection1.adjacencyMatrix();
        System.out.println(connection1.existsPath(Iasi, Cluj));
        
    }
}
