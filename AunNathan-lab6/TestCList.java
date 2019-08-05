public class TestCList{
	public static void main(String[] args){
		
		int size = 10;
        
        CList<Child> ronde = new CList<Child>();
        Child C;
        for (int i=0 ; i<size; i++) {
            C = new Child("child", i+1);  
            ronde.addDataAtEnd(C);
        }
        ronde.print();
		
		System.out.println("\nTesting Add at start method");
		C = new Child("Brad", 11);
		Node<Child> child = new Node<Child>(C);
		ronde.addAtStart(child);
		ronde.print();
		
		System.out.println("\nTesting Add location method");
		C = new Child("Greg", 12);
		child = new Node<Child>(C);
		ronde.addAtLocation(child, 3);
		ronde.print();
		
		
		System.out.println("\nTesting Mutliple to end method");
		Child X = new Child("Zack", 13);
		Child Y = new Child("Cody", 14);
		Child Z = new Child("Jeff", 15);
		child = new Node<Child>(X);
		Node<Child> child2 = new Node<Child>(Y);
		Node<Child> child3 = new Node<Child>(Z);
		child.setNext(child2);
		child2.setNext(child3);
		ronde.addMultiAtEnd(child);
		ronde.print();
		
		System.out.println("\n testing Multiple to start method");
		X = new Child("Jake", 16);
		Y = new Child("Jacob", 17);
		Z = new Child("Travis", 18);
		child = new Node<Child>(X);
		child2 = new Node<Child>(Y);
		child3 = new Node<Child>(Z);
		child.setNext(child2);
		child2.setNext(child3);
		ronde.addMultiAtStart(child);
		ronde.print();
		
		System.out.println("\n testing Multiple to location method");
		X = new Child("Ronald", 19);
		Y = new Child("Evan", 20);
		Z = new Child("Kevin", 21);
		child = new Node<Child>(X);
		child2 = new Node<Child>(Y);
		child3 = new Node<Child>(Z);
		child.setNext(child2);
		child2.setNext(child3);
		ronde.addMultiAtLocation(child, 4);
		ronde.print();
		
		System.out.println("\n testing remove start method");
		ronde.removeStart();
		ronde.print();
		
		System.out.println("\n testing remove end method");
		ronde.removeLast();
		ronde.print();
		
		System.out.println("\n testing remove location method");
		ronde.removeLocation(4);
		ronde.print();
		
		System.out.println("\n testing remove node method");
		ronde.removeNode(child2);
		ronde.print();
    }
}
