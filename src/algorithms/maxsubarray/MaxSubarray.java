package algorithms.maxsubarray;

//import main.ValueHolder;

public class MaxSubarray {
	
	// determined crossover point with time trials between brute force and 
	// divide & conquer implementations 
	private static int CROSSOVERPT = 120;
	
	/** Divide and Conquer Maximum-Subarray Algorithm (CLRS Ch4, p. 71/72)
	 * running time is O(n * log(n))
	 * */
	public static ValueHolder findMaxSubarray(int[] array) {
		return findMaxSubarray(array, 0, array.length - 1);
	}
	
	public static ValueHolder findMaxSubarray(int[] array, int low, int high) {
		if (high == low) {
			return new ValueHolder(low, high, array[low]);
		}
		int mid = (high - low) / 2 + low;
		
		ValueHolder left = findMaxSubarray(array, low, mid);
		ValueHolder right = findMaxSubarray(array, mid + 1, high);
		ValueHolder cross = findMaxCrossingSubarray(array, low, mid, high);
		if (left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) {
			return left;
		} else if (right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()) {
			return right;
		} else {
			return cross;
		}
	}
	
	
	private static ValueHolder findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
		int maxLeft = 0;
		int leftSum = Integer.MIN_VALUE; // sorta hackish Cormen
		int sum = 0;
		for (int i = mid; i >= low; i--) {
			sum = sum + array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		int maxRight = 0;
		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		for (int j = mid + 1; j <= high; j++) {
			sum = sum + array[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		return new ValueHolder(maxLeft, maxRight, leftSum + rightSum);
	}
	
	/** Brute Force Maximum-Subarray Algorithm (CLRS ch4, p. 74)
	 * running time is O(n^2)
	 * 
	 */
	public static ValueHolder bruteForceMaxSubarray(int[] array) {
		return bruteForceMaxSubarray(array, 0, array.length - 1);
	}
	
	public static ValueHolder bruteForceMaxSubarray(int[] array, int low, int high) {
		int maxLow = 0;
		int maxHigh = 0;
		int maxSum = array[0];
		
		for (int i = low; i <= high; i++) {
			int currSum = array[i];
			for (int j = i + 1; j <= high; j++) {
				currSum += array[j];
				if (currSum > maxSum) {
					maxLow = i;
					maxHigh = j;
					maxSum = currSum;
				}
			}
		}
		return new ValueHolder(maxLow, maxHigh, maxSum);
	}
	
	public static ValueHolder hybridMaxSubarray(int[] array) {
		return findMaxSubarray(array, 0, array.length - 1);
	}
	
	public static ValueHolder hybridMaxSubarray(int[] array, int low, int high) {
		if (high - low < CROSSOVERPT) {
			return bruteForceMaxSubarray(array, low, high);
		}
		int mid = (high - low) / 2 + low;
		
		ValueHolder left = hybridMaxSubarray(array, low, mid);
		ValueHolder right = hybridMaxSubarray(array, mid + 1, high);
		ValueHolder cross = findMaxCrossingSubarray(array, low, mid, high);
		if (left.getSum() >= right.getSum() && left.getSum() >= cross.getSum()) {
			return left;
		} else if (right.getSum() >= left.getSum() && right.getSum() >= cross.getSum()) {
			return right;
		} else {
			return cross;
		}
	}
	
	
	
	
}

