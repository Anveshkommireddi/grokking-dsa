package com.learn.java.sliding.window;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinSizeSubArraySum {

	private static final Logger LOGGER = LoggerFactory.getLogger(MinSizeSubArraySum.class);

	// find the length of the smallest contiguous sub array whose sum is greater than or equal to ‘S’.
    // Return 0 if no such sub array exists.
	public static void main(String[] args) {
		int minLength = findMinSubArray(12, new int[] { 2, 1, 5, 2, 3, 2 });
		LOGGER.info("Result is :: {}", minLength);
	}

	private static int findMinSubArray(int sum, int[] arr) {
		int minLength = Integer.MAX_VALUE;
		int start = 0;
		int currSum = 0;
		for (int end = 0; end < arr.length; end++) {
			currSum += arr[end];
			while (start <= end && currSum >= sum) {
				minLength = Math.min(minLength, end - start + 1);
				currSum -= arr[start];
				start++;
			}
		}
		minLength = minLength == Integer.MAX_VALUE ? 0 : minLength;
		return minLength;
	}
}
