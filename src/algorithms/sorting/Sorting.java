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
}
