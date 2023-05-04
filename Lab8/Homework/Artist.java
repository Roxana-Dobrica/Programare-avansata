package lab8homework;

/**
 *
 * @author Roxana Dobrica
 */
public class Artist extends Superclass {

    private String name;

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    @Override
    public String toString() {
        return "Artist{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
