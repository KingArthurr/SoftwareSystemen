package ss.week3.hotel;

public class Password {

	public String INITPASS;
	public String password;
	
    @SuppressWarnings("unused")
	private Checker checker = new BasicChecker();
	
	public Password(Checker checker){
        this.checker = checker;
        this.INITPASS = checker.generatePass();
        this.password = INITPASS;
	}
   
	public Password() {	
        this(new BasicChecker());
    }
    
	
	public boolean acceptable(String suggestion){
		return (suggestion.length()>=6 && !suggestion.contains(" "));
	}
	
	public boolean setWord(String oldPass, String newPass){
		if(acceptable(newPass) && testWord(oldPass)){
			this.password = newPass;
			return true;
		}
		return false;
		
	}
	
	public boolean testWord(String test){
		return test.equals(password);
	}
	
}