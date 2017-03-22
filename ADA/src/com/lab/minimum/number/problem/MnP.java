package com.lab.minimum.number.problem;

import java.util.Scanner;

public class MnP {
	public int[] input;
	public int size;

	public MnP() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the size of Array: ");
		size = scanner.nextInt();
		input = new int[size];
		System.out.println("Enter the elements of the array: ");

		for (int i = 0; i < size; i++) {
			input[i] = scanner.nextInt();
		}
	}

	public static void main(String... args) {
		MnP constructor = new MnP();
		int min = constructor.input[0];
		for (int index = 1; index < constructor.size; index++) {
			if (constructor.input[index] < constructor.input[index - 1]) {
				min = constructor.input[index];
			}
		}
		System.out.println(min);
	}
}