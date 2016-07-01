import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Map {

	private static int numOfBlocks = 9;
	private static double scaling = 1.0;
	public static int tileSize = (int) (32 * scaling);
	public final static int viewSize = tileSize * numOfBlocks;
	private BufferedImage tileset;
	private char[][] map;

	public Map()    {
		try {
			map = readMap("newbarktown");
			tileset = ImageIO.read(new File("resources/tilesets/Newbarktown.png"));
			tileset = scaleImage(tileset, scaling);
		} catch (IOException e) {
			System.err.println("Yo dawg, couldn't find the file.");
		}
	}

	public char getEntityAt(int x, int y) {
		try {
			return map[y][x];
		} catch (IndexOutOfBoundsException e) { //TODO: Probably not the most efficient way of doing this...lol
			return 'O';
		}
	}


	public void drawMap(Graphics g, int centerX, int centerY) {
		for(int y = 0; y < numOfBlocks; y++) {
			g.drawLine(0, y * tileSize, viewSize, y * tileSize);
		}

		for(int x = 0; x < numOfBlocks; x++) {
			g.drawLine(x* tileSize, 0, x * tileSize, viewSize);
		}

		g.setFont(new Font(null, 0, tileSize));
		for(int x = 0; x < numOfBlocks; x++) {
			for(int y = 0; y < numOfBlocks; y++) {
				g.drawString("" + getEntityAt(x + (centerX - (numOfBlocks/2)), y + (centerY - (numOfBlocks/2))), x * tileSize, y * tileSize + tileSize);
			}
		}

		for(int x = 0; x < numOfBlocks; x++) {
			for(int y = 0; y < numOfBlocks; y++) {
				char entity = getEntityAt(x + (centerX - (numOfBlocks / 2)), y + (centerY - (numOfBlocks / 2)));
				BufferedImage tile = null;
				switch (entity)	{
					case 'T': tile = tileset.getSubimage(0, 0, tileSize, tileSize); break;
					case 't': tile = tileset.getSubimage(2 * tileSize, 4 * tileSize, tileSize, tileSize); break;
					case 'R': tile = tileset.getSubimage(1 * tileSize, 149 * tileSize, tileSize, tileSize); break;
					case 'S': tile = tileset.getSubimage(4 * tileSize, 2 * tileSize, tileSize, tileSize); break;
					case 'B': tile = tileset.getSubimage(4 * tileSize, 6 * tileSize, tileSize, tileSize); break;
					case 'D': tile = tileset.getSubimage(4 * tileSize, 7 * tileSize, tileSize, tileSize); break;
					case 'W': tile = tileset.getSubimage(3 * tileSize, 14 * tileSize, tileSize, tileSize); break;
					default: tile = tileset.getSubimage(0, 6 * tileSize, tileSize, tileSize);
				}
				if (tile != null)  {
					g.drawImage(tile.getSubimage(0, 0, tileSize, tileSize), x * tileSize, y * tileSize, null);
				}
			}
		}
	}

	private char[][] readMap(String filename) throws IOException	{
		Scanner scan = new Scanner(new File("resources/maps/" + filename + ".txt"));

		int mapWidth = scan.nextInt();
		int mapHeight = scan.nextInt();
		scan.nextLine();

		char[][] map = new char[mapHeight][mapWidth];

		for (int y = 0; y < mapHeight; y++) {
			String row = scan.nextLine();
			for (int x = 0; x < mapWidth; x++) {
				map[y][x] = row.charAt(x * 2); //Skip 2 because there is a space between characters
			}
		}
		return map;
	}

	private BufferedImage scaleImage(BufferedImage img, double scale)	{

		System.out.println(img.getRaster());
		BufferedImage after = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(scale, scale);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		after = scaleOp.filter(img, after);

		System.out.println(after.getRaster());

		return after;
	}


}
