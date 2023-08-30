package com.learn.java.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {

	private static List<Integer> findNumbers(int[] arr) {
		List<Integer> resultLst = new ArrayList<>();
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
			if (arr[i] != i + 1) {
				resultLst.add(i + 1);
			}
		}
		return resultLst;
	}

	public static void main(String[] args) {
		List<Integer> missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
		System.out.println("Missing numbers: " + missing);

		missing = AllMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
		System.out.println("Missing numbers: " + missing);

		missing = AllMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
		System.out.println("Missing numbers: " + missing);
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
