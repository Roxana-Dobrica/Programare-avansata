package com.mycompany.lab6homework;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roxana Dobrica
 */
public class Game implements Serializable {

    private List<Dot> dots = new ArrayList<>();
    private List<Line> lines = new ArrayList<>();
    private Player player1, player2;
    private Dot dot1, dot2;
    private int color;
    private int numDots;
    private double lineProbability;
    private MainFrame frame;
    private int[] x, y;

    @JsonCreator
    public Game(@JsonProperty("dots") List<Dot> dots, @JsonProperty("lines") List<Line> lines,
            @JsonProperty("source") Dot source, @JsonProperty("destination") Dot destination,
            @JsonProperty("color") int color, @JsonProperty("frame") MainFrame frame, @JsonProperty("x") int[] x, @JsonProperty("y") int[] y,
            @JsonProperty("numVertices") int numVertices, @JsonProperty("edgeProbability") double edgeProbability) {
        this.dots = dots;
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.color = color;
        this.frame = frame;
        this.lines = lines;
        this.x = x;
        this.y = y;
        this.numDots = numVertices;
        this.lineProbability = edgeProbability;
        //createOffscreenImage();
        //initPanel();
    }

    public Game(Player player1, Player player2) {
        this.dots = new ArrayList<>();
        this.lines = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public void setDots(List<Dot> dots) {
        this.dots = dots;
    }

    public List<Line> getLines() {
        return lines;
    }

    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Dot getDot1() {
        return dot1;
    }

    public void setDot1(Dot dot1) {
        this.dot1 = dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public void setDot2(Dot dot2) {
        this.dot2 = dot2;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getNumDots() {
        return numDots;
    }

    public void setNumDots(int numDots) {
        this.numDots = numDots;
    }

    public double getLineProbability() {
        return lineProbability;
    }

    public void setLineProbability(double lineProbability) {
        this.lineProbability = lineProbability;
    }

    public MainFrame getFrame() {
        return frame;
    }

    public void setFrame(MainFrame frame) {
        this.frame = frame;
    }

    public int[] getX() {
        return x;
    }

    public void setX(int[] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

}
