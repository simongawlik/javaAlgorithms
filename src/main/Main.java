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
		
		int[][] A = {
				{1, 2},
				{3, 4}
		};
		
		int[][] B = {
				{1, 0},
				{0, 1}
		};
		
		int[][] C = strassen(A, B);
		Printer.printMatrix(C);
		
		int[][] D = {
				{1, 2, 3},
				{2, 3, 4},
				{3, 4, 5}
		};
		
		int[][] E = {{9}};
		
//		reinsertMatrix(E, D, 0, 0, 1);
//		Printer.printMatrix(D);
		
		
		
		
		// fill test array for hybrid max subarray algorithm
//		Random random = new Random();
//		int max = 100;
//		int min = -100;
//		int trials = 100000;
//		int arrayLength = 300;
//		int[][] testArray = new int[trials][arrayLength];
//		for (int t = 0; t < trials; t++) {
//			for (int i = 0; i < arrayLength; i++) {
//				testArray[t][i] = random.nextInt((max - min) + 1) + min;
//			}
//		}
		//Printer.printMatrix(testArray);
		
		// Timing Brute Force
//		long startTime = System.nanoTime();    
//		for (int[] singleTest : testArray) {
//			ValueHolder result = MaxSubarray.bruteForceMaxSubarray(singleTest);
//		}
//		long estimatedTime = System.nanoTime() - startTime;
//		double seconds = ((double)estimatedTime / 1000000000);
//		System.out.println("Brute Force Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
		
		// Timing Divide & Conquer
//		startTime = System.nanoTime();    
//		for (int[] singleTest : testArray) {
//			ValueHolder result = MaxSubarray.findMaxSubarray(singleTest);
//		}
//		estimatedTime = System.nanoTime() - startTime;
//		seconds = ((double)estimatedTime / 1000000000);
//		System.out.println("Divide & Conquer Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
		
		
		// Timing Hybrid
//		startTime = System.nanoTime();    
//		for (int[] singleTest : testArray) {
//			ValueHolder result = MaxSubarray.hybridMaxSubarray(singleTest);
//		}
//		estimatedTime = System.nanoTime() - startTime;
//		seconds = ((double)estimatedTime / 1000000000);
//		System.out.println("Hybrid Time : " + new DecimalFormat("#.##########").format(seconds) + " Seconds");
	}
	
	public static int[][] strassen(int[][] A, int[][] B) {
		
		int n = A.length;
		//assuming both matrices are n x n
		
		if (n == 1) {
			A[0][0] = A[0][0] * B[0][0];
			return A;
		}
		
		int[][] C = new int[n][n];
		int halfn = n / 2;
		
		int[][] P1, P2, P3, P4, S1, S2 = new int[halfn][halfn];
		
		// calculate P5
		S1 = addMatrices(A, 0, 0, A, halfn, halfn, halfn);
		S2 = addMatrices(A, 0, 0, A, halfn, halfn, halfn);
		P1 = strassen(S1, S2);
		
		// calculate P4
		S1 = subtractMatrices(B, halfn, 0, B, 0, 0, halfn);
		int[][] A22 = copyMatrix(A, halfn, halfn, halfn);
		P2 = strassen(A22, S1);
		
		// calculate P2
		S2 = addMatrices(A, 0, 0, A, 0, halfn, halfn);
		int[][] B22 = copyMatrix(B, halfn, halfn, halfn);
		P3 = strassen(S2, B22);
		
		// calculate P6
		S1 = subtractMatrices(A, 0, halfn, A, halfn, halfn, halfn);
		S2 = addMatrices(B, halfn, 0, B, halfn, halfn, halfn);
		P4 = strassen(S1, S2);
		
		// calculate C11 = P5 + P4 - P2 + P6
		P4 = subtractMatrices(P4, 0, 0, P3, 0, 0, halfn);
		P4 = addMatrices(P4, 0, 0, P1, 0, 0, halfn);
		P4 = addMatrices(P4, 0, 0, P2, 0, 0, halfn);
		reinsertMatrix(P4, C, 0, 0, halfn);
		
		// calculate P1
		int[][] A11 = copyMatrix(A, 0, 0, halfn);
		S1 = subtractMatrices(B, 0, halfn, B, halfn, halfn, halfn);
		P4 = strassen(A11, S1);
		
		// calculate C12 = P1 + P2
		P3 = addMatrices(P4, 0, 0, P3, 0, 0, halfn);
		reinsertMatrix(P3, C, 0, halfn, halfn);
		
		// calculate P3
		int[][] B11 = copyMatrix(B, 0, 0, halfn);
		S1 = addMatrices(A, halfn, 0, A, halfn, halfn, halfn);
		P3 = strassen(S1, B11);
		
		// calculate C21 = P3 + P4
		P2 = addMatrices(P3, 0, 0, P2, 0, 0, halfn);
		reinsertMatrix(P2, C, halfn, 0, halfn);
		
		// calculate P7
		S1 = subtractMatrices(A, 0, 0, A, halfn, 0, halfn);
		S2 = addMatrices(B, 0, 0, B, 0, halfn, halfn);
		P2 = strassen(S1, S2);
		
		// calculate C22 = P5 + P1 - P3 - P7
		S1 = addMatrices(P1, 0, 0, P4, 0, 0, halfn);
		S2 = addMatrices(P3, 0, 0, P2, 0, 0, halfn);
		P1 = subtractMatrices(S1, 0, 0, S2, 0, 0, halfn);
		reinsertMatrix(P1, C, halfn, halfn, halfn);
		
		// TODO triage issue
		
		return C;
	}
	
	
	public static void reinsertMatrix(int[][] source, int[][] target, int offsetTop, int offsetSide, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				target[i + offsetTop][j + offsetSide] = source[i][j];
			}
		}
	}
	
	public static int[][] copyMatrix(int[][] source, int offsetTop, int offsetSide, int n) {
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = source[i + offsetTop][j + offsetSide];
			}
		}
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
	public static int[][] subtractMatrices(int[][] A, int offsetTopA, int offsetSideA, int[][] B, int offsetTopB, int offsetSideB, int n) {
		int[][] C = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = A[i + offsetTopA][j + offsetSideA] - B[i + offsetTopB][j + offsetSideB];
			}
		}
		return C;
	}
}


