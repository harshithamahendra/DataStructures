import java.util.*;
import java.io.*;

public class StringCompression {
	
	public static String a="abcd";
	
	public static StringBuffer b = new StringBuffer();
	public static int count;
	public static void main(String args[])
	{
		
		System.out.println(a);
		System.out.println(compress(a,b));
		
	}
	
	public static String compress(String a,StringBuffer b)
	{
		int j=1;
		char c= a.charAt(0);
		count=1;
		
		 
		while(j<a.length())
		{
			
			if(a.charAt(j)==c)
			{
				
				count++;
				
			}
			else
			{
			
				b.append(c);
				b.append(count);
				if(b.length()>=a.length())
				{
					return a;
				}
				c=a.charAt(j);
				count=1;
				
			}
			j++;
		}
		b.append(c);
		b.append(count);
		return b.toString();
	}
	
	

}
