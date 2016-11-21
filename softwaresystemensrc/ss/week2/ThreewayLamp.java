package ss.week2;


public class ThreewayLamp {
		
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	private int state; 
	
	//* @ ensures getSetting() == OFF;
	
	public ThreewayLamp () {
		state = ThreewayLamp.OFF;
		assert getSetting() == OFF;
	}
	
    //* @ ensures if (\old(getSetting()) == 0 { getSetting() == ThreewayLamp.HIGH };
    //* @ ensures if (\old(getSetting()) == 1 { getSetting() == ThreewayLamp.OFF };
    //* @ ensures if (\old(getSetting()) == 2 { getSetting() == ThreewayLamp.LOW };
    //* @ ensures if (\old(getSetting()) == 3 { getSetting() == ThreewayLamp.MEDIUM };
 
	
	public void switchSetting(int setting) {
		setting = (setting + 1) % 4;
		switch (setting) {
			case 0: state = ThreewayLamp.HIGH;
			assert getSetting() == HIGH;
				break;
			case 1: state = ThreewayLamp.OFF;
			assert getSetting() == OFF;
				break;	
			case 2: state = ThreewayLamp.LOW;
			assert getSetting() == LOW;
				break;	
			case 3: state = ThreewayLamp.MEDIUM;
			assert getSetting() == MEDIUM;
				break;
		}
	}
	
	//* @ pure;
	
	public int getSetting() {
		return state;
	}
	public static void main(String[] args) {
	}

}