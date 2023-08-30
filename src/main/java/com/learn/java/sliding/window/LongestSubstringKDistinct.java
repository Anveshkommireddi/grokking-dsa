package com.learn.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestSubstringKDistinct {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LongestSubstringKDistinct.class);
	
	//find the length of the longest substring in it with no more than K distinct characters
	public static void main(String[] args) {
		// "araaci", 1 "cbbebi", 3
		LOGGER.info("Length of the longest substring: {}", findLength("cbbebi", 10));
	}

	private static int findLength(String input, int k) {
		int res = Integer.MIN_VALUE;
		int start = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int end = 0; end < input.length(); end++) {
			Character rightChar = input.charAt(end);
			Integer rightCharVal = charFreqMap.getOrDefault(rightChar, 0);
			charFreqMap.put(rightChar, rightCharVal + 1);
			while (start < end && charFreqMap.size() > k) {
				Character leftChar = input.charAt(start);
				Integer leftCharVal = charFreqMap.get(leftChar);
				if (leftCharVal == 1) {
					charFreqMap.remove(leftChar);
				} else {
					charFreqMap.put(leftChar, leftCharVal - 1);
				}
				start++;
			}
			res = Math.max(res, end - start + 1);
		}
		return res;
	}

}
