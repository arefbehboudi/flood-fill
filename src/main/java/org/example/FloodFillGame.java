package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FloodFillGame extends JFrame implements ActionListener {
    private static final int GRID_SIZE = 6;
    private static final int MAX_MOVES = 9;

    private static final List<Color> colors = Arrays.asList(Color.RED,
            Color.GREEN,
            Color.BLUE,
            Color.YELLOW);

    private JButton[][] gridButtons;
    private JButton[] colorButtons;
    private int movesLeft = MAX_MOVES;

    public FloodFillGame() {
        setTitle("Flood Fill Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(GRID_SIZE, GRID_SIZE));
        gridButtons = new JButton[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(50, 50));
                button.setBackground(getRandomChoice(colors));
                button.addActionListener(this);
                gridPanel.add(button);
                gridButtons[i][j] = button;
            }
        }

        JPanel colorPanel = new JPanel(new FlowLayout());
        colorButtons = new JButton[]{
                createColorButton(Color.RED),
                createColorButton(Color.GREEN),
                createColorButton(Color.BLUE),
                createColorButton(Color.YELLOW)
        };
        for (JButton button : colorButtons) {
            colorPanel.add(button);
        }

        add(gridPanel, BorderLayout.CENTER);
        add(colorPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);

        //resetGame();
    }

    private JButton createColorButton(Color color) {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(50, 50));
        button.setBackground(color);
        button.addActionListener(this);
        return button;
    }

    private void resetGame() {
        movesLeft = MAX_MOVES;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                gridButtons[i][j].setBackground(getRandomChoice(colors));
            }
        }
    }

    private void floodFill(int row, int col, Color targetColor, Color replacementColor) {
        if (row < 0 || row >= GRID_SIZE || col < 0 || col >= GRID_SIZE) {
            return;
        }

        if (!gridButtons[row][col].getBackground().equals(targetColor)) {
            return;
        }

        gridButtons[row][col].setBackground(replacementColor);
        floodFill(row - 1, col, targetColor, replacementColor);
        floodFill(row + 1, col, targetColor, replacementColor);
        floodFill(row, col - 1, targetColor, replacementColor);
        floodFill(row, col + 1, targetColor, replacementColor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton button) {
            Color replacementColor = button.getBackground();
            floodFill(0, 0, gridButtons[0][0].getBackground(), replacementColor);
            movesLeft--;
            setTitle("Moves Left: " + movesLeft);
            if (checkWinCondition()) {
                JOptionPane.showMessageDialog(this, "You Win!");
                resetGame();
            }else if (movesLeft == 0) {
                JOptionPane.showMessageDialog(this, "Game Over!");
                resetGame();
            }
        }
    }

    private boolean checkWinCondition() {
        Color firstColor = gridButtons[0][0].getBackground();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (!gridButtons[i][j].getBackground().equals(firstColor)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Color getRandomChoice(List<Color> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        new FloodFillGame();
    }
}

