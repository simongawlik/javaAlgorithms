package printing;

public class Printer {
	
	public static void printArray(int[] array) {
		System.out.print("[ ");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + " ]");
	}
}
