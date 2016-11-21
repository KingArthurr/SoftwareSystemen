package dss.week3.hotel;

public class BasicChecker implements Checker {
	
	public boolean acceptable(String pass){
		
		return (pass.length()>=6 && !pass.contains(" "));
	}
	
	public String generatePass() {
		
		return "password";
	}

}
