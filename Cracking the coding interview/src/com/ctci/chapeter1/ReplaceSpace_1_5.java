package com.ctci.chapeter1;

public class ReplaceSpace_1_5 {

	public static void main(String[] args) {
		String result = replaceSpace("Fuck this Shit!");
		System.out.println(result);
	}

	public static String replaceSpace(String str) {
		str = str.replace(" ", "%20");
		return str;
	}
}
