package com.learn.java.two.pointers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackspaceCompare {

	private static final Logger LOGGER = LoggerFactory.getLogger(BackspaceCompare.class);

	public static void main(String[] args) {
		boolean isMatched = compare("xp#", "xyz##");
		LOGGER.info("Result is {}", isMatched);
	}

	private static boolean compare(String ip1, String ip2) {
		int index1 = ip1.length() - 1;
		int index2 = ip2.length() - 1;

		while (index1 >= 0 || index2 >= 0) {
			int idx1 = getProperIdx(ip1, index1);
			int idx2 = getProperIdx(ip2, index2);
			LOGGER.info("idx1 is {} && idx2 is {}", idx1, idx2);

			if (idx1 < 0 && idx2 < 0)
				return true;

			if (idx1 < 0 || idx2 < 0)
				return false;

			if (ip1.charAt(idx1) != ip2.charAt(idx2))
				return false;

			index1 = idx1 - 1;
			index2 = idx2 - 1;
		}
		return true;
	}

	private static int getProperIdx(String input, int index) {
		int backSpaceCounter = 0;
		while (index >= 0) {
			char val = input.charAt(index);
			if (val == '#') {
				backSpaceCounter++;
			} else if (backSpaceCounter > 0) {
				backSpaceCounter--;
			} else {
				break;
			}
			index--;
		}
		return index;
	}
}
