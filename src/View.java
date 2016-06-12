import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener	{

	PimpPanel panel;

	public View()	{
		JFrame frame = new JFrame("Pokémon");

		panel = new PimpPanel();
		panel.setPreferredSize(new Dimension(500, 500));

		frame.add(new KeyMap());
		frame.add(panel);

		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);

		Timer timer = new Timer((int) (1000 / 60), this);
		timer.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panel.repaint();
	}
}

class PimpPanel extends JPanel 	{

	public PimpPanel() {
		this.setBackground(new Color(0, 150, 0));
	}

	@Override
	protected void paintComponent(Graphics g)	{
		super.paintComponent(g);
		Player player = Client.player;
		g.drawImage(player.getOverworldImage(), player.getXPosition() * 20, player.getYPosition() * 20, null);
	}
}
