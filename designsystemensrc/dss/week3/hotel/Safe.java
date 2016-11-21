package dss.week3.hotel;

import dss.week3.hotel.Password;
import dss.week3.hotel.Safe;

public class Safe {
    
	// @ public invariant open == true ==> active == true ;
	private Password password;
    private boolean active;
    private boolean open;
    
    // @ requires password != null;
    public Safe(Password password) {
    	this.password = password;
    }
    
    
    /* @ pure */ public boolean isActive() {
        return active;
    }
    
    /* @ pure */ public boolean isOpen() {
        return open;
    }
    
    /* @ pure */ private Password getPassword() {
        return password;
    }
    
    // @ requires password.length() > 0;
    // @ ensures !isActive() && getPassword().testWord(password) ==> isActive() == true;
    public boolean activate(String password) {
        assert password.length() > 0;
        if (!isActive() && getPassword().testWord(password)) {
            this.active = true;
            return true;
        }
        return false;
    }
    
    // @ ensures !isActive() && !isOpen();
    public void deactivate() {
    	if (isActive()) {
            this.open = false;
            this.active = false;
        }
    }
    
    // @ requires password.length() > 0;
    
    public boolean open(String password) {
        assert password.length() > 0;
        if ((isActive() && !isOpen()) && getPassword().testWord(password)) {
            this.open = true;
            return true;
        }
        return false;
    }
    
    // @ ensures !isOpen();
    public void close() {
        if (isOpen()) {
            this.open = false;
        }
    }
    
    public static void main(String[] args) {
    	Safe safe = new Safe(new Password());
        safe.open("");
    }
    
}
