public class CharStack{
	protected char[] stackArray;
	protected int topOfStack;
	
	private static int counter;
	
	public CharStack(int capacity){
		stackArray = new char[capacity];
		topOfStack = -1;
		counter++;	
	}
	
	public void push(char element){
		stackArray[++topOfStack] = element;	
	}

	public char pop(){
		return stackArray[topOfStack--];
	}
	
	public char peek(){return stackArray[topOfStack];}
	public boolean isEmpty(){return topOfStack <0;}
	public boolean isFUll(){return topOfStack == stackArray.length -1;}
	public static int getInstance(){return counter;}
}

