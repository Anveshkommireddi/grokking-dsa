package com.learn.java.sliding.window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CharacterReplacement {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterReplacement.class);
	
	//replace no more than k letters with any letter, find the length of the longest substring having the same letters after replacement.
	public static void main(String[] args) {
		int maxLength = findLength("abaccbb", 2);
		LOGGER.info("Max Length is {}", maxLength);
	}

	private static int findLength(String input, int k) {
		int maxLength = Integer.MIN_VALUE;
		int start = 0;
		Map<Character, Integer> charFreqMap = new HashMap<>();
		for (int end = 0; end < input.length(); end++) {
			Character rightChar = input.charAt(end);
			Integer rightCharVal = charFreqMap.getOrDefault(rightChar, 0);
			charFreqMap.put(rightChar, rightCharVal + 1);
			// find maxRepating char from the window or by using map
			int maxRepeatingChar = charFreqMap.entrySet().stream()
					.sorted(Comparator.comparing(Entry::getValue, (value1, value2) -> value2 - value1))
					.findFirst()
					.get().getValue();
			while (start < end && end - start + 1 - maxRepeatingChar > k) {
				Character leftChar = input.charAt(start);
				Integer leftCharVal = charFreqMap.get(leftChar);
				if (leftCharVal == 1) {
					charFreqMap.remove(leftChar);
				} else {
					charFreqMap.put(leftChar, leftCharVal - 1);
				}

				maxRepeatingChar = charFreqMap.size() > 0 ? charFreqMap.entrySet().stream()
						.sorted(Comparator.comparing(Entry::getValue, (value1, value2) -> value2 - value1)).findFirst()
						.get().getValue() : maxRepeatingChar;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}
		return maxLength;
	}

}
