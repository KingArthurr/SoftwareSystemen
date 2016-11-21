package dss.week3.hotel;

public class StrongChecker extends BasicChecker {
	
	public boolean acceptable(String pass) {
		
		return (super.acceptable(pass) && Character.isLetter(pass.charAt(0)) && Character.isDigit(pass.charAt(pass.length()-1)));
		
	}
	
	public String generatePass() {
		
		return ("password123");
		
	}
}
