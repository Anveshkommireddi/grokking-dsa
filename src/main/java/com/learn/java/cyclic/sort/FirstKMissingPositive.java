package com.learn.java.cyclic.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {

	private static List<Integer> findNumbers(int[] arr, int k) {
		List<Integer> resultLst = new ArrayList<>();

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
		Set<Integer> extraNumbers = new HashSet<>();
		for (int i = 0; i < arr.length && resultLst.size() < k; i++) {
			int currVal = arr[i];
			int actualVal = i + 1;
			if (currVal != actualVal) {
				resultLst.add(actualVal);
			}
			extraNumbers.add(currVal);
		}

		for (int i = 1; resultLst.size() < k; i++) {
			int potentialNumber = i + arr.length;
			if (!extraNumbers.contains(potentialNumber)) {
				resultLst.add(potentialNumber);
			}
		}
		return resultLst;
	}

	public static void main(String[] args) {
		List<Integer> missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 3, -1, 4, 5, 5 }, 3);
		System.out.println("Missing numbers: " + missingNumbers);

		missingNumbers = FirstKMissingPositive.findNumbers(new int[] { 2, 3, 4 }, 3);
		System.out.println("Missing numbers: " + missingNumbers);

		missingNumbers = FirstKMissingPositive.findNumbers(new int[] { -2, -3, 4 }, 2);
		System.out.println("Missing numbers: " + missingNumbers);
	}

	private static void swap(int[] arr, int idx1, int idx2) {
		if (idx1 != idx2 && arr[idx1] != arr[idx2]) {
			int temp = arr[idx1];
			arr[idx1] = arr[idx2];
			arr[idx2] = temp;
		}
	}

}
