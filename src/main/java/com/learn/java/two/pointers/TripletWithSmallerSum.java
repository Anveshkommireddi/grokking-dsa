package com.learn.java.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TripletWithSmallerSum {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripletWithSmallerSum.class);

	public static void main(String[] args) {
		int result = searchTriplets(new int[] { -1, 0, 2, 3 }, 3);
		LOGGER.info("Result is {}", result);
	}

	private static int searchTriplets(int[] arr, int target) {
		int result = 0;
		for (int i = 0; i < arr.length - 2; i++) {
			int currVal = arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int sum = currVal + arr[left] + arr[right];
				if (sum < target) {
					left++;
					result += right - left;
				} else {
					right--;
				}
			}
		}
		return result;
	}

	private static List<List<Integer>> findTripletsWithSmallerSum(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			int currVal = arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				int sum = currVal + arr[left] + arr[right];
				if (sum < target) {
					// loop keeping left as fixed to get all smaller sums
					for (int val = right; val > left; val--) {
						triplets.add(Arrays.asList(currVal, arr[left], arr[val]));
					}
					left++;
				} else {
					right--;
				}
			}
		}
		return triplets;
	}
}
