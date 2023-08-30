package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LinkedListCycleStart {

	private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListCycleStart.class);

	private static final String CONST_LL_CYCLE_START = "LinkedList cycle start: {}";

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);

		head.next.next.next.next.next.next = head.next.next;
		LOGGER.info(CONST_LL_CYCLE_START, findCycleStart(head).value);

		head.next.next.next.next.next.next = head.next.next.next;
		LOGGER.info(CONST_LL_CYCLE_START, findCycleStart(head).value);

		head.next.next.next.next.next.next = head;
		LOGGER.info(CONST_LL_CYCLE_START, findCycleStart(head).value);
	}

	private static ListNode findCycleStart(ListNode head) {
		ListNode curr = head;
		ListNode slow = curr;
		ListNode fast = curr;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return findStartNode(slow, head);
			}
		}
		return null;
	}

	private static ListNode findStartNode(ListNode pointer1, ListNode pointer2) {
		while (pointer1 != pointer2) {
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return pointer1;
	}

}
