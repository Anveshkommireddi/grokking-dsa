package com.learn.java.two.pointers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TripletSumCloseToTarget {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripletSumCloseToTarget.class);

	public static void main(String[] args) {
		int result = searchTriplet(new int[] { 1, 0, 1, 1 }, 100);
		LOGGER.info("Result is {}", result);
	}

	private static int searchTriplet(int[] arr, int target) {
		Integer resultSum = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int currVal = arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int currSum = currVal + arr[left] + arr[right];
				if (currSum < target)
					left++;
				else
					right--;
				//update the difference
				if (Math.abs(currSum - target) < Math.abs(resultSum - target)) {
					resultSum = currSum;
				}
			}
		}
		return resultSum;
	}

}
