package com.learn.java.cyclic.sort;

public class FirstSmallestMissingPositive {

	public static void main(String[] args) {
		System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
		System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
		System.out.println(FirstSmallestMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
	}

	private static int findNumber(int[] arr) {
		int idx = 0;
		while (idx < arr.length) {
			int currIdx = idx;
			int targetIdx = arr[idx] - 1;
			if (arr[currIdx] <= arr.length && arr[currIdx] > 0 && arr[currIdx] != arr[targetIdx]) {
				swap(arr, currIdx, targetIdx);
			} else {
				idx++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int currVal = arr[i];
			int actualVal = i + 1;
			if (currVal != actualVal) {
				return actualVal;
			}
		}
		return -1;
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
