package ss.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Deck {
	//Aantal Tiles
	 public static final int SIZE = 108;

	   	//Lijst van Tiles
	    private ArrayList<Tile> tiles;
	    
	    //Create deck, elke tile 3 keer
	    public Deck() {
	        tiles = new ArrayList<>(SIZE);

	        for (Tile.Shape s : Tile.Shape.values()) {
	            for (Tile.Color c : Tile.Color.values()) {
	                for (int i = 0; i < 3; i++) {
	                    tiles.add(new Tile(s, c));
	                }
	            }
	        }
	    }
	    
	  //Aantal Tiles over in deck
	    public int Tilesremaining() {
	        return tiles.size();
	    }
	    
	    public ArrayList<Tile> getDeck() {
	    	return tiles;
	    }
	    
	    //Schud Deck
	    public void Shuffle() {
	    	Collections.shuffle(tiles);
	    }
	    
	    //Krijg Hand
	    public Set<Tile> drawHand() {
	    	Shuffle();
	    	Set<Tile> hand = new HashSet<Tile>();
	        for (int i = 0; i < 6; i++) {
	            hand.add(drawTile());
	        }
	        return hand;
	    }
	    
	    //Krijg de bovenste Tile en verwijder deze
	    public Tile drawTile() {
	    	Shuffle();
	    	Tile t = tiles.get(0);
	    	tiles.remove(0);
	    	return t;
	    }
	    
	    //Wissel Tile
	    public Set<Tile> changeTile(Set<Tile> hand) {
	    	Set<Tile> output = new HashSet<Tile>();
	    	List<Tile> input = new ArrayList<Tile>(hand);
	    	for (int i = 0; i < input.size(); i++) {	
	    		tiles.add(new Tile(input.get(i).getShape(), input.get(i).getColor()));
	    		output.add(drawTile());
	    	}
	    	return output;    	
	    }
	    
	    public void reset() {
	    	tiles.clear();
	    }


}