package org.parabot.jketelaar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author: JKetelaar
 */
public class UI {

    public static void main(String[] args) {
        startUp();
    }

    public static void startUp() {
        final JFrame frame = new JFrame("Settings");
        frame.setBounds(1, 1, 250, 300);
        final JTextField field = new JTextField("ID Here");
        field.setBounds(1, 1, 250, 100);
        JButton button = new JButton("Start");
        button.setBounds(100, 100, 100, 150);
        frame.add(field);
        frame.add(button);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(field.getText());
                    Variables.setMineID(Integer.parseInt(field.getText()));
                    Variables.setFrameVisible(false);
                    frame.dispose();
                } catch (NumberFormatException ex) {
                    field.setText("Make sure the ID is a numeric value!");
                }
            }
        });
    }
}
