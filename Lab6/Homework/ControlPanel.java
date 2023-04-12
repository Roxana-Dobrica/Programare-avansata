package com.mycompany.lab6homework;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Roxana Dobrica
 */
public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton loadButton;
    JButton saveButton;
    JButton resetButton;
    JButton exitButton;
    JButton exportButton;

    private DrawingPanel drawingPanel;

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        loadButton = new JButton("Load");
        saveButton = new JButton("Save");
        resetButton = new JButton("Reset");
        exitButton = new JButton("Exit");
        exportButton = new JButton("Export");

        exitButton.addActionListener(this::exitGame);
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
        resetButton.addActionListener(this::resetGame);
        exportButton.addActionListener(this::exportGame);

        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
        add(exportButton);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void exportGame(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(frame);
        File file = fileChooser.getSelectedFile();
        try {
            ImageIO.write(frame.canvas.image, "PNG", file);
            repaint();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
    
    
    private void loadGame(ActionEvent actionEvent) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("savefile.ser"));
            drawingPanel.setGame((Game) in.readObject());
            drawingPanel.getGame().resetDrawingPanel(frame.canvas);
            in.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void saveGame(ActionEvent e) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("savefile.ser"));
            out.writeObject(this.drawingPanel.getGame());
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private void resetGame(ActionEvent e) {
        frame.canvas.reset();
    }

}
