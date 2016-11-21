package ss.week2.hotel;
//TODO jml
import ss.week2.hotel.Password;

public class Safe {
	
	// --- Instance Variables ---
	
	private Password password;
	private boolean active;
	private boolean open;
	
	// --- Constructor ---
	
	public Safe(Password pass) {
		password = pass;
		active = false;
		open = false;
	}
	
	// --- Methods ---
	
	//@ requires pass != null;
	//@ ensures \old(isActive()) || getPassword().testWord(pass) ==> this.isActive();
	public void activate(String pass) {
		assert pass != null;
		if (password.testWord(pass)) { 
			active = true;
		}
	}
	
	public void deactivate() {
		assert active != false;
		if(open = true) {
			this.close();
		}
		active = false;
	}
	
	public void open(String pass) {	
		assert pass != "";
		if (password.testWord(pass)) {
			open = true;	
		
		}
	}
	
	public void close() { 
		assert open != false;
		open = false;		
	}
	
	
	// --- Queries ---
	
	// Returns the activity state of the safe
	//@ pure
	public boolean isActive() {
		return active;
	}
	
	// Returns the status of the safe (opened/closed)
	//@ pure
	public boolean isOpen() {
		return open;
	}
	
	// Returns the password of the safe, so we can check it using the testword of our Password class
	//@ pure
	public String getPassword() {
		return password.getPass();
	}
	
	public static void main(String[] args) {
	
	}
}
