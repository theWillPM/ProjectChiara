package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler keyH;
    File f1 = new File("./../src/res/character_models/Chiara_back_walk.gif");
    File f2 = new File("./../src/res/character_models/back2.png");
    File f3 = new File("./../src/res/character_models/back3.png");
    File f4 = new File("./../src/res/character_models/back4.png");
    File f5 = new File("./../src/res/character_models/back5.png");
    File f6 = new File("./../src/res/character_models/back6.png");
    File f7 = new File("./../src/res/character_models/front1.png");
    File f8 = new File("./../src/res/character_models/front2.png");
    File f9 = new File("./../src/res/character_models/left1.png");
    File f10 = new File("./../src/res/character_models/left2.png");
    File f11 = new File("./../src/res/character_models/left3.png");
    File f12 = new File("./../src/res/character_models/left4.png");
    File f13 = new File("./../src/res/character_models/right1.png");
    File f14 = new File("./../src/res/character_models/right2.png");
    File f15 = new File("./../src/res/character_models/right3.png");
    File f16 = new File("./../src/res/character_models/right4.png");

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            System.out.println("Image loading started");
            up1 = ImageIO.read(f1);
            up2 = ImageIO.read(f2);
            up3 = ImageIO.read(f3);
            up4 = ImageIO.read(f4);
            up5 = ImageIO.read(f5);
            up6 = ImageIO.read(f6);
            down1 = ImageIO.read(f7);
            down2 = ImageIO.read(f8);
            left1 = ImageIO.read(f9);
            left2 = ImageIO.read(f10);
            left3 = ImageIO.read(f11);
            left4 = ImageIO.read(f12);
            right1 = ImageIO.read(f13);
            right2 = ImageIO.read(f14);
            right3 = ImageIO.read(f15);
            right4 = ImageIO.read(f16);
            System.out.println("Image loading ended");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if(keyH.upPressed) {
            direction = "up";
            y -= speed;
        } else if (keyH.downPressed) {
            direction = "down";
            y += speed;
        } else if (keyH.leftPressed) {
            direction = "left";
            x -= speed;
        } else if (keyH.rightPressed) {
            direction = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize); //display test

        BufferedImage image = null;

        switch(direction) {
            case "up":
            image = up1;
            break;
            case "down":
            image = down1;
            break;
            case "left":
            image = left1;
            break;
            case "right":
            image = right1;
            break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
        
    }
}
