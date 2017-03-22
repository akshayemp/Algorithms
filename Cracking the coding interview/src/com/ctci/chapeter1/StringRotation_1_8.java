package com.ctci.chapeter1;

import java.util.Arrays;

public class StringRotation_1_8 {

	public static void main(String[] args) {
		boolean result = isSubsring("waterbottle", "terbottlewa");
		System.out.println(result);
	}

	public static boolean isSubsring(String str1, String str2) {
		String s = "";
		if (str1.length() != str2.length())
			return false;

		for (int i = 0; i < str1.length(); i++) {
			str1 = str1.substring(1) + str1.charAt(0);
			if (str1.equals(str2)) {
				return true;
			}
		}
		return false;
	}

}
