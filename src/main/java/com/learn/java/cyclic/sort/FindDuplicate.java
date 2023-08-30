package com.learn.java.cyclic.sort;

public class FindDuplicate {

	private static int findNumber(int[] arr) {
		int idx = 0;
		while (idx < arr.length) {
			int currIdx = idx;
			int targetIdx = arr[idx] - 1;
			if (arr[currIdx] != arr[targetIdx]) {
				swap(arr, currIdx, targetIdx);
			} else {
				if (currIdx != targetIdx) {
					return arr[currIdx];
				}
				idx++;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(FindDuplicate.findNumber(new int[] { 1, 4, 4, 3, 2 }));
		System.out.println(FindDuplicate.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
		System.out.println(FindDuplicate.findNumber(new int[] { 2, 4, 1, 4, 4 }));
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
