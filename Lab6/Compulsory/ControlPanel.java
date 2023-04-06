package lab6compulsory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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

        exitButton.addActionListener(this::exitGame);
        loadButton.addActionListener(this::loadGame);
        saveButton.addActionListener(this::saveGame);
        resetButton.addActionListener(this::resetGame);

        add(loadButton);
        add(saveButton);
        add(resetButton);
        add(exitButton);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Loading game...");
    }

    private void saveGame(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Saving game...");
    }

    private void resetGame(ActionEvent e) {
        JOptionPane.showMessageDialog(frame, "Game reset");
    }

}
