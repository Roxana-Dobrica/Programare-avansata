package lab3bonus;

import java.util.Map;

/**
 *
 * @author Roxana Dobrica
 */
interface Node extends Comparable<Node> {

    public String getName();

    public void addRelationships(Node node, String relationship);

    public void nodeImportance();

    public Map<Node, String> getRelationships();
}
