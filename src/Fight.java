import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Fight {

	private Font font;
	private Player player, enemy;

	public Fight(Player a, Player b) {
		font = new Font("SANS_SERIF", Font.BOLD, 45);
		player = a;
		enemy = b;
	}

	public void paint(Graphics g, int width, int height) {
		g.setColor(Color.white);
		g.setFont(font);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.darkGray);
		g.drawString("Get ready, " + player.getName() + "! It's time to fight!", 10, 50);
	}

}
