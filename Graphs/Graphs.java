import java.util.*;

class Queue {
	public int[] queue;
	public int size, front, rear;
	
	public Queue(int x)
	{
		size = x;
		queue = new int[size];
		front = -1;
		rear = 0;
	}
	
	public int pop()
	{
		if(front < rear)
		{
			System.out.println("Underflow");
			return -1;
		}
		else
		{
			return(queue[rear++]);
		}
	}
	
	public void push(int value)
	{
		if(front >= size)
		{
			System.out.println("Overflow");
		}
		else
		{
			front++;
			queue[front] = value;
		}
	}
	
	public boolean isempty()
	{
		if(front < rear)
			return true;
		else
			return false;
	}
	
}

class BFS{
	
	public Queue Q;
	public int[] edgeTo;
	public boolean[] visited;
	
	public BFS(int size)
	{
		Q = new Queue(size);
		edgeTo = new int[size];
		visited = new boolean[size];
	}
	
	public void bfs(Graphs G, int s)
	{
		Q.push(s);
		visited[s] = true;
		while(!Q.isempty())
		{
			int vertex = Q.pop();
			for(int w : G.adj(vertex))
			{
				if(!visited[w])
				{
					Q.push(w);
					visited[w] = true;
					edgeTo[w] = vertex;
				}
			}
		}
	}
	
	public void display(Graphs G)
	{
		for(int i = 0;i < G.V();i++)
		{
			System.out.println(i + "-->" + edgeTo[i]);
		}
	}
}

class DFS{
	public int[] edgeTo;
	public boolean[] visited;
	
	public DFS(int size)
	{
		edgeTo = new int[size];
		visited = new boolean[size];
	}
	
	public void dfs(Graphs G, int s)
	{
		visited[s]=true;
		for(int j: G.adj(s))
		{
			if(!visited[j])
			{
				visited[j]=true;
				edgeTo[j]=s;
				dfs(G,j);
			}
		}
	}
	
	public void display(Graphs G)
	{
		for(int i = 0;i < G.V();i++)
		{
			System.out.println(i + "-->" + edgeTo[i]);
		}
	}
}

public class Graphs {
	private int vertices;
	public ArrayList<Integer>[] adj;
	public static BFS B;
	public static DFS D;
	
	public Graphs(int V)
	{
		vertices = V;
		adj = new ArrayList[vertices];
		for(int i=0;i<vertices;i++)
		{
			adj[i]= new ArrayList<Integer>();
		}
		
		B = new BFS(V);
		D = new DFS(V);
	}
	
	public void addEdge(int v, int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	
	public int V()
	{
		return vertices;
	}
	
	public static void main(String[] args)
	{
		Graphs G = new Graphs(5); 
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 2);
		G.addEdge(1, 4);
		G.addEdge(2, 3);
		G.addEdge(2, 4);
		
		D.dfs(G, 0);
		D.display(G);
		B.bfs(G, 0);
		B.display(G);
	}

}


