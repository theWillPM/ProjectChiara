package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.Graphics2D;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
    
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    int counter[][];
    
    public TileManager(GamePanel gp) {
        
        this.gp = gp;
        
        tile = new Tile[14];
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        counter = new int[gp.maxScreenCol][gp.maxScreenRow];

        getTileImage();
        loadMap("../res/world/Maps/map1.txt");
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/grass.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/wall.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/water1.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/water2.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/water3.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/water4.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassTop_WaterBottom.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassRight_WaterLeft.png"));
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassBottom_WaterTop.png"));
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassLeft_WaterRight.png"));
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassTopLeft_WaterBottomRight.png"));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassTopRight_WaterBottomLeft.png"));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassBottomRight_WaterTopLeft.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("../res/world/Tiles/GrassBottomLeft_WaterTopRight.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filepath) {
        try {
            // System.out.println("Loading map:");
            InputStream is = getClass().getResourceAsStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();
                System.out.println(line);
                while(col < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col== gp.maxScreenCol) {
                col = 0;
                row++;
            }
        }
        // System.out.println("Map Loaded!");
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = col * gp.tileSize;
        int y = row * gp.tileSize;
        // System.out.println("Started drawing map:");


        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            
            int tileNum = mapTileNum[col][row];

            if (tileNum == 2) {
                counter[col][row]++;
                if(counter[col][row] == 20) {
                mapTileNum[col][row] = 3;
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                counter[col][row] = 0;
                }
            } else if (tileNum == 3) {
                counter[col][row]++;
                if(counter[col][row] == 20) {
                mapTileNum[col][row] = 4;
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                counter[col][row] = 0;
                }
            } else if (tileNum == 4) {
                counter[col][row]++;
                if(counter[col][row] == 20) {
                mapTileNum[col][row] = 5;
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                counter[col][row] = 0;
                }
            } else if (tileNum == 5) {
                counter[col][row]++;
                if(counter[col][row] == 20) {
                mapTileNum[col][row] = 2;
                g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                counter[col][row] = 0;
                }
            }

            g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;
            
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
        // System.out.println("Map draw succesfull.");
    }

}
