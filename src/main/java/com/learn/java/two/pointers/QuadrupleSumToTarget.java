package com.learn.java.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuadrupleSumToTarget {

	private static final Logger LOGGER = LoggerFactory.getLogger(QuadrupleSumToTarget.class);

	// find all the unique quadruplets
	public static void main(String[] args) {
		List<List<Integer>> resultLst = searchQuadruplets(new int[] { 2, 0, -1, 1, -2, 2 }, 2);
		LOGGER.info("Result List :: {}", resultLst);
	}

	private static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
		Arrays.sort(arr);
		List<List<Integer>> resultLst = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			// to avoid duplicates
			if (i != 0 && arr[i] == arr[i - 1])
				continue;
			searchTriplets(arr, arr[i], i + 1, target, resultLst);
		}
		return resultLst;
	}

	private static void searchTriplets(int[] arr, int currVal, int start, int target, List<List<Integer>> resultLst) {

		for (int i = start; i < arr.length; i++) {
			// to avoid duplicates
			if (i != start && arr[i] == arr[i - 1])
				continue;
			searchPair(arr, currVal, arr[i], i + 1, target, resultLst);
		}
	}

	private static void searchPair(int[] arr, int val1, int val2, int start, int target,
			List<List<Integer>> resultLst) {
		int left = start;
		int right = arr.length - 1;
		while (left <= right) {
			int currSum = val1 + val2 + arr[left] + arr[right];
			if (currSum < target) {
				left++;
			} else if (currSum == target) {

				resultLst.add(Arrays.asList(val1, val2, arr[left], arr[right]));
				left++;
				right--;

				// to avoid duplicates
				while (left < right && arr[left] == arr[left - 1]) {
					left++;
				}

				// to avoid duplicates
				while (left < right && arr[right] == arr[right + 1]) {
					right--;
				}
			} else {
				right--;
			}
		}
	}

}
