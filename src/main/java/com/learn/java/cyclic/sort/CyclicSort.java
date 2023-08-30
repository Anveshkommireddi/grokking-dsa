package com.learn.java.cyclic.sort;

public class CyclicSort {

	private static void sort(int[] arr) {
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

	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 1, 5, 4, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 2, 6, 4, 3, 1, 5 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();

		arr = new int[] { 1, 5, 6, 4, 3, 2 };
		CyclicSort.sort(arr);
		for (int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}
}
