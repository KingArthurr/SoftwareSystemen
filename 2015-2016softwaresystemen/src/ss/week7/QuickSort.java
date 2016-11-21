package ss.week7;


public class QuickSort implements Runnable {
	int first;
	int last;
	int[] a;	
	
	public QuickSort(int[] a, int first, int last) {
		this.a = a;
		this.first = first;
		this.last = last;
	}
	
    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }
    
    public static void qsort(int[] a, int first, int last) {
        if (first < last) {
            int position = partition(a, first, last);
            Thread t1 = new Thread(new QuickSort(a, first, position - 1));
            Thread t2 = new Thread(new QuickSort(a, position + 1, last));
            t1.start();
            t2.start();
            try {
            	t1.join();
            	t2.join();
            } catch (InterruptedException e) {
            	System.out.println(e.getMessage());
            }
        }
    }
    
    public void run() {
    	qsort(a, first, last);
    }
    
    public static int partition(int[] a, int first, int last) {

        int mid = (first + last) / 2;
        int pivot = a[mid];
        swap(a, mid, last);
        int pi = first;
        int i = first;
        while (i != last) {
            if (a[i] < pivot) {
                swap(a, pi, i);
                pi++;
            }
            i++;
        }
        swap(a, pi, last);
        return pi;
    }
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}