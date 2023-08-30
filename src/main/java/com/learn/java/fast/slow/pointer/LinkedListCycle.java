package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListCycle {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListCycle.class);

	private static final String CONST_LINKED_LIST_CYCLE = "LinkedList has cycle: {}";

	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		LOGGER.info(CONST_LINKED_LIST_CYCLE, hasCycle(head));

		head.next.next.next.next.next.next = head.next.next;
		LOGGER.info(CONST_LINKED_LIST_CYCLE, hasCycle(head));

		head.next.next.next.next.next.next = head.next.next.next;
		LOGGER.info(CONST_LINKED_LIST_CYCLE, hasCycle(head));
	}

	private static boolean hasCycle(ListNode head) {
		ListNode curr = head;
		ListNode slow = curr;
		ListNode fast = curr;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				return true;
		}
		return false;
	}

}
