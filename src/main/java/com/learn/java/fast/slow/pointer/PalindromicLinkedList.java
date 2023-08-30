package com.learn.java.fast.slow.pointer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PalindromicLinkedList {

	private static final Logger LOGGER = LoggerFactory.getLogger(PalindromicLinkedList.class);

	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(4);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(4);
		//LOGGER.info("Is palindrome: {}", isPalindrome(head));

		head.next.next.next.next.next = new ListNode(2);
		LOGGER.info("Is palindrome: {}", isPalindrome(head));
	}

	private static boolean isPalindrome(ListNode head) {
		// find middle
		ListNode mid = findMiddle(head);
		// reverse 2nd half
		printList(head);
		ListNode newHead = reverse(mid);
		printList(newHead);
		printList(head);
		// compare 2 halves for palindrome
		boolean result = compareTwoHalves(head, newHead);
		// reverse 2nd half
		ListNode afterHead = reverse(newHead);
		printList(afterHead);
		printList(head);
		return result;
	}

	private static boolean compareTwoHalves(ListNode head1, ListNode head2) {
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		while (null != curr1 && null != curr2) {
			if (curr1.value != curr2.value)
				return false;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		return true;
	}

	private static ListNode reverse(ListNode head) {
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

	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static void printList(ListNode head) {
		ListNode curr = head;
		List<Integer> list = new ArrayList<>();
		while (null != curr) {
			list.add(curr.value);
			curr = curr.next;
		}

		LOGGER.info("{}", list);
	}

}
