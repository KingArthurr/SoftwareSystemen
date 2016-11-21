package ss.week7.threads;

public class TestConsole extends Thread{
	@SuppressWarnings("unused")
	private Thread thread;
	
	public static void main(String[] args) {
		TestConsole one = new TestConsole("Thread A");
		one.start();
		
		TestConsole two = new TestConsole("Thread B");
		two.start();
	}
	
	public TestConsole (String name) {
		super(name);
	}
	
	public void sum() {
		int first = Console.readInt(this.getName() + ": get number 1?");
		int second = Console.readInt(this.getName() + ": get number 2?");
		Console.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
	}
	
	public void run() {
		sum();
	}

}