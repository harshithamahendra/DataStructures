/*
 * Given an integer array, output all pairs that sum up to a specific value k. 
 */
import java.util.*;
public class ArrayPairSum {
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		findPairSum(arr, 6);
		
	}
	
	public static void findPairSum(int[] arr, int k){
		Set<Integer> seen = new HashSet<Integer>();
		for(int i = 0; i < arr.length;i++){
			int num = k - arr[i];
			if(!(seen.contains(arr[i]))){
				seen.add(num);
			}
			else
				System.out.println("(" + arr[i] + "," + num + ")");
		}
	}

}
