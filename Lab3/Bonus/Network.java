package lab3bonus;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Roxana Dobrica
 */
public class Network {

    private List<Node> nodes = new ArrayList();
    private int time;
    private boolean[] visited;
    private int[] parent;
    private int[] low;
    private int[] disc;
    private Set<Node> result = new HashSet();

    public void initialize() {
        time = 0;
        visited = new boolean[nodes.size()];
        parent = new int[nodes.size()];
        low = new int[nodes.size()];
        disc = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            visited[i] = false;
            parent[i] = -1;
            low[i] = 0;
            disc[i] = 0;
        }
    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List getNodes() 
    {
        return nodes;
    }

    public void AddNode(Node node) {
        if (nodes.contains(node) == true) {
            System.out.println("The node " + node.getName() + " already exists in the network.");
        } else {
            nodes.add(node);
        }
    }

    public void addRelationship(Node node1, Node node2, String relationship) {
        if (nodes.contains(node1) == true) {
            if (nodes.contains(node2) == true) {
                node1.addRelationships(node2, relationship);
                node2.addRelationships(node1, relationship);
            } else {
                System.out.println("The network doesn't contain " + node2.getName() + " node.");
            }
        } else {
            System.out.println("The network doesn't contain " + node1.getName() + " node.");
        }
    }

    @Override
    public String toString() {
        return "Network{" + "nodes=" + nodes + '}';
    }

    Set<Node> findArticulationPoints(Node v) {
        int indexOfV = nodes.indexOf(v);
        visited[indexOfV] = true;
        time++;
        disc[indexOfV] = low[indexOfV] = time;  //discovery time and low value
        int numOfChildren = 0;   //numarul de fii ai nodului in arborele DFS
        for (Node adjVertex : v.getRelationships().keySet()) //nodurile adiacente cu v
        {
            int indexOfAdjVertex = nodes.indexOf(adjVertex);
            if (visited[indexOfAdjVertex] == false) {
                numOfChildren++;
                parent[indexOfAdjVertex] = indexOfV;
                findArticulationPoints(adjVertex);
                low[indexOfV] = Math.min(low[indexOfV], low[indexOfAdjVertex]);
                if (parent[indexOfV] == -1 && numOfChildren > 1) {   //daca v este radacina si are cel putin 2 copii
                    result.add(v);
                } else if (parent[indexOfV] != -1 && low[indexOfAdjVertex] >= disc[indexOfV]) {  //daca v nu este radacina si low value de unul din fiii lui este mai mult decat discovery time de v
                    result.add(v);
                }
            } else if (indexOfAdjVertex != parent[indexOfV]) {   //back edge
                low[indexOfV] = Math.min(low[indexOfV], disc[indexOfAdjVertex]);
            }
        }
        return result;
    }

    void printArticulationPoints() { 
        System.out.println("Articulation points: " + result);
    }

    void nodeImportance(Node node) {
        if (nodes.contains(node)) {
            node.nodeImportance();
        } else {
            System.out.println(node + "doesn't exist in this network.");
        }
    }

}
