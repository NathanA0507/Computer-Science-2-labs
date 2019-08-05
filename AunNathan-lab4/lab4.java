public class lab4 {

    // Merge sort 
	// Taken from https://www.geeksforgeeks.org/merge-sort/
    public static void merge(int arr[], int l, int m, int r) 
    { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    public static void mergeSort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(arr, l, m); 
            mergeSort(arr , m + 1, r); 
  
            // Merge the sorted halves 
            merge(arr, l, m, r); 
        } 
    } 
        
    // Quick sort 
	//taken from https://www.geeksforgeeks.org/quick-sort/
    public static int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr[j] <= pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    public static void quickSort(int arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 
    
    // Your chosen quadratic sorting algorithm
	//taken from https://www.geeksforgeeks.org/bubble-sort/
    public static void bubbleSort(int arr[]) 
    { 
        int n = arr.length; 
		boolean swap = false;
        for (int i = 0; i < n-1; i++) {
			swap = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
					swap = true;
                } 
			}
			if (!swap)
				break;
		}
    } 
    
    
    // Proposed combination algorithm
    public static void proposedAlgo (int[] A, int l, int r) {
		
		//This method combines bubble sort and merge sort, where it does merge sort until the arrays are size 3, at that point they will do bubble sort
        if (l < r){
			
			int m = ((l + r) / 2);
			
			if (r - l > 4){
				proposedAlgo(A, l, m);
				proposedAlgo(A, m + 1, r); 
			}
			//This method does bubble sort, and it only does it if the size of the sub-array is 3 or less
			if (r - l <= 4){
				boolean swap = false;
				int n = r - l; 
				for (int i = 0; i < n; i++){
					swap = false;
					for (int j = l; j < r-i; j++){ 
						if (A[j] > A[j+1]) 
						{ 
							// swap arr[j+1] and arr[i] 
							int temp = A[j]; 
							A[j] = A[j+1]; 
							A[j+1] = temp; 
							swap = true;
						} 
			
			
					}
					if (!swap)
						break;
				}
			}
			merge(A, l, m, r);	
		}
    }
	
	//This method copies the array in order to test all the different sorting algorithms in one run of the program
	public static int[] copyArray(int[] A){
		int[] B = new int[A.length];
		for (int i = 0; i < A.length; i++)
			B[i] = A[i];
		return B;
	}
	
	//This method prints the sorted array, used only in testing
	public static void printArray(int[] A){
		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");
	}
	
	//This method goes through and creates all 5 of my test cases.
	public static int[] createArray(int k){
		int[] arr = new int[10000];
		//Case 1 randomly generates an array of 1000 values
		if (k == 1){
			for (int i = 0; i < arr.length; i++)
				arr[i] = (int)(Math.random() * 100);
		}
		//Case 2 gives an already sorted array
		if (k == 2){
			for (int i = 0; i < arr.length; i++)
				arr[i] = i;
		}
		//Case 3 gives a sorted array in descending order
		if (k == 3){
			int j = 0;
			for (int i = arr.length-1; i >= 0; i--){
				arr[j] = i;
				j++;
			}
		}
		//Case 4 gives a half sorted array
		if (k == 4){
			for (int i = 0; i < arr.length/2; i++)
				arr[i] = i;
			for (int i = arr.length/2 + 1; i < arr.length; i++)
				arr[i] = (int)(Math.random() * 10000) + (arr.length/2);
		}
		//Case 5 gives an array that is sorted in ascending in Q1 and Q3 and sorted in descending in Q2 and Q4
		if (k == 5){
			int j = arr.length / 4;
			for (int i = 0; i < arr.length/4; i++)
				arr[i] = i;
			for (int i = arr.length/4 + 1; i < arr.length/2; i++){
				arr[i] = j;
				j--;
			}
			for (int i = arr.length / 2; i < 3 * (arr.length / 4); i++){
				j++;
				arr[i] = j;
			}
			for (int i = 3 * (arr.length / 4); i < arr.length; i++){
				arr[i] = j;
				j--;
			}
		}
		
		return arr;
			
	}
	
	// Main method
    public static void main (String[] args) {
        
		int[] arr = createArray(Integer.parseInt(args[0])); //args[0] is the test case we want
		
		printArray(arr);
		System.out.println("\n");

		//this block just runs each sorting algorithm and prints their time
		long time = System.nanoTime();
		proposedAlgo(copyArray(arr), 0, arr.length - 1);
		time = System.nanoTime() - time;
		System.out.println("Proposed Algo: " +time +" ns");
		time = System.nanoTime();
		mergeSort(copyArray(arr), 0, arr.length-1);
		time = System.nanoTime() - time;
		System.out.println("Merge Sort:    " +time +" ns");
		time = System.nanoTime();
		quickSort(copyArray(arr), 0, arr.length-1);
		time = System.nanoTime() - time;
		System.out.println("Quick Sort:    " +time +" ns");
		time = System.nanoTime();
		bubbleSort(copyArray(arr));
		time = System.nanoTime() - time;
		System.out.println("Bubble Sort:   " +time +" ns");
	}
}