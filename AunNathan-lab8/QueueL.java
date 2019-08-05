/* 
*  This file is the general form for a queue implemented as a linked list. 
*  In the case of this lab, our node will only take integers
*  
*/
public class QueueL{
	private int size;
	private Node head;
	private Node tail;

	//Constructors
	//Defualt
	public QueueL(){
		size = 0;
		head = tail = null;
	}
	public QueueL(Node N){
		head = tail = N;
		size = 1;
		
	}
	
	//Getters
	public int getSize(){
		return this.size;
	}
	
	//Other Methods
	//Enqueue adds a new piece of data to the front of the queue
	public void enqueue(int newInt){
		Node iter = head;
		while(iter.getNext() != null){
			iter = iter.getNext();
		}
		Node N = new Node(newInt);
		iter.setNext(N);
		tail = N;
	}
	
	//Dequeue will remove the element at the front of the queue and return it
	public int dequeue(){
		if(!this.isEmpty()){
			Node temp = head;
			head = head.getNext();
			return temp.getData();
		}
		else{
			System.out.println("Cannot dequeue if the queue is empty, will return integer max value instead");
			return Integer.MAX_VALUE;
		}
	}
	
	//Peek will look at the element at the front of the queue and return it
	public int peek(){
		if(!this.isEmpty()){
			return head.getData();
		}
		else{
			System.out.println("Cannot peek a value if the queue is empty, will return integer max value instead");
			return Integer.MAX_VALUE;
		}
	}
	//Clear will clear the queue 
	public void clear(){
		if(!isEmpty()){
			head = tail = null;
			size = 0;
		}
	}
	//Checks to see if the queue is empty and returns a boolean value based on that
	public boolean isEmpty(){
		return (size == 0);
	}
}