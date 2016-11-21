package ss.week7;


public class MultiThreadedQuickSort extends Thread {
	
	int[] array;
	int first = 0;
	int last;
	
	public MultiThreadedQuickSort(int[] a, int first, int last) {
		this.array = a;
		this.first = first;
		this.last = last;
	}
	
	public static void qsort(int[] a) {
		qsort(a, 0, a.length - 1);
	}
	
	public static void qsort(int[] a, int first, int last) {
		if (first < last) {
			int position = partition(a, first, last);
			MultiThreadedQuickSort q1 = new MultiThreadedQuickSort(a, first, position - 1);
			q1.start();
			MultiThreadedQuickSort q2 = new MultiThreadedQuickSort(a, position + 1, last);
			q2.start();
			try {
				q1.join();
				q2.join();
			} catch (Exception e) {}
		}
	}
	
	public static int partition(int[] a, int first, int last) {

		int mid = (first + last) / 2;
		int pivot = a[mid];
		swap(a, mid, last); // put pivot at the end of the array
		int pi = first;
		int i = first;
		while (i != last) {
			if (a[i] < pivot) {
				swap(a, pi, i);
				pi++;
			}
			i++;
		}
		swap(a, pi, last); // put pivot in its place "in the middle"
		return pi;
	}
	
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public void run() {
		qsort(array, first, last);
	}

	public static void main(String[] args) {
		int[] array = {3,4,5,7,2,1,6,2,7,9};
		printArray(array);
		qsort(array);
		printArray(array);
	}
	
	public static void printArray(int[] array) {
		boolean first = true;
		for (int i = 0; i < array.length; i++) {
			if (!first) System.out.print(", ");
			System.out.print(array[i]);
			first = false;
		}
		System.out.println("");
	}
	
}