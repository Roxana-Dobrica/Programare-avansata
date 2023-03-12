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
        Location Tecuci = new Location("Tecuci", new City(31_000, 86.9f, 601), 45.3f, 27.9f );
        Location NewYork = new Location("New York", new City(8_500_000, 778.2f, 650), 200.9f, 278.3f );
        Location LosAngeles = new Location("Los Angeles", new City(3_800_000, 1300.5f,600), 389.2f, 480.8f);
        Location Chicago = new Location("Chicago", new City(2_697_000, 606.1f, 601), 501.5f, 304.6f);
        Location Otopeni = new Location("Otopeni", new Airport(2, 1270, 53), 51.2f, 45.2f);
        Location Petrom = new Location("Petrom", new GasStation(6.62f, 20),24.3f, 25.1f);
        Location ChicagoMidway = new Location("Chicago Midway", new Airport(1, 1023, 50), 500.2f, 459.4f);
        
        Road road1 = new Road(new Highway("concrete", 4), 120.0f, Iasi, Brasov);
        Road road2 = new Road(new Highway("cement", 4), 120.0f, Brasov, Cluj);
        Road road3 = new Road(new Express("concrete", 7), 90.0f, Sibiu, Cluj);
        Road road4 = new Road(new Highway("cement", 4), 120.0f, Iasi, Bucuresti);  
        Road road5 = new Road(new Highway("concrete", 4), 120.0f, NewYork, LosAngeles);
        Road road6 = new Road(new Country("stone", 2), 70.0f, Iasi, Petrom);
        Road road7 = new Road(new Express("cement", 10), 90.0f, Chicago, ChicagoMidway);
        Road road8 = new Road(new Express("concrete", 7), 90.0f, Bucuresti, Otopeni);
        
        ArrayList<Location> locations1 = new ArrayList<>();
        locations1.add(Iasi);
        locations1.add(Brasov);
        locations1.add(Cluj);
        locations1.add(Bucuresti);
        locations1.add(Sibiu);
        locations1.add(NewYork);
        locations1.add(LosAngeles);
        locations1.add(Chicago);
        locations1.add(Otopeni);
        locations1.add(Petrom);
        locations1.add(ChicagoMidway);
        
        ArrayList<Road> roads1 = new ArrayList<>();
        roads1.add(road1);
        roads1.add(road2);
        roads1.add(road3);
        roads1.add(road4);
        roads1.add(road5);
        roads1.add(road6);
        roads1.add(road7);
        roads1.add(road8);
        
        Connection connection1 = new Connection(locations1, roads1);
        connection1.validInstance(NewYork, Iasi);
        connection1.validInstance(Brasov, Tecuci);
        System.out.println(road1.getLocation1().getName());
        connection1.adjacencyMatrix();
        System.out.println(connection1.existsPath(Iasi, Cluj));
        System.out.println(connection1.existsPath(Bucuresti, Chicago));
        System.out.println(connection1.existsPath(Chicago, ChicagoMidway));
        System.out.println(connection1.existsPath(Iasi, Petrom));
        
    }
}
