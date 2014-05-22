/* One of the keys from 0-9 on the keyboard isn't working. Given the actual password and expected password for the user, check if the actual password is valid considering the flaw in the keyboard. For exmaple, if key 8 is not working, if the user input is read as 164 and the expected password is 18684, it should be a valid password.
*/
import java.util.*;
import java.io.*;

public class MissingKey {
	public static void main(String[] args) throws IOException
	{
		 String str1,str2;
		 int out1,out2;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Enter the expected string");
		 str1 = br.readLine();
		 out1 = Integer.parseInt(String.valueOf(str1.charAt(0)));
		 for(int i = 1;i < str1.length();i++)
		 {
			 out1 ^= Integer.parseInt(String.valueOf(str1.charAt(i)));
			 
		 }
		 
		 System.out.println("Enter the actual string");
		 str2 = br.readLine();
		 out2 = Integer.parseInt(String.valueOf(str2.charAt(0)));
		 for(int i = 1;i < str2.length();i++)
		 {
			 out2 ^= Integer.parseInt(String.valueOf(str2.charAt(i)));
			 
		 }
		 if(out1 == out2)
			 System.out.println("Valid");
		 else
			 System.out.println("Invalid");
		 
	}

}
