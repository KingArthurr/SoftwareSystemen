package ss.project;

import java.util.Observer;

public interface View extends Observer {
	public void start();
	public void initBoard();
	public void showPlayers ();
}
