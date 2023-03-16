package lab3homework;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Roxana
 */
public class Network {

    private List<Node> nodes = new ArrayList();

    public Network(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List getNodes() {
        return nodes;
    }

    public void AddNode(Node node) {
        if (nodes.contains(node) == true) {
            System.out.println("The node " + node.getName() + " already exists in the network.");
        } else {
            nodes.add(node);
        }
    }

    public void addRelationship(Node node1, Node node2, String relationship) {
        if (nodes.contains(node1) == true) {
            if (nodes.contains(node2) == true) {
                node1.addRelationships(node2, relationship);
                node2.addRelationships(node1, relationship);
            } else {
                System.out.println("The network doesn't contain " + node2.getName() + " node.");
            }
        } else {
            System.out.println("The network doesn't contain " + node1.getName() + " node.");
        }
    }

    @Override
    public String toString() {
        return "Network{" + "nodes=" + nodes + '}';
    }

    void nodeImportance(Node node) {
        if (nodes.contains(node)) {
            node.nodeImportance();
        } else {
            System.out.println(node + "doesn't exist in this network.");
        }
    }

}
