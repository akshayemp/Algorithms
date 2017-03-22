package com.ctci.chapeter1;

import java.util.Arrays;

public class Anagrams_1_4 {
	public static void main(String args[]) {
		boolean result = anagrams("cinema", "iceman");
		System.out.println(result);
	}

	public static boolean anagrams(String str1, String str2) {
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);		
		return String.valueOf(a).equals(String.valueOf(b));
	}
}
