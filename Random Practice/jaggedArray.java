

public class jaggedArray{
	public static void main(String args[]){
		int[][] a = {{ 5, 10, 15, 20}, {2, 3, 4}, {5, 3, 2, 1}};
		int[][] b = {{2, 2}, {3, 3}, {4, 4}};
		System.out.println(isJagged(a));
		System.out.println(isJagged(b));
	}
	
	public static boolean isJagged(int[][] a){
		for (int i = 0; i < a.length-1; i++){
			if (a[i].length != a[i+1].length)
				return true;
		}
		return false;
	}
}