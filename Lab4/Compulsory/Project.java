package lab4compulsory;

import java.util.Objects;

/**
 *
 * @author Roxana Dobrica
 */
public class Project implements Comparable<Project> {

    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Project project) {
        if (this.name == null && project.getName() == null) {
            return 0;
        }
        if (project.getName() == null) {
            return 1;
        }
        if (this.name == null) {
            return -1;
        }
        return this.name.compareTo(project.getName());
    }

    @Override
    public String toString() {
        return "Project{" + "name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Project other = (Project) obj;
        return Objects.equals(this.name, other.name);
    }

}
