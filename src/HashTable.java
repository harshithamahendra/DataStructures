import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.io.*;

public class HashTable{
	public static HashMap<String, Integer> h= new HashMap<String, Integer>();
	public static void main(String args[])
	{
		add("A", 1);
		add("B", 2);
		add("C", 3);
		add("D", 4);
		add("E", 5);
		h.put("D",h.get("D")+1);
		h.remove("A");
		Set set= h.keySet();
		Iterator i= set.iterator();
		
		while(i.hasNext())
		{
			Object index= i.next();
		System.out.print(index+"\t");
		System.out.println(h.get(index));
		}
		
		
	}
	
	public static void add(String key, int value)
	{
		h.put(key, value);
	}
}
