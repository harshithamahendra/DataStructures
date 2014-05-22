/*
 * Given a matrix in which each row and each column is sorted, write a method to find an element in it.
 */
import java.io.*;
public class BinarySearchArray {
	public static int[][] array = {	{1, 2, 3},
									{4, 5, 6},
									{7, 8, 9} };
	public static int key;
	public static void main(String[] args)throws IOException{
		System.out.println("Enter the element to search");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		key = Integer.parseInt(br.readLine());
		if(search(array,key,array.length,array[0].length))
			System.out.println("Element found");
		else
			System.out.println("Element not found");
	}
	public static boolean search(int[][] a, int key, int M, int N){
		int i = M - 1;
		int j = 0;
		while(i >= 0 && j < N){
			if(a[i][j] == key)
				return true;
			else if(a[i][j] > key)
				i--;
			else
				j++;
		}
		return false;
	}
}
