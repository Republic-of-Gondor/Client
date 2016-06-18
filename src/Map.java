import java.awt.*;

public class Map {

    private String[][] map =
            {
                    {" ","X","X"," "," "," "," ","X","X","X"},
                    {"X","X"," "," "," "," "," ","X"," "," "},
                    {"X"," "," ","X","X"," "," ","X"," "," "},
                    {" "," ","X","X","X"," "," "," "," "," "},
                    {" "," ","X","X"," "," "," "," "," "," "},
                    {" "," ","X"," "," "," "," "," "," ","X"},
                    {" "," "," "," "," "," "," "," "," ","X"},
                    {" ","X","X","X"," "," "," "," "," ","X"},
                    {" "," "," "," ","X"," ","X"," "," ","X"},
                    {"X","X","X"," ","X"," ","X"," "," "," "},
            };

    private static int numOfBlocks = 10;
    private static int size = 500/numOfBlocks;

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
    }
}
