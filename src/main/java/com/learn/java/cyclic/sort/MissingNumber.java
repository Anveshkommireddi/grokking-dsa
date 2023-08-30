package com.learn.java.cyclic.sort;

public class MissingNumber {

	private static int findMissingNumber(int[] arr) {
		int idx = 0;
		while (idx < arr.length) {
			int currIdx = idx;
			int targetIdx = arr[idx];
			if (arr[currIdx] < arr.length && arr[currIdx] != arr[targetIdx]) {
				swap(arr, currIdx, targetIdx);
			} else {
				idx++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(MissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
		System.out.println(MissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
