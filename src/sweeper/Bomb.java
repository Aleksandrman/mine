package sweeper;

	class Bomb {
		private Matrix bombMap;
		private int totalBombs;
	Bomb(int totalBombs){
		this.totalBombs = totalBombs;
		fixBombsCount();
	}
	void start() {
		bombMap = new Matrix(Box.zero);
		for(int j = 0; j < totalBombs; j++)
		placeBomp();
	}
	
	Box get (Coord coord) {
		return bombMap.get(coord);
	}
	
	private void fixBombsCount() {
		int maxBombs = Ranges.getSize().x * Ranges.getSize().y/2;
		if(totalBombs > maxBombs)
			totalBombs = maxBombs;
	}
	
	private void placeBomp() {
		while(true) {
		Coord coord = Ranges.getRandomCoord();
		if(Box.bomb == bombMap.get(coord))
			continue;
		bombMap.set(coord, Box.bomb);
		incNumbersAroundBomb(coord);
		break;
		}
		
		
	}
	private void incNumbersAroundBomb(Coord coord) {
		for(Coord around : Ranges.getCoordsAround(coord)) 
			if (Box.bomb != bombMap.get(around))
			bombMap.set(around, bombMap.get(around).getnextNumperBox()); // увеличивает цифру вокруг бомбы
	}
}
