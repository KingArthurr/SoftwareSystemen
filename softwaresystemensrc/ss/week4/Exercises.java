package ss.week4;

public class Exercises {
    public static int countNegativeNumbers(int[] arr) {
        assert arr.length > 0;
        int negativeCount = 0;
        for (int number : arr) {
        	if (number < 0) {
        		negativeCount++;
        	}
        }
        return negativeCount;
    }

    public static void reverseArray(int[] ints) {
        int low = 0;
        int high = ints.length - 1;
        while (low < high) {        	
        	int temp = ints[low];
        	ints[low] = ints[high];
        	ints[high] = temp;
        	low = low+1;
        	high = high-1;
        }
    }

    class SimpleList {
        public class Element {}

        public class Node {
            public Node next;
            public Element element;
        }

        private Node first;

        private Node find(Element element) {
            Node p = first;
            if (p == null) {
                return null;
            }
            while (p.next != null && !p.next.element.equals(element)) {
                p = p.next;
            }
            if (p.next == null) {
                return null;
            } else {
                return p;
            }
        }

        public void remove(Element element) {
            Node p = find(element);
            if (p != null) {
                p.next = p.next.next;
            }
        }
    }
}
