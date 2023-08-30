package com.learn.java.arrays.misc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MajorityElement {

	private static final Logger LOGGER = LoggerFactory.getLogger(MajorityElement.class);

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 2, 4, 5, 5 };
		int res = majorityElement(arr);
		LOGGER.info("Majority Element is {}", res);
	}

	private static int majorityElement(int[] arr) {
		int res = Integer.MIN_VALUE;
		int counter = 1;
		int resIdx = 0;
		// moore voting algo to find most freq element
		for (int i = 1; i < arr.length; i++) {

			if (arr[i] == arr[resIdx]) {
				counter++;
			} else {
				counter--;
			}

			if (counter == 0) {
				resIdx = i;
				counter = 1;
			}
		}

		// check if it is really a majority element
		int resCount = arr.length / 2;
		int resCounter = 0;
		if (counter > 0) {
			for (int i = 0; i < arr.length; i++) {
				if (arr[resIdx] == arr[i]) {
					resCounter++;
					if (resCounter > resCount) {
						return arr[resIdx];
					}
				}
			}
		}
		return res;
	}

}
