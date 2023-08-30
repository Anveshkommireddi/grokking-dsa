package com.learn.java.merge.intervals;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IntervalsIntersection {

	private static final Logger LOGGER = LoggerFactory.getLogger(IntervalsIntersection.class);

	public static void main(String... args) {
		Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
		Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
		Interval[] result = IntervalsIntersection.merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
		System.out.println();

		input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
		input2 = new Interval[] { new Interval(5, 10) };
		result = IntervalsIntersection.merge(input1, input2);
		System.out.print("Intervals Intersection: ");
		for (Interval interval : result)
			System.out.print("[" + interval.start + "," + interval.end + "] ");
	}

	private static Interval[] merge(Interval[] input1, Interval[] input2) {
		List<Interval> commonIntervals = new ArrayList<>();
		int ip1Idx = 0;
		int ip2Idx = 0;
		while (ip1Idx < input1.length && ip2Idx < input2.length) {
			Interval interval1 = input1[ip1Idx];
			Interval interval2 = input2[ip2Idx];
			if ((interval1.start >= interval2.start && interval1.start <= interval2.end)
					|| (interval2.start >= interval1.start && interval2.start <= interval1.end)) {
				commonIntervals.add(new Interval(Math.max(interval1.start, interval2.start),
						Math.min(interval1.end, interval2.end)));
			}

			if (interval1.end < interval2.end) {
				ip1Idx++;
			} else {
				ip2Idx++;
			}
		}
		return commonIntervals.toArray(new Interval[commonIntervals.size()]);
	}

}
