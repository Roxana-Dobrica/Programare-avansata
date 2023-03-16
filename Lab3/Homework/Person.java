package lab3homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roxana Dobrica
 */
public class Person implements Node {

    private String name;
    private LocalDate birthDate;
    private Map<Node, String> relationships = new HashMap<>();

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void addRelationships(Node node, String relationship) {
        relationships.put(node, relationship);
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public void nodeImportance() {
        System.out.println("The importance of the node: " + relationships.size());
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
        return "Person{" + "name=" + name + ", birthDate=" + birthDate + ", relationships=" + relationships + '}';
    }

}
