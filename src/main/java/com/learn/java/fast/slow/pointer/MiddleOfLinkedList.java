package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiddleOfLinkedList {

	private static final Logger LOGGER = LoggerFactory.getLogger(MiddleOfLinkedList.class);

	private static final String CONST_MIDDLE = "Middle Node: {}";

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		LOGGER.info(CONST_MIDDLE, findMiddle(head).value);

		head.next.next.next.next.next = new ListNode(6);
		LOGGER.info(CONST_MIDDLE, findMiddle(head).value);

		head.next.next.next.next.next.next = new ListNode(7);
		LOGGER.info(CONST_MIDDLE, findMiddle(head).value);
	}

	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
