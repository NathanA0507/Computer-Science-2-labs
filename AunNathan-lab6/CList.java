/*************************************************************************
 * This class is for a circular linked list. You will notice that it has 
 * the same attributes as in a regular linked list. What will be different 
 * though is the way we manipulate the list.
 * Also, instead of calling a node the head, we call it start since there 
 * is no more head of the list
 *************************************************************************/ 

public class CList<T> {
    private Node<T> start;
    private int size;
    
    // CONSTRUCTORS ******************************************************
    public CList() {}
    
    // TODO 1: Complete the following constructor that takes a node as a parameter
    // Pre-condition: N is a single node
    public CList(Node<T> N) { 
        this.start = N;
		this.size = 1;
    }
    
    // SETTERS ***********************************************************
    // TODO 2: Write a setter method for setting the attribute start:
    // YOUR CODE (INCLUDING THE SIGNATURE) GOES HERE...
    public void setStart(Node<T> N){
		this.start = N;
	}
	
    // no setter for the size since it is a consequence of other methods
        
    // GETTERS ***********************************************************
    // TODO 3 & TODO 4: Write a getter method for accessing each of the attributes:
    // YOUR CODE (INCLUDING SIGNATURE) GOES HERE...
	public Node getStart(){
		return this.start;
	}
	public int getSize(){
		return this.size;
	}
    
    
    // OTHER METHODS *****************************************************
    
    // ADDING NODES OR SEQUENCES OF NODES ////////////////////////////////
    /* Method addAtEnd: 
     *      Takes a node N 
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtEnd(Node<T> N) {
		//if size is initially 0 or 1, adding a node is pretty easy since there are only 2 pointers you need to change and no traversal
		if (size == 0){
			this.start = N;
			start.setNext(start);
			size++;
		}
		else if(size == 1){
			this.start.setNext(N);
			N.setNext(start);
			size++;
		}
		//Anyhting bigger than 1 will require some traversal to get through so this method will allow the list to be created with anything greater than 1
		if(size > 1){
			Node<T> iter = start;
			while (iter.getNext() != start && iter.getNext() != null){
				iter = iter.getNext();
			}
			iter.setNext(N);
			N.setNext(start);
			size++;
		}
    }
    
    /* Method addDataAtEnd: 
     *      Takes data of type T 
     *      Creates a node that contains T
     *      Adds it to the circle "at the end", i.e., just before start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addDataAtEnd(T data) {
		Node<T> N = new Node<T>(data);
		this.addAtEnd(N);
    }
    
    /* Method addAtStart: 
     *      Takes a node N 
     *      Adds it to the circle just before start and makes it the new start.
     *      Notes: 1/ take into account when the list is null
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtStart(Node<T> N) {
        Node<T> iter = start;
		//Traverse throguh the array and then take the end of the array and set it to the new start, then set the new start's next to the old start
		while(iter.getNext() != start){
			iter = iter.getNext();
		}
		iter.setNext(N);
		N.setNext(start);
		size++;
		this.start = N;
    }
    
    /* Method addAtLocation: 
     *      Takes a node N and an integer n
     *      Adds N to the circle just after the n-th node in the circle
     *          (where start is the first node)
     *      Notes: 1/ take into account when the list is null or has 
     *          less than n nodes
     *          2/ Make sure to update the size
     ********************************************************************/
    public void addAtLocation(Node<T> N, int n) {
		if(n > size){
			System.out.println("Location not within the linked list, please change numbers and try again");
			System.exit(1);
		}
        Node<T> iter = start;
		//Traverse to the point in the array specified by n, then change the pointers 
		for (int i = 1; i < n; i++){
			iter = iter.getNext();
		}
		Node<T> temp = iter.getNext();
		iter.setNext(N);
		N.setNext(temp);
		size++;
    }   
    
    /* Method addMultiAtEnd: 
     *      Similar to addAtEnd
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtEnd(Node<T> N) {
		//go to the end and point the last node to this new node, then set the new node to point to the start
        Node<T> iter = start;
		size+= N.sizeFromNode();
		while (iter.getNext() != start){
			iter = iter.getNext();
		}
		iter.setNext(N);
		for(int i = 0; i < N.sizeFromNode(); i++){
			iter = iter.getNext();
		}
		iter.setNext(start);
    }
    
    /* Method addMultiAtStart: 
     *      Similar to addAtStart
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtStart(Node<T> N) {
		//the process is the exact same as the add multi at end, except we have one extra step of updating the start to be the new node 
		this.addMultiAtEnd(N);
		this.start = N;
    }
    
    /* Method addMultiAtLocation: 
     *      Similar to addAtLocation
     *      But adds N along with its possible sequence of following nodes
     ********************************************************************/
    public void addMultiAtLocation(Node<T> N, int n) {
        if (n > size){
			System.out.println("location is not within the list");
			System.exit(1);
		}
		else{
			size+= N.sizeFromNode();
			Node<T> iter = start;
			//go to the location you're going to be adding after
			for(int i = 1; i < n; i++){
				iter = iter.getNext();
			}
			//set the next node to be our new node 
			Node<T> temp = iter.getNext();
			iter.setNext(N);
			//iterate through the links that the node is connected to
			for (int i = 0; i < N.sizeFromNode(); i++){
				iter = iter.getNext();
			}
			//set the pointer of the last node of the sequence to point to the node after n
			iter.setNext(temp);
		}
    }   
    
    // REMOVING NODES OR SEQUENCES OF NODES ////////////////////////////////

    /* Method removeStart: 
     *      Removes the start node
     *      Makes the next node in sequence the start
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeStart() {
		//removing one from a list that only has one in it will make the list null
		if(size <= 1){
			start = null;
			start.setNext(null);
			size--;
		}
        else {
			Node<T> iter = start;
			//go to the end of the list and set the last node's next to be the one next of start. start then becomes the node next to the last node
			while (iter.getNext() != start){
				iter = iter.getNext();
			}
			iter.setNext(start.getNext());
			start = iter.getNext();
			size--;
			if(size == 1){
				start.setNext(start);
			}
		}
    }
    
    /* Method removeLast: 
     *      Removes the node just before start in the circle (i.e., the last node)
     *  Notes: 1/ take into account the case where the list is empty or 
     *      has only one node
     *      2/ do not forget to update the value of size
     ********************************************************************/
    public void removeLast() {
		if (size < 1){
			System.out.println("There are no nodes to remove");
			System.exit(1);
		}
        else if(size == 1){
			this.start = null;
			start.setNext(null);
			size--;
		}
        else {
			//go to the second to last node in the list, set the pointer to the first node in the list
			Node<T> iter = start;
			while (iter.getNext().getNext() != start){
				iter = iter.getNext();
			}
			iter.setNext(start);
			size--;
			if(size == 1){
				start.setNext(start);
			}
		}
    }
    
    /* Method removeNode: 
     *      Takes a node N
     *      Removes this node N from the list if it is in the list
     *  Notes: 1/ take into account the case where N is not in the list,
     *      or the list is empty 
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeNode(Node<T> N) {
		if(size < 1 ){
			System.out.println("There are no nodes to remove");
			System.exit(1);
		}
        boolean notFound = true;
		Node<T> iter = start;
		//if the node is the first one in the list, we can just user remove start
		if(N == start){
			this.removeStart();
		}
		else{
			//goes through and compares each node to the one it's looking for. If it finds it, we remove it
			while(iter.getNext() != start && notFound)
			{
				if(iter.getNext() == N){
					iter.setNext(iter.getNext().getNext());
					size--;
					notFound = false;
				}
				iter = iter.getNext();
			}
			if(notFound){
				System.out.println("Did not find node");
			}
		}
    }
    
    /* Method removeLocation: 
     *      Takes an integer n
     *      Removes the n-th node from the list if there is such a node
     *  Notes: 1/ take into account the case there are fewer nodes than n
     *      in the list
     *      2/ do not forget to update the value of size if relevant
     ********************************************************************/
    public void removeLocation(int n) {
		try{
			if (n > size){
				throw new RuntimeException("Node not in list");
			}
			//if we remove node 1, we're basically just removing the start
			if(n == 1){
				this.removeStart();
			}
			//go through the list to the node right before the one being removed, and set it's next to the node after the 
			else {
				Node<T> iter = this.start;
				int i = 1;
				while(i < n-1){
					iter = iter.getNext();
					i++;
				}
				Node<T> temp = iter.getNext();
				iter.setNext(temp.getNext());
				size--;
			}
		}catch (RuntimeException e){
			System.out.println("The given node is not in the list");
			System.exit(1);
		}
    }
    
    // PRINTING THE CONTENT OF A CLIST //////////////////////////////////
    /* Method print: 
     *      Prints every element of the circle once
     *      Prints "There is nothing to print" if the list is empty
     ********************************************************************/
    public void print() {
        if (size <= 0)
			System.out.println("There is nothing to print");
		else
		{
			Node<T> iter = start;
			System.out.println(iter.getData());
			iter = iter.getNext();
			while (iter != start && iter != null){
				System.out.println(iter.getData());
				iter = iter.getNext();
			}
		}
		
    }
    
    /*******************************************************************/
    /* Method: ChildrenRonde: 
     * It applies to a circular linked list and takes an integer s 
     *      (given a CList L, you will call it as L.ChildrenRonde(s)). 
     * It successively removes every s-th child from the circle until 
     *      only one child is left. 
     * It does not return anything, but it directly modifies the list 
     *      of children, which contains only one child at the end of 
     *      the game, the winner. 
     * NOTE: make sure to handle special cases like when the list may
     *      be empty
     * ALSO: if the list contains only one element, print out:
     *      "There is only one element remaining: "
     *      and then print the node (its content) using the appropriate
     *      method
     *******************************************************************/
    public void ChildrenRonde(int s) {
		Node<T> iter = start;
		//The first time has slightly different rules than every time afterwards, we need to go s-1 places. This first if statement just makes sure the list at least has 2 elements in it and then it removes the first one
		if (s < 1){
			System.out.println("Invalid step size, please try again");
			System.exit(1);
		}
		if (size >= 2){
			for(int i = 1; i < s; i++){
				iter = iter.getNext();
			}
			removeNode(iter);
		}
		//Every time after the first we need to go s places so this while statement will play the rest of the game 
        while(size > 1){
			for(int i = 0; i < s; i++){
				iter = iter.getNext();
			}
			removeNode(iter);
		}
		System.out.println("\nThere is only one child remaining");
		this.print();
    }

}