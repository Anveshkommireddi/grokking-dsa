package com.learn.java.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TripletSumToZero {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripletSumToZero.class);

	// find all the unique triplets that sums to 0
	public static void main(String[] args) {
		List<List<Integer>> result = searchUniqueTriplets(new int[] { -3, 0, 1, 2, -1, 1, -2 });
		LOGGER.info("result is {}", result);
	}

	public static List<List<Integer>> searchUniqueTriplets(int[] arr) {
		// result
		List<List<Integer>> result = new ArrayList<>();
		// sort for applying 2 pointer approach
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {

			// condition to avoid duplicate triplets
			if (i > 0 && arr[i] == arr[i - 1])
				continue;

			int currVal = arr[i];
			findPair(arr, i + 1, arr.length - 1, currVal, result);
		}
		return result;
	}

	// apply 2 pointer approach and store the result
	private static void findPair(int[] arr, int left, int right, int currVal, List<List<Integer>> result) {
		int target = 0 - currVal;
		while (left <= right) {
			int sum = arr[left] + arr[right];
			if (sum == target) {
				result.add(Arrays.asList(currVal, arr[left], arr[right]));
				left++;
				right--;
				// condition to avoid duplicate triplets from left
				while (left < right && arr[left] == arr[left + 1]) {
					left++;
				}

				// condition to avoid duplicate triplets from right
				while (left < right && arr[right] == arr[right - 1]) {
					right--;
				}

			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}

	}
}
