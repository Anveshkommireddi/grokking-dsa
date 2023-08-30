package com.learn.java.merge.intervals;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Given a list of intervals representing the start and end time of ‘N’ meetings, find the minimum number of rooms required to hold all the meetings.
public class MinimumMeetingRooms {
	private static final Logger LOGGER = LoggerFactory.getLogger(MinimumMeetingRooms.class);
	private static final String CONST_RESPONSE = "Minimum meeting rooms required: {}";

	public static void main(String[] args) {
		List<Meeting> input = new ArrayList<>();
		input.add(new Meeting(1, 4));
		input.add(new Meeting(2, 5));
		input.add(new Meeting(7, 9));
		int result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		LOGGER.info(CONST_RESPONSE, result);

		input = new ArrayList<>();
		input.add(new Meeting(6, 7));
		input.add(new Meeting(2, 4));
		input.add(new Meeting(8, 12));
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		LOGGER.info(CONST_RESPONSE, result);

		input = new ArrayList<>();
		input.add(new Meeting(1, 4));
		input.add(new Meeting(2, 3));
		input.add(new Meeting(3, 6));
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		LOGGER.info(CONST_RESPONSE, result);

		input = new ArrayList<>();
		input.add(new Meeting(4, 5));
		input.add(new Meeting(2, 3));
		input.add(new Meeting(2, 4));
		input.add(new Meeting(3, 5));
		result = MinimumMeetingRooms.findMinimumMeetingRooms(input);
		LOGGER.info(CONST_RESPONSE, result);
	}

	private static int findMinimumMeetingRooms(List<Meeting> meetings) {
		int result = Integer.MIN_VALUE;
		meetings.sort(Comparator.comparingInt(m -> m.start));
		PriorityQueue<Meeting> minHeap = new PriorityQueue<>(Comparator.comparingInt(m -> m.end));
		for (Meeting currMeeting : meetings) {
			while (!minHeap.isEmpty() && currMeeting.start >= minHeap.peek().end) {
				minHeap.poll();
			}
			minHeap.offer(currMeeting);
			result = Math.max(result, minHeap.size());
		}
		return result;
	}
}
