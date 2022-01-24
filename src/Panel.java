import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Panel {

	private String name;
	private int x, y, width, height;
	private String[] instructions;
	private int progress;
	private boolean isFightMode;
	private Font font;

	public Panel(String name, int frameW, int frameH, int mapW) {
		this.name = name;
		this.x = mapW + 2;
		this.y = 0;
		this.width = frameW - mapW - (frameW / 100);
		this.height = frameH - (frameH / 28);
		this.instructions = populateInstructions();
		this.progress = 0;
		this.isFightMode = false;
		this.font = new Font("SANS_SERIF", Font.BOLD, 30);
	}

	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.setFont(font);
		if (!isFightMode) {
			g.drawString(instructions[progress], x + 8, y + 35);
			g.drawString("Press space to continue.", x + 8, height - 20);
		} else {
			paintFightInstructions(g);
		}
	}

	public String[] populateInstructions() {
		String greeting = "Hello, " + name + "!";
		String welcome = "Welcome to Non-Fungimon!";
		return new String[] {
				greeting,
				welcome,
				"Use the arrow keys to move.",
				"Try exploring the map!"
		};
	}

	public void incrementProgress() {
		if (progress < instructions.length - 1)
			progress++;
	}

	private void paintFightInstructions(Graphics g) {
		g.drawString("You're in a fight!", x + 8, y + 30);
		g.drawString("Decide your next move:", x + 8, y + 60);
		g.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
		g.drawString("Z - Fight", x + 8, y + 100);
		g.drawString("X - Cloud", x + 8, y + 130);
		g.drawString("C - Blockchain", x + 8, y + 160);
		g.drawString("V - Log out", x + 8, y + 190);
	}

	public boolean isFightMode() {
		return isFightMode;
	}

	public void setFightMode(boolean isFightMode) {
		this.isFightMode = isFightMode;
	}

}
