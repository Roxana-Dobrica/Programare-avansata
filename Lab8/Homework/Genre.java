package lab8homework;

/**
 *
 * @author Roxana Dobrica
 */
public class Genre extends Superclass {

    private String name;

    public Genre(int id, String name) {
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
        return "Genre{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }
}
