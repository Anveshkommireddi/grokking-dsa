package com.learn.java.two.pointers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DutchFlag {

	private static final Logger LOGGER = LoggerFactory.getLogger(DutchFlag.class);

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 0, 2, 1, 0 };
		int[] order = new int[] { 0, 1, 2 };
		sort(arr, order);
		LOGGER.info("{}", Arrays.toString(arr));
	}

	private static void sort(int[] arr, int[] order) {
		int left = 0;
		int mid = 0;
		int right = arr.length - 1;
		while (mid <= right) {
			if (arr[mid] == order[0]) {
				swap(arr, left, mid);
				left++;
				mid++;
			} else if (arr[mid] == order[1]) {
				mid++;
			} else if (arr[mid] == order[2]) {
				swap(arr, mid, right);
				right--;
			}
		}
	}

	private static void swap(int[] arr, int left, int right) {
		if (arr[left] == arr[right]) return;
		if (left != right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
		}
	}

}
