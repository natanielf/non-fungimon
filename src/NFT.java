import javax.swing.ImageIcon;

public class NFT {

	private String name;
	private int rarity, level, health;
	private boolean evo, isPoisoned, isStunned;
	private ImageIcon img;

	public NFT(String name, int rarity, int level, int health, boolean evo, boolean isPoisoned, boolean isStunned,
			ImageIcon img) {
		this.name = name;
		this.rarity = rarity;
		this.level = level;
		this.health = health;
		this.evo = evo;
		this.isPoisoned = isPoisoned;
		this.isStunned = isStunned;
		this.img = img;
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
		this.img = new ImageIcon("img/duck1.png");
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

	public ImageIcon getImg() {
		return img;
	}

	public void setImg(ImageIcon img) {
		this.img = img;
	}

}
