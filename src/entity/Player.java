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
    File f1 = new File("./../src/res/character_models/back1.png");
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
    File f17 = new File("./../src/res/character_models/shadow.png");

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
            // System.out.println("Image loading started");
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
            shadow = ImageIO.read(f17);
            // System.out.println("Image loading ended");
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if(keyH.upPressed || keyH.downPressed ||
         keyH.leftPressed || keyH.rightPressed) {

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
    
            spriteCounter ++;
            //Changes player sprite every 9 frames. (150ms)
            if(spriteCounter > 9) {
                if(spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 3;
                }
                else if (spriteNum == 3) {
                    spriteNum = 4;
                }
                else if (spriteNum == 4) {
                    if (direction == "up") {
                        spriteNum = 5;
                    } else {
                    spriteNum = 1;
                    }
                }
                else if (spriteNum == 5) {
                    if (direction == "up") {
                        spriteNum = 6;
                    } else {
                    spriteNum = 1;
                    }
                }
                else if (spriteNum == 6) {                
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void draw(Graphics2D g2) {
        // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize); //display test
    
        BufferedImage image = null;

        switch(direction) {
            case "up":
                if(spriteNum == 1) 
                image = up1;
                if(spriteNum == 2) 
                image = up2;
                if(spriteNum == 3) 
                image = up3;
                if(spriteNum == 4) 
                image = up4;
                if(spriteNum == 5) 
                image = up5;
                if(spriteNum == 6) 
                image = up6;
            break;
            case "down":
                if(spriteNum == 1) 
                image = down1;
                if(spriteNum == 2) 
                image = down2;
                if(spriteNum == 3) 
                image = down1;
                if(spriteNum == 4) 
                image = down2;
            break;
            case "left":
                if(spriteNum == 1) 
                image = left1;
                if(spriteNum == 2) 
                image = left2;
                if(spriteNum == 3) 
                image = left3;
                if(spriteNum == 4) 
                image = left4;
            break;
            case "right":
                if(spriteNum == 1) 
                image = right1;
                if(spriteNum == 2) 
                image = right2;
                if(spriteNum == 3) 
                image = right3;
                if(spriteNum == 4) 
                image = right4;
            break;
        }
        g2.drawImage(shadow, x, y+2, gp.tileSize*2, gp.tileSize*2, null);
        g2.drawImage(image, x, y, gp.tileSize*2, gp.tileSize*2, null);
        
    }
}
