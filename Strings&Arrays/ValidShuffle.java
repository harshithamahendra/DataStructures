/*
 * We are given 3 strings: str1, str2, and str3. Str3 is said to be a shuffle of str1 and str2 if it can 
 * be formed by interleaving the characters of str1 and str2 in a way that maintains the left to right ordering 
 * of the characters from each string. Given 3 strings check if the str3 is a valid shuffle of str1 and str2
 */
public class ValidShuffle {
	public static void main(String[] args){
		String str1 = "abc";
		String str2 = "efg";
		String str3 = "abecfg";
		if(CheckValidity(str1.toCharArray(),str2.toCharArray(),str3.toCharArray()))
			System.out.println("String 3 is a valid shuffle");
		else
			System.out.println("String 3 is not a valid shuffle");
	}
	public static Boolean CheckValidity(char[] str1, char[] str2, char[] str3){
		int flag,pointer1 = 0;
		int pointer2 = 0;
		
		for(char c : str3){
			flag = 0;
			if(pointer1 < str1.length)
				if(c == str1[pointer1]){
					flag = 1;
					pointer1++;
				}
			if (pointer2 < str2.length){
				if(c == str2[pointer2]){
					flag = 1;
					pointer2++;
				}
			}
			if(flag == 0){
				System.out.println(pointer1 + " " + pointer2 + " " + c);
				return false;
				
			}
		}
		return true;
	}

}
