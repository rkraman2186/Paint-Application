package com.paint;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Objects;
import javax.swing.*;

public class Draw implements ActionListener{

    public static void main(String[] args) {
        new Draw();
    }

    Canvas canvas;
    Color color = Color.WHITE;
    JButton clearButton, blackButton, blueButton, greenButton, redButton,
            colorPicker, magentaButton, orangeButton, yellowButton,
            cyanButton, lightGrayButton, saveButton, loadButton,
            saveAsButton;
    private File file;
    private int saveCounter = 0;
    private final JLabel filenameBar;

    @Override
    public void actionPerformed(ActionEvent event) {
        JFileChooser fileChooser;
        if (event.getSource() == clearButton) {
            canvas.clear();
        } else if (event.getSource() == blackButton) {
            canvas.black();
        } else if (event.getSource() == blueButton) {
            canvas.blue();
        } else if (event.getSource() == greenButton) {
            canvas.green();
        } else if (event.getSource() == redButton) {
            canvas.red();
        } else if (event.getSource() == magentaButton) {
            canvas.magenta();
        } else if (event.getSource() == orangeButton) {
            canvas.orange();
        } else if (event.getSource() == yellowButton) {
            canvas.yellow();
        } else if (event.getSource() == cyanButton) {
            canvas.cyan();
        } else if (event.getSource() == lightGrayButton) {
            canvas.lightGray();
        } else if (event.getSource() == saveButton) {
            if (saveCounter == 0) {
                fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(saveButton) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    saveCounter = 1;
                    filenameBar.setText(file.toString());
                    canvas.save(file);
                    }
                } else {
                    filenameBar.setText(file.toString());
                    canvas.save(file);
                }
        } else if (event.getSource() == saveAsButton) {
            saveCounter = 1;
            fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(saveAsButton) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                filenameBar.setText(file.toString());
                canvas.save(file);
                }
            } else if (event.getSource() == loadButton) {
                fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(loadButton) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    filenameBar.setText(file.toString());
                    canvas.load(file);
                }
            } else if (event.getSource() == colorPicker) {
                color = JColorChooser.showDialog(null, "Pick your color!",
                        color);
                if (color == null)
                    color = (Color.WHITE);
                canvas.picker(color);
            }
        }

    public Draw() {
        JFrame frame = new JFrame("Paint");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        canvas = new Canvas();

        container.add(canvas, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        blackButton = new JButton();
        blackButton.setBackground(Color.BLACK);
        blackButton.setPreferredSize(new Dimension(40, 40));
        blackButton.addActionListener(this);
        blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setPreferredSize(new Dimension(40, 40));
        blueButton.addActionListener(this);
        greenButton = new JButton();
        greenButton.setBackground(Color.GREEN);
        greenButton.setPreferredSize(new Dimension(40, 40));
        greenButton.addActionListener(this);
        redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setPreferredSize(new Dimension(40, 40));
        redButton.addActionListener(this);
        magentaButton = new JButton();
        magentaButton.setBackground(Color.MAGENTA);
        magentaButton.setPreferredSize(new Dimension(40, 40));
        magentaButton.addActionListener(this);
        orangeButton = new JButton();
        orangeButton.setBackground(Color.ORANGE);
        orangeButton.setPreferredSize(new Dimension(40, 40));
        orangeButton.addActionListener(this);
        yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setPreferredSize(new Dimension(40, 40));
        yellowButton.addActionListener(this);
        cyanButton = new JButton();
        cyanButton.setBackground(Color.CYAN);
        cyanButton.setPreferredSize(new Dimension(40, 40));
        cyanButton.addActionListener(this);
        lightGrayButton = new JButton();
        lightGrayButton.setBackground(Color.LIGHT_GRAY);
        lightGrayButton.setPreferredSize(new Dimension(40, 40));
        lightGrayButton.addActionListener(this);
        Icon save = new ImageIcon(Objects.requireNonNull(getClass().getResource("save.png")));
        saveButton = new JButton(save);
        saveButton.addActionListener(this);
        saveAsButton = new JButton("Save As");
        saveAsButton.addActionListener(this);
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        colorPicker = new JButton("Color Picker");
        colorPicker.addActionListener(this);
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);

        filenameBar = new JLabel("No file");
        panel1.add(filenameBar, BorderLayout.SOUTH);
        panel.add(greenButton);
        panel.add(blueButton);
        panel.add(blackButton);
        panel.add(redButton);
        panel.add(magentaButton);
        panel.add(orangeButton);
        panel.add(yellowButton);
        panel.add(cyanButton);
        panel.add(lightGrayButton);
        panel.add(saveButton);
        panel.add(saveAsButton);
        panel.add(loadButton);
        panel.add(colorPicker);
        panel.add(clearButton);

        container.add(panel, BorderLayout.NORTH);
        container.add(panel1,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}