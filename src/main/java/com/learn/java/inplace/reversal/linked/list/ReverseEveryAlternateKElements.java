package com.learn.java.inplace.reversal.linked.list;

public class ReverseEveryAlternateKElements {

	public static ListNode reverse(ListNode head, int k) {
		if (k <= 0 || null == head)
			return head;
		ListNode currNode = head;
		ListNode prevNode = null;
		while (null != currNode) {
			ListNode lastNodeOfPreviousPart = prevNode;
			ListNode lastNodeOfSubList = currNode;
			for (int i = 0; i < k; i++) {
				ListNode nextNode = currNode.next;
				currNode.next = prevNode;
				prevNode = currNode;
				currNode = nextNode;
			}
			if (null == lastNodeOfPreviousPart) {
				head = prevNode;
			} else {
				lastNodeOfPreviousPart.next = prevNode;
			}
			lastNodeOfSubList.next = currNode;
			// skip k nodes
			for (int i = 0; i < k && null != currNode; i++) {
				prevNode = currNode;
				currNode = currNode.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseEveryAlternateKElements.reverse(head, 2);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
