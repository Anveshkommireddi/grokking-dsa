package com.learn.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxFruitCountOf2Types {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaxFruitCountOf2Types.class);

	//find the length of the longest substring in it with no more than 2 distinct characters
	public static void main(String[] args) {
		int maxLength = findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'});
		LOGGER.info("Max Length is {}", maxLength);
	}

	private static int findLength(char[] arr) {
		int maxLength = Integer.MIN_VALUE;
		int k = 2;
		int start = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int end = 0; end < arr.length; end++) {
			Character rightChar = arr[end];
			Integer rightCharVal = charFreqMap.getOrDefault(rightChar, 0);
			charFreqMap.put(rightChar, rightCharVal + 1);
			while (start < end && charFreqMap.size() > k) {
				Character leftChar = arr[start];
				Integer leftCharVal = charFreqMap.get(leftChar);
				if (leftCharVal == 1) {
					charFreqMap.remove(leftChar);
				} else {
					charFreqMap.put(leftChar, leftCharVal - 1);
				}
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
