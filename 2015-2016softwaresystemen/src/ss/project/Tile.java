package ss.project;

/**
 * Tile is the class for representing a physical Tile that would
 * be laid upon the game board. Each Tile has several properties,
 * such as a color and a shape.
 */
public class Tile {

// Mogelijke vormen van een Tile
    public enum Shape {
        SQUARE(1), CIRCLE(2), DIAMOND(3), CLUB(4), STAR(5), CROSS(6);
        public final int shape;
        
        Shape(int s) {
            shape = s;
        }
    }

// Mogelijke kleuren van een Tile
    public enum Color {
        RED(1), GREEN(2), YELLOW(3), BLUE(4), ORANGE(5), PURPLE(6);
        public final int color;

        Color(int c) {
            color = c;
        }
    }

    private final Shape shape;
    private final Color color;

// maakt nieuwe Tile met gegeven waarden
    public Tile(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
    }
    
// return vorm van Tile
    public Shape getShape() {
        return shape;
    }

// return kleur van Tile
    public Color getColor() {
        return color;
    }

// return shape en color van een Tile
    public String toString() {
		String tile;

		switch (getShape()) {
    		case SQUARE:
    		    tile = "Square";
    		    break;
    		case CIRCLE:
    		    tile = "Circle";
    		    break;
    		case DIAMOND:
    		    tile = "Diamond";
    		    break;
    		case CLUB:
    		    tile = "Club";
    		    break;
    		case STAR:
    		    tile = "Star";
    		    break;
    		default:
    		    tile = "Cross";
		}
		tile += " ";
		switch (getColor()) {
    		case RED:
    		    tile += "Red";
    		    break;
    		case GREEN:
    		    tile += "Green";
    		    break;
    		case YELLOW:
    		    tile += "Yellow";
    		    break;
    		case BLUE:
    		    tile += "Blue";
    		    break;
    		case ORANGE:
    		    tile += "Orange";
    		    break;
    		default:
    		    tile += "Purple";
		}
		return tile;
	}
    
    public static void main(String[] args) {
    	Tile a = new Tile(Shape.CIRCLE , Color.PURPLE);
    	System.out.println(a.getShape());
    }
}
