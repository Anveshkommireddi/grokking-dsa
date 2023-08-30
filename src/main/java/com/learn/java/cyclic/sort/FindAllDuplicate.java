package com.learn.java.cyclic.sort;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {

	private static List<Integer> findNumbers(int[] arr) {
		List<Integer> resLst = new ArrayList<>();
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
				resLst.add(currVal);
			}
		}
		return resLst;
	}

	public static void main(String[] args) {
		List<Integer> duplicates = FindAllDuplicate.findNumbers(new int[] { 3, 4, 4, 5, 5 });
		System.out.println("Duplicates are: " + duplicates);

		duplicates = FindAllDuplicate.findNumbers(new int[] { 5, 4, 7, 2, 3, 5, 3 });
		System.out.println("Duplicates are: " + duplicates);
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}
}
