package com.practice.questions.linkedin;

public class Palindrome {
	public static void main(String args[]) {
		int num = 1221;
		int result = findNextSmallestPalindrome(num);
		System.out.println(result);
	}

	public static int findNextSmallestPalindrome(int num) {
		int i = num;
		i++; //1222
		boolean isPalindrome = false;
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(i);
		while (!isPalindrome) {
			strBuild = new StringBuilder();
			strBuild = strBuild.append("");
			strBuild.append(i);
			if (strBuild.equals(strBuild.reverse()) ) {
				isPalindrome = true;
				break;
			}
			i++;
		}
		return Integer.valueOf(new String(strBuild));
	}
}
