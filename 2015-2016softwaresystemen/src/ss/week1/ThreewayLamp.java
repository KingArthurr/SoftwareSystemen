package ss.week1;

public class ThreewayLamp {
	
	public static final int OFF = 0;
	public static final int LOW = 1;
	public static final int MEDIUM = 2;
	public static final int HIGH = 3;
	private int state;
	
	public ThreewayLamp () {
		state = ThreewayLamp.OFF;
	}
	
	public void switchSetting(int setting) {
		setting = (setting + 1) % 4;
		switch (setting) {
			case 0: state = ThreewayLamp.HIGH;
				break;
			case 1: state = ThreewayLamp.OFF;
				break;	
			case 2: state = ThreewayLamp.LOW;
				break;	
			case 3: state = ThreewayLamp.MEDIUM;
				break;
		}
	}
	
	public int getSetting() {
		return state;
	}
	public static void main(String[] args) {
	}

}