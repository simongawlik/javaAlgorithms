package algorithms.matrixmultiply;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import printing.Printer;

public class MatrixMultiplyTest {

	@Test
	public void squareMatrixMultiplyTest() {
		int[][] I = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] B = MatrixMultiply.squareMatrixMultiply(A, I);
		for (int i = 0; i < I.length; i++) {
			Assert.assertArrayEquals(A[i], B[i]);
		}
	}

}
