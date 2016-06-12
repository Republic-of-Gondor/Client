import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * The setup of this class can and probably should change going forward
 */
public class KeyMap extends JPanel {

	public KeyMap()	{
		this.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode())	{
					case KeyEvent.VK_LEFT: Client.player.changeX(-1); break;
					case KeyEvent.VK_UP: Client.player.changeY(-1); break;
					case KeyEvent.VK_RIGHT: Client.player.changeX(1); break;
					case KeyEvent.VK_DOWN: Client.player.changeY(1); break;
					case KeyEvent.VK_Z: Client.audioPlayer.playSound("pokemon-recovery"); break;
					case KeyEvent.VK_H: Client.conn.write();
				}
			}
		});
		this.setOpaque(false);
		this.setFocusable(true);
		this.requestFocus();
	}
}
