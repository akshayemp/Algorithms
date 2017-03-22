package com.lab.huffman.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings(value = { "unchecked" }) 
public class HuffmanCoding {
	// public static Queue<Code> priorityQueue = new PriorityQueue<Code>();
	public static void main(String args[]) {
		HuffmanCoding hc = new HuffmanCoding();
		List<Code> codes = Arrays.asList(new Code('a', 0.3f), new Code('b', 0.4f), new Code('c', 0.2f),
				new Code('d', 0.1f));

		Comparator<Code> comparator = new Comparator<Code>() {
			@Override
			public int compare(Code o1, Code o2) {
				return (o1.probability < o2.probability) ? -1 : 1;
			}
		};

		Queue<Code> priorityQueue = new PriorityQueue<Code>(11, comparator);

		for (Code code : codes) {
			priorityQueue.add(code);
		}
		findHuffmanCode(priorityQueue, codes.size());
	}

	public static void findHuffmanCode(Queue priorityQueue, int size) {

		while ((!(priorityQueue.isEmpty()) || priorityQueue != null) && priorityQueue.size() > 1) {
			List<Code> CodeList = new ArrayList<Code>();
			Code left = (Code) priorityQueue.remove();
			left.code = 0;
			CodeList.add(left);
			Code right = (Code) priorityQueue.remove();
			right.code = 1;
			CodeList.add(right);

			float probability = left.probability + right.probability;
			Code codeList = new Code(CodeList, probability);
			priorityQueue.add(codeList);
		}

		Code finalCode = (Code) priorityQueue.remove();
		System.out.println("Huffman codes:");
		printCodes(finalCode, size);
	}

	static class Code {
		public char character;
		public float probability;
		public List<Code> list = new ArrayList<Code>();
		public boolean isLeaf;
		public int code;

		Code(List list, float probability) {
			this.list = list;
			this.probability = probability;
			this.isLeaf = false;
		}

		Code(char character, float probability) {
			this.character = character;
			this.probability = probability;
			this.isLeaf = true;
		}

	}

	public static void printCodes(Code codes, int size) {
		int i = 0;
		int[] store = new int[size];
		String binaryCode;
		List<Code> code = codes.list;
		int k = 0;
		int count = 0;

		while (k < code.size()) {
			if (code.get(k).isLeaf == true) {
				System.out.println(code.get(k).character + ":" + (count >= 2 ? store[i - 2] : "")
						+ (i > 0 ? store[i - 1] : "") + code.get(k).code);
				count++;
			} else {
				store[i] = code.get(k).code;
				code = code.get(k).list;
				k = 0;
				i++;
				continue;
			}

			k++;
		}
		System.out.println();
	}
}