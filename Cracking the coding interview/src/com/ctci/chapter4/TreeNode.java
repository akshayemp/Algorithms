package com.ctci.chapter4;

/**
 * TreeNode class provides the skeleton of the Tree Data Structure which has
 * three parts: a left TreeNode, a data part and a right TreeNode.
 * 
 * @author prerit
 *
 */
public class TreeNode {
	private TreeNode left;
	private int data;
	private TreeNode right;

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

}
