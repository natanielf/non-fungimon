import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Fight {

	private Font font;
	private Player player, enemy;
	private String strZ, strA, strB, strC, strD, strE, strF;
	

	public Fight(Player a, Player b) {
		font = new Font("SANS_SERIF", Font.BOLD, 45);
		player = a;
		enemy = b;
		fightStr(b.getName()+" challenges you!", "", "", "", "", "", "");
		
	}
	
	public void pick() {
		
	}
	
	
	
	public void paint(Graphics g, int width, int height) {
		g.setColor(Color.white);
		g.setFont(font);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.darkGray);
		g.drawString("Get ready, " + player.getName() + "! It's time to fight!", 10, 50);
	}
	
	public void fightStr(String z, String a, String b, String c, String d, String e, String f) {
		strZ = z;
		strA = a;
		strB = b;
		strC = c;
		strD = d;
		strE = e;
		strF = f;
	}
	
	public String[] fightStr() {
		String[] strArr = {strZ, strA, strB, strC, strD, strE, strF};
		return strArr;
	}

}
