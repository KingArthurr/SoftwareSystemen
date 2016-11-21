package ss.week7.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class FinegrainedIntCell implements IntCell {
	private boolean written = false;
	private int value = 0;
	
	private final Lock lock;
	private final Condition Write;
	private final Condition Read;
	
	public FinegrainedIntCell() {
		lock = new ReentrantLock();
		Write = lock.newCondition();
		Read = lock.newCondition();
	}
// try finally block
	public void setValue(int valueArg) {
		lock.lock();
		while (written) {
			try {
				Write.await();
			} catch (InterruptedException e) {}
		}
		this.value = valueArg;
		written = true;
		Read.signal();
		lock.unlock();
	}

	public int getValue() {
		lock.lock();
		while (!written) {
			try {
				Read.await();
			} catch (InterruptedException e) {}
		}
		Write.signal();
		int val = value;
		written = false;
		lock.unlock();
		return val;
	}
}