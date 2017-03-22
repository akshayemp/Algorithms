package practice;
import java.util.*; 
import java.io.*;

class Function {  
  String LongestWord(String sen) { 
  
    // code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
    String[] tokenizedString = sen.split(" ");
    int max = 0;
    int i;
    for(i=0;i<tokenizedString.length;i++){
    	
    	if(tokenizedString[i].length()>max&&tokenizedString[i].length()!=max){
    		max = tokenizedString[i].length();
    		sen = tokenizedString[i];
    	}
    }
    
    return sen;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner  s = new Scanner(System.in);
    Function c = new Function();
    System.out.print(c.LongestWord(s.nextLine())); 
  }   
  
}