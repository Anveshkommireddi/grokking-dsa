package com.learn.java.cyclic.sort;

public class FindCorruptNums {

	private static int[] findNumbers(int[] arr) {
		int idx = 0;
		while (idx < arr.length) {
			int currIdx = idx;
			int targetIdx = arr[idx] - 1;
			if (arr[currIdx] != arr[targetIdx]) {
				swap(arr, currIdx, targetIdx);
			} else {
				idx++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int currVal = arr[i];
			int actualVal = i + 1;
			if (currVal != actualVal) {
				return new int[] { currVal, actualVal };
			}
		}
		return new int[] { -1, -1 };
	}

	public static void main(String[] args) {
		int[] nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 5, 2 });
		System.out.println(nums[0] + ", " + nums[1]);
		nums = FindCorruptNums.findNumbers(new int[] { 3, 1, 2, 3, 6, 4 });
		System.out.println(nums[0] + ", " + nums[1]);
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}
}
