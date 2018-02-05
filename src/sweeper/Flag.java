package sweeper;

class Flag {
private Matrix flagMap;
private int countOfClosedBoxes;

void start() {
	flagMap = new Matrix(Box.closed);
	countOfClosedBoxes = Ranges.getSize().x*Ranges.getSize().y;
	
}
Box get (Coord coord) {
	return flagMap.get(coord);
}
void setOpenedToBox(Coord coord) {
	flagMap.set(coord, Box.opened);
	countOfClosedBoxes--;
	
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
int getCountofClosedBoxes() {
	return countOfClosedBoxes;
}
 void setBombedToBox(Coord coord) {
	flagMap.set(coord, Box.bombed);
	
}
void setOpenedToClosedBombBox(Coord coord) {
	if(flagMap.get(coord) == Box.closed)
		flagMap.set(coord, Box.opened);
	
}
void setNoBombToFlagedSafeBox(Coord coord) {
	if(flagMap.get(coord) == Box.flaged)
		flagMap.set(coord, Box.nobomb);
	
}

}