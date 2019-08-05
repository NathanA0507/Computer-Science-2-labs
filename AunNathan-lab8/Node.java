/*
*	This is the node class used in this lab. For this lab we are only taking 
*	integers, so we do not need to use the general type.
*/
public class Node{

    private int data;
    private Node next;
    
    // Constructors ****************************************************************
    public Node() {}
    
    public Node(int d) {
        data = d;
        next = null;
    }
    
    // Setters *********************************************************************
    public void setData(int d) {
        data = d;   
    }
    
    public void setNext(Node N) {
        next = N;
    }
    
    // Getters **********************************************************************
    public int getData() {
        return data;   
    }
    
    public Node getNext() {
        return next;   
    }
    
   
}