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

	Tile b;
	Player p;

	boolean ctrlKeyPressed;
	JFrame f;
	Timer t;

	public void paint(Graphics g) {
		super.paintComponent(g);
	}

	public Frame() {
		f = new JFrame("Non-Fungimon");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.add(this);
		f.addKeyListener(this);
		t = new Timer(16, this);
		t.start();
		f.setVisible(true);

		ctrlKeyPressed = false;

		b = new Tile();
		p = new Player();
	}

	public static void main(String[] arg) {
		Frame frame = new Frame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// key codes: 38 = up, 39 = right, 40 = down, 37 = left
		switch (e.getKeyCode()) {
		case 38:
			p.up();
			break;
		case 39:
			p.right();
			break;
		case 40:
			p.down();
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
