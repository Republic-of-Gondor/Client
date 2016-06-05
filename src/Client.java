import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Client {
	public static void main(String[] args) {
		JFrame frame = new JFrame("SwingDemo, Bitches");
		AudioPlayer player = new AudioPlayer();

		PimpPanel panel = new PimpPanel(player);
		panel.setPreferredSize(new Dimension(500, 500));

		frame.getContentPane().add(player.add(panel));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

		player.playSong("goldenrod-city");
	}
}

class PimpPanel extends JPanel 	{

	private ImageIcon character = new ImageIcon("resources/gold-right.png");
	private int x = 10, y = 10;
	private AudioPlayer player;

	public PimpPanel(AudioPlayer player) {
		this.player = player;
		this.setBackground(new Color(0, 150, 0));
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode())	{
					case KeyEvent.VK_LEFT: x--; break;
					case KeyEvent.VK_UP: y--; break;
					case KeyEvent.VK_RIGHT: x++; break;
					case KeyEvent.VK_DOWN: y++; break;
					case KeyEvent.VK_Z: player.playSound("pokemon-recovery"); break;
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

