package ss.project;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Board {

	public Map<Point, Tile> map;
	public Map<Point, Tile> lastSetField;
 
	public Board() {
		map = new HashMap<>();
	}

	public boolean validMove(Map<Point, Tile> choice) {
		int j = 0;
		List<Point> choiceP = new ArrayList<Point>(choice.keySet());
		Map<Point, Tile> map2 = new HashMap<>();
		map2.clear();
		map2 = map;
		for (int i = 0; i < choice.size(); i++) {
			System.out.println("Round:"+i+" j:"+j);
			if (map2.isEmpty()) {
				map2.put(choiceP.get(i), choice.get(i));
				j++;
			}
			if (!map.containsKey(choiceP.get(i)) && hasAdjacent(map2, choiceP.get(i))){
				System.out.println("j1");
				if (fitsRoworColor(choiceP.get(i), choice.get(i))) {
					if(isSameShapeorColor(choice.get(i), choice.get(i--))) {
						map2.put(choiceP.get(i), choice.get(i));
						System.out.println("j");
						j++;
					}
				}
			}
		}
		return (j == choice.size());
	}
	
	public boolean hasAdjacent(Map<Point, Tile> map3, Point point) {
		boolean output = false;
		if (map3.containsKey(new Point(point.x, point.y +1))) {
			output = true;
		}
		if (map3.containsKey(new Point(point.x +1, point.y))) {
			output = true;
		}
		if (map3.containsKey(new Point(point.x, point.y -1))) {
			output = true;
		}
		if (map3.containsKey(new Point(point.x -1, point.y))) {
			output = true;
		}
		return output;
	}
	
	private boolean isSameShapeorColor(Tile choice, Tile previous) {
		if (choice.getColor() == previous.getColor()) {
			return true;
		}
		if (choice.getShape() == previous.getShape()) {
			return true;
		}
		return false;
	}
	
	private boolean fitsRoworColor(Point choiceP, Tile choiceT) {
		int i = 0;
		List<Integer> adjacent = new ArrayList<Integer>(getAdjacent(choiceP));
		for (int j = 0; j < adjacent.size(); j++) {
			List<Tile> roworcolom = new ArrayList<Tile>(makeRoworColom(choiceP, adjacent.get(j)));
			int k = 0;
			for(int l = 0; l < roworcolom.size(); l++) {
				if(isSameShapeorColor(choiceT, roworcolom.get(l)) && choiceT.toString() != roworcolom.get(l).toString()){
					k++;
				}
			}
			if (k == roworcolom.size()){
				i++;
			}
		}
		return (i == adjacent.size());
		
	}
	
	public Set<Integer> getAdjacent(Point point) {
		Set<Integer> adjacent = new HashSet<Integer>();
		if (map.containsKey(new Point(point.x, point.y + 1))){
			adjacent.add(1);
		}
		if (map.containsKey(new Point(point.x + 1, point.y))){
			adjacent.add(2);
		}
		if (map.containsKey(new Point(point.x, point.y - 1))){
			adjacent.add(3);
		}
		if (map.containsKey(new Point(point.x - 1, point.y))){
			adjacent.add(4);
		}
		return adjacent;
		
	}
	
	private List<Tile> makeRoworColom(Point point, int dir) {
		List<Tile> roworcolom = new ArrayList<Tile>();
		switch (dir) {
		case 1:
			for (int i = 0; map.containsKey(new Point(point.x, point.y+i)); i++) {
				roworcolom.add(map.get(new Point(point.x, point.y+i)));			
			}
			break;
		case 2:
			for (int i = 0; map.containsKey(new Point(point.x+i, point.y)); i++) {
				roworcolom.add(map.get(new Point(point.x+i, point.y)));			
			}
			break;
		case 3:
			for (int i = 0; map.containsKey(new Point(point.x, point.y-i)); i++) {
				roworcolom.add(map.get(new Point(point.x, point.y-i)));			
			}
			break;
		case 4:
			for (int i = 0; map.containsKey(new Point(point.x+i, point.y)); i++) {
				roworcolom.add(map.get(new Point(point.x+i, point.y)));			
			}
			break;
		}
		return roworcolom;
	}
	
	public List<Point> getEmptyPoints() {
		Map<Point, Tile> boardmap = getMap();
		List<Point> takenpoints = new ArrayList<Point>(boardmap.keySet());
		List<Point> openpoints = new ArrayList<Point>();
		for (int i = 0; i <= takenpoints.size(); i++) {
			Point p1 = new Point((takenpoints.get(i).x)++, takenpoints.get(i).y);
			Point p2 = new Point((takenpoints.get(i).x)--, takenpoints.get(i).y);
			Point p3 = new Point(takenpoints.get(i).x, (takenpoints.get(i).y)++);
			Point p4 = new Point(takenpoints.get(i).x, (takenpoints.get(i).y)--);
			if (!map.containsKey(p1)) {
				openpoints.add(p1);
			}
			if (!map.containsKey(p2)) {
				openpoints.add(p2);
			}
			if (!map.containsKey(p3)) {
				openpoints.add(p3);
			}
			if (!map.containsKey(p4)) {
				openpoints.add(p4);
			}
		}
        for (int j = 1; j < openpoints.size(); j++) {
            Point a1 = openpoints.get(j);
            Point a2 = openpoints.get(j-1);
            if (a1.equals(a2)) {
            	openpoints.remove(a1);
            }
        }
		return openpoints;
	}		
		
	public Tile getField(Point p) {
		return map.get(p);
	}

	public void setField(Map<Point, Tile> choice) {
		int i;
		List<Point> points = new ArrayList<Point>(choice.keySet());
		if (validMove(choice)) {
			for (i=0; i< choice.size(); i++) {
				if (map.isEmpty() == true) {
					map.put(new Point(0,0), choice.get(i));
					System.out.println("Tile placed");
				}
				else {
					map.put(points.get(i), choice.get(i));
					System.out.println("Tile placed");
				}
			}
		} else {
			System.out.println("No valid move");
		}
	}
	
	public void setLastSetField(Map<Point, Tile> setField) {
		lastSetField.clear();
		List<Point> points = new ArrayList<Point>(setField.keySet());
		for (int i = 0; i < setField.size(); i++) {
			lastSetField.put(points.get(i), setField.get(i));
		}
	}
	
	public Map<Point, Tile> getLastSetField() {
		return lastSetField;
	}

	public void reset() {
		map.clear();
	}

	public Map<Point, Tile> getMap() {
		return map;
	}
	
	public int getScore(Map<Point, Tile> move) {
		int score = move.size();
		List<Integer> adjacent = new ArrayList<Integer>();
		List<Point> movePoints = new ArrayList<Point>(move.keySet());
		List<Tile> roworcolom = new ArrayList<Tile>();
		for (int i = 0; i < movePoints.size(); i++) {
			if (hasAdjacent(map, movePoints.get(i))) {
				adjacent.clear();
				adjacent.addAll(getAdjacent(movePoints.get(i)));
			}
			for (int j = 0; j < adjacent.size(); j++) {
				roworcolom.clear();
				roworcolom.addAll(makeRoworColom(movePoints.get(i), adjacent.get(j)));
				score += roworcolom.size() + 1;
				if (roworcolom.size() + 1 == 6) {
					score += 6;
				}
			}
		}
		return score;
	}
	
	
}