public class Player {

	private NFT[] myNFTs;
	private Item[] myItems;
	private int x, y; // location on the grid
	private int size; // size of the player

	public Player() {
		this.myNFTs = new NFT[5];
		this.myNFTs[0] = new NFT();
		this.myItems = new Item[10];
		x = 0;
		y = 0;
	}

	public void up(Map m) {
		if (y > 0 && m.getMap()[this.y - 1][this.x].getIsSolid() < 3)
			y--;
	}

	public void right(int max, Map m) {
		if (x < max && m.getMap()[this.y][this.x + 1].getIsSolid() < 3)
			x++;
	}

	public void down(int max, Map m) {
		if (y < max && m.getMap()[this.y + 1][this.x].getIsSolid() < 3)
			y++;
	}

	public void left(Map m) {
		if (x > 0 && m.getMap()[this.y][this.x - 1].getIsSolid() < 3)
			x--;
	}

	public void printLocation() {
		System.out.println(" X:Y - " + x + ":" + y);
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
