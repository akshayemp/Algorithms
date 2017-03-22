package com.ctci.chapeter1;

public class ReverseString_1_2 {
	public static void main(String args[]) {
		String result = reverseString("abcd\0");
		System.out.println(result);
	}

	public static String reverseString(String str) {
		String s = "";
		for (int i = str.length() - 2; i >= 0; i--) {
			s = s + str.charAt(i);
		}
		return s + "\0";
	}
}