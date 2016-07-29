package main;

import algorithms.sorting.*;
import printing.Printer;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {4, 3, 2, 1};
		Sorting.bubbleSort(array);
		Printer.printArray(array);
		
		int[][] a = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		int[][] c = squareMatrixMultiply(a, b);
		Printer.printMatrix(c);
		
		
		int[] array2 = {-1, 3, -1, 2};
		ValueHolder result = findMaxCrossingSubarray(array2, 0, 1, 3);
		System.out.println(result.getLow());
		System.out.println(result.getHigh());
		System.out.println(result.getSum());
		
		int[] array3 = {-1, -3, -10, -2};
		result = findMaxCrossingSubarray(array3, 0, 1, 3);
		System.out.println(result.getLow());
		System.out.println(result.getHigh());
		System.out.println(result.getSum());
		
		result = findMaxSubarray(array3, 0, 3);
		System.out.println("low:  " + result.getLow());
		System.out.println("high: " + result.getHigh());
		System.out.println("sum:  " + result.getSum());
		
		
		int[] array4 = {-1, -3, 5, 4, -2, 3, -10, -2};
		result = findMaxCrossingSubarray(array4, 0, 3, 7);
		System.out.println(result.getLow());
		System.out.println(result.getHigh());
		System.out.println(result.getSum());
		
		int[] array5 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		result = findMaxSubarray(array5, 0, 15);
		System.out.println("low:  " + result.getLow());
		System.out.println("high: " + result.getHigh());
		System.out.println("sum:  " + result.getSum());
	}
	
	public static int[][] squareMatrixMultiply(int[][] arrayA, int[][] arrayB) {
		int n = arrayA.length;
		int[][] arrayC = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arrayC[i][j] = 0;
				for (int k = 0; k < n; k++) {
					arrayC[i][j] += arrayA[i][k] * arrayB[k][j];
				}
			}
		}
		return arrayC;
	}
	
	
	/** Divide and Conquer Maximum-Subarray Algorithm (CLRS Ch4, p. 71/72)
	 * running time is
	 * */
	public static ValueHolder findMaxSubarray(int[] array, int low, int high) {
		if (high == low) {
			return new ValueHolder(low, high, array[low]);
		}
		int mid = (low + high) / 2;
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

class ValueHolder {
	private int low;
	private int high;
	private int sum;
	
	ValueHolder(int low, int high, int sum) {
		this.low = low;
		this.high = high;
		this.sum = sum;
	}
	
	public int getLow() /*to the windows... to the wall*/ {
		return this.low;
	}
	
	public int getHigh() /*on no arguments supplied*/ {
		return this.high;
	}
	
	public int getSum /*haha, I swear I'll stop here*/ () {
		return this.sum;
	}
}
