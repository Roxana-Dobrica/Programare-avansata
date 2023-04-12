package com.mycompany.lab6homework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author Roxana Dobrica
 */
public class DrawingPanel extends JPanel {

    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;

    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image 

    private List<Dot> dots = new ArrayList<>();
    private List<Line> availableLines = new ArrayList<>();
    private Dot dot1, dot2;
    private int color;
    private Player player1 = new Player("Player1");
    private Player player2 = new Player("Player2");
    private List<Line> deletedLines = new ArrayList<>();
    private Game game;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        dots.clear();
        availableLines.clear();
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("You clicked on " + e.getX() + " " + e.getY());
                int mouseX = e.getX();
                int mouseY = e.getY();

                if (color % 2 == 0) {
                    graphics.setColor(Color.pink);
                } else {
                    graphics.setColor(Color.green);
                }

                if (dot1 == null) {  // cazul in care selecteaza primul capat al liniei
                    for (Dot dot : dots) {
                        if ((mouseX >= dot.getX() - 5 && mouseX <= dot.getX() + 5) && (mouseY >= dot.getY() - 5 && mouseY <= dot.getY() + 5)) {
                            dot1 = dot;
                            graphics.fillOval(dot1.getX() - 10 / 2, dot1.getY() - 10 / 2, 10, 10);
                            repaint();

                        }
                    }
                }

                if (dot1 != null && dot2 == null) {  //cazul in care primul capat este deja selectat si se selecteaza al doilea capat al liniei
                    for (Dot dot : dots) {
                        if ((dot != dot1) && (mouseX >= dot.getX() - 5 && mouseX <= dot.getX() + 5) && (mouseY >= dot.getY() - 5 && mouseY <= dot.getY() + 5)) {
                            dot2 = dot;
                            graphics.fillOval(dot2.getX() - 10 / 2, dot2.getY() - 10 / 2, 10, 10);
                            repaint();
                        }
                    }

                }

                if (dot1 != null && dot2 != null) {   //cazul in care s-au selectat atat primul capat, cat si al doilea capat
                    Line lineToRemove = null;
                    System.out.println(availableLines.size());
                    for (Line line : availableLines) {
                        if ((line.getDot1().getX() == dot1.getX() && line.getDot1().getY() == dot1.getY()) && (line.getDot2().getX() == dot2.getX() && line.getDot2().getY() == dot2.getY())
                                || (line.getDot1().getX() == dot2.getX() && line.getDot1().getY() == dot2.getY()) && (line.getDot2().getX() == dot1.getX() && line.getDot2().getY() == dot1.getY())) {
                            graphics.drawLine(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
                            repaint();
                            lineToRemove = line;
                            break;
                        }
                    }
                    if (lineToRemove != null) {
                        availableLines.remove(lineToRemove);
                        System.out.println(availableLines.size());
                        if (color % 2 == 0) {
                            player1.addSelectedLine(lineToRemove);
                            System.out.println(player1);
                            if (player1.checkTriangle()) {
                                System.out.println("A castigat 1");
                                int confirmed = JOptionPane.showConfirmDialog(frame, "Player 1 wins! New game?", "End Game", JOptionPane.YES_NO_OPTION);
                                if (confirmed == JOptionPane.NO_OPTION) {
                                    frame.dispose();
                                } else {
                                    frame.canvas.createBoard();
                                }
                            }
                        } else {
                            player2.addSelectedLine(lineToRemove);
                            System.out.println(player2);
                            if (player2.checkTriangle()) {
                                System.out.println("A castigat 2");
                                int confirmed = JOptionPane.showConfirmDialog(frame, "Player 2 wins! New game?", "End Game", JOptionPane.YES_NO_OPTION);
                                if (confirmed == JOptionPane.NO_OPTION) {
                                    frame.dispose();
                                } else {
                                    frame.canvas.createBoard();
                                }
                            }
                        }
                    }
                    color++;
                    dot1 = null;
                    dot2 = null;
                }
            }
        });
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 800, 600);
    }

    final void createBoard() {
        color = 0;
        dots.clear();
        availableLines.clear();
        dot1 = null;
        dot2 = null;

        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawVertices();
        drawLines();
        repaint();

    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        graphics.setColor(Color.GRAY);
        Random random = new Random();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i != j) {
                    if (random.nextDouble() <= edgeProbability) {
                        graphics.drawLine(x[i], y[i], x[j], y[j]);
                        availableLines.add(new Line(new Dot(x[i], y[i]), new Dot(x[j], y[j])));
                    }
                }
            }
        }
    }

    private void drawVertices() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 10 / 2, y[i] - 10 / 2, 10, 10);
            dots.add(new Dot(x[i], y[i]));
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    @Override
    public void update(Graphics g) {
    }

    //Draw the offscreen image, using the original graphics
    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }

}
