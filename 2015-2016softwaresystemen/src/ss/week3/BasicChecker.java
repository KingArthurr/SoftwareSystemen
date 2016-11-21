package ss.week3;

public class BasicChecker implements Checker {
	
	public static final String INITPASS = Password.INITIAL;
	
	@Override
	public boolean acceptable(String pass) {
		return (pass.length() >= 6 && !(pass.contains(" ")));
	}
	
	@Override
	public String generatePassword() {
		return INITPASS;
	}

}
