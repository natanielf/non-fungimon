import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class NFT {

	private String name, status;
	private int rarity, lvl, max, hp, type, evo;
	private Image img;

	public NFT(String name, String status, int rarity, int lvl, int max, int hp, int type, int evo, Image img) {
		this.name = name;
		this.status = status;
		this.rarity = rarity;
		this.lvl = lvl;
		this.max = max;
		this.hp = hp;
		this.type = type;
		this.img = img;
		
	}
	
	public NFT() {
		name = "The Grey Duck";
		status = "";
		rarity = 1;
		lvl = 1;
		hp = 10;
		type = 0;
		evo = 0;
		img = getImage("./img/duck1.png");
	}
	
	public void hit (Ability a) {
		status = a.getEffect();
		if(this.type == 1) {

		}
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
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
