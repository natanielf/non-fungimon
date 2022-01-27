import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class Fight {

	private Font font;
	private ArrayList<String> panelTxt;
	private Player player, enemy;
	private NFT pNFT, eNFT;
	

	public Fight(Player a, Player b) {
		font = new Font("SANS_SERIF", Font.BOLD, 45);
		player = a;
		enemy = b;
		panelTxt = new ArrayList<>();
		panelTxt.add(b.getName()+" challenges you!");
		
	}
	
	public void pick() {
		String[] NFTs = { "Pick you next NFT!", player.NFT(0).getName(), player.NFT(1).getName(),
				player.NFT(2).getName(), player.NFT(3).getName(), player.NFT(4).getName(), player.NFT(5).getName() };
		panelTxt(NFTs);
	}
	
	
	
	
	
	public void paint(Graphics g, int width, int height) {
		g.setColor(Color.white);
		g.setFont(font);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.darkGray);
		g.drawString("Get ready, " + player.getName() + "! It's time to fight!", 10, 50);
	}
	
	public void panelTxt(String[] str) {
		for(int i=0; i<panelTxt.size(); i++)
			panelTxt.remove(i);
		for(int i=0; i<str.length; i++)
			panelTxt.add(str[i]);
	}
	
	public ArrayList panelTxt() {
		return panelTxt;
	}

}
