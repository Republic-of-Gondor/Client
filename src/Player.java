import javax.swing.*;
import java.awt.*;

public class Player {

	private int xPosition, yPosition;
	private ImageIcon overworldImage;

	public Player()	{
		xPosition = 10;
		yPosition = 10;
		overworldImage = new ImageIcon("resources/gold-right.png");
	}

	public void changeX(int change)	{
		xPosition += change;
	}

	public int getXPosition()	{
		return xPosition;
	}

	public void changeY(int change)	{
		yPosition += change;
	}

	public int getYPosition()	{
		return yPosition;
	}

	public Image getOverworldImage()	{
		return overworldImage.getImage();
	}
}
