package algorithms.sorting;

public class Sorting {
	/** Insertion Sort (CLRS Ch2, p. 18) 
	 * running time is O(n^2) 
	 * currently using int[], should be polymorphic
	 * */
	public static void insertionSort(int[] array) {
		
		for (int j = 1; j < array.length; j++) {
			int key = array[j];
			
			// insert array[j] into the sorted sequence array[1..j-1]
			int i = j - 1;
			while (i >= 0 && array[i] > key) {
				array[i + 1] = array[i];
				i = i - 1;
			}
			array[i + 1] = key;
		}
	}
	
	/** Selection Sort (CLRS Ch2, p. 29) 
	 * running time is O(n^2) 
	 * currently using int[], should be polymorphic
	 * */
	public static void selectionSort(int[] array) {
		int min = 0;
		for (int i = 0; i < array.length - 1; i++) {
			// find smallest element
			for (int j = i; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			// swap array[i] with array[min]
			int tmp = array[min];
			array[min] = array[i];
			array[i] = tmp;
		}
	}
	
	
	public static void mergeSort(int[] array) {
		if (array.length == 0) {
			return;
		}
		mergeSort(array, 0, array.length - 1);
	}
	
	private static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			merge(array, p, q, r);
		} 
	}
	
	
	private static void merge(int[] array, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		
		int i, j, k;
		
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for (i = 0; i < n1; i++) {
			left[i] = array[p + i];
		}
		for (j = 0; j < n2; j++) {
			right[j] = array[q + j + 1];
		}
		
		for (k = p, i = 0, j = 0; k <= r; k++) {
			array[k] = i == n1 ? right[j++]
					 : j == n2 ? left[i++]
					 : right[j] < left[i] ? right[j++]
					 : left[i++];
		}
		
	}
	
	
//	private static void merge(int[] array, int n, int m) {
//		int i, j, k;
//		
//		int[] newArray = new int[n];
//		
//		for (i = 0, j = m, k = 0; k < n; k++) {
//			newArray[k] = j == n ? array[i++]
//					: i == m ? array[j++]
//					: array[j] < array[i] ? array[j++]
//					: array[i++];
//		}
//		for (i = 0; i < n; i++) {
//			array[i] = newArray[i];
//		}
//	}
	
	
	
	
}
