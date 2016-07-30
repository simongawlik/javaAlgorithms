package algorithms.maxsubarray;

//import main.ValueHolder;

public class MaxSubarray {
	
	/** Divide and Conquer Maximum-Subarray Algorithm (CLRS Ch4, p. 71/72)
	 * running time is
	 * */
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
	
	
	public static ValueHolder findMaxCrossingSubarray(int[] array, int low, int mid, int high) {
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
}

