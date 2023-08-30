package com.learn.java.merge.intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.
public class MergeIntervals {

	private static final Logger LOGGER = LoggerFactory.getLogger(MergeIntervals.class);
	private static final String CONST_MERGE_INTERVALS = "Merged intervals: ";
	private static final String CONST_RESPONSE_LOG = "[ {} , {} ]";

	public static void main(String[] args) {
		List<Interval> input = new ArrayList<>();

		input.add(new Interval(1, 4));
		input.add(new Interval(2, 5));
		input.add(new Interval(7, 9));
		LOGGER.info(CONST_MERGE_INTERVALS);
		for (Interval interval : merge(input))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info("===============================");

		input = new ArrayList<>();
		input.add(new Interval(6, 7));
		input.add(new Interval(2, 4));
		input.add(new Interval(5, 9));
		LOGGER.info(CONST_MERGE_INTERVALS);
		for (Interval interval : merge(input))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info("=============================");

		input = new ArrayList<>();
		input.add(new Interval(1, 4));
		input.add(new Interval(2, 6));
		input.add(new Interval(3, 5));
		LOGGER.info(CONST_MERGE_INTERVALS);
		for (Interval interval : merge(input))
			LOGGER.info(CONST_RESPONSE_LOG, interval.start, interval.end);
		LOGGER.info("===============================");
	}

	private static List<Interval> merge(List<Interval> intervals) {
		
		List<Interval> mergedIntervals = new LinkedList<>();

		// sort based on the start time
		List<Interval> sortedLst = intervals.stream().sorted(Comparator.comparingInt(interval -> interval.start))
												 .collect(Collectors.toList());
		mergedIntervals.add(sortedLst.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			Interval prev = mergedIntervals.get(mergedIntervals.size() - 1);
			Interval curr = intervals.get(i);
			if (curr.start <= prev.end) {
				if (curr.end > prev.end)
					prev.end = curr.end;
			} else {
				mergedIntervals.add(curr);
			}
		}
		return mergedIntervals;
	}

}
