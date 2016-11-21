package ss.week7.threads;

import java.util.concurrent.locks.ReentrantLock;

public class TestSyncConsole extends Thread{
/*	private Thread thread;
	
	public static void main(String[] args) {
		TestSyncConsole one = new TestSyncConsole("Thread A");
		one.start();
		
		TestSyncConsole two = new TestSyncConsole("Thread B");
		two.start();
	}
	
	public TestSyncConsole (String name) {
		super(name);
	}
	
	public synchronized void sum() {
		synchronized (System.in) {
		int first = SyncConsole.readInt(this.getName() + ": get number 1?");
		int second = SyncConsole.readInt(this.getName() + ": get number 2?");
		SyncConsole.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
		}
	}
	
	public void run() {
		sum();
	}

}*/

	
	@SuppressWarnings("unused")
	private Thread thread;
	private static ReentrantLock lock = new ReentrantLock();
		
		public static void main(String[] args) {
			TestSyncConsole one = new TestSyncConsole("Thread A");
			one.run();
			
			TestSyncConsole two = new TestSyncConsole("Thread B");
			two.run();
		}
		
		public TestSyncConsole (String name) {
			thread = new Thread(this, name);
		}
		
		public synchronized void sum() {
			lock.lock();
			try {
			int first = SyncConsole.readInt(this.getName() + ": get number 1?");
			int second = SyncConsole.readInt(this.getName() + ": get number 2?");
			SyncConsole.println(this.getName() + ": " + first + " + " + second + " = " + (first + second));
			} finally {			
			lock.unlock();
			}
		}
		
		public void run() {
			sum();
		}

	}