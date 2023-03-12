package lab2bonus;

/**
 *
 * @author Roxana Dobrica
 */
public class Solution {

    private Connection connection;
    private float[][] pathMatrix;

    Solution(Connection connection) {
        this.connection = connection;
        pathMatrix = new float[connection.getLocations().size()][connection.getLocations().size()];
    }

    /**
     * daca exista drum intre cele 2 locatii, va returna lungimea drumului,
     * altfel va returna 0
     */
    public void createLengthMatrix() {
        for (int i = 0; i < pathMatrix.length; i++) {
            for (int j = 0; j < pathMatrix.length; j++) {
                pathMatrix[i][j] = connection.roadLength(connection.getLocations().get(i), connection.getLocations().get(j));
            }
        }
    }

    /**
     * daca exista drum intre cele 2 locatii, va returna viteza de pe acel drum,
     * altfel va returna 0
     */
    public void createSpeedMatrix() {
        for (int i = 0; i < pathMatrix.length; i++) {
            for (int j = 0; j < pathMatrix.length; j++) {
                pathMatrix[i][j] = connection.calculateSpeed(connection.getLocations().get(i), connection.getLocations().get(j));
            }
        }
    }

    /**
     * returneaza indicele nodului care se afla la distanta cea mai mica; vom
     * folosi acest indice pentru ca mai apoi sa parcurgem linia nodului cu
     * indicele respectiv
     */
    int minDistance(float dist[], boolean existsMinPath[]) {
        float min = Float.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < pathMatrix.length; v++) {
            if (existsMinPath[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    void dijkstraLength(Location location1, Location location2) {
        createLengthMatrix();
        dijkstra(location1, location2);
    }

    void dijkstraSpeed(Location location1, Location location2) {
        createSpeedMatrix();
        dijkstra(location1, location2);
    }

    void dijkstra(Location location1, Location location2) {
        if (connection.existsPath(location1, location2)) {
            int startNode = connection.getLocations().indexOf(location1);
            float[] dist = new float[pathMatrix.length];  // distanta cea mai mica dintre nodul de start si nodul x

            // existsMinPath returneaza true daca nodul este inclus deja in drumul de lungime minima 
            boolean existsMinPath[] = new boolean[pathMatrix.length];

            //pentru inceput vom initializa distanta catre toate celelalte noduri cu "infinit" 
            //si vom seta existsMinPath pe false pt. toate nodurile deoarece niciunul nu se afla in drumul de lungime minima
            for (int i = 0; i < pathMatrix.length; i++) {
                dist[i] = Float.MAX_VALUE;
                existsMinPath[i] = false;
            }

            dist[startNode] = 0;
            //cautam drumul de lungime minima
            for (int count = 0; count < pathMatrix.length; count++) {
                // alegem nodul aflat la distanta cea mai mica dintre nodurile care inca nu au fost procesate
                int u = minDistance(dist, existsMinPath);
                existsMinPath[u] = true;
                
                //dijkstraPath = dijkstraPath + connection.getLocations().get(u).getName() + " ";
                // actualizam valoarea distantei nodurilor adiacente cu nodul ales
                for (int v = 0; v < pathMatrix.length; v++) {  
                    // vom actualiza valoarea distantei pentru v daca v nu face parte deja din drumul minim, 
                    //daca exista o muchie intre u si v si 
                    //daca lungimea totala a drumului de la nodul de start pana la v prin u este 
                    //mai mica decat valoarea curenta a lui dist[v] 
                    if ((existsMinPath[v] == false && pathMatrix[u][v] != 0) && dist[u] != Float.MAX_VALUE && dist[u] + pathMatrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + pathMatrix[u][v];
                    }
                }
            }
            
            System.out.println("From " + location1.getName() + " to " + location2.getName() + ": " + dist[connection.getLocations().indexOf(location2)]);
        } else {
            System.out.println("There is no path between " + location1.getName() + " and " + location2.getName());
        }
    }
}
