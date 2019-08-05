public class ExecuteWithArrays {

    public static int ChildrenRonde(int[] C, int s) {
		try{
			int temp = -1;
			int iter;
			int j;
			int k = 0;
			//This While loop will make sure that it will traverse "s" steps without repeated spots that have already been covered
			//We go to length-1 because we will always have that many times through the array to leave one value left
			while (k < C.length-1){
				iter = 1; 
				while (iter <= s){
					temp++;
					//If temp is greater than the length, we need to make it less than length to avoid exceptions
					if(temp >= C.length)
						temp = temp - C.length;
					if (C[temp] == 0)
						iter++;
				}
				//set temp to anything else so the computer will know this space has already been checked
				C[temp] = -1;
				k++;
			}
		
			//This loop checks to find the part of the array that is not filled 
			for (int i = 0; i < C.length; i++){
				if (C[i] == 0)
					return i + 1;
			}
		}catch(IndexOutOfBoundsException e){
			System.out.println("Index is out of bounds, please try a different number");
			System.exit(1);
		}
		return -1;
    }
    
    public static void main(String[] args) {
        int size = Integer.valueOf(args[0]);
        int step = Integer.valueOf(args[1]);
        int[] children = new int[size];
        int last = ChildrenRonde(children, step);
        System.out.println(last);
    }
}