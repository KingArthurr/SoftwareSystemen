package ss.week3;

import ss.week3.BasicChecker;
import ss.week3.Checker;
import ss.week3.StrongChecker;
import java.lang.System;

@SuppressWarnings("unused")
public class Password {
	
	public static final String INITIAL = "admins6";
	private String password;
	private Checker checker;
	private String factoryPassword;
	
	public Password(Checker check) {
		checker = check;
		factoryPassword = check.generatePassword();		
	}
	
	public Password() {
		this(new BasicChecker());
		password = INITIAL;
	}
	
	public boolean acceptable(String suggestion) {
		return ((suggestion.length() >= 6) && !(suggestion.contains(" ")));
	}
	
	public boolean testWord(String test) {
		return (test.equals(password));
	}
	
	public boolean setWord(String oldpass, String newpass) {
		if (acceptable(newpass) && oldpass.equals(password)) {
			password = newpass;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getPass() {
		return password;
	}
	
	
}
