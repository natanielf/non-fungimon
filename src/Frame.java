import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
	private Fight fight;

	private boolean ctrlKeyPressed, readyToPaint, isFightMode;
	private JFrame f;
	private Timer t;
	private ImageIcon icon;

	public void paint(Graphics g) {
		if (readyToPaint) {
			super.paintComponent(g);
			paintBackground(g);
			paintMap(g);
			p.paint(g, p.getX(), p.getY(), tileSize, tileSpacer);
			panel.setFightMode(isFightMode);
			panel.paint(g);
			if (fight != null && panel.isFightMode()) {
				fight.paint(g, (int) f.getSize().getWidth() - panel.getWidth() - 15,
						(int) f.getSize().getHeight() - 35);
			}
		}
	}

	public Frame() {
		this.readyToPaint = false;
		String name = JOptionPane.showInputDialog(f, "Welcome to Non-Fungimon! Enter your player name below:");
		if (name == null || name.trim().equals(""))
			name = "Player 1";
		else
			name = name.trim();

		f = new JFrame("Non-Fungimon");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setMinimumSize(new Dimension(1280, 720));
		icon = new ImageIcon(getClass().getResource("./img/duck1.png"));
		f.setIconImage(icon.getImage());
		f.add(this);
		f.addKeyListener(this);
		f.setVisible(true);

		init(name);

		t = new Timer(16, this);
		t.start();
	}

	public static void main(String[] arg) {
		Frame frame = new Frame();
	}

	public void init(String name) {
		int frameWidth = (int) f.getSize().getWidth();
		int frameHeight = (int) f.getSize().getHeight();
		m = new Map(frameWidth, frameHeight);
		tileSize = m.getSize();
		tileSpacer = m.getSpacer();
		p = new Player(name, tileSize - 5);
		panel = new Panel(name, frameWidth, frameHeight, m.getPixelWidth());
		ctrlKeyPressed = false;
		isFightMode = false;
		readyToPaint = true;
		startFight();
	}

	public void startFight() {
		fight = new Fight(p, p);
		this.isFightMode = true;
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

	@Override
	public void keyPressed(KeyEvent e) {
		// key codes: 38 = up, 39 = right, 40 = down, 37 = left
		// 32 = space, 90 = Z, 88 = X, 67 = C, 86 = V
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
			break;
		case 90:
			System.out.println("Z");
			break;
		case 88:
			System.out.println("X");
			break;
		case 67:
			System.out.println("C");
			break;
		case 86:
			System.out.println("V");
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// quit game with CTRL+Q activation
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
