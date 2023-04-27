package lab7homework;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roxana Dobrica
 */
public class Exploration {

    private final SharedMemory mem = new SharedMemory(5);
    private final ExplorationMap map = new ExplorationMap(5);
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        TimeKeeper timeKeeper = new TimeKeeper(5000);
        timeKeeper.start();

        for (Robot robot : robots) {
            //start a new Thread representing the robot;
            robot.setRunning(true);
            robot.setExplore(this);
            new Thread(robot).start();
        }
    }

    public void pauseARobot(Robot robotToPause) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotToPause.getName())) {
                robot.setRunning(false);
                System.out.println("Robot " + robot.getName() + " paused.");
            }
        }
    }

    public void pauseARobot(Robot robotToPause, int numOfSeconds) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotToPause.getName())) {
                robot.setRunning(false);
                try {
                    System.out.println("Robot " + robot.getName() + " sleep for " + numOfSeconds + " seconds");
                    Thread.sleep(numOfSeconds * 1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                robot.setRunning(true);
                robot.setExplore(this);
                new Thread(robot).start();
            }
        }
    }

    public void pauseAllRobots() {
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
        System.out.println("All robots paused");
    }

    public void startARobot(Robot robotToStart) {
        for (Robot robot : robots) {
            if (robot.getName().equals(robotToStart.getName())) {
                robot.setRunning(true);
                robot.setExplore(this);
                new Thread(robot).start();
                System.out.println("Robot " + robot.getName() + " started");
            }
        }
    }

    public static void main(String args[]) {
        var explore = new Exploration();

        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));

        //explore.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            String commandName = parts[0];
            if (commandName.equals("Pause")) {
                String robotName = parts[1];
                if (parts.length == 2) {
                    explore.pauseARobot(new Robot(robotName));
                } else if (parts.length == 3) {
                    int numberOfSeconds = Integer.parseInt(parts[2]);
                    explore.pauseARobot(new Robot(robotName), numberOfSeconds);
                }
            } else if (commandName.equals("Pause_all")) {
                explore.pauseAllRobots();
            } else if (commandName.equals("Start")) {
                String robotName = parts[1];
                explore.startARobot(new Robot(robotName));
            } else if (commandName.equals("Start_all")) {
                explore.start();
            } else if (commandName.equals("Exit")) {
                break;
            }
        }

    }

    public void addRobot(Robot toAdd) {
        robots.add(toAdd);
    }

    public ExplorationMap getMap() {
        return map;
    }

    public SharedMemory getMem() {
        return mem;
    }
}
