package com.mycompany.lab5bonus;

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

    @Override
    public void run() {
        int vertex = 0;
        while (running) {
            explore.getMap().visit(vertex, this);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (explore.getMap().allVerticesVisited() == true) {
                running = false;
                System.out.println("All vertices of the graph were explored.");
            }
        }
    }
}
