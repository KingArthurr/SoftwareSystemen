package ss.week2;


public class TWLamp {
	
	public enum State {OFF, LOW, MEDIUM, HIGH};
	private State state ;
	
	public TWLamp () {
		state = State.OFF;
	}
	
	public void switchSetting() {
		switch (state) {
			case OFF: state = State.LOW;
				break;
			case LOW: state = State.MEDIUM;
				break;	
			case MEDIUM: state = State.HIGH;
				break;	
			case HIGH: state = State.OFF;
				break;
		}
	}
	
	public State getSetting() {
		return state;
	}
	public static void main(String[] args) {
	}

}