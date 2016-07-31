package main;

import algorithms.matrixmultiply.*;
import algorithms.maxsubarray.*;
import algorithms.sorting.*;
import java.util.Random;
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
	
	
	
}


