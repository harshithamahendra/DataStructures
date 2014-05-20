import java.util.*;
public class BST {
	
	public BST()
	{
		root=null;
	}
	protected BSTnode root;
	
	public void add(Comparable value)
	{
		root = add(root, value);
	}
	
	public BSTnode add(BSTnode node, Comparable data)
	{
		if(node==null)
		{
			node= new BSTnode(data);
			return node;
		}
		
		else if(data.compareTo(node.value)<0)
				node.left= add(node.left, data);
			else 
				node.right=add(node.right, data);
			return node;
	}
	
	public boolean search(Comparable value)
	{
		return search(root,value);
	}
	
	public boolean search(BSTnode node, Comparable value)
	{
		while(node!=null)
		{
		 if(value.compareTo(node.value)<0)
			node=node.left;
		else if(value.compareTo(node.value)>0)
			node=node.right;
		 else
			 break;
		}
	return (node!=null)?true:false;
	}
	
	public static void main(String[] args)
	{
		BST tree= new BST();
		tree.add(8);
		tree.add(3);
		tree.add(4);
		tree.add(9);
		if(tree.search(4))
			System.out.println("Element found");
		else
			System.out.println("Element not found");
	}
}


 class BSTnode{
	Comparable value;
	BSTnode left;
	BSTnode right;
	
	public BSTnode(Comparable data){
		this.value=data;
		this.left=this.right=null;
		//BST root= null;
	}
 }

