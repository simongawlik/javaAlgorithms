package main;

import algorithms.matrixmultiply.*;
import algorithms.maxsubarray.*;
import algorithms.sorting.*;
import java.util.Random;
import java.util.LinkedList;
import java.text.*;
import printing.Printer;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int[] array = {4, 3, 2, 1};
//		Sorting.bubbleSort(array);
//		Printer.printArray(array);
		
		
		// fill test array for hybrid max subarray algorithm
		Random random = new Random();
		int max = 100;
		int min = -100;
		int trials = 100000;
		int arrayLength = 300;
		int[][] testArray = new int[trials][arrayLength];
		for (int t = 0; t < trials; t++) {
			for (int i = 0; i < arrayLength; i++) {
				testArray[t][i] = random.nextInt((max - min) + 1) + min;
			}
		}
		//Printer.printMatrix(testArray);
		
		// Timing Brute Force
		long startTime = System.nanoTime();    
		for (int[] singleTest : testArray) {
			ValueHolder result = MaxSubarray.bruteForceMaxSubarray(singleTest);
		}
		long estimatedTime = System.nanoTime() - startTime;
		double seconds = ((double)estimatedTime / 1000000000);
		System.out.println("Brute Force Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
		
		// Timing Divide & Conquer
		startTime = System.nanoTime();    
		for (int[] singleTest : testArray) {
			ValueHolder result = MaxSubarray.findMaxSubarray(singleTest);
		}
		estimatedTime = System.nanoTime() - startTime;
		seconds = ((double)estimatedTime / 1000000000);
		System.out.println("Divide & Conquer Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
		
		
		// Timing Hybrid
		startTime = System.nanoTime();    
		for (int[] singleTest : testArray) {
			ValueHolder result = MaxSubarray.hybridMaxSubarray(singleTest);
		}
		estimatedTime = System.nanoTime() - startTime;
		seconds = ((double)estimatedTime / 1000000000);
		System.out.println("Hybrid Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
	}
	
	public static int[][] strassen(int[][] A, int[][] B) {
		
		int n = A.length;
		//assuming both matrices are n x n
		int[][] C = new int[n][n];
		int halfn = n / 2;
		
		int[][] P1, P2, P3, P4, S1, S2 = new int[halfn][halfn];
		
		S1 = addMatrices(A, 0, 0, A, halfn, halfn, halfn);
		S2 = addMatrices(A, 0, 0, A, halfn, halfn, halfn);
		P1 = strassen(S1, S2);
		
		// TODO
		
		return C;
	}
	
	
	
	
	public static int[][] addMatrices(int[][] A, int offsetTopA, int offsetSideA, int[][] B, int offsetTopB, int offsetSideB, int n) {
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i + offsetTopA][j + offsetSideA] + B[i + offsetTopB][j + offsetSideB];
			}
		}
		return C;
	}
	public static int[][] addMatrices(int[][] A, int[][] B) {
		int[][] C = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		return C;
	}
	public static int[][] subtractMatrices(int[][] A, int[][] B) {
		int[][] C = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				C[i][j] = A[i][j] - B[i][j];
			}
		}
		return C;
	}
}


