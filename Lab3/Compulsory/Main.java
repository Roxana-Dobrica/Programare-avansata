package lab3;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String[] args) {
        Node node1 = new Person("Oliver");
        Node node2 = new Person("Jack");
        Node node3 = new Person("Olivia");
        Node node4 = new Person("Emily");
        Node node5 = new Company("Amazon");
        Node node6 = new Company("Microsoft");
        Node node7 = new Company("Endava");

        List<Node> myList = new ArrayList<>();

        myList.add(node1);
        myList.add(node2);
        myList.add(node3);
        myList.add(node4);
        myList.add(node5);
        myList.add(node6);
        myList.add(node7);

        System.out.println(myList);
        System.out.println(node1.compareTo(node2));
        System.out.println(node1.compareTo(node5));
    }
}
