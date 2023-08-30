package com.learn.java.inplace.reversal.linked.list;

public class RotateList {

	private static ListNode rotate(ListNode head, int k) {
		int length = length(head);
		head = reverse(head, 1, length - k);
		head = reverse(head, length - k + 1, length);
		head = reverse(head, 1, length);
		return head;
	}

	private static ListNode reverse(ListNode head, int start, int end) {
		ListNode lastNodeOfPreviousPart = null;
		ListNode curr = head;
		for (int i = 0; i < start - 1 && null != curr; i++) {
			lastNodeOfPreviousPart = curr;
			curr = curr.next;
		}
		ListNode lastNodeOfSubList = curr;
		ListNode prevNode = null;
		for (int i = 0; i < end - start + 1 && null != curr; i++) {
			ListNode next = curr.next;
			curr.next = prevNode;
			prevNode = curr;
			curr = next;
		}

		if (null == lastNodeOfPreviousPart) {
			head = prevNode;
		} else {
			lastNodeOfPreviousPart.next = prevNode;
		}

		lastNodeOfSubList.next = curr;

		return head;
	}

	private static int length(ListNode head) {
		int result = 0;
		ListNode currNode = head;
		while (null != currNode) {
			result++;
			currNode = currNode.next;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode result = RotateList.rotate(head, 3);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

}
