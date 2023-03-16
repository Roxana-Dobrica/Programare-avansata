package lab3bonus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class Main {

    public static void main(String[] args) {
        Node programmer1 = new Programmer("John", LocalDate.of(1998, 12, 8), ProgrammerType.SOFTWARE_DEVELOPER, "Java");
        Node programmer2 = new Programmer("Olivia", LocalDate.of(1999, 4, 20), ProgrammerType.WEB_DEVELOPER, "JavaScript");
        Node programmer3 = new Programmer("James", LocalDate.of(1997, 3, 14), ProgrammerType.ANALYST_PORGRAMMER, "Python");
        Node programmer4 = new Programmer("Charlotte", LocalDate.of(2000, 7, 3), ProgrammerType.DATA_DEVELOPER, "SQL");
        Node programmer5 = new Programmer("Liam", LocalDate.of(1995, 10, 20), ProgrammerType.SYSTEM_HARDWARE_DEVELOPER, "Python");
        Node designer1 = new Designer("Isabella", LocalDate.of(1997, 1, 21), "Canva");
        Node designer2 = new Designer("Mia", LocalDate.of(1998, 2, 10), "Photoshop");
        Node designer3 = new Designer("Will", LocalDate.of(2001, 8, 29), "Sketch");
        Node person1 = new Person("Carl", LocalDate.of(1992, 3, 30));

        Company company1 = new Company("Microsoft", 221_000);
        Company company2 = new Company("Endava", 10_000);
        Company company3 = new Company("Centric", 4000);

        List<Node> list1 = new ArrayList<Node>();
        list1.add(programmer1);
        list1.add(programmer2);
        list1.add(programmer3);
        list1.add(programmer4);
        list1.add(programmer5);
        list1.add(designer1);
        list1.add(designer2);
        list1.add(designer3);
        list1.add(person1);
        list1.add(company1);
        list1.add(company2);
        list1.add(company3);

        Network network1 = new Network(list1);
        network1.addRelationship(programmer1, programmer2, "Colleagues");
        network1.addRelationship(programmer1, programmer3, "Brothers");
        network1.addRelationship(programmer3, programmer2, "Colleagues");
        network1.addRelationship(programmer3, programmer4, "Friends");
        network1.addRelationship(programmer4, programmer5, "Colleagues");
        network1.addRelationship(designer2, programmer5, "Friends");
        network1.addRelationship(programmer5, designer1, "Employee");

        System.out.println(programmer1.getRelationships());

        network1.initialize();
        network1.findArticulationPoints(programmer1);
        network1.printArticulationPoints();
    }
}
