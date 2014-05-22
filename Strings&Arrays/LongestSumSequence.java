import java.util.*;

public class LongestSumSequence {
	public static void main(String[] args){
		int[] arr  = {-6, -10, -22};
		int maxSum = arr[0];
		int currentSum = arr[0];
		for(int i = 1;i < arr.length;i++){
			currentSum = Math.max(arr[i] + currentSum, arr[i]);
			maxSum = Math.max(currentSum, maxSum); 
		}
		System.out.println(maxSum);
	}
}
