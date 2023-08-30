package com.learn.java.inplace.reversal.linked.list;

public class ReverseEveryKElements {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);

		ListNode result = ReverseEveryKElements.reverse(head, 2);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

	private static ListNode reverse(ListNode head, int k) {
		if (k <= 1 || head == null)
			return head;
		ListNode currNode = head;
		ListNode prevNode = null;
		while (true) {
			ListNode lastNodeOfPreviousPart = prevNode;
			ListNode lastNodeOfSubList = currNode;
			for (int i = 0; i < k && null != currNode; i++) {
				ListNode nextNode = currNode.next;
				currNode.next = prevNode;
				prevNode = currNode;
				currNode = nextNode;
			}

			if (null != lastNodeOfPreviousPart) {
				lastNodeOfPreviousPart.next = prevNode;
			} else {
				head = prevNode;
			}
			lastNodeOfSubList.next = currNode;
			if (null == currNode)
				break;
			prevNode = lastNodeOfSubList;
		}
		return head;
	}

}
