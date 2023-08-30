package com.learn.java.two.pointers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShortestWindowSort {

	private static final Logger LOGGER = LoggerFactory.getLogger(ShortestWindowSort.class);

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 5, 3, 7, 10, 9, 12 };
		int result = shortestWindowSort(arr);
		LOGGER.info("Result is {}", result);
	}

	private static int shortestWindowSort(int[] arr) {
		// identify improper index from left
		int left = 0;
		while (left < arr.length - 1 && arr[left] < arr[left + 1]) {
			left++;
		}

		// identity improper index from right
		int right = arr.length - 1;
		while (right > 0 && arr[right] > arr[right - 1]) {
			right--;
		}
		// find the min and max from the range
		int subArrayMax = Integer.MIN_VALUE;
		int subArrayMin = Integer.MAX_VALUE;
		for (int i = left; i <= right; i++) {
			subArrayMin = Math.min(subArrayMin, arr[i]);
			subArrayMax = Math.max(subArrayMax, arr[i]);
		}
		// iterate from start and find min position
		while (left < arr.length && arr[left] < subArrayMin) {
			left++;
		}
		// iterate from end and find the max position
		while (right >= 0 && arr[right] > subArrayMax) {
			right--;
		}
		// find length max - min + 1
		return right - left + 1;
	}

}
