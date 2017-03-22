package com.lab.linked.list.bucket.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

class Link{
    public int data;
    public Link nextLink;

    public Link(int data){
            this.data = data;
    }
}

class LinkedListClass{
    public Link head;

    public LinkedListClass(){
            head = null;
    }
    public void insert(int data){
            Link link = new Link(data);
            link.nextLink = head;
            head = link;
    }
    
    public void print(){
            Link current = head;
            while(current!= null){
                    System.out.println(current.data);
                    current = current.nextLink;
            }
    }
    
    public int findLocation(int data){
    	Link current = head;
    	int index = 0;
        while(current!= null){
                if(data<=current.data){
                	break;
                }
                index++;
                current = current.nextLink;
        }
        return index;
    }
}
 


public class BucketSort {
	static int[] array = { 6, 3, 2, 0, 5, 10};
	Random randomGenerator = new Random();
	public static ArrayList<LinkedListClass> linkedListArray = new ArrayList<LinkedListClass>();
	
	public static int findMax(int[] array){
		int max = array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]>max){
				max = array[i];
			}
		}
		return max;
	}
	public static int findMin(int[] array){
		int min = array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]<min){
				min = array[i];
			}
		}
		return min;
	}
	
	public static ArrayList<LinkedListClass> addToBucket(int data,int min,int max){
		Random r = new Random();
		LinkedListClass linkedList1 = new LinkedListClass();
		LinkedListClass linkedList2 = new LinkedListClass();
		
 		int randomValue = r.nextInt(max-min)+min;
		if(data>=min && data<=randomValue){
			System.out.println("x"+linkedList1.findLocation(data));
			linkedList1.insert(data);
		}else if(data>=randomValue+1 && data<=max){
			linkedList2.insert(data);
		}
		linkedListArray.add(linkedList1);
		linkedListArray.add(linkedList2);
		
		return linkedListArray;
	}
	public static void main(String... args){
		int min = findMin(array);
		int max = findMax(array);
		for(int i=0;i<array.length;i++){
			addToBucket(array[i], min, max);
		}
		Iterator it = linkedListArray.iterator();
		while(it.hasNext()){
			LinkedListClass llc = (LinkedListClass)it.next();
			llc.print();
		}
	}
	
}
