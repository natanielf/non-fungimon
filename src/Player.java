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

	public void up() {
		if (y > 0)
			y--;
		System.out.println(" X:Y - " + x + ":" + y);
	}
	
	public void right() {
		if (x < 30)
			x++;
		System.out.println(" X:Y - " + x + ":" + y);
	}
	
	public void down() {
		if (y < 20)
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

}
