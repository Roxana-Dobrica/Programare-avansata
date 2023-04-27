package com.mycompany.lab5bonus;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;

public class ExplorationMap {

    private Graph graph;
    private Robot robot;
    private boolean[] isVisited;

    public ExplorationMap(int n) {

        graph =  GraphBuilder.empty().estimatedNumVertices(n).buildGraph();
        isVisited = new boolean[n];

        for(int vertex : graph.vertices()){
            isVisited[vertex] = false;
        }
    }

    public boolean visit(int vertex, Robot robot) {
        Integer integerVertex = Integer.valueOf(vertex);
        synchronized (integerVertex) {
            //the vertex is not visited
            if (isVisited[vertex] == false) {
                //the robot visits that vertex
                isVisited[vertex] = true;

                //display a success message
                System.out.println("Robot " + robot.getName() + " visited vertex " + vertex);

                int nextVertex = -1;
                for (var it = graph.neighborIterator(vertex); it.hasNext(); ) {
                    int neighbor = it.next();
                    if(isVisited[neighbor] == false){
                        nextVertex = neighbor;
                        break;
                    }
                }
                if (nextVertex == -1) {
                    // no unvisited neighbors, choose another unvisited vertex
                    for (int i = 0; i < isVisited.length; i++) {
                        if (isVisited[i] == false) {
                            nextVertex = i;
                            break;
                        }
                    }
                }
                if (nextVertex != -1) {
                    return visit(nextVertex, robot);
                }
            }
        }
        return false;
    }

    public boolean allVerticesVisited() {
        for(int vertex : graph.vertices()){
            if(isVisited[vertex] == false){
                return false;
            }
        }
        return true;
    }

    public Graph getGraph(){
        return graph;
    }

    @Override
    public String toString() {
        return "ExplorationMap{" +
                "graph=" + graph +
                '}';
    }
}

