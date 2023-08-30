package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RearrangeList {

	private static final Logger LOGGER = LoggerFactory.getLogger(RearrangeList.class);

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(8);
		head.next.next.next.next = new ListNode(10);
		head.next.next.next.next.next = new ListNode(12);
		reorder(head);
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}

	private static void reorder(ListNode head) {
		// find the middle
		ListNode mid = middle(head);
		// reverse 2nd half
		ListNode head2 = reverse(mid);
		// create new links and map
		connectTwoLists(head, head2);

	}

	private static void connectTwoLists(ListNode head1, ListNode head2) {
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while (null != curr1 && null != curr2) {
			
			ListNode next1 = curr1.next;
			curr1.next = curr2;
			curr1 = next1;
			
			ListNode next2 = curr2.next;
			curr2.next = curr1;
			curr2 = next2;
		}
		
		if(null != curr1)
			curr1.next = null;
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (null != curr) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static ListNode middle(ListNode head) {
		ListNode curr = head;
		ListNode slow = curr;
		ListNode fast = curr;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
