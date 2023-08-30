package com.learn.java.inplace.reversal.linked.list;

public class ReverseEvenOddNodes {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		ListNode result = ReverseEvenOddNodes.reverseEvenOddNodes(head);
		System.out.print("Nodes of the reversed LinkedList are: ");
		while (result != null) {
			System.out.print(result.value + " ");
			result = result.next;
		}
	}

	private static ListNode reverseEvenOddNodes(ListNode head) {
		if (null == head)
			return null;
		// find length
		int length = 0;
		ListNode curr = head;
		while (null != curr) {
			curr = curr.next;
			length++;
		}

		int mid = length / 2;
		head = reverseSubList(head, 1, mid);
		head = reverseSubList(head, mid + 1, length);
		return head;
	}

	private static ListNode reverseSubList(ListNode head, int start, int end) {
		ListNode currNode = head;
		ListNode lastNodeOfPreviousPart = null;

		for (int i = 0; i < start - 1 && null != currNode; i++) {
			lastNodeOfPreviousPart = currNode;
			currNode = currNode.next;
		}

		ListNode lastNodeOfSubList = currNode;

		ListNode nextNode = null;
		ListNode prevNode = null;
		for (int i = 0; i < end - start + 1 && null != currNode; i++) {
			nextNode = currNode.next;
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
		return head;
	}

}
