import javax.swing.*;
import java.awt.*;

public class Player {

	private int xPosition, yPosition;
	private ImageIcon overworldImage;

	public Player()	{
		xPosition = 5;
		yPosition = 5;
		overworldImage = new ImageIcon("resources/gold-right.png");
	}

	public void changeX(int change)	{
		if(Client.map.getEntityAt(xPosition+change, yPosition) == " ")
            xPosition += change;
	}

	public int getXPosition()	{
		return xPosition;
	}

	public void changeY(int change)	{
		if(Client.map.getEntityAt(xPosition, yPosition+change) == " ")
			yPosition += change;
	}

	public int getYPosition()	{
		return yPosition;
	}

	public Image getOverworldImage()	{
		return overworldImage.getImage();
	}
}
