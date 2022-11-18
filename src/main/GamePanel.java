package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import entity.Player;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    final int originalTileSize = 64; //64px
    final int scale = 1; //sets scale to multiply tile size

    public final int tileSize = originalTileSize * scale;

    final int maxScreenCol = 16;
    final int maxScreenRow = 9;

    final int screenWidth = tileSize * maxScreenCol; //1024
    final int screenHeight = tileSize * maxScreenRow; //576

    //FPS
    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; //Starts the 'game clock' - required: implements Runnable
    Player player = new Player(this,keyH);

    //Set player default stats
    int playerX = player.x;
    int playerY = player.y;
    int playerSpeed = player.speed;

    public GamePanel() { 
        //GamePanel constructor with size, background color and double buffer.    
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this); //instantiate new thread;
        gameThread.start(); //calls thread start.
    }

    //run method that loops infinitely and obtains feedback on character position, information, etc.    
    @Override
    public void run() {

        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

       while(gameThread != null) {

            currentTime = System.nanoTime();    
            
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if(delta>=1) {
                update();
                repaint();
                delta--;
                drawCount ++;
            }

        if(timer >= 1000000000) {
            System.out.println("FPS: "+drawCount);
            drawCount = 0;
            timer = 0;
        }
    }
        
}

    public void update() {
        player.update();        
    }

    public void paintComponent(Graphics g) { //Graphics is simpler

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; //this has a little more functions so I'm going to convert graphics g into a Graphics2D

        player.draw(g2);
        g2.dispose();
    
    }

}