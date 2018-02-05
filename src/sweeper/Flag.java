package sweeper;

class Flag {
private Matrix flagMap;

void start() {
	flagMap = new Matrix(Box.closed);
	
}
Box get (Coord coord) {
	return flagMap.get(coord);
}
void setOpenedToBox(Coord coord) {
	flagMap.set(coord, Box.opened);
	
}
public void setFlagToBox(Coord coord) {
	flagMap.set(coord, Box.flaged);
	
}
public void toggleFlagToBox(Coord coord) {
	switch(flagMap.get(coord)) {
	case flaged : setClosedToBox(coord);break;
	case closed : setFlagToBox(coord);break;
	}
	
}
private void setClosedToBox(Coord coord) {
	flagMap.set(coord, Box.closed);
	
}

}