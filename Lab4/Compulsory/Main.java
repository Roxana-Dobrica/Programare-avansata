package lab4compulsory;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String[] args) {
        var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i))
                .toList();

        List<Student> studentList = new LinkedList<>(students);
        Collections.sort(studentList);
        System.out.println(studentList);

        var projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i))
                .toList();

        Set<Project> projectsTreeSet = new TreeSet<>(projects);

        System.out.println(projectsTreeSet);
    }
}
