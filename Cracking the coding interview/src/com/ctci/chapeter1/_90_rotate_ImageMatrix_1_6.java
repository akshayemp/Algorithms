package com.ctci.chapeter1;

public class _90_rotate_ImageMatrix_1_6 {

	public static int n = 10;
	static int[][] image = new int[n][n];
	
	public _90_rotate_ImageMatrix_1_6() {
		
		for (int i = 0; i < image.length; i++) {
		    for (int j = 0; j < image[i].length; j++) {
		        image[i][j] = (int)(Math.random()*10);
		    }
		}
	}

	public static void main(String[] args) {
		rotateImage(image);
	}
	
	public static void rotateImage(int[][] image){
		
	}

}
