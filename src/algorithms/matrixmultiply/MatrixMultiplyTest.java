package algorithms.matrixmultiply;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class MatrixMultiplyTest {

	@Test
	public void squareMatrixMultiplyTest() {
		int[][] i = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] b = MatrixMultiply.squareMatrixMultiply(a, i);
		for (int j = 0; j < i.length; j++) {
			Assert.assertArrayEquals(a[j], b[j]);
		}
		
		int[][] c = {{1, 2, 3, 4}, 
				{3, 4, 5, 6},
				{5, 6, 7, 8},
				{7, 8, 9, 0}};
		int[][] d = {{16,  2,  3, 13}, 
				{ 5, 11, 10,  8},
				{ 9,  7,  6, 12},
				{ 4, 14, 15,  1}};
		
		int[][] expectedCxD = {{ 69, 101, 101,  69},
				{137, 169, 169, 137},
				{205, 237, 237, 205},
				{233, 165, 155, 263}};
		int[][] expectedDxC = {{128, 162, 196, 100}, 
				{144, 178, 212, 166},
				{144, 178, 212, 126},
				{128, 162, 196, 220}};
		
		int[][] actualCxD = MatrixMultiply.squareMatrixMultiply(c, d);
		for (int j = 0; j < c.length; j++) {
			Assert.assertArrayEquals(expectedCxD[j], actualCxD[j]);
		}
		int[][] actualDxC = MatrixMultiply.squareMatrixMultiply(d, c);
		for (int j = 0; j < d.length; j++) {
			Assert.assertArrayEquals(expectedDxC[j], actualDxC[j]);
		}
	}
}
