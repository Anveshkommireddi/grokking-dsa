package com.learn.java.fast.slow.pointer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HappyNumber {

	private static final Logger LOGGER = LoggerFactory.getLogger(HappyNumber.class);

	public static void main(String[] args) {
		LOGGER.info("Is Happy Number {}", checkForHappyNumber(23));
		LOGGER.info("Is Happy Number {}", checkForHappyNumber(12));
	}

	private static boolean checkForHappyNumber(int num) {
		int slow = num;
		int fast = num;
		do {
			slow = findSumOfSquares(slow);
			fast = findSumOfSquares(findSumOfSquares(fast));
		} while (slow != fast);

		return slow == 1;
	}

	private static int findSumOfSquares(int val) {
		int result = 0;
		while (val > 0) {
			int rem = val % 10;
			val = val / 10;
			result += rem * rem;
		}
		return result;
	}

}
