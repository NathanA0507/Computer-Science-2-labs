
public class Execute{
	public static void main(String[] args){
		System.out.println("This is a stack implemented via a linked list");
		Node top = new Node(1);
		StackL Stack1 = new StackL(top);
		Stack1.push(2);
		Stack1.push(3);
		Stack1.push(4);
		Stack1.push(5);
		int temp = Stack1.getSize();
		for(int i = 0; i < temp; i++){
			System.out.println(Stack1.peek());
			Stack1.pop();
		}
		Stack1.pop();
		System.out.println(Stack1.peek());
		for(int i = 0; i < 100; i++){
			Stack1.push(i);
		}
		System.out.println(Stack1.peek());
		Stack1.clear();
		System.out.println(Stack1.peek());
		
		System.out.println("\nThis is a stack implemented via an array");
		StackA Stack2 = new StackA(100);
		
		for(int i = 0; i < 100; i++){
			Stack2.push(i);
		}
		Stack2.push(100);
		Stack2.pop();
		System.out.println(Stack2.peek());
		Stack2.push(3000);
		System.out.println(Stack2.peek());
		Stack2.clear();
		Stack2.pop();
		Stack2.peek();
		
		System.out.println("\nThis is a queue implented as an array");
		QueueA Queue1 = new QueueA(100);
		for(int i = 0; i < 100; i++){
			Queue1.enqueue(i);
		}
		System.out.println(Queue1.peek());
		System.out.println(Queue1.dequeue());
		Queue1.clear();
		System.out.println(Queue1.dequeue());
		Queue1.peek();
		
		System.out.println("\nThis is a queue implemented as a linked list");
		QueueL Queue2 = new QueueL(top);
		for(int i = 0; i < 100; i++){
			Queue2.enqueue(i);
		}
		System.out.println(Queue2.peek());
		System.out.println(Queue2.dequeue());
		Queue2.clear();
		System.out.println(Queue2.dequeue());
		Queue2.peek();
		
	}
}