package com.learn.java.sliding.window;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxSumSubArrayOfSizeK {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaxSumSubArrayOfSizeK.class);

    public static void main(String[] args) {
        // Given an array of positive numbers and a positive number ‘k,’
        int k = 3;
        int windowSum = findMaxSumSubArray(new int[]{2, 1, 5, 1, 3, 2}, k);
        LOGGER.info("Window Sum is {}", windowSum);
    }

    private static int findMaxSumSubArray(int[] arr, int k) {
        int res = Integer.MIN_VALUE;
        int start = 0;
        int currSum = 0;
        for (int end = 0; end < arr.length; end++) {
            currSum += arr[end];
            if (end - start + 1 == k) {
                res = Math.max(res, currSum);
                currSum -= arr[start];
                start++;
            }
        }
        return res;
    }
}
