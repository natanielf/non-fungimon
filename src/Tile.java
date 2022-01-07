public class Tile {

	// 0 = ground, 1 = moss, 2 = grass, 3 = rock
	private int type;
	private double chance;

	public Tile() {
		this.type = 0;
		this.chance = 0;
	}

	public Tile(int type, double chance) {
		this.type = type;
		this.chance = chance;
	}

	public int getType() {
		return type;
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