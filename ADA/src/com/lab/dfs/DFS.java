package com.lab.dfs;

import java.util.Stack;

public class DFS {

	public boolean[] visited;
	public static Stack<Integer> stack = new Stack<Integer>();

	public DFS(Graph G, int s) {
		visited = new boolean[G.V()];
		dfs(G, s);
	}

	private void dfs(Graph G, int v) {
		visited[v] = true;
		stack.push(v);
		for (int w : G.adj(v)) {
			if (!visited[w])
				dfs(G, w);
		}
	}
	
	public boolean visited(int w){
		return visited[w];
	}
	
	
	public static void main(String args[]){
		Graph G = new Graph(6);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(1, 4);
		G.addEdge(2, 5);
		DFS dfSearch = new DFS(G,1);
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}

	}
}
