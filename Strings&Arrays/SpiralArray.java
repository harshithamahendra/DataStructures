/* Display an NxN array in a spiral fashion */
import java.io.*;
import java.util.*;

public class SpiralArray {
	public static void main(String[] args)
	{
		char[][] a = new char[][]{	{'i',	'l', 	'o', 	'v', 	'e' },
									{'d',	'i', 	'n', 	't', 	'e' },
									{'n', 	'e', 	'w', 	'e', 	'p' }, 
									{'a', 	'i', 	'v', 	'r', 	'i' }, 
									{'m',	'a', 	'x', 	'e', 	'c' } };
		
		int max =a.length-1;
/*		int max = a.length-1;
*/		int min = 0;
/*		int min = 0;
*/		
		while(min != max || min != max)
		{
			for(int j = min;j <= max;j++)
				System.out.print(a[min][j]);
			
			for(int i = min + 1;i <= max;i++)
				System.out.print(a[i][max]);
			
			for(int j = max - 1;j >= min; j--)
				System.out.print(a[max][j]);
			
			for(int i = max - 1;i > min;i--)
				System.out.print(a[i][min]);
			
/*			max--;
*/			max--;
/*			min++;
*/			min++;
			
		}
		
		System.out.print(a[min][min]);
	}
}
