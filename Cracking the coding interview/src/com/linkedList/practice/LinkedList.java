package com.linkedList.practice;

import java.util.Hashtable;

public class LinkedList implements LinkedListImpl {

	public Node head = null;

	@Override
	public void insert(int data) {
		Node n = null;
		if (head == null) {
			head = new Node(data, null);
		} else {
			n = createUnconnectedNodes(data);
			n.next = head;
			head = n;
		}
//		if (n != null)
//			System.out.println(n.getData());

	}
	
	@Override
	public void circularInsert(int data, boolean loop) {
//		Node n = null;
//		if (head == null) {
//			head = new Node(data, null);
//			System.out.println(head.getData());
//		} else {
//			n = createUnconnectedNodes(data);
//			n.next = head;
//			head = n;
//		}
//		if(loop == true){
//			this.head
//		}
//		if (n != null)
//			System.out.println(n.getData());
//
	}

	@Override
	public int deleteHead() {
		Node prev = null;
		if (head == null) {
			throw new RuntimeException("cannot delete head!");
		} else {
			prev = head;
			head = head.next;
			prev.next = null;
		}

		return prev.getData();
	}

	@Override
	public int delete(int data) {
		if (head == null) {
			throw new RuntimeException("Cannot delete.");
		}
		Node curr = head;
		Node prev = null;

		if (head != null && head.getData() == data) {
			head = null; // list is empty.
			return head.getData();
		}

		while (head != null && curr.getData() != data) {
			prev = curr;
			curr = prev.next;
		}
		if (curr != null && curr.getData() == data) {
			prev.next = curr.next;
			curr.next = null;
		}

		return curr.getData();
	}

	@Override
	public void traverse() {
		Node curr = head;
		int i = 0;
		while (curr != null) {
			System.out.println("The node " + i + " is " + curr.getData());
			curr = curr.next;
			i++;
		}
	}

	@Override
	public void traverse(LinkedList list) {
		Node curr = list.head;
		int i = 0;
		while (curr != null) {
			System.out.println("The node " + i + " is " + curr.getData());
			curr = curr.next;
			i++;
		}
	}

	@Override
	public void append(int data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void prepend(int data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reverse() {
		Node curr;
		Node save = null;
		curr = head.next;
		head.next = null;
		while (curr != null) {
			save = curr.next;
			curr.next = head;
			head = curr;
			curr = save;
		}
	}

	@Override
	public void removeDuplicates() {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeDuplicatesEfficient() {
		Node curr = head;
		Node checker = head;

	}

	@Override
	public Node findnToLast(int n) {
		int length = size(this);
		Node curr = head;
		int i = 0;
		while (curr != null) {
			if (length - n == i) {
				return curr;
			}
			curr = curr.next;
			i++;
		}
		return null;
	}

	@Override
	public int size(LinkedList list) {
		Node curr = list.head;
		int length = 0;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	@Override
	public Node createUnconnectedNodes(int data) {
		Node node = new Node(data);
		return node;
	}

	@Override
	public Node search(int data) {
		Node curr = head;
		while (curr != null) {
			if (curr.getData() == data) {
				break;
			}
			curr = curr.next;
		}
		return curr;
	}

	@Override
	public void partition(int data) {
		Node pivot = search(data);
		Node checker = head;
		Node prev = null;
		while (checker != null) {
			if (pivot == head) {
				prev = head;
				checker = head.next;
				if (checker.getData() < pivot.getData()) {
					prev.next = checker.next;
					checker.next = head;
					head = checker;
					checker = prev.next;
				} else if (checker.getData() >= pivot.getData()) {
					prev = checker;
					checker = checker.next;
				}

			} else {
				prev = head;
				checker = head;
				if (checker.getData() >= pivot.getData()) {
					prev.next = checker.next;
					checker.next = pivot.next;
					pivot.next = checker;
				} else if (checker.getData() < pivot.getData()) {
					prev = checker;
					checker = checker.next;
				}

			}

		}

	}

	@Override
	public void deleteAtPosition(Node n) {
		if (n == null) {
			throw new RuntimeException("Cannot delete the node.");
		}

		if (n.next != null) {
			n.setData(n.next.getData());
			n.next = n.next.next;
		} else {
			n = null;
		}
	}

	@Override
	public void addNumbers(LinkedList l1, LinkedList l2) {
		addNumbers(l1, l2, 0);
	}

	private void addNumbers(LinkedList l1, LinkedList l2, int carry) {
		Node n1 = l1.head;
		Node n2 = l2.head;
		LinkedList result = new LinkedList();
		int length1 = size(l1);
		int length2 = size(l2);
		int checkValue;
		if (length1 >= length2) {
			checkValue = length1;
		} else {
			checkValue = length2;
		}
		int i = 0;

		while (i < checkValue) {
			int data1 = 0, data2 = 0;
			if (n1 != null) {
				data1 = n1.getData();
			}
			if (n2 != null) {
				data2 = n2.getData();
			}
			int sum = 0;
			sum = data1 + data2 + carry;
			int sumValue = sum % 10;
			carry = sum >= 10 ? 1 : 0;
			result.insert(sumValue);
			if (n1 != null)
				n1 = n1.next;
			if (n2 != null)
				n2 = n2.next;
			i++;
		}
		System.out.println("-----");
		result.reverse();
		result.traverse();
	}

	@Override
	public void loopInList(){
		Node curr = this.head;
		Node checker = curr;
		boolean condition = curr.next != null;
		while(condition){
		Hashtable hashTable = new Hashtable();
		if(hashTable.contains(curr)){
			System.out.println(curr.getData());
			condition = false; // found a loop
		}else{
			hashTable.put(curr.hashCode(), curr); //check if the hashcode would change or be same, prone to error
			curr = curr.next;
		}
		}
	}

}
