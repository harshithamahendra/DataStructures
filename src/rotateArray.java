import java.util.*;
import java.io.*;


 
public class rotateArray {
	public static int[][] a={{1,2,3},
							{4,5,6},
							{7,8,9}};
	
	public static void main(String args[])
	{
		int m= a.length;
		int n= a[0].length;
		
		for(int j=0;j<n;j++)
		{
			for(int i=m-1;i>=0;i--)
			{
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("\n");

		}
		
		int temp, min = 0;
		int max = a.length - 1;
		while(min < max){
			for(int i = min; i < max;i++)
			{
				temp = a[min][i];
				a[min][i] = a[i][max];
				a[i][max] = a[max][max - i];
				a[max][max - i] = a[max - i][min];
				a[max - i][min] = temp;
			}
			min++;
			max--;
		}
		for(int i = 0;i < a.length;i++){
			for(int j = 0;j < a.length;j++){
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
}
