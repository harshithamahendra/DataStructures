import java.util.*;
import java.io.*;
public class UniqueChar {

	public static String string;
	public static ArrayList<Character> unique = new ArrayList<Character>();
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("Enter a string");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		string= br.readLine();
		boolean flag=true;
		for(int i=0;i<string.length();i++)
		{
			if(unique.contains(string.charAt(i)))
			{
				flag=false;
				break;
			}
			else
			{
				unique.add(string.charAt(i));
				
			}
		}
		
		if(flag==true)
		{
			System.out.println("String has unique characters");
		}
		else
		{
			System.out.println("System has repetitive characters");
		}
	}
}
