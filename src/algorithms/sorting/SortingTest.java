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
	}
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
}
