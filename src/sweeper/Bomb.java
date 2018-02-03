package sweeper;

	class Bomb {
		private Matrix bombMap;
		private int totalBombs;
	Bomb(int totalBombs){
		this.totalBombs = totalBombs;
	}
	void start() {
		bombMap = new Matrix(Box.zero);
		for(int j = 0; j < totalBombs; j++)
		placeBomp();
	}
	
	Box get (Coord coord) {
		return bombMap.get(coord);
	}
	
	
	private void placeBomp() {
		Coord coord = Ranges.getRandomCoord();
		bombMap.set(coord, Box.bomb);
		
	}
	
}
