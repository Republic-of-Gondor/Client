import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Map {

    private String[][] map =
            {
                    {"T","T"," "," ","B","B","B","B","B","B","T","T","R","R","R","R","T","T","T"},
                    {"T","T"," ","S","B","B","D","B","B","B","T","T","R","R","R","R","T","T","T"},
                    {"T","T"," "," "," "," "," "," "," "," "," "," ","B","B","B","B","T","T","T"},
                    {"T","T"," "," "," "," "," "," "," "," "," ","S","B","D","B","B","T","T","T"},
                    {"T","T"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","W"},
                    {"T","T"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","W"},
                    {" "," "," "," "," "," "," "," ","S"," "," "," "," "," "," "," "," "," ","W"},
                    {" "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","W"},
                    {"T","T","R","R","R","R"," "," "," "," "," "," "," "," "," "," "," ","t","T"},
                    {"T","T","B","D","B","B"," "," "," "," "," "," "," "," "," "," "," ","t","T"},
                    {" "," "," "," "," "," "," "," "," "," ","R","R","R","R"," "," "," ","t","T"},
                    {" "," "," "," "," "," "," "," "," ","S","B","D","B","B"," "," "," ","t","T"},
                    {"T","T"," "," "," "," "," "," "," "," "," "," "," "," "," "," "," ","t","T"},
                    {"T","T","t","t","t","t"," "," "," "," "," "," "," "," "," "," "," ","t","T"},
            };

    private static int numOfBlocks = 9;
    private static int size = 500/numOfBlocks;
    private BufferedImage tileset;

    public Map()    {
        try {
            tileset = ImageIO.read(new File("resources/tilesets/Newbarktown.png"));
        } catch (IOException e) {
            System.err.println("Yo dawg, couldn't find the file.");
        }
    }

    public String getEntityAt(int x, int y) {
        try {
            return map[y][x];
        } catch (IndexOutOfBoundsException e) { //TODO: Probably not the most efficient way of doing this...lol
            return "O";
        }
    }


    public void drawMap(Graphics g, int centerX, int centerY) {
        for(int y = 0; y < numOfBlocks; y++) {
            g.drawLine(0, y*size, 500, y*size);
        }

        for(int x = 0; x < numOfBlocks; x++) {
            g.drawLine(x*size, 0, x*size, 500);
        }

        g.setFont(new Font(null, 0, size));
        for(int x = 0; x < numOfBlocks; x++) {
            for(int y = 0; y < numOfBlocks; y++) {
                g.drawString(getEntityAt(x + (centerX - (numOfBlocks/2)), y + (centerY - (numOfBlocks/2))), x * size, y * size + size);
            }
        }
        BufferedImage tmp = null;
        try {
            tmp = ImageIO.read(new File("resources/gold-right.png"));
        } catch (Exception e)   {

        }
        for(int x = 0; x < numOfBlocks; x++) {
            for(int y = 0; y < numOfBlocks; y++) {
                String entity = getEntityAt(x + (centerX - (numOfBlocks / 2)), y + (centerY - (numOfBlocks / 2)));
                if (entity.compareTo("T") == 0)  {
                    //g.setClip(0, 0, 50, 50);
                    int spotX = x * size;
                    int spotY = y * size;
                    g.drawImage(tileset.getSubimage(0, 0, 50, 50), spotX, spotY, null);
                    //g.setClip(null);
                }
            }
        }


    }
}
