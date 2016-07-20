package algorithms.sorting;

public class Sorting {
	/** Insertion Sort (CLRS Ch2, p. 18) currently using int[], should be polymorphic 
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
			//Printer.printArray(array);
		}
	}
}
