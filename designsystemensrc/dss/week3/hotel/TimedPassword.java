package dss.week3.hotel;

import dss.week3.hotel.Password;

public class TimedPassword extends Password {
    private int validTime = 1000;
    private long startTime;

	public TimedPassword() {
		startTime = System.currentTimeMillis();
	}
	
	public boolean isExpired() {
		return (System.currentTimeMillis() > startTime + validTime);
	}

	public boolean setWord(String oldPass, String newPass){
		if(acceptable(newPass) && testWord(oldPass)){
			this.password = newPass;
			this.reset();
			return true;
		}
		return false;
		
	}
	public void reset() {
		startTime = System.currentTimeMillis();
	}
}