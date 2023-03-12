package lab3;

/**
 *
 * @author Roxana Dobrica
 */
public class Person implements Node {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
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
        return "Person{" + "name=" + name + '}';
    }

}
