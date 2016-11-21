package ss.project;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

import ss.project.Game;
import ss.project.Player;
import ss.project.Deck;
import ss.project.Board;

public class TUIView implements View, Observer {
	
	private String join = "join";
	private String start = "start";
	private String exit = "exit";
	private String hint = "hint";
	private String swap = "swap";
	private String move = "move";
	private String done = "done";
	private String help = "help";
	private Game game;
	private Deck deck;
	private Player player;
	private Board board;
	private HumanPlayer humanPlayer;
	@SuppressWarnings("unused")
	private Qwirkle qwirkle;
	
	public TUIView(Qwirkle qwirkle) {
		this.qwirkle = qwirkle;
	}
	
	@SuppressWarnings("unused")
	public void start() {
		boolean notEmpty = true;
		System.out.println("Welcome");
		Scanner in = new Scanner(System.in);
		while(notEmpty) {
			String command = in.next();
			if (command.equals(join)) {
				Player[] players = new Player[1];//TODO  join
			}
			if (command.equals(start)) {
				game.start();
			}
			if (command.equals(exit)) {
				exit();
			}
			if (command.equals(hint)) {
				player.getHint(board);
			}
			if (command.equals(swap)) {
				deck.changeTile(player.getHand());
			}
			if (command.equals(move)) {
				player.makeMove(board);
			}
			if (command.equals(done)) {
				humanPlayer.readDone("Y");
				game.printResult();
				game.nextPlayer();
			}
			if (command.equals(help)) {
				System.out.println("join: join game");
				System.out.println("start: start a game");
				System.out.println("exit: exit game");
				System.out.println("hint: give a hint");
				System.out.println("swap: swap tile");
				System.out.println("move: make a move");
				System.out.println("done: confirm a move or swap");
			}
		}
		in.close();
	}
	
	public void initBoard() {
		board.getMap();
	}
	
	public void showPlayers () {
		System.out.println(game.getPlayers());
	}
	
	public void showHint () {
		player.getHint(board);
	}
	
	public void showTiles () {
		System.out.println(player.getHand());
	}
	
	public void showMove () {
		System.out.println(board.getLastSetField());
	}
	
	public void showScore () {
		System.out.println(player.getPoints());
	}
	
	public void exit() {
		System.out.println(game.getCurrentPlayer() + " exited the game.");
		game.printResult();
		delay(700);
		System.exit(0);
	}
	
	public static void delay(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException exp) {
		}
	}
	
	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("move")) {
			System.out.println(game.getCurrentPlayer() + "madeMove" + board.getLastSetField());
		}
		if (arg1.equals("join")) {
			System.out.println("Your playername = " + game.getCurrentPlayer() + " type 'start' to start a game");
		}
		if (arg1.equals("exit")) {
			System.out.println(game.getCurrentPlayer() + " left the game");
		}
		if (arg1.equals("end")) {
			System.out.println("End of game");
			game.printResult();
		}
		if (arg1.equals("done")) {
			System.out.println("receiveTile: " + deck.drawTile());
			System.out.println("Score:");
			game.printResult();
			System.out.println("Turn: " + game.getCurrentPlayer());
		}
	}

}