import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Tile {

	// 0 = ground, 1 = moss, 2 = grass, 3 = rock, 4 = water
	private Image img;
	private boolean isSolid;
	private int chance;

	public Tile() {
		this.img = getImage("./img/grass.png");
		this.isSolid = false;
		this.chance = 0;
	}

	public Tile(int type) {
		switch (type) {
			case 0:
				this.img = getImage("./img/grass.png");
				this.isSolid = false;
				this.chance = (int) Math.random() * 100;
				break;
			case 1:
				this.img = getImage("./img/rock.png");
				this.isSolid = true;
				this.chance = 0;
				break;
		}
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean getIsSolid() {
		return isSolid;
	}

	public void setSolid(boolean isSolid) {
		this.isSolid = isSolid;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
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

}