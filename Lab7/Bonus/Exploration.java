package com.mycompany.lab5bonus;

import java.util.ArrayList;
import java.util.List;

public class Exploration {

    private final ExplorationMap map = new ExplorationMap(3);
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        for (Robot robot : robots) {
            //start a new Thread representing the robot;
            robot.setRunning(true);
            robot.setExplore(this);
            new Thread(robot).start();
        }
    }

    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));

        explore.map.getGraph().addVertex(0);
        explore.map.getGraph().addVertex(1);
        explore.map.getGraph().addVertex(2);

        explore.map.getGraph().addEdge(0, 1);
        explore.map.getGraph().addEdge(1,2);
        explore.map.getGraph().addEdge(0,2);

        explore.start();
    }

    public void addRobot(Robot toAdd) {
        robots.add(toAdd);
    }

    public ExplorationMap getMap() {
        return map;
    }

}