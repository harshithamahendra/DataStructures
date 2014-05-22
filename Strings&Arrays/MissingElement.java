/*
 * There is an array of non-negative integers. A second array is formed by shuffling the elements of the
 *  first array and deleting a random element. Given these two arrays, find which element is missing in 
 *  the second array.
 *  Solution: Perform an XOR operation on all the elements in the first array. XOR the result with all the 
 *  elements of the second array. The result will be the missing element since XOR of two equal numbers is 0.
 */

public class MiissingElement {
	public static void main(String[] args){
		int[] arr1 = {2,3,4,8,5,6,3};
		int[] arr2=  {2,5,8,3,6,4};
		int sum1= arr1[0];
		for(int i = 1;i < arr1.length; i++)
			sum1 ^= arr1[i];
		for(int j = 0; j < arr2.length; j++)
			sum1 ^= arr2[j];
		System.out.println(sum1);
	}

}
