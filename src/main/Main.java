package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Project Chiara");

        GamePanel gamePanel = new GamePanel(); //create new panel/canvas;
        window.add(gamePanel);

        window.pack(); // so we can see it.

        window.setLocationRelativeTo(null); // displays window in center of screen
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}