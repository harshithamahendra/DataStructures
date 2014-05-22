//Rotate array by 90 degree
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
	}
}
