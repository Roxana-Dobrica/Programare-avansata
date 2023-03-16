package lab3bonus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static junit.framework.Assert.assertEquals;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Roxana
 */
public class MyTests {
    
    @Test
        void testFindArticulationPoints() {
        Node a = new Person("A", LocalDate.of(1999, 1, 1));
        Node b = new Person("B", LocalDate.of(2000, 2, 2));
        Node c = new Person("C", LocalDate.of(2001, 3, 3));
        Node d = new Person("D", LocalDate.of(2000, 4, 4));
        Node e = new Person("E", LocalDate.of(2002, 5, 5));
        
        List<Node> list1 = new ArrayList<Node>();
        list1.add(a);
        list1.add(b);
        list1.add(c);
        list1.add(d);
        list1.add(e);

        Network network1 = new Network(list1);
        network1.addRelationship(b, a, "Colleagues");
        network1.addRelationship(a, c, "Colleagues");
        network1.addRelationship(c, d,"Colleagues");
        network1.addRelationship(b,c, "Brothers");
        network1.addRelationship(d,e, "Brothers");
        network1.addRelationship(b,e, "Colleagues");
        network1.addRelationship(e, a, "Friends");

        Set<Node> result = new HashSet();
        result = network1.findArticulationPoints(a);

        // Check results
        List<Node> expected = Arrays.asList(b, c);
        assertEquals(expected, network1.findArticulationPoints(a));
    }
}
