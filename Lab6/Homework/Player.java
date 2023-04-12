package com.mycompany.lab6homework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class Player implements Serializable {

    private String name;
    private String color;
    private List<Line> selectedLines;

    public Player(String name) {
        this.name = name;
        selectedLines = new ArrayList<Line>();
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSelectedLine(Line line) {
        selectedLines.add(line);
    }

    public boolean checkTriangle() {
        if (selectedLines.size() < 3) {
            return false;
        }
        for (int i = 0; i < selectedLines.size() - 2; i++) {
            for (int j = i + 1; j < selectedLines.size() - 1; j++) {
                for (int k = j + 1; k < selectedLines.size(); k++) {
                    System.out.println(selectedLines.get(i).isConnected(selectedLines.get(j)) + " "
                            + selectedLines.get(j).isConnected(selectedLines.get(k)) + " "
                            + selectedLines.get(i).isConnected(selectedLines.get(k)));
                    if (selectedLines.get(i).isConnected(selectedLines.get(j))
                            && selectedLines.get(j).isConnected(selectedLines.get(k))
                            && selectedLines.get(i).isConnected(selectedLines.get(k))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", color=" + color + ", selectedLines=" + selectedLines + '}';
    }
}
