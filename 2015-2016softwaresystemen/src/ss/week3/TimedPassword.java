package ss.week3;

import java.lang.System;

public class TimedPassword extends Password {
	
	private long validTime;
	private long startTime;
	
	public TimedPassword() {
		validTime = 1000; // Maximum value for the integer
		startTime = System.currentTimeMillis();
	}
	
	public TimedPassword(int valid) {
		validTime = (valid * 1000);
		startTime = System.currentTimeMillis();	

	}
	
	public boolean isExpired() {
		return (System.currentTimeMillis() > startTime + validTime);
	}

	public boolean setWord(String oldpass, String newpass) {
		if (super.setWord(oldpass, newpass)) {
			startTime = System.currentTimeMillis();
			return true;
		}
		return false;
	}
}
