import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class SwingDemo {
    public static void main(String[] args) {
		JFrame frame = new JFrame("SwingDemo, Bitches");

		PimpPanel panel = new PimpPanel();
		panel.setPreferredSize(new Dimension(500, 500));

		frame.getContentPane().add(panel);

		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
    }
}

class PimpPanel extends JPanel	{

	private ImageIcon character = new ImageIcon("resources/gold-right.png");
	private int x = 10, y = 10;

	public PimpPanel()	{
		this.setBackground(new Color(0, 150, 0));
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode())	{
					case 37: x--; break;
					case 38: y--; break;
					case 39: x++; break;
					case 40: y++; break;
				}
				repaint();
			}
		});
		this.setFocusable(true);
		this.requestFocus();
	}

	@Override
	protected void paintComponent(Graphics g)	{
		super.paintComponent(g);
		g.drawImage(character.getImage(), x * 20, y * 20, null);
	}
}

