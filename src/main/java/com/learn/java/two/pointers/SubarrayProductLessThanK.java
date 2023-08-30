package com.learn.java.two.pointers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubarrayProductLessThanK {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubarrayProductLessThanK.class);

	public static void main(String[] args) {
		List<List<Integer>> result = findSubarrays(new int[] { 2, 5, 1, 10 }, 30);
		LOGGER.info("Result is {}", result);
	}

	private static List<List<Integer>> findSubarrays(int[] arr, int target) {
		List<List<Integer>> result = new ArrayList<>();
		int left = 0;
		int product = 1;
		for (int right = 0; right < arr.length; right++) {
			product *= arr[right];
			while (product >= target && left < arr.length) {
				product /= arr[left];
				left++;
			}

			List<Integer> tempList = new ArrayList<>();
			for (int val = right; val >= left; val--) {
				tempList.add(0, arr[val]);
				result.add(new ArrayList<>(tempList));
			}
		}
		return result;
	}

}
