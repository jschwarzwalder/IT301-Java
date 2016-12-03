/**
 * Jami Schwarzwalder
 * Dec 2, 2016
 * NodeLinkedList.java
 * Returns maximum value in list
 */
package edu.greenriver.it.dataStructures;

/**
 * Takes a reference to the first node in a linked list as argument and returns
 * the value of the maximum key in the list
 *
 * @author Jami Schwarzwalder
 * @version 1.1
 */
public class NodeLinkedList {
	
	public class Node {
		Node next = null;
		int value;
		
		public Node (int value){
			this.value = value;
		}
		
		public void setNext(Node nextNode){
			this.next = nextNode;
		}
		
		public int getValue(){
			return value;
		}
	}
	
	public int max(Node head){
		if (head == null){
			return 0;
		}
		int maxValue = head.value;
		Node currentNode = head;
		while (currentNode.next != null){
			currentNode = currentNode.next;
			if (currentNode.value > maxValue){
				maxValue = currentNode.value;
			}
		}
		return maxValue;
	}

}
