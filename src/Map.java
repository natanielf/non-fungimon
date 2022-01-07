public class Map {
	
	private Tile[][] map;

	public Map() {
		map = new Tile[53][28];
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				// set the type of ground (0 = floor, 1 = grass)
				map[r][c] = new Tile();
			}
		}
	}

	public Tile[][] getMap() {
		return map;
	}

	public void setMap(Tile[][] arr2D) {
		map = arr2D;
	}

}
