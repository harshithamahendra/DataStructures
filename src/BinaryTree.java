import java.util.*;
public class BinaryTree{
	Tree root;
	BinaryTree(){
		root = null;
	}

	/*
	 * Adding nodes to the tree
	 */
	public void add(int value){
		root = add(root,value);
	}

	public Tree add(Tree node, int value){
		if(node == null){
			node = new Tree(value);
			return node;
		}
		else{
			if(value < node.value)
				node.left = add(node.left, value);
			else
				node.right = add(node.right, value);
		}
		return node;
	}
	/*
	 * Display level order of tree
	 */
	public void displayLevelOrder(){
		int size = countNode(root);
		int currentLevel, nextLevel = 0;
		Q q = new Q(size);
		q.push(root);
		currentLevel = 1;
		while(!(q.isempty())){
			Tree node = q.pop();
			currentLevel--;
			System.out.print(node.value + " ");
			if(node.left != null){
				q.push(node.left);
				nextLevel++;
			}
			if(node.right != null){
				q.push(node.right);
				nextLevel++;
			}
			if(currentLevel == 0){
				System.out.println();
				currentLevel = nextLevel;
				nextLevel = 0;
			}
		}
		//Display the queue from front to get the reverse level order traversal of the tree
		System.out.println("Reverse level order traversal of the tree");
		for(int i = q.front; i >= 0; i--)
			System.out.println(q.queue[i].value);
	}
	/* 
	 * Display left, root, right
	 */
	public void displayInorder(Tree node){
		if(node == null){
			return;
		}
		displayInorder(node.left);
		System.out.println(node.value);
		displayInorder(node.right);
		return;
	}

	/*
	 * Display root, left, right
	 */
	public void displayPreOrder(Tree node){
		if(node == null){
			return;
		}
		System.out.println(node.value);
		displayPreOrder(node.left);
		displayPreOrder(node.right);
		return;
	}

	/*
	 * Display left, right, root
	 */
	public void displayPostOrder(Tree node){
		if(node == null){
			return;
		}
		displayPostOrder(node.left);
		displayPostOrder(node.right);
		System.out.println(node.value);
		return;
	}
	/*
	 * Trim BST - Given min and max trim the tree so that all nodes has values between min and max
	 */
	public Tree trimTree(Tree node, int min, int max){
		if(node == null)
			return null;
		node.left = trimTree(node.left, min, max);
		node.right = trimTree(node.right, min, max);
		if(node.value < min)
			return node.right;
		else if(node.value > max)
			return node.left;
		else
			return node;
	}

	/*
	 * Find the number of nodes
	 */
	public int countNode(Tree node){
		int count;
		if(node == null)
			return 0;
		else{
			count = 1 + countNode(node.left) + countNode(node.right);
			return count;
		}
	}

	/*
	 * Calculate the height of the tree
	 */
	public int height(Tree node){
		int height;
		if(node == null)
			return 0;
		else{
			height = 1 + Math.max(height(node.left) , height(node.right));
			return height;
		}

	}
	/*
	 * check if the tree is a binary search tree
	 */
	public boolean ifBST(Tree node, int min, int max){
		if(node == null)
			return true;
		if(!(node.value >= min  && node.value <= max))
			return false;
		return ifBST(node.left, min, node.value) && ifBST(node.right, node.value, max);
	}

	public static void main(String[] args){
		BinaryTree B1 = new BinaryTree();
		B1.add(10);
		B1.add(5);
		B1.add(13);
		B1.add(12);
		B1.add(4);
		B1.add(7);
		B1.add(14);
		B1.add(20);
		B1.add(1);
		B1.add(0);
		System.out.println("Inorder traversal:");
		B1.displayInorder(B1.root);
		System.out.println("Preorder traversal:");
		B1.displayPreOrder(B1.root);
		System.out.println("Postorder traversal:");
		B1.displayPostOrder(B1.root);
		System.out.println("Level order Traversal:");
		B1.displayLevelOrder();
		B1.root = B1.trimTree(B1.root,4,10);
		B1.displayPostOrder(B1.root);
		int height = B1.height(B1.root);
		System.out.println("The hieght of the tree is " + height);
		if(B1.ifBST(B1.root, Integer.MIN_VALUE, Integer.MAX_VALUE))
			System.out.println("The tree is a Binary search tree");
		else
			System.out.println("The tree is not a Binary search tree");
	}
}

class Tree{
	int value;
	Tree left, right;
	Tree(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class Q{
	public int rear,front;
	public Tree[] queue;
	public Q(int size){
		rear = 0;
		front = -1;
		queue = new Tree[size];

	}
	public Tree pop(){
		if(front < rear){
			System.out.println("Empty");
			return null;
		}
		return queue[rear++];
	}
	public void push(Tree node){
		if(front == queue.length - 1)
			System.out.println("Queue full");
		queue[++front] = node;
	}
	public boolean isempty()
	{
		if(front < rear)
			return true;
		else
			return false;
	}
}