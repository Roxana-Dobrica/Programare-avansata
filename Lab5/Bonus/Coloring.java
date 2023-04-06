package com.mycompany.lab5bonus;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.graph4j.Graph;
import org.graph4j.GraphBuilder;

/**
 * @author Roxana Dobrica
 */
public class Coloring {

    public boolean areRelated(Document document1, Document document2) {
        Map<String, Object> tags1 = document1.getTags();
        Map<String, Object> tags2 = document2.getTags();
        for (String key1 : tags1.keySet()) {
            Object value1 = tags1.get(key1);
            for (String key2 : tags2.keySet()) {
                Object value2 = tags2.get(key2);

                if (key1.equals(key2) && value1.equals(value2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Graph createGraph(Catalog catalog) {
        Graph g = GraphBuilder.empty().buildGraph();
        for (Document document : catalog.getDocuments()) {
            g.addVertex(catalog.getDocuments().indexOf(document));
        }

        // Pentru a tine evidenta muchiilor adaugate, pentru a nu avea duplicate
        Set<String> addedEdges = new HashSet<>();

        for (Document document1 : catalog.getDocuments()) {
            for (Document document2 : catalog.getDocuments()) {
                if (!document1.getId().equals(document2.getId())) {
                    if (areRelated(document1, document2) == true) {
                        int index1 = catalog.getDocuments().indexOf(document1);
                        int index2 = catalog.getDocuments().indexOf(document2);

                        // Verificam daca muchia nu exista deja inainte sa o adaugam
                        if (!addedEdges.contains(index1 + "-" + index2) && !addedEdges.contains(index2 + "-" + index1)) {
                            g.addEdge(index1, index2);
                            addedEdges.add(index1 + "-" + index2);
                        }
                    }
                }
            }
        }
        return g;
    }

    public void greedyColoring(Catalog catalog) {
        Graph graph = createGraph(catalog);

        int[] color = new int[graph.numVertices()];

        for (int v : graph.vertices()) {
            color[v] = -1;  //Initializam culoarea fiecarui nod cu -1 (nu are culoare)
        }

        // Asignam primului nod prima culoare
        color[0] = 0;

        //Un array in care stocam culorile disponibile. O culoarea va avea
        //valoarea false atunci cand un nod adiacent cu nodul curent va avea acea culoare
        boolean available[] = new boolean[graph.numVertices()];

        // Initial, toate culorile sunt disponibile
        for (int i : graph.vertices()) {
            available[i] = true;
        }

        //Asignam culori celor v-1 noduri ramase
        for (int v = 1; v < graph.numVertices(); v++) {
            for (var it = graph.neighborIterator(v); it.hasNext(); ) {
                int u = it.next(); //u este vecin cu v
                if (color[u] != -1) {  //verificam daca vecinul lui care vreo culoare asignata
                    available[color[u]] = false;
                }
            }
            // Gasim prima culoare disponibila
            int col;
            for (col = 0; col < graph.numVertices(); col++) {
                if (available[col]) {
                    break;
                }
            }
            color[v] = col; //Asignam nodului culoarea gasita
            //Resetam valorile din nou cu true pentru urmatoarea iteratie
            for (int i : graph.vertices()) {
                available[i] = true;
            }
        }
        // Afisam nodurile si culorile
        for (int v = 0; v < graph.numVertices(); v++) {
            System.out.println("Vertex " + v + " --->  Color " + color[v]);
        }
    }
}
