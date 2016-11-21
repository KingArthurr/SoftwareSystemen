package ss.week7.threads;

public class SynchronizedIntCell implements IntCell{
	private int value=0;
	private boolean Set;
	@Override
	public synchronized void setValue(int val) {
		while (Set){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		this.value = val;
		Set = true;
		notifyAll();
	}

	@Override
	public synchronized int getValue() {
		while (!Set){
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		Set = false;
		notifyAll();
		return value;
	}
}