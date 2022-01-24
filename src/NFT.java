import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class NFT {

	private String name, type, status;
	private int rarity, lvl, max, hp, evo;
	private boolean fainted;
	private Image img;

	public NFT(String name, String type, String status, int rarity, int lvl, int max, int hp, int evo, boolean fainted, Image img) {
		this.name = name;
		this.type = type;
		this.status = status;
		this.rarity = rarity;
		this.lvl = lvl;
		this.max = max;
		this.hp = hp;
		this.fainted = fainted;
		this.img = img;
		
	}
	
	public NFT() {
		name = "The Grey Duck";
		status = "";
		rarity = 1;
		lvl = 1;
		hp = 10;
		type = "none";
		evo = 0;
		img = getImage("./img/duck1.png");
	}
	
	public void hit (Ability a) {
		int dmg;
		
		if(status == "immune")
			status = "";
		else
			status = a.getEffect();
		
		if(type == "rock" && a.getType() == "paper")
			dmg = a.getDmg() + a.getDmg()/5;
		else if(type == "rock" && a.getType() == "scissors")
			dmg = a.getDmg() - a.getDmg()/5;
		else if(type == "paper" && a.getType() == "scissors")
			dmg = a.getDmg() + a.getDmg()/5;
		else if(type == "paper" && a.getType() == "rock")
			dmg = a.getDmg() - a.getDmg()/5;
		else if(type == "scissor" && a.getType() == "rock")
			dmg = a.getDmg() + a.getDmg()/5;
		else if(type == "scissor" && a.getType() == "paper")
			dmg = a.getDmg() - a.getDmg()/5;
		else
			dmg = a.getDmg();
		
		if(hp > dmg)
			hp -= dmg;
		else
			hp = 0;
			//faint();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public boolean getFainted() {
		return fainted;
	}
	
	public void setFainted(boolean fainted) {
		this.fainted = fainted;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = NFT.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

//	public void paint(Graphics g) {
//		g.drawImage(img, x, y, null);
//	}

}
