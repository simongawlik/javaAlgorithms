package main;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {4, 3, 2, 1};
		insertionSort(array);
		printArray(array);
	}
	
	
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
			//printArray(array);
		}
	}
	
	public static void printArray(int[] array) {
		System.out.print("[ ");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + " ]");
	}
}
