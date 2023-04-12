package com.mycompany.lab6homework;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Roxana Dobrica
 */
public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
        createButton.addActionListener(e -> {
            frame.canvas.createBoard();
        });
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots: ");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line probability");

        Double[] numbers = {1.0, 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1, 0.0};

        linesCombo = new JComboBox(numbers);
        createButton = new JButton("Create new game");

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesCombo);
        add(createButton);
    }
}
