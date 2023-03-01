package homeworklab1;

/**
 *
 * @author Roxana Dobrica
 */

public class HomeworkLab1 {

    public static void main(String args[]) throws Exception {
        long startTime = System.nanoTime();
        if (args.length != 1) {
            System.out.println("Introduce a single argument!");
            System.exit(-1);
        }
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } 
        catch (Exception e) {
            System.out.println(e);
            System.out.println(args[0] + " is not an integer!");
        }

        if (n <= 30_000 && n > 1) {
            int[][] mat = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        mat[i][j] = 1;
                    } else if (i < j) {    //deasupra diagonalei principale
                        mat[i][j] = j - i + 1;
                    } else {
                        mat[i][j] = n - i + j + 1;    //sub diagonala principala
                    }
                }
            }
            System.out.println("Latin Square: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mat[i][j] + " ");
                }
                System.out.println("\t");
            }

            String[] lineObject = new String[n];
            String[] columnObject = new String[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0) {
                        lineObject[i] = Integer.toString(mat[i][j]);
                        columnObject[i] = Integer.toString(mat[j][i]);
                    } else {
                        lineObject[i] = lineObject[i] + mat[i][j];
                        columnObject[i] = columnObject[i] + mat[j][i];
                    }
                }
            }

            int j = 1;
            for (int i = 0; i < n; i++) {
                System.out.println("For line " + j + ":");
                System.out.println(lineObject[i]);
                j++;
            }

            j = 1;
            for (int i = 0; i < n; i++) {

                System.out.println("For column " + j + ":");
                System.out.println(columnObject[i]);
                j++;
            }
        } else {
            long endTime = System.nanoTime();
            long runningTime = endTime - startTime;
            System.out.println("Running time of the application is: " + runningTime);
        }
    }
}
