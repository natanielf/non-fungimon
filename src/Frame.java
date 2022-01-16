import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener {

	private Map m;
	private Player p;
	private int tileSize, tileSpacer;
	private Panel panel;

	private boolean ctrlKeyPressed;
	private JFrame f;
	private Timer t;
	private ImageIcon icon;

	public void paint(Graphics g) {
		super.paintComponent(g);
		paintBackground(g);
		paintMap(g);
		paintPlayer(g);
		panel.paint(g);
	}

	public Frame() {
		f = new JFrame("Non-Fungimon");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setMinimumSize(new Dimension(1280, 720));
		icon = new ImageIcon(getClass().getResource("./img/duck1.png"));
		f.setIconImage(icon.getImage());
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();

		f.setVisible(true);

		String name = JOptionPane.showInputDialog(f, "Welcome to Non-Fungimon! Enter your player name below:");
		if (name == null)
			name = "Player 1";

		init(name);
	}

	public static void main(String[] arg) {
		Frame frame = new Frame();
	}

	public void init(String name) {
		int frameWidth = (int) f.getSize().getWidth();
		int frameHeight = (int) f.getSize().getHeight();
		ctrlKeyPressed = false;
		p = new Player();
		m = new Map(frameWidth, frameHeight);
		tileSize = m.getSize();
		tileSpacer = m.getSpacer();
		panel = new Panel(name, frameWidth, frameHeight, m.getPixelWidth());
	}

	public void paintBackground(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, (int) f.getSize().getWidth(), (int) f.getSize().getHeight());
	}

	public void paintMap(Graphics g) {
		for (int r = 0; r < m.getMap().length; r++) {
			for (int c = 0; c < m.getMap()[0].length; c++) {
				g.drawImage(m.getMap()[r][c].getImg(), c * (tileSize + tileSpacer), r * (tileSize + tileSpacer), null);
			}
		}
	}

	public void paintPlayer(Graphics g) {
		int playerX = p.getX() * (tileSize + tileSpacer) + tileSpacer;
		int playerY = p.getY() * (tileSize + tileSpacer) + tileSpacer;
		g.setColor(Color.orange);
		g.fillOval(playerX, playerY, tileSize - 5, tileSize - 5);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// key codes: 38 = up, 39 = right, 40 = down, 37 = left
		switch (e.getKeyCode()) {
			case 38:
				p.up(m);
				break;
			case 39:
				p.right(m.getMap()[0].length - 1, m);
				break;
			case 40:
				p.down(m.getMap().length - 1, m);
				break;
			case 37:
				p.left(m);
				break;
			case 17:
				ctrlKeyPressed = true;
				break;
			case 32:
				panel.incrementProgress();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// quit with CTRL+Q activation
		if (e.getKeyCode() == 17)
			ctrlKeyPressed = false;

		if (e.getKeyCode() == 81 && ctrlKeyPressed)
			System.exit(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
