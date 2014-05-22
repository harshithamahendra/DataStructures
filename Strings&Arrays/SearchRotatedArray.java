/*
 * Given a sorted array of n integers that has been rotated an unknown number of times, give an O(log n) 
 * algorithm that finds an element in the array. You may assume that the array was originally sorted in 
 * increasing order.
 */
import java.io.*;
import java.util.StringTokenizer;
public class SearchRotatedArray {
	public static int array[];
	public static int key;
	public static int size;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		System.out.println("Enter the size of the array");
		size = Integer.parseInt(br.readLine());
		array = new int[size];
		System.out.println("Enter the elements of the array");
		StringTokenizer tr = new StringTokenizer(br.readLine());
		while(tr.hasMoreTokens())
			array[i++] = Integer.parseInt(tr.nextToken());
		System.out.println("Enter the number to be searched");
		key = Integer.parseInt(br.readLine());
		if(search(array,0,size - 1,key))
			System.out.println("Element found");
		else
			System.out.println("Element not found");
	}
	public static boolean search(int[] a, int low, int high, int key){
		int mid;
		while(low <= high){
			mid = (high + low)/2;
			if(key == mid)
				return true;
			else if(a[low] <= a[mid]){
				if(key > a[mid])
					low = mid + 1;
				else if(key >= a[low])
					high = mid - 1;
				else
					low = mid + 1;
			}
			else if(key >= a[low])
				high = mid - 1;
			else if(key > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}
		return false;
	}
}
