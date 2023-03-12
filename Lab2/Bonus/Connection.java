package lab2bonus;

import java.util.ArrayList;

/**
 *
 * @author Roxana Dobrica
 */
public class Connection {

    private ArrayList<Location> locations = new ArrayList<>();
    private ArrayList<Road> roads = new ArrayList<>();
    private int[][] adjacencyMatrix;
    private boolean[] visited;

    public Connection(ArrayList<Location> myLocations, ArrayList<Road> myRoads) {
        for (Location i : myLocations) {
            this.addLocation(i);
        }

        for (Road i : myRoads) {
            this.addRoad(i);
        }
    }

    public boolean verifyIfLocationExists(Location location) {
        for (int i = 0; i < locations.size(); i++) {
            if (location.equals(locations.get(i)) == true) {
                return true;
            }
        }
        return false;
    }

    public void addLocation(Location locationToAdd) {
        if (verifyIfLocationExists(locationToAdd) == false) {
            locations.add(locationToAdd);
        } else {
            System.out.println("Location " + locationToAdd + " already exists.");
        }
    }

    public boolean verifyIfRoadExists(Road road) {
        for (int i = 0; i < roads.size(); i++) {
            if (road.equals(roads.get(i)) == true) {
                return true;
            }
        }
        return false;
    }

    public void addRoad(Road roadToAdd) {
        if (verifyIfRoadExists(roadToAdd) == false) {
            roads.add(roadToAdd);
        } else {
            System.out.println("Location " + roadToAdd + " already exists.");
        }
    }

    public boolean validInstance(Location location1, Location location2) {
        boolean location1Exists = false;
        boolean location2Exists = false;
        for (int i = 0; i < locations.size(); i++) {
            if (location1.equals(locations.get(i)) == true) {
                location1Exists = true;
            }
            if (location2.equals(locations.get(i)) == true) {
                location2Exists = true;
            }
        }
        if (location1Exists == true && location2Exists == true) {
            System.out.println("Valid instance.");
            return true;
        } else {
            System.out.println("Invalid instance.");
            return false;
        }

    }

    public int areConnected(Location loc1, Location loc2) {
        for (Road i : roads) {
            if ((i.getLocation1().equals(loc1) == true && i.getLocation2().equals(loc2) == true) || (i.getLocation1().equals(loc2) == true && i.getLocation2().equals(loc1) == true)) {
                return 1;
            }
        }
        return 0;
    }

    public void adjacencyMatrix() {
        adjacencyMatrix = new int[locations.size()][locations.size()];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                adjacencyMatrix[i][j] = areConnected(locations.get(i), locations.get(j));
                adjacencyMatrix[j][i] = areConnected(locations.get(i), locations.get(j));
            }
        }
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println("\t");
        }
    }

    public boolean existsPath(Location loc1, Location loc2) {
        if (validInstance(loc1, loc2) == false) {
            return false;
        }
        int start = locations.indexOf(loc1);
        visited = new boolean[locations.size()];
        dfs(start, visited);
        int destination = locations.indexOf(loc2);
        return visited[destination];
    }

    public void dfs(int start, boolean[] visited) {

        visited[start] = true;

        for (int i = 0; i < adjacencyMatrix[start].length; i++) {
            if (adjacencyMatrix[start][i] == 1 && (visited[i] == false)) {
                dfs(i, visited);
            }
        }
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Location> getLocations() {
        return this.locations;
    }

    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }

    public ArrayList<Road> getRoads() {
        return this.roads;
    }

    public float roadLength(Location location1, Location location2) {
        for (Road i : roads) {
            if ((location1.getName().equals(i.getLocation1().getName()) && location2.getName().equals(i.getLocation2().getName()))
            || (location1.getName().equals(i.getLocation2().getName()) && location2.getName().equals(i.getLocation1().getName()))) {
                return i.getLength();
            }
        }
        return 0;
    }

    public float calculateSpeed(Location location1, Location location2) {
        for (Road i : roads) {
            if ((location1.getName().equals(i.getLocation1().getName()) && location2.getName().equals(i.getLocation2().getName()))
            || (location1.getName().equals(i.getLocation2().getName()) && location2.getName().equals(i.getLocation1().getName()))){
                return i.getLength() / i.getSpeedLimit();
            }
        }
        return 0;
    }
}
