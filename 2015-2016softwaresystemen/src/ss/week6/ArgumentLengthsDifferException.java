package ss.week6;

public class ArgumentLengthsDifferException extends WrongArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5334428647357885720L;
	private String s1;
	private String s2;
	
	public ArgumentLengthsDifferException(int s1, int s2) {
		super();
	}
	
	public String getMessage() {
		return "error: length of command line arguments differs (" + 
				s1 + ", " + s2 + ")";
	}
	
}