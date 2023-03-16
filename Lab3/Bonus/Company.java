package lab3bonus;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roxana Dobrica
 */
public class Company implements Node {

    private String name;
    private int numOfEmployees;
    private Map<Node, String> relationships = new HashMap<>();

    public Company(String name, int numOfEmployees) {
        this.name = name;
        this.numOfEmployees = numOfEmployees;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setNumOfEmployees(int numOfEmployees) {
        this.numOfEmployees = numOfEmployees;
    }

    public int getNumOfEmployees() {
        return numOfEmployees;
    }

    public void addRelationships(Node node, String relationship) {
        relationships.put(node, relationship);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void nodeImportance() {
        System.out.println("The importance of the node " + ": " + relationships.size());
    }

    @Override
    public int compareTo(Node node) {
        if (this.name == null && node.getName() == null) {
            return 0;
        }
        if (node.getName() == null) {
            return 1;
        }
        if (this.name == null) {
            return -1;
        }
        return this.name.compareTo(node.getName());
    }

    @Override
    public String toString() {
        return "Company{" + "name=" + name + ", numOfEmployees=" + numOfEmployees + ", relationships=" + relationships + '}';
    }

}
