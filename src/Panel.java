import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Panel {

	private String name;
	private int x, y, width, height;
	private String[] instructions;
	private int progress;
	private Font font;

	public Panel(String name, int frameW, int frameH, int mapW) {
		this.name = name;
		this.x = mapW + 2;
		this.y = 0;
		this.width = frameW - mapW - (frameW / 100);
		this.height = frameH - (frameH / 28);
		this.instructions = populateInstructions();
		this.progress = 0;
		this.font = new Font("SANS_SERIF", Font.BOLD, 30);
	}

	public void paint(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(x, y, width, height);
		g.setColor(Color.black);
		g.setFont(font);
		g.drawString(instructions[progress], x + 5, y + 30);
		g.drawString("Press space to continue.", x + 5, height - 20);
	}

	public String[] populateInstructions() {
		String greeting = "Hello, " + name + "!";
		String welcome = "Welcome to Non-Fungimon!";
		return new String[] {
				greeting,
				welcome,
				"Try exploring the map!"
				};
	}

	public void incrementProgress() {
		if (progress < instructions.length - 1)
			progress++;
	}

}
