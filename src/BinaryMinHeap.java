import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BinaryMinHeap {

	private int arr[];
	private int size=0;
	
	public BinaryMinHeap(int n)
	{
		arr= new int[n];
		size=n;
	}
	
	// get the minimum element of the heap
	 public int getmin()
	{
		 if(isEmpty())
		 {
			 throw new HeapException("Heap empty");
		 }
		 else
			 return arr[0];
	}
	 
	 // index of left child
	 public int getLeftChildIndex(int i)
	 {
		 return (i*2+1);
	 }
	 
	// index of right child
	 public int getRightChildIndex(int i)
	 {
		 return (i*2+2);
	 }
	 
	 //Index of parent
	 public int getIndexParent(int i)
	 {
		 return ((i-1)/2);
	 }
	 
	 // check to see if the heap is empty
	 public boolean isEmpty()
	 {
		 return(size==0);
	 }
	 
	 public static void main(String[] args) throws NumberFormatException, IOException
	 {
		 System.out.println("Enter the number of elements in the heap");
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 int arraysize= Integer.parseInt(br.readLine());
		 
		 BinaryMinHeap bh = new BinaryMinHeap(arraysize);
		 
		 System.out.println("Enter the elements of the heap, level by level");
		 for(int i=0;i<bh.size;i++)
		 {
			 bh.arr[i]= Integer.parseInt(br.readLine());
		 }
		 
		 System.out.println("the minimun element is "+bh.getmin());
		 System.out.println("level 1 nodes are\n"+bh.arr[bh.getLeftChildIndex(0)]+"\t" +bh.arr[bh.getRightChildIndex(0)]);
		 
		 
		 
	 }
	 
	 public class HeapException extends RuntimeException{
		 public HeapException(String message){
			 super(message);
		 }
	 }
}
