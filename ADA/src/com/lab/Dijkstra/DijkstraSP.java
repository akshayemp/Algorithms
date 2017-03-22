package com.lab.Dijkstra;

import java.util.ArrayList;
import java.util.Stack;

import com.lab.dfs.Graph;

public class DijkstraSP {
	public static boolean[] visited;
	public static Stack<Integer> stack = new Stack<Integer>();
	public static int[][] costMatrix;
	public static int totalCost;

	public DijkstraSP(Graph G) {
		visited = new boolean[G.V()];
		costMatrix = new int[G.V()][G.V()];
		setInitCost(costMatrix, G.V());
	}

	public void setInitCost(int[][] costMatrix, int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				costMatrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}

	public void dijkstra(Graph G, int source, int destination) {
		stack.push(source);

		int[] costObject = new int[2];
		int currentCost = 0;
		do {

			costObject = updateCostMatrixAndGetMax(costMatrix, source, G.getEdgeWeightMatrix(source), G.adj(source),
					currentCost);
			source = costObject[0];
			currentCost = costObject[1];
			stack.push(costObject[0]);
		} while (costObject[0] != destination);
	}

	public static int[] updateCostMatrixAndGetMax(int[][] costMatrix, int v, ArrayList<Integer> edgeList,
			Iterable<Integer> adj, int current) {
		int i = 0;
		int[] temp = new int[2];
		visited[v] = true;
		temp[1] = Integer.MAX_VALUE;
		int save = v;
		int tempV = Integer.MAX_VALUE;
		for (int e : adj) {
			if (visited[e] != true) {
				int edgeCost = edgeList.get(i);
				if (tempV > current + edgeCost) {
					tempV = current + edgeCost;
					save = e;
				}
				i++;
			}
		}
		temp[0] = save;
		temp[1] = tempV;
		return temp;
	}

	public static void main(String args[]) {
		Graph G = new Graph(5);
		G.addEdge(0, 1, 3);
		G.addEdge(0, 3, 1);
		G.addEdge(1, 2, 1);
		G.addEdge(1, 3, 1);
		G.addEdge(3, 2, 4);
		DijkstraSP dsp = new DijkstraSP(G);
		dsp.dijkstra(G, 0, 2);
		System.out.println("Path printed in reverse order:");
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
