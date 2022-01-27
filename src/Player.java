import java.awt.Color;
import java.awt.Graphics;

public class Player {

	private String name;
	private NFT[] myNFTs;
	private Item[] myItems;
	private int x, y; // location on the grid
	private int size; // size of the player
	private boolean isLocked; // lock/unlock movement

	public Player(String name, int size) {
		this.name = name;
		this.myNFTs = new NFT[6];
		this.myNFTs[0] = new NFT();
		this.myItems = new Item[10];
		this.x = 0;
		this.y = 0;
		this.size = size;
		this.isLocked = false;
	}

	public void up(Map m) {
		if (y > 0 && !m.getMap()[this.y - 1][this.x].getIsSolid() && !isLocked)
			y--;
	}

	public void right(int max, Map m) {
		if (x < max && !m.getMap()[this.y][this.x + 1].getIsSolid() && !isLocked)
			x++;
	}

	public void down(int max, Map m) {
		if (y < max && !m.getMap()[this.y + 1][this.x].getIsSolid() && !isLocked)
			y++;
	}

	public void left(Map m) {
		if (x > 0 && !m.getMap()[this.y][this.x - 1].getIsSolid() && !isLocked)
			x--;
	}

	public void printLocation() {
		System.out.println(" X:Y - " + x + ":" + y);
	}

	public void paint(Graphics g, int x, int y, int tileSize, int tileSpacer) {
		int playerX = x * (tileSize + tileSpacer) + tileSpacer;
		int playerY = y * (tileSize + tileSpacer) + tileSpacer;
		g.setColor(Color.orange);
		g.fillOval(playerX, playerY, tileSize - 5, tileSize - 5);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NFT[] getMyNFTs() {
		return myNFTs;
	}

	public void setMyNFTs(NFT[] myNFTs) {
		this.myNFTs = myNFTs;
	}

	public Item[] getMyItems() {
		return myItems;
	}

	public void setMyItems(Item[] myItems) {
		this.myItems = myItems;
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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	public NFT NFT(int n) {
		return myNFTs[n];
	}

}
