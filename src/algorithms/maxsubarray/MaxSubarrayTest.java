package algorithms.maxsubarray;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import algorithms.maxsubarray.*;;

public class MaxSubarrayTest {

	@Test
	public void findMaxSubarraytest() {
		
		int[] array1 = {-1, -3, -10, -2};
		ValueHolder result = MaxSubarray.findMaxSubarray(array1, 0, 3);
		Assert.assertEquals(0, result.getLow());
		Assert.assertEquals(0, result.getHigh());
		Assert.assertEquals(-1, result.getSum());
		
		
		int[] array2 = {-1, -3, 5, 4, -2, 3, -10, -2};
		result = MaxSubarray.findMaxSubarray(array2, 0, 7);
		Assert.assertEquals(2, result.getLow());
		Assert.assertEquals(5, result.getHigh());
		Assert.assertEquals(10, result.getSum());

		
		int[] array3 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		result = MaxSubarray.findMaxSubarray(array3, 0, 15);
		Assert.assertEquals(7, result.getLow());
		Assert.assertEquals(10, result.getHigh());
		Assert.assertEquals(43, result.getSum());
	}
	
	@Test
	public void bruteForceMaxSubarraytest() {
		
		int[] array1 = {-1, -3, -10, -2};
		ValueHolder result = MaxSubarray.bruteForceMaxSubarray(array1);
		Assert.assertEquals(0, result.getLow());
		Assert.assertEquals(0, result.getHigh());
		Assert.assertEquals(-1, result.getSum());
		
		
		int[] array2 = {-1, -3, 5, 4, -2, 3, -10, -2};
		result = MaxSubarray.bruteForceMaxSubarray(array2);
		Assert.assertEquals(2, result.getLow());
		Assert.assertEquals(5, result.getHigh());
		Assert.assertEquals(10, result.getSum());

		
		int[] array3 = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		result = MaxSubarray.bruteForceMaxSubarray(array3);
		Assert.assertEquals(7, result.getLow());
		Assert.assertEquals(10, result.getHigh());
		Assert.assertEquals(43, result.getSum());
	}
	
}
