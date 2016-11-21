package ss.week3;

import java.lang.Character;



public class StrongChecker extends BasicChecker {
	
	private static final String SAFEPASSWORD = "imanadmin2";	

	public boolean acceptable(String pass) {
		return (Character.isLetter(pass.charAt(0)) && Character.isDigit(pass.charAt(pass.length()-1)) && super.acceptable(pass));	
	}
	
	@Override
	public String generatePassword() {
		return SAFEPASSWORD;
	}
}
