
public class PrintableCharStack extends CharStack{
	public void printStackElements(){
		for(int i = 0; i<=topOfStack; i++)
			System.out.print(stackArray[i]);
		System.out.println();
	}
PrintableCharStack(int capacity){super(capacity);}

public static void main(String args[]){
	PrintableCharStack pcStack = new PrintableCharStack(3);
	pcStack.push('H');
	pcStack.push('i');
	pcStack.printStackElements();
}
}
