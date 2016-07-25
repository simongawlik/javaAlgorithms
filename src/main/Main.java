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
	
	
}
