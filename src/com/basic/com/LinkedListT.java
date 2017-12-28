package com.basic.com;

/*
 * Nov 09
 */

public class LinkedListT {

	public Node head;
	public LinkedListT(){
		head = null;
	}
	
	public static void main(String[] args) {
		LinkedListT ll = new LinkedListT();
		ll.addAtBegin(23);
		ll.addAtBegin(33);
		ll.addAtBegin(45);
		ll.addAtBegin(78);
		ll.display(ll.head);
		ll.reverseIterative(ll.head);
		
		ll.reverseWithoutStackOrModifications(ll.head);
	}
	
	public void addAtBegin(int data){
		Node n = new Node(data);
		n.next = head;
		head = n;
	}
	
	public void reverseIterative(Node head){
		Node currNode = head;
		Node nextNode = null;
		Node prevNode = null;
		
		while(currNode!=null){
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}
		head = prevNode;
		display(head);
		
	}
	
	public void display(Node head){
		Node currNode = head;
		while(currNode!=null){
			System.out.print("->" + currNode.data);
			currNode = currNode.next;
		}
	}
	
	//Reverse without extra modifications or using stack
	public int getNth(Node head, int index){
		Node current = head;
		int count = 0 ;
		
		while(current!=null){
			if(count == index){
				return current.data;
			}
			count++;
			current = current.next;
		}
		
		assert(false);
		return 0;
	}
	
	//get count of nodes
	public int getCount(Node head){
		Node current = head;
		int count = 0;
		
		while(current!=null){
			count++;
			current = current.next;
		}
		return count;
	}
	
	public void reverseWithoutStackOrModifications(Node head){
		System.out.println("Reverse : Without stack or modifications");
		int n = getCount(head);
		for(int i = n; i >= 1; i--){
			System.out.println(getNth(head, i));
		}
	}
}
