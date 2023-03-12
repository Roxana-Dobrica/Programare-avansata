package lab2;

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

    /**
     *
     * @param myLocations
     * @param myRoads 
     * va fi verificat ca o locatie sau un drum sa nu fie adaugat
     * de mai multe ori
     */
    public Connection(ArrayList<Location> myLocations, ArrayList<Road> myRoads) {
        for (Location i : myLocations) {
            this.addLocation(i);
        }

        for (Road i : myRoads) {
            this.addRoad(i);
        }
    }

    /**
     *
     * @param location
     */
    public boolean verifyIfLocationExists(Location location) {
        for (int i = 0; i < locations.size(); i++) {
            if (location.equals(locations.get(i)) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param locationToAdd
     */
    public void addLocation(Location locationToAdd) {
        if (verifyIfLocationExists(locationToAdd) == false) {
            locations.add(locationToAdd);
        } else {
            System.out.println("Location " + locationToAdd + " already exists.");
        }
    }

    /**
     *
     * @param road
     * return true or false
     */
    public boolean verifyIfRoadExists(Road road) {
        for (int i = 0; i < roads.size(); i++) {
            if (road.equals(roads.get(i)) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param roadToAdd
     */
    public void addRoad(Road roadToAdd) {
        if (verifyIfRoadExists(roadToAdd) == false) {
            roads.add(roadToAdd);
        } else {
            System.out.println("Location " + roadToAdd + " already exists.");
        }
    }

    /**
     *
     * @param location1
     * @param location2 
     * se va verifica daca locatiile date ca parametri exista
     * in multimea locatiilor
     * @return true or false
     */
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

    /**
     *
     * @param loc1
     * @param loc2 
     * functia va returna 1 daca exista un drum intre prima si a
     * doua locatie date ca parametru
     * @return 0 or 1
     */
    public int areConnected(Location loc1, Location loc2) {
        for (Road i : roads) {
            if ((i.getLocation1().equals(loc1) == true && i.getLocation2().equals(loc2) == true) || (i.getLocation1().equals(loc2) == true && i.getLocation2().equals(loc1) == true)) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * functia creeaza si afiseaza matricea de adiacenta corespunzatoare
     * nodurilor si drumurilor existente
     */
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

    /**
     *
     * @param loc1
     * @param loc2 
     * functia verifica daca locatiile date ca parametri reprezinta
     * locatii valide, apoi in caz afirmativ, se va face un dfs pornind de la
     * prima locatie data ca parametru
     * @return
     */
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

    /**
     *
     * @param start
     * @param visited 
     * se parcurg in mod recursiv liniile din matricea de
     * adiacenta pornind de la nodul de start si continuand cu vecinii
     */
    public void dfs(int start, boolean[] visited) {

        visited[start] = true;

        for (int i = 0; i < adjacencyMatrix[start].length; i++) {
            if (adjacencyMatrix[start][i] == 1 && (visited[i] == false)) {
                // daca vecinul respectiv al nodului nu a fost vizitat, vom aplica dfs si pentru el
                dfs(i, visited);
            }
        }
    }
}
