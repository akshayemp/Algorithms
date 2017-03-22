package com.lab.binary.tree;

import java.util.Arrays;

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		left = null;
		right = null;
		this.data = data;
	}
}

public class BinaryTree {

	Node root;

	public BinaryTree() {
		root = null;
	}

	public void insert(int data) {
		root = insert(root, data);
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;

	}

	public Boolean search(Node node, int data) {
		if (node == null) {
			return false;
		}
		if (data == node.data) {
			return true;
		}
		if (data < node.data) {
			return search(node.left, data);
		} else {
			return search(node.right, data);
		}

	}
	
	public static void inorder(Node root){
		if(root == null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + ", ");
		inorder(root.right);
		
	}

	public static void main(String... args) {
		int[] array = { 3, 2, 6, 4, 55, 23, 76, 21, 0 };
		BinaryTree binaryTree = new BinaryTree();

		for (int i = 0; i < array.length; i++) {
			binaryTree.insert(array[i]);

		}
		System.out.println(Arrays.toString(array));
		System.out.println("Sorted Array using inorder traversal: ");
		System.out.print("[");
		inorder(binaryTree.root);
		System.out.print("]");
		
		System.out.println("\n"+"Is 76 in tree: "+binaryTree.search(binaryTree.root, 76));
		System.out.println("Is 2 in tree: "+binaryTree.search(binaryTree.root, 2));
		System.out.println("Is 0 in tree: "+binaryTree.search(binaryTree.root, 0));
		System.out.println("Is 13 in tree: "+binaryTree.search(binaryTree.root, 13));
	}
}
