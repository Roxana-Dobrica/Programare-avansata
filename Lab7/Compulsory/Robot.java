package com.mycompany.lab7compulsory;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Roxana Dobrica
 */
public class Robot implements Runnable {

    private String name;
    private boolean running;
    Exploration explore;

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

    public void run() {
        while (running) {
            int row = ThreadLocalRandom.current().nextInt(0, explore.getMap().getMatrix().length);
            int col = ThreadLocalRandom.current().nextInt(0, explore.getMap().getMatrix().length);

            explore.getMap().visit(row, col, this);
            try {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (explore.getMap().isFull() == true) {
                running = false;
                System.out.println("A fost parcursa toata mapa");
            }
        }
    }

}
