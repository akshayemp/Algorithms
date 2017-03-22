package com.ctci.chapeter1;

public class Matrix_zero_1_7 {

	public static final int n = 3;

	public static int[] saveRowIndex = new int[n];
	public static int[] saveColIndex = new int[n];
	public static int matrix[][] = { { 1, 2, 4 }, { 1, 0, 3 }, { 0, 2, 3 } };

	public Matrix_zero_1_7() {

	}

	public static void main(String[] args) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] == 0) {
					saveRowIndex[i] = 1;
					saveColIndex[j] = 1;
				}

			}

		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(saveRowIndex[i] == 1 || saveColIndex[j] == 1){
					matrix[i][j] = 0;
				}
			}
		}
	}

}
