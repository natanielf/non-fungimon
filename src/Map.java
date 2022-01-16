public class Map {

	private Tile[][] map;
	private int size, spacer;

	// default map for 1920x1080 screen
	public Map() {
		size = 35;
		spacer = 1;
		map = new Tile[28][53];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = generateRandomTile();
			}
		}
	}

	// map adjusts to frame size
	public Map(int frameW, int frameH) {
		int width = frameW / 50;
		int height = frameH / 28;
		size = Math.min(width, height) - 2;
		spacer = 1;
		map = new Tile[28][50];

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				switch (r) {
					case 0:
						map[r][c] = new Tile();
						break;
					case 27:
						map[r][c] = new Tile();
						break;
					default:
						map[r][c] = generateRandomTile();
						break;
				}

			}
		}
	}

	public Tile generateRandomTile() {
		int rand = (int) (Math.random() * 100);
		int type;
		// 0 = ground, 1 = moss, 2 = grass, 3 = rock, 4 = water
		if (rand < 40)
			type = 0;
		else if (rand < 60)
			type = 1;
		else if (rand < 80)
			type = 2;
		else if (rand < 90)
			type = 3;
		else
			type = 4;
		double chance = 0.0;
		return new Tile(type, chance);
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] arr2D) {
		map = arr2D;
	}

	public int getWidth() {
		return map[0].length;
	}

	public int getHeight() {
		return map.length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpacer() {
		return spacer;
	}

	public void setSpacer(int spacer) {
		this.spacer = spacer;
	}

}
