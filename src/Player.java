import java.util.ArrayList;

public class Player {

	private NFT[] myNFTs;
	private Item[] myItems;
	private int x, y; // location on the grid

	public Player() {
		this.myNFTs = new NFT[10];
		this.myItems = new Item[5];
		x = 0;
		y = 0;
	}

	public Player(NFT[] myNFTs, Item[] myItems) {
		this.myNFTs = myNFTs;
		this.myItems = myItems;
	}

	public void move(int dir) {
		// 0 = up, 1 = right, 2 = down, 3 = left
		if (dir == 0) {
			if (y > 0)
				y--;
		} else if (dir == 1) {
			if (x < 30)
				x++;
		} else if (dir == 2) {
			if (y < 20)
				y++;
		} else if (dir == 3) {
			if (x > 0)
				x--;
		}
		updateLocation();
	}
	
	public void updateLocation() {
		
	}

}
