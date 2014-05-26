
import java.util.*;

public class BinaryTree{
	Tree root;
	BinaryTree(){
		root = null;
	}
	// Used in printing the right/left view of the tree
	public static int maxLevel = 0;
	// To store to the tree in vertical order
	public static LinkedHashMap<Integer,ArrayList<Integer>> verticalOrder = new LinkedHashMap<Integer,ArrayList<Integer>>();

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
	/**
	 * calls printVerticalOrder(node, level) function that populates the verticalOrder LinkedHashMap
	 * and prints the vertical order of the tree
	 * @param root root of the tree
	 */
	public void printVerticalOrder(Tree root){
		printVerticalOrder(root,0);
		System.out.println("\nVertical Order: ");
		for(Integer i : verticalOrder.keySet()){
			for(Integer j : verticalOrder.get(i))
				System.out.print(j + " ");
			System.out.println();
		}
			
	}
	/**
	 * Populates the verticalOrder LinkedHashMap based on the distance of the node from the root
	 * decrement level by 1 on moving right from root and increment by 1 on moving left
	 * @param node Tree node, initialized to root
	 * @param level Distance from the root
	 */
	public static void printVerticalOrder(Tree node, int level){
		if(node == null)
			return;
		// Add the node to the hash map with its level as the key
		if(verticalOrder.get(level) == null)
			verticalOrder.put(level,new ArrayList<Integer>());
		verticalOrder.get(level).add(node.value);
		printVerticalOrder(node.left, level + 1); /*Increment by 1 if moving to the left*/
		printVerticalOrder(node.right, level - 1); /*Decrement by 1 if moving to the right*/
	}
	/**
	 * 
	 * @param node current node, initially the root
	 * @param level current level of node. Initialized to 1
	 * maxLevel maximum level of the tree seen so far
	 */
	public void printRightView(Tree node, int level){
		if(node == null)
			return;
		if(maxLevel < level){			/* print current node if a new level is reached */
			System.out.print(node.value + " ");
			maxLevel = level;
		}
		printRightView(node.right, level + 1);	/*traverse the right child first since we want to print the Tree's right view*/
		printRightView(node.left, level + 1);
	}
	/**
	 * 
	 * @param node current node, initially the target node
	 * @param level current level of node, initially 0
	 * @param k distance from target node
	 */
	public void printNodesAtDistK(Tree node, int level, int k){
		if(node == null || level > k)
			return;
		if(level == k)
			System.out.print(node.value + " ");
		printNodesAtDistK(node.left, level + 1, k);
		printNodesAtDistK(node.right, level + 1, k);
		
	}
	/**
	 * find Least Common Ancestor of values n1 and n2
	 * @param node Tree node, initialized to root
	 * @param n1,  value n1
	 * @param n2, value n2
	 * @return
	 */
	public Tree findLCA(Tree node, int n1, int n2){
		if(node == null)
			return null;
		if(node.value == n1 || node.value == n2)
			return node;
		Tree left_LCA = findLCA(node.left, n1, n2);
		Tree right_LCA = findLCA(node.right, n1, n2);
		if(left_LCA != null && right_LCA != null)
			return node;
		return (left_LCA != null)? left_LCA : right_LCA;
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
	 * Inorder traversal
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
	 * Preorder traversal
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
	 * Postorder traversal
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
		B1.add(2);
		System.out.println("Inorder traversal:");
		B1.displayInorder(B1.root);
		System.out.println("Preorder traversal:");
		B1.displayPreOrder(B1.root);
		System.out.println("Postorder traversal:");
		B1.displayPostOrder(B1.root);
		System.out.println("Level order Traversal:");
		B1.displayLevelOrder();
		System.out.println("Nodes at distance 2 from root:");
		B1.printNodesAtDistK(B1.root, 0, 2);
		B1.printVerticalOrder(B1.root);
		System.out.println("LCA of 2 and 7 is " + B1.findLCA(B1.root,2,7).value);
		System.out.println("\nTree after trimming:");
		B1.root = B1.trimTree(B1.root,4,10);
		B1.displayLevelOrder();
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