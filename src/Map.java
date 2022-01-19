public class Map {

	private Tile[][] map;
	private int size, spacer;
	private int pixelWidth, pixelHeight;

	public Map(int frameW, int frameH) {
		int w = frameW / 40;
		int h = frameH / 28;
		size = Math.min(w, h) - 2;
		spacer = 1;
		map = new Tile[28][40];

		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[r].length; c++) {
				map[r][c] = new Tile();
			}
		}
		this.pixelWidth = (size + spacer) * map[0].length;
		this.pixelHeight = (size + spacer) * map.length;
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

	public int getPixelWidth() {
		return pixelWidth;
	}

	public void setPixelWidth(int pixelWidth) {
		this.pixelWidth = pixelWidth;
	}

	public int getPixelHeight() {
		return pixelHeight;
	}

	public void setPixelHeight(int pixelHeight) {
		this.pixelHeight = pixelHeight;
	}

}
