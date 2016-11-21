package ss.week2;


public class LampTest {
	
	public static void main(String[] args) {
		ThreewayLampTest test;
		test = new ThreewayLampTest () ;
		test.runLamptest () ;
	}

}

class ThreewayLampTest {
	
	private ThreewayLamp lamp;
	
	public ThreewayLampTest () {
		lamp = new ThreewayLamp ();
	}
	
	public void runLamptest () {
		testInitialState();
		testChange();
	}
	
	private void testInitialState () {
		System.out.println("testInitialState: Initial setting: " + lamp.getSetting());
	}
	
	private void testChange () {
		System.out.println("testChange:");
		System.out.println(
				"Starting setting: " + lamp.getSetting());
		lamp.switchSetting(1);
		System.out.println(
				"After turning low: " + lamp.getSetting());
		lamp.switchSetting(2);
		System.out.println(
				"After turning medium: " + lamp.getSetting());
		lamp.switchSetting(3);
		System.out.println(
				"After turning high " + lamp.getSetting());
		lamp.switchSetting(0);
		System.out.println(
				"After turning off: " + lamp.getSetting());
	}
}
