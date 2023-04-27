package lab7homework;

/**
 *
 * @author Roxana Dobrica
 */
public class TimeKeeper extends Thread {

    private final long timeLimit;
    private long startTime;
    private boolean timeUp;

    public TimeKeeper(long timeLimit) {
        this.timeLimit = timeLimit;
        this.startTime = System.currentTimeMillis();
        this.timeUp = false;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (timeUp == false) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println("Elapsed time: " + elapsedTime / 1000 + " seconds.");

            if (elapsedTime >= timeLimit) {
                timeUp = true;
                System.out.println("The time limit of " + timeLimit / 1000 + " has been exceeded. Stopped the exploration.");
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
