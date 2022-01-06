import java.util.ArrayList;

public class Player {

	private NFT[] myNFTs;
	private Item[] myItems;
	private int x, y; // location on the grid
	private int size;

	public Player() {
		this.myNFTs = new NFT[5];
		this.myNFTs[0] = new NFT();
		this.myItems = new Item[10];
		x = 0;
		y = 0;
	}

	public void up() {
		if (y > 0)
			y--;
		System.out.println(" X:Y - " + x + ":" + y);
	}

	public void right(int max) {
		if (x < max)
			x++;
		System.out.println(" X:Y - " + x + ":" + y);
	}

	public void down(int max) {
		if (y < max)
			y++;
		System.out.println(" X:Y - " + x + ":" + y);
	}

	public void left() {
		if (x > 0)
			x--;
		System.out.println(" X:Y - " + x + ":" + y);
	}

	public void updateLocation() {

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

}
