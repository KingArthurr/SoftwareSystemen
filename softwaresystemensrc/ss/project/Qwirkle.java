package ss.project;

public class Qwirkle {
	
	public static void main(String[] args) {
		Deck deck = new Deck();
		Player p1 = new HumanPlayer("Maarten", deck.drawHand());
		Player p2 = new ComputerPlayer(deck.drawHand(), new NaiveStrategy());
		Game game = new Game(p1, p2);
		System.out.println("Hello! " + game.getPlayers()[1].getName() + " & " + game.getPlayers()[0].getName());
		game.start();
	}

}
