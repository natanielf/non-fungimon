public class Tile {

	// 0 = ground, 1 = moss, 2 = grass, 3 = rock, 4 = water
	
	private String image;
	private boolean isSolid;
	private double chance;

	public Tile() {
		this.isSolid = false;
		this.chance = 0;
	}

	public Tile(int type, double chance) {
		this.isSolid = isSolid;
		this.chance = chance;
	}

	public boolean getIsSolid() {
		return isSolid;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getChance() {
		return chance;
	}

	public void setChance(double chance) {
		this.chance = chance;
	}
}