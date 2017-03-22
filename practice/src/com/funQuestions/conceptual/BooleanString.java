package com.funQuestions.conceptual;

/**
 * You have to be carefull when using Boolean.valueOf(string) or Boolean.parseBoolean(string).
 *  The reason for this is that the methods will always return false if the String is not equal to "true" (the case is ignored).

For example:

Boolean.valueOf("YES") -> false
Because of that behaviour I would recommend to add some mechanism to ensure that the string which should be translated
to a Boolean follows a specified format.

For instance:

if (string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false")) {
    Boolean.valueOf(string)
    // do something   
} else {
    // throw some exception
}
 * @author panwe
 *
 */
public class BooleanString {
	 static String str;
	  
	  public static boolean test1(){
	    return new Boolean("1");
	  }
	  
	  public static boolean test2(){
	    return new Boolean(str);
	  }

	  public static void main(String[] args) {

	    if(test1())
	      System.out.print("1");
	    if(!test2())
	      System.out.print("2");
	    if(test1() != test2())
	      System.out.print("3");
	  }
}
