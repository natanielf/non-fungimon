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
			System.out.println("up");
			p.move(0);
			break;
		case 39:
			System.out.println("right");
			p.move(1);
			break;
		case 40:
			System.out.println("down");
			p.move(2);
			break;
		case 37:
			System.out.println("left");
			p.move(3);
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
