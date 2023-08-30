package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListCycleLength {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListCycleLength.class);

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = head.next.next;
		LOGGER.info("LinkedList cycle length: {}", LinkedListCycleLength.findCycleLength(head));

		head.next.next.next.next.next.next = head.next.next.next;
		LOGGER.info("LinkedList cycle length: {}", LinkedListCycleLength.findCycleLength(head));
	}

	private static int findCycleLength(ListNode head) {
		ListNode curr = head;
		ListNode slow = curr;
		ListNode fast = curr;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return findLength(slow);
			}
		}
		return 0;
	}

	private static int findLength(ListNode slow) {
		int result = 0;
		ListNode curr = slow;
		do {
			curr = curr.next;
			result++;
		} while (curr != slow);
		return result;
	}
}
