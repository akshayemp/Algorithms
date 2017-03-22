package com.ctci.chapter4;

public interface ITree {
	/**
	 * Insert() is used to insert data into the tree. It takes in two parameters a integer data and the subtree in which
	 * the data needs to be added. subTree can be either left-subtree or the right-subtree.
	 * 
	 * @param data
	 */
	public void insert(int data, TreeNode subTree);
}
