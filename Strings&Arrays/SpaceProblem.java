import java.util.*;
import java.io.*;

public class SpaceProblem {
	
	public static String input="Mr John Smith    ";
	public static void main(String args[])
	{
		char[] s=input.toCharArray();
		int i= s.length-1;
		System.out.println(s);
		
		while(s[i]==' ')
		{
		i--;	
		}
		
		int j=s.length-1;
		while(i>0)
		{
			if(s[i]==' ')
			{
				s[j]='0';
				s[j-1]='2';
				s[j-2]='%';
				j=j-3;
				i=i-1;
			}
			else
			{
				s[j]=s[i];
				j--;
				i--;
				      
			}
		}
		
		System.out.println(s);
		
		
		
	}

}
