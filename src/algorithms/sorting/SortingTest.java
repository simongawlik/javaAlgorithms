package algorithms.sorting;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import printing.Printer;

public class SortingTest {

	@Test
	public void testInsertionSort() {
		int[] input = {4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4};
		Sorting.insertionSort(input);
		Assert.assertArrayEquals(expected, input);
	}
	
	@Test
	public void testSelectionSort() {
		int[] input = {4, 3, 2, 1};
		int[] expected = {1, 2, 3, 4};
		Sorting.selectionSort(input);
		Assert.assertArrayEquals(expected, input);
		
		int[] input2 = {4};
		int[] expected2 = {4};
		Sorting.selectionSort(input2);
		Assert.assertArrayEquals(expected2, input2);
	}
	
	@Test
	public void testMergeSort() {
		// zipper
		int[] input = {1, 3, 5, 2, 4, 6};
		int[] expected = {1, 2, 3, 4, 5, 6};
		Sorting.mergeSort(input);
		Assert.assertArrayEquals(expected, input);
		
		// reverse
		int[] input2 = {4, 3, 2, 1};
		int[] expected2 = {1, 2, 3, 4};
		Sorting.mergeSort(input2);
		Assert.assertArrayEquals(expected2, input2);
		
		// singlet
		int[] input3 = {4};
		int[] expected3 = {4};
		Sorting.mergeSort(input3);
		Assert.assertArrayEquals(expected3, input3);
		
		// empty
		int[] input4 = {};
		int[] expected4 = {};
		Sorting.mergeSort(input4);
		Assert.assertArrayEquals(expected4, input4);
	}
	
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
}
