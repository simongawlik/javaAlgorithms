package algorithms.matrixmultiply;

public class MatrixMultiply {
	
	/** Square-Matrix Multiply (CLRS ch4, p. 75)
	 * running time is O(n^3)
	 * 
	 */
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
