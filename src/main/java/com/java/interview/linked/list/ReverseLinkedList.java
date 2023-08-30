package com.java.interview.linked.list;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReverseLinkedList {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReverseLinkedList.class);

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		LOGGER.info("Reversed Head: {}", reverseALinkedList(head));
	}

	private static ListNode reverseALinkedList(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (null != curr) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
