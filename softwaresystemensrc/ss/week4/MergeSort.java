package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>>
           void mergesort(List<Elem> list) {
    	List <Elem> aux = new ArrayList <Elem>(list);
    	mergesort(list, aux, 0, list.size() -1);
    }
    
    private static <Elem extends Comparable<Elem>>
    		void mergesort(List<Elem> list, List <Elem> aux, int left, int right) {
    	if (left < right) {
    		int mid = (left + right) / 2;
    		mergesort(list, aux, left, mid);
    		mergesort(list,aux, mid + 1, right);
    		merge(list, aux, left, mid, right);
    	}
    }
    
    private static <Elem extends Comparable <Elem>>
    		void merge(List<Elem> list, List <Elem> aux, int startLeft, int mid, int endRight) {
    	int endLeft = mid;
    	int startRight = mid + 1;
    	
    	int leftPos = startLeft;
    	int rightPos = startRight;
    	int auxPos = startLeft;
    	
    	while (leftPos <= endLeft && rightPos <= endRight) {
    		if(list.get(leftPos).compareTo(list.get(rightPos)) <= 0) {
    			aux.set(auxPos++,  list.get(leftPos++));
    		}
    		else {
    			aux.set(auxPos++,  list.get(rightPos++));
    		}
    	}
    	
    	while (leftPos <= endLeft) {
    		aux.set(auxPos++,  list.get(leftPos++));
    	}
    	
    	while (rightPos <= endRight) {
    		aux.set(auxPos++,  list.get(rightPos++));
    	}
    	
    	for (int i = startLeft; i <= endRight; i++) {
    		list.set(i, aux.get(i));
    	}
    }
}
