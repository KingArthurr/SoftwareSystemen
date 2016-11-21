package ss.project;

import java.awt.Point;
//import java.util.ArrayList;
//import java.util.List;
import java.util.Map;

public class SmartStrategy extends NaiveStrategy {
	
	private String name;

    public SmartStrategy() {
        this.name = "Smart";
    }

    public String getName() {
        return name;
    }
    
    public Map<Point, Tile> determineMove(Board board) {
    	//List<Point> empty = new ArrayList<Point>(board.getEmptyPoints());
		return null;
		
/*		if (validMoves.size() != 0) {
			return validMoves.get(random(validMoves.size()));
			// possible moves in dezelfde rij en aangrenzend
			// voorwaarde: geen rij van 5 en meerdere rijeen tegelijk aanleggen
			// meeste punten en snelle tijd?
		} else {
			// change complete deck
		}*/
	}

}
