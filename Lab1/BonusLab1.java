package bonuslab1;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Roxana Dobrica
 */
public class BonusLab1 {

    public static void main(String[] args) throws Exception {
        //Cycle graph
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices in the cycle graph: ");
        int numOfVertices;
        while (!input.hasNextInt()) {
            System.out.println("The value you introduced is not an integer. Try again");
            input.next();
        }
        numOfVertices = input.nextInt();

        int[][] adjMatrix = new int[numOfVertices][numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            if (i == (numOfVertices - 1)) {
                adjMatrix[i][0] = 1;
                adjMatrix[0][i] = 1;
            } else {
                adjMatrix[i][(i + 1)] = 1;
                adjMatrix[(i + 1)][i] = 1;
            }
        }

        System.out.println("Adjacency matrix of the cycle graph: ");
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println("\t");
        }

        int[][] powMatrix = new int[numOfVertices][numOfVertices];
        powMatrix = adjMatrix;

        for (int m = 2; m <= numOfVertices; m++) {
            int[][] powAux = new int[numOfVertices][numOfVertices];
            for (int i = 0; i < numOfVertices; i++) {
                for (int j = 0; j < numOfVertices; j++) {
                    powAux[i][j] = 0;
                    for (int k = 0; k < numOfVertices; k++) {
                        powAux[i][j] = powAux[i][j] + powMatrix[i][k] * adjMatrix[k][j];
                    }
                }
            }
            powMatrix = powAux;
            System.out.println("Power " + m + ":");
            for (int i = 0; i < numOfVertices; i++) {
                for (int j = 0; j < numOfVertices; j++) {
                    System.out.print(powMatrix[i][j] + " ");
                }
                System.out.println("\t");
            }
        }
        //Interpretarea rezultatului:
        //Din fiecare putere k a matricei de adiacenta putem determina 
        //cate mersuri de lungime k exista intre fiecare doua noduri

        //Regular graph
        if (args.length != 2) {
            System.out.println("Introduce the number of vertices and the vertex degree!");
        }
        int numVertices = 0, vertexDegree = 0;
        try {
            numVertices = Integer.parseInt(args[0]);
            vertexDegree = Integer.parseInt(args[1]);
            System.out.println("The number of vertices is: " + numVertices);
            System.out.println("The vertex degree is: " + vertexDegree);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Introduce two integers for the number of vertices and the vertex degree!");
        }

        int[] numOfNeighbors = new int[numVertices];
        int[][] neighbors = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            numOfNeighbors[i] = 0;
        }
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                neighbors[i][j] = 0;
            }
        }
        for (int i = 0; i < numVertices; i++) {
            while (numOfNeighbors[i] != vertexDegree) //cat timp mai putem adauga vecini pentru nodul i
            {
                int min = 0;
                int max = numVertices;
                
                Random rand = new Random();
                int randVertex = rand.nextInt(numVertices);  //alegem un nod random
                if (randVertex != i) //verificam daca nodul ales este altul decat i
                {
                    if (numOfNeighbors[randVertex] < vertexDegree) //verificam daca mai putem 
                    //adauga vecini pentru nodul ales random
                    {
                        if (neighbors[randVertex][i] == 1 || neighbors[i][randVertex] == 1) //verificam daca cele 2 noduri sunt deja vecine
                        {
                            //System.out.println("The vertex" + i + " is already neighbor with vertex" + randVertex);
                            break;
                        } else {
                            neighbors[randVertex][i] = 1;
                            neighbors[i][randVertex] = 1;
                            numOfNeighbors[i]++;
                            numOfNeighbors[randVertex]++;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(neighbors[i][j]);
            }
            System.out.println("\t");
        }
    }
}
