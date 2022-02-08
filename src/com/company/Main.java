package com.company;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        HW1 exp = new HW1(1000, 400);
        exp.controller();
    }
}

class HW1 {
    private int x, y;
    final String[] options = {"First", "Second", "Third"};
    final JComboBox<String> menu = new JComboBox<>(options);
    final JFrame frame = new JFrame("Very nice HW");

    public HW1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private void setCanvas(int width, int height) {
        frame.setSize(width, height);
        menu.setBounds(20, 20, 400, 100);
        frame.add(menu);
        frame.setVisible(true);
    }

    public void controller() {
        setCanvas(x, y);
        selection();
    }

    public void selection() {
        menu.addActionListener((ActionEvent e) -> {
            Object selection = menu.getSelectedItem();
            assert selection != null;
            if (selection.equals("First"))
                System.out.println("First");
            else if (selection.equals("Second"))
                System.out.println("Second");
            else System.out.println("Third");
        });
    }
}