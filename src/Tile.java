import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Tile {

	// 0 = ground, 1 = moss, 2 = grass, 3 = rock, 4 = water
	private Image img;
	private boolean isSolid;
	private double chance;

	public Tile() {
		this.img = getImage("./img/grass.png");
		this.isSolid = false;
		this.chance = 0;
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

	public double getChance() {
		return chance;
	}

	public void setChance(double chance) {
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