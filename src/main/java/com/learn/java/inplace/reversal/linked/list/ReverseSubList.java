package com.learn.java.inplace.reversal.linked.list;

public class ReverseSubList {

	private static ListNode reverse(ListNode head, int start, int end) {
		ListNode startNode = null;
		ListNode prevNode = null;

		ListNode curr = head;
		for (int i = 0; null != curr && i < start - 1; i++) {
			prevNode = curr;
			curr = curr.next;
		}
		ListNode prev = null;
		if (null == curr) return head;
		startNode = curr;
		for (int i = 0; i < end - start + 1 && null != curr; i++) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		if (null == prevNode) {
			head = prev;
		} else {
			prevNode.next = prev;
		}
		startNode.next = curr;
		return head;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode result = ReverseSubList.reverse(head, 3, 5);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}
}
