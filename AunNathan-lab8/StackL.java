/* 
*  This file is the general form for a stack implemented as a linked list. 
*  In the case of this lab, our node will only take integers
*  
*/
public class StackL{
	private Node top;
	private int size;
	
	//Constructors
	public StackL(){
		size = 0;
	}
	public StackL(Node n){
		this.top = n;
		size = 1;
	}
	
	//Getters
	public int getSize(){
		return this.size;
	}
	
	//Other Methods
	//Push adds new data to the top of the stack
	public void push(int data){
		Node N = new Node(data);
		N.setNext(this.top);
		this.top = N;
		size++;
	}
	//Pop removes the top piece of data from the stack without returning anything
	public void pop(){
		//The method makes sure the stack isn't empty before attempting to remove somethign from it.
		if (!this.isEmpty()){
			this.top = this.top.getNext();
			size--;
		}
		else
			System.out.println("Cannot remove data if the stack is empty");
	}
	//Peek returns the top piece of data of the stack.
	public int peek(){
		//The method checks to make sure that the stack isn't empty before looking at the piece of data on the top of it
		if(!this.isEmpty()){
			return top.getData();
		}
		else{
			System.out.println("Cannot see data if there's nothing in the stack, will return max int value");
			return Integer.MAX_VALUE;
		}
	}
	//Clear will basically "delete" all the data currently stored in the stack
	public void clear(){
		top = null;
		size = 0;
	}
	//Checks to see if the stack is empty or not
	public boolean isEmpty(){
		return (size == 0);
	}
}