package lab7homework;


/**
 *
 * @author Roxana Dobrica
 */
public class Robot implements Runnable {

    private String name;
    private boolean running;
    Exploration explore;
    private int numOfTokens;

    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean getRunning() {
        return running;
    }

    @Override
    public void run() {
        int row = 0;
        int col = 0;
        while (running) {
            explore.getMap().visit(row, col, this);

            if (row < explore.getMap().getMatrix().length) {
                numOfTokens += explore.getMap().getNumOfTokens(row, col);
            }

            col++;

            if (col == explore.getMap().getMatrix().length) {
                col = 0;
                row++;
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (explore.getMap().isFull() == true) {
                running = false;
                System.out.println("Robot " + this.getName() + " placed " + this.numOfTokens + " tokens in the matrix.");
                System.out.println("All cells of the matrix were explored.");
            }
        }
    }
}
