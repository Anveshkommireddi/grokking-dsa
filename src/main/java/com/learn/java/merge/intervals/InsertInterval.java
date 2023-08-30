package com.learn.java.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertInterval {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsertInterval.class);
	private static final String CONST_NEW_INTERVALS = "Intervals after inserting the new interval: ";
	private static final String CONST_RESPONSE_LOG = "[ {} , {} ]";
	private static final String CONST_DASH = "==========================";

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		LOGGER.info(CONST_NEW_INTERVALS);
		for (Interval interval : insert(input, new Interval(4, 6)))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info(CONST_DASH);

		input = new ArrayList<>();
		input.add(new Interval(1, 3));
		input.add(new Interval(5, 7));
		input.add(new Interval(8, 12));
		LOGGER.info(CONST_NEW_INTERVALS);
		for (Interval interval : insert(input, new Interval(4, 10)))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info(CONST_DASH);

		input = new ArrayList<>();
		input.add(new Interval(2, 3));
		input.add(new Interval(5, 7));
		LOGGER.info(CONST_NEW_INTERVALS);
		for (Interval interval : insert(input, new Interval(1, 4)))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info(CONST_DASH);
	}

	private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (null == intervals || intervals.isEmpty())
			return Arrays.asList(newInterval);
		List<Interval> mergedIntervals = new ArrayList<>();
		int idx = 0;
		// add all non overlapping intervals
		while (idx < intervals.size() && newInterval.start > intervals.get(idx).end) {
			mergedIntervals.add(intervals.get(idx));
			idx++;
		}

		// modify the new interval according to overlap conditions
		while (idx < intervals.size() && newInterval.start <= intervals.get(idx).end) {
			newInterval.start = Math.min(intervals.get(idx).start, newInterval.start);
			newInterval.end = Math.max(intervals.get(idx).end, newInterval.end);
			idx++;
		}

		// add the newInterval after overlapping is done
		mergedIntervals.add(newInterval);

		// add all the remaining elements to the result
		while (idx < intervals.size()) {
			mergedIntervals.add(intervals.get(idx));
			idx++;
		}

		return mergedIntervals;
	}

}
