package com.learn.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestSubStringWithDisctinctCharacters {

	private static final Logger LOGGER = LoggerFactory.getLogger(LongestSubStringWithDisctinctCharacters.class);
	
	//length of the longest substring, which has all distinct characters.
	public static void main(String[] args) {
		int maxLength = findLength("geeksforgeeks");
		LOGGER.info("Length of the longest substring: {}", maxLength);
	}

	private static int findLength(String input) {
		int maxLength = Integer.MIN_VALUE;
		int start = 0;
		Map<Character, Integer> charIdxMap = new HashMap<>();
		for (int end = 0; end < input.length(); end++) {
			Character rightChar = input.charAt(end);
			if (charIdxMap.containsKey(rightChar) && charIdxMap.get(rightChar) + 1 > start) {
				start = charIdxMap.get(rightChar) + 1;
			}
			charIdxMap.put(rightChar, end);
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}
}
