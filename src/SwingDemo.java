import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.lang.management.ManagementFactory;

public class SwingDemo {
	static MusicPlayer player; //Avoiding garbage collection

    public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame("SwingDemo, Bitches");
		player = new MusicPlayer();

		PimpPanel panel = new PimpPanel();
		panel.setPreferredSize(new Dimension(500, 500));

		frame.getContentPane().add(player.add(panel));

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);

		player.start();
		//Thread.sleep(5000);
		//player.stop();
		//Thread.sleep(5000);
		//player.start();
    }
}

class MusicPlayer extends JFXPanel	{

	MediaPlayer player;
	MediaPlayer interruptPlayer; //Declared up here to avoid potential garbage collection

	public MusicPlayer()	{
		File file = new File("resources/goldenrod-city.mp3");
		Media song = new Media(file.toURI().toString());
		player = new MediaPlayer(song);
	}

	public void start()	{
		player.play();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {}
		System.out.println(player.getCurrentTime());
	}

	public void interrupt()	{
		System.out.println("Thread count: " + ManagementFactory.getThreadMXBean().getThreadCount());
		player.pause();

		File file = new File("resources/pokemon-recovery.mp3");
		Media interruption = new Media(file.toURI().toString());
		if(interruptPlayer != null) interruptPlayer.dispose();
		interruptPlayer = new MediaPlayer(interruption);
		interruptPlayer.play();
		interruptPlayer.setOnEndOfMedia(new Runnable() {
			public void run()	{
				player.play();
			}
		});
		//if (interruptPlayer.getStatus().toString())	{
		System.out.println(interruptPlayer.getStatus().toString());
		System.out.println(player.getStatus().toString());
		//}
		System.out.println("Balls");
	}

	public void stop()	{
		player.stop();
	}

}

class PimpPanel extends JPanel 	{

	private ImageIcon character = new ImageIcon("resources/gold-right.png");
	private int x = 10, y = 10;


	public PimpPanel() throws Exception	{
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
					case KeyEvent.VK_Z: SwingDemo.player.interrupt(); break;
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

