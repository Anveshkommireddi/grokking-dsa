package com.learn.java.merge.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountIntegerNIntervals {

	List<Interval> rangeSet = new ArrayList<>();

	public CountIntegerNIntervals() {

	}

	public void add(int left, int right) {
		if (rangeSet.isEmpty()) {
			rangeSet.add(new Interval(left, right));
			return;
		}
		List<Interval> mergedIntervals = new ArrayList<>();
		rangeSet.add(new Interval(left, right));
		List<Interval> sortedList = rangeSet.stream().sorted((r1, r2) -> r1.start - r2.start).collect(Collectors.toList());
		mergedIntervals.add(sortedList.get(0));
		for (int i = 1; i < sortedList.size(); i++) {
			Interval prev = mergedIntervals.get(mergedIntervals.size() - 1);
			Interval curr = sortedList.get(i);
			if (curr.start <= prev.end) {
				if (curr.end > prev.end) {
					prev.end = curr.end;
				}
			} else {
				mergedIntervals.add(new Interval(curr.start, curr.end));
			}
		}

		rangeSet = new ArrayList<>(mergedIntervals);
	}

	public int count() {
		int count = 0;
		for (Interval range : rangeSet) {
			count += range.end - range.start + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		CountIntegerNIntervals obj = new CountIntegerNIntervals();
		obj.add(33, 49);
		obj.count();
		obj.add(43, 47);
		obj.count();
		obj.add(37, 37);
		obj.count();
		obj.add(26, 38);
		obj.count();
		obj.add(11, 11);
		obj.count();
	}
}
