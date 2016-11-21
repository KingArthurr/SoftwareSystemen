package ss.project;

import ss.project.Board;
import ss.project.Tile;
import ss.project.Tile.Color;
import ss.project.Tile.Shape;

import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// Player class for qwirkle

public class HumanPlayer extends Player {


    // -- Constructors -----------------------------------------------

    /*@
       requires name != null;
       requires Tiles == Tiles.XX || Tiles== Tiles.OO;
       ensures this.getName() == name;
       ensures this.getDeck() == Tiles;
     */
    
    // create new player object
    
    public HumanPlayer(String name, Set<Tile> hand) {
        super(name, hand);
    }

    // -- Queries ----------------------------------------------------

    // return player name
    
    /*@ pure */ 
    
    public Map<Point, Tile> determineMove(Board board) {
        Boolean done = false;
        Boolean mistakes = true;
        String x = "What X-Coördinate?";
        String y = "What Y-Coördinate?";
        String color = "What color? (red/green/yellow/blue/orange/purple)";
        String shape = "What shape? (circle/star/club/diamond/cross/square)";
   		Map<Point, Tile> choice = new HashMap<>();
        Map<Point, Tile> map = new HashMap<>();
        while (mistakes == true) {
        	map.clear();
        	while (done == false) {
             	Point choiceP = new Point(readInt(x), readInt(y));
               	Tile choiceT = new Tile(readShape(shape), readColor(color));
               	// Als ik deze if zonder de .toString() deed gaf het statement altijd false
               	// Ik vermoed dat dit komt doordat hij de memorylocatie vergelijkt ipv uit welke enums hij bestaat
               	if (getHand().toString().contains(choiceT.toString())) {
               		choice.clear();
               		choice.put(choiceP, choiceT);
               		System.out.println(choice);
               		boolean valid = board.validMove(choice);
                   	while (!valid) {
                   		System.out.println("ERROR: Choice " + "X=" + choiceP.x + ", " + "Y=" + choiceP.y + " " + choiceT + " is no valid choice.");
                   		choiceP = new Point(readInt(x), readInt(y));
                   		choiceT = new Tile(readShape(shape), readColor(color));
                   		choice.clear();
                   		choice.put(choiceP, choiceT);
                   		valid = board.validMove(choice);
                   	} 
               	} else {
               		System.out.println("You don't have this Tile!");
                }
                map.put(choiceP, choiceT); 
                done = readDone("Done? (Y/N)");     
            }
        	if (board.validMove(map)) {
        	System.out.println(map);
        	mistakes = readDone("Did you make any mistakes? (Y/N)");
        	} else {
        		System.out.println("Move invalid, please try again");
        	}
        }
        return map;
    }
    
    public Set<Tile> determineExchange() {
    	Boolean done = false;
        Boolean mistakes = true;
        String color = "What color? (red/green/yellow/blue/orange/purple)";
        String shape = "What shape? (circle/star/club/diamond/cross/square)";
   		Set<Tile> exchange = new HashSet<Tile>();
        while (mistakes == true) {
        	exchange.clear();
        	while (done == false) {
               	Tile choiceT = new Tile(readShape(shape), readColor(color));
               	// Als ik deze if zonder de .toString() deed gaf het statement altijd false
               	// Ik vermoed dat dit komt doordat hij de memorylocatie vergelijkt ipv uit welke enums hij bestaat
               	if (getHand().toString().contains(choiceT.toString())) {
               		exchange.add(choiceT);
               		System.out.println(exchange); 
               	} else {
               		System.out.println("You don't have this Tile!");
                }
                done = readDone("Done? (Y/N)");     
            }
        	System.out.println(exchange);
        	mistakes = readDone("Did you make any mistakes? (Y/N)");
        }
        return exchange;
    }
	
    
    private int readInt(String prompt) {
        int value = 0;
        boolean intRead = false;
        @SuppressWarnings("resource")
        Scanner line = new Scanner(System.in);
        do {
            System.out.print(prompt);
            try (Scanner scannerLine = new Scanner(line.nextLine());) {
                if (scannerLine.hasNextInt()) {
                    intRead = true;
                    value = scannerLine.nextInt();
                }
            }
        } while (!intRead);
        return value;
    }
    
    private String readString(String prompt) {
    	String string = "";
        boolean stringRead = false;
        @SuppressWarnings("resource")
        Scanner line = new Scanner(System.in);
        do {
            System.out.print(prompt);
            try (Scanner scannerLine = new Scanner(line.nextLine());) {
                if (scannerLine.hasNext()) {
                    stringRead = true;
                    string = scannerLine.next().toString();
                }
            }
        } while (!stringRead);
        return string;
    }
    
    private Color readColor(String prompt) {
		Color color = null;
    	int i = 0;
    	while (i != 1) {
    		switch (readString(prompt)) {
    		case "red":
    		    color = Color.RED;
    		    i = 1;
    		    break;
    		case "green":
    			color = Color.GREEN;
    			i = 1;
    		    break;
    		case "yellow":
    			color = Color.YELLOW;
    			i = 1;
    		    break;
    		case "blue":
    			color = Color.BLUE;
    			i = 1;
    		    break;
    		case "orange":
    			color = Color.ORANGE;
    			i = 1;
    		    break;
    		case "purple":
    			color = Color.PURPLE;
    			i = 1;
    		    break;
    		default:
    			System.out.println("Please enter a color!");
    		}
    	}
    System.out.println(color);
	return color;
    }
    
    private Shape readShape(String prompt) {
		Shape shape = null;
    	int i = 0;
    	while (i != 1) {
    		switch (readString(prompt)) {
    		case "circle":
    		    shape = Shape.CIRCLE;
    		    i = 1;
    		    break;
    		case "club":
    			shape = Shape.CLUB;
    			i = 1;
    		    break;
    		case "cross":
    			shape = Shape.CROSS;
    			i = 1;
    		    break;
    		case "diamond":
    			shape = Shape.DIAMOND;
    			i = 1;
    		    break;
    		case "square":
    			shape = Shape.SQUARE;
    			i = 1;
    		    break;
    		case "star":
    			shape = Shape.STAR;
    			i = 1;
    		    break;
    		default:
    			System.out.println("Please enter a shape!");
    		}
    	}
    System.out.println(shape);
	return shape;
    }
    
    public boolean readDone(String prompt) {
		Boolean done = null;
    	int i = 0;
    	while (i != 1) {
    		switch (readString(prompt)) {
    		case "Y":
    		    done = true;
    		    i = 1;
    		    break;
    		case "N":
    		    done = false;
    		    i = 1;
    		    break;
    		default:
    			System.out.println("Please enter Y/N");
    		}
    	}
    return done;
    }
}