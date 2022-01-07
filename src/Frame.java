import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements KeyListener, ActionListener {

	private Map m;
	private Player p;
	private int tileSize, tileSpacer;
	private int walkX = 0;
	private int walkY = 0;

	private boolean ctrlKeyPressed;
	private JFrame f;
	private Timer t;

	public void paint(Graphics g) {
		super.paintComponent(g);
		paintGrid(g);
		paintPlayer(g);
		paintNFT(g);
	}

	public Frame() {
		f = new JFrame("Non-Fungimon");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); // maximize window
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);

		ctrlKeyPressed = false;
		p = new Player();
		tileSize = 35;
		tileSpacer = 1;
		m = new Map();
	}

	public static void main(String[] arg) {
		Frame frame = new Frame();
	}

	public void paintGrid(Graphics g) {
		for (int r = 0; r < m.getMap().length; r++) {
			for (int c = 0; c < m.getMap()[0].length; c++) {
				switch (m.getMap()[r][c].getType()) {
				case 0:
					g.setColor(Color.black);
					break;
				case 1:
					g.setColor(Color.green);
					break;
				}
				g.fillRect(r * (tileSize + tileSpacer), c * (tileSize + tileSpacer), tileSize, tileSize);
			}
		}
	}

	public void paintPlayer(Graphics g) {
		p.setX(p.getX() + walkX);
		p.setY(p.getY() + walkY);
		int playerX = p.getX() * (tileSize + tileSpacer) + tileSpacer;
		int playerY = p.getY() * (tileSize + tileSpacer) + tileSpacer;
		g.setColor(Color.pink);
		g.fillOval(playerX, playerY, tileSize - 5, tileSize - 5);
	}

	public void paintNFT(Graphics g) {
		NFT myNFT = p.getMyNFTs()[0];
		myNFT.setX(p.getX() * (tileSize + tileSpacer) + tileSpacer);
		myNFT.setY(p.getY() * (tileSize + tileSpacer) + tileSpacer);
		myNFT.paint(g);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// key codes: 38 = up, 39 = right, 40 = down, 37 = left
		switch (e.getKeyCode()) {
		case 38:
			p.up();
			break;
		case 39:
			p.right(m.getMap().length - 1);
			break;
		case 40:
			p.down(m.getMap()[0].length - 1);
			break;
		case 37:
			p.left();
			break;
		case 17:
			ctrlKeyPressed = true;
			break;
		default:
			System.out.println("other: " + e.getKeyCode());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Quit with CTRL+Q activation
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
