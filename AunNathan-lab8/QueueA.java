/* 
*  This file is the general form for a queue implemented as an array. 
*  In the case of this lab, we will only be using an array of integers.
*  
*/
public class QueueA{
	private int head;
	private int tail;
	private int size;
	private int[] queue;
	
	//Constructor 
	public QueueA(int maxSize){
		queue = new int[maxSize];
		size = head = tail = 0;
	}
	
	//Getter
	public int getSize(){
		return this.size;
	}
	
	//Other Methods
	//Enqueue adds a new element to the end of the queue
	public void enqueue(int newInt){
		//Checks to make sure the queue isn't full before adding the new element to it
		if(!this.isFull()){
			queue[tail] = newInt;
			tail++;
			size++;
			if(tail == queue.length)
				tail -= queue.length;
		}
	}
	
	//Dequeue removes the element at the front of the queue
	public int dequeue(){
		//The method makes sure the queue isn't empty before attempting to dequeue an element
		if(!this.isEmpty()){
			int temp = head;
			head++;
			if(head == queue.length){
				head -= queue.length;
			}
			size--;
			return queue[temp];
		}
		else{
			System.out.println("Cannot dequeue if the queue is empty, returns max value instead");
			return Integer.MAX_VALUE;
		}
	}
	
	//Peek returns the data that's at the front of the queue
	public int peek(){
		//The method makes sure that the queue isnt empty before looking at the top of it
		if(!this.isEmpty())
			return queue[head];
		else{
			System.out.println("Cannot peek if the queue is empty, returns max value instead");
			return Integer.MAX_VALUE;
		}
	}
	
	//Clear will clear all the data from the queue
	public void clear(){
		head = tail = size = 0;
	}
	
	//Checks if the queue is empty and returns a boolean value based on that
	public boolean isEmpty(){
		return (size == 0);
	}
	
	//Checks to see if the queue is full and returns a boolean value based on that
	public boolean isFull(){
		return (size == queue.length);
	}
}