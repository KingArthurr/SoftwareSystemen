package ss.week7;

public class ConcatThread extends Thread {
    private static String text = "";
    private String toe;

    public ConcatThread(String toeArg) {
        this.toe = toeArg;
    }

    public synchronized void run() { 	
    	if (text.equals("") && toe.equals("two;")) {
    		try {
				wait();
			} catch (InterruptedException e) {
			}
    	}
    	text = text.concat(toe);
    	notifyAll();
    	System.out.println(text);
    }

    public static void main(String[] args) {
        (new ConcatThread("one;")).start();
        (new ConcatThread("two;")).start();
    }
}
