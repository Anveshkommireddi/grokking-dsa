package com.learn.java.sliding.window;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringPermutation {

	private static final Logger LOGGER = LoggerFactory.getLogger(StringPermutation.class);

	public static void main(String[] args) {
		boolean permutationExists = findPermutation("odicf", "dc");
		LOGGER.info("Permutation exist: {}", permutationExists);
		boolean permutationExists2 = findPermutation("knagaanvesh", "aa");
		LOGGER.info("Permutation exist: {}", permutationExists2);
	}

	private static boolean findPermutation(String input, String pattern) {
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int val = 0; val < pattern.length(); val++) {
			Character patternChar = pattern.charAt(val);
			Integer patternCharVal = charFreqMap.getOrDefault(patternChar, 0);
			charFreqMap.put(patternChar, patternCharVal + 1);
		}
		int start = 0;
		int matchCount = 0;
		
		for (int end = 0; end < input.length(); end++) {
			
			Character rightChar = input.charAt(end);
			
			if (charFreqMap.containsKey(rightChar)) {
				Integer rightCharVal = charFreqMap.get(rightChar);
				charFreqMap.put(rightChar, rightCharVal - 1);
				if (rightCharVal == 1)
					matchCount += 1;
			}
			
			int currInputLength = end - start + 1;
			if (currInputLength > pattern.length()) {
				Character leftChar = input.charAt(start);
				if (charFreqMap.containsKey(leftChar)) {
					Integer leftCharVal = charFreqMap.get(leftChar);
					charFreqMap.put(leftChar, leftCharVal + 1);
					if (leftCharVal == 0)
						matchCount -= 1;
				}
				start++;
			}

			if (matchCount == charFreqMap.size()) {
				return true;
			}

		}
		return false;
	}

}
