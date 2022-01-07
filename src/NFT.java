import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class NFT {

	private String name;
	private int rarity, level, health;
	private boolean evo, isPoisoned, isStunned;
	private Image img;
	private int x, y;

	public NFT(String name, int rarity, int level, int health, boolean evo, boolean isPoisoned, boolean isStunned,
			Image img, int x, int y) {
		this.name = name;
		this.rarity = rarity;
		this.level = level;
		this.health = health;
		this.evo = evo;
		this.isPoisoned = isPoisoned;
		this.isStunned = isStunned;
		this.img = img;
		this.x = x;
		this.y = y;
	}

	// default NFT that every player starts with
	public NFT() {
		this.name = "The Grey Duck";
		this.rarity = 1;
		this.level = 1;
		this.health = 10;
		this.evo = false;
		this.isPoisoned = false;
		this.isStunned = false;
		this.img = getImage("/img/duck1.png");
		this.x = 0;
		this.y = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRarity() {
		return rarity;
	}

	public void setRarity(int rarity) {
		this.rarity = rarity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public boolean isEvo() {
		return evo;
	}

	public void setEvo(boolean evo) {
		this.evo = evo;
	}

	public boolean isPoisoned() {
		return isPoisoned;
	}

	public void setPoisoned(boolean isPoisoned) {
		this.isPoisoned = isPoisoned;
	}

	public boolean isStunned() {
		return isStunned;
	}

	public void setStunned(boolean isStunned) {
		this.isStunned = isStunned;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
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

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, x, y, null);
	}

}
