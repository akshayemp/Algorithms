package com.lab.dfs;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Graph {

	private final int V;
	private int E;

	private ArrayList<Integer>[] adj;
	private ArrayList<Integer>[] edgeWeights;

	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = new ArrayList[V];
		edgeWeights = new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Integer>();
			edgeWeights[v] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int v, int w) {

		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public void addEdge(int v, int w, int weight) {

		adj[v].add(w);
		adj[w].add(v);
		edgeWeights[v].add(weight);
		edgeWeights[w].add(weight);
		E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}
	

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public ArrayList<Integer> getEdgeWeightMatrix(int v) {
		return edgeWeights[v];
	}
}
