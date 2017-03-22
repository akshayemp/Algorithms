package com.ctci.chapeter1;

/**
 * This code is for finding if the string contains unique characters.
 * @author Prerit
 *
 */
public class UniqueChars_1_1 {
	public static void main(String args[]){
		boolean result = findUniqueness("abcde");
		System.out.println(result);
	}
	/**
	 * The function findUniqueness finds whether a given string contains 
	 * unique characters or not. The logic behind the code is to find if
	 * the index of character from beginning and from the last is the
	 * same. If it is not it returns false, else true after the whole 
	 * iteration.
	 * 
	 * Time Complexity: O(n^2) amortized cost is much better, we don't need
	 * to search the whole string if a mis-match is found. Further, we don't
	 * have to always go to the start of the string.
	 * 
	 * Space Complexity: No space.
	 * 
	 * @param str
	 * @return
	 */
	public static boolean findUniqueness(String str){
		for(int index = 0; index<str.length();index++){
			if(index != str.lastIndexOf(str.charAt(index))) return false;
		}
		return true;
	}
}



