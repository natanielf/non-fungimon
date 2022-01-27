import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

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
		this.width = frameW - mapW;
		this.height = frameH;
		this.instructions = populateInstructions();
		this.progress = 0;
		this.isFightMode = false;
		this.font = new Font("SANS_SERIF", Font.BOLD, 30);
	}

	public void paint(Graphics g, ArrayList<String> panelTxt) {
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.setFont(font);
		if (!isFightMode) {
			g.drawString(instructions[progress], x + 8, y + 35);
			g.drawString("Press space to continue.", x + 8, height - (font.getSize() * 2));
		} else {
			paintFightInstructions(g, panelTxt);
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

	private void paintFightInstructions(Graphics g, ArrayList<String> panelTxt) {
		g.drawString("You're in a fight!", x + 8, y + 30);
		g.drawString("Decide your next move:", x + 8, y + 60);
		g.setFont(new Font("SANS_SERIF", Font.BOLD, 25));
		for (int i = 0; i < panelTxt.size(); i++) {
			g.drawString(panelTxt.get(i), x + 8, y + 100 + (i * 20));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFightMode() {
		return isFightMode;
	}

	public void setFightMode(boolean isFightMode) {
		this.isFightMode = isFightMode;
	}

}
