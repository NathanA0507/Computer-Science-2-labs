/* 
*  This file is the general form for a stack implemented as an array. 
*  In the case of this lab, we will only be using an array of integers.
*  
*/
public class StackA{
	private int[] stack;
	private int size;
	
	//Constructor
	public StackA(int maxSize){
		stack = new int[maxSize];
		size = 0;
	}
	
	//Getter
	public int getSize(){
		return this.size;
	}
	
	//Other methods
	//Push adds data to the top of the stack
	public void push(int data){
		//The method makes sure that the stack isn't full before attempting to add data to it
		if(!this.isFull()){
			stack[size] = data;
			size++;
		}
		else{
			System.out.println("Stack is full, cannot add any new data to it");
		}
	}
	//Pop removes data from the top of the stack without returning anything
	public void pop(){
		//The method makes sure the list isnt attempting to "pop" an empty stack
		if (!this.isEmpty()){
			size--;
		}
		else
			System.out.println("Stack is empty, cannot remove any data from it");
	}
	//Peek will return the piece of data at the top of the stack
	public int peek(){
		//The method makes sure that the list isnt empty before attempting to peek it;
		if(!this.isEmpty()){
			return stack[size - 1];
		}
		//Returning the max integer value because it is very unlikely that it will be an actual data point and will allow the user to see that there is an error somewhere in the execution. Alternatively there could be a System.exit(1); here to end the program prematurely but I feel like that depends on what program you're using a stack in.
		else{
			System.out.println("No value to look at, will return max integer value instead");
			return Integer.MAX_VALUE;
		}
	}
	//Clear will essentially set the stack to be "new". It still has values in it but it will overwrite those values 
	public void clear(){
		//Makes sure that it isnt already empty before messing with it.
		if (!this.isEmpty()){
			size = 0;
		}
	}
	//Checks if the stack is empty
	public boolean isEmpty(){
		return (size == 0);
	}
	//Checks if the stack is full
	public boolean isFull(){
		return (size == stack.length);
	}
	
}