package com.learn.java.merge.intervals;

import java.util.Arrays;
import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.
public class ConflictingAppointments {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConflictingAppointments.class);
	private static final String CONST_RESPONSE = "Can attend all appointments: {}";

	public static void main(String[] args) {
		Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
		boolean result = canAttendAllAppointments(intervals);
		LOGGER.info(CONST_RESPONSE, result);

		Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
		result = canAttendAllAppointments(intervals1);
		LOGGER.info(CONST_RESPONSE, result);

		Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
		result = canAttendAllAppointments(intervals2);
		LOGGER.info(CONST_RESPONSE, result);
	}

	private static boolean canAttendAllAppointments(Interval[] intervals) {
		// sort based on start time
		Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
		// find if there is any overlap and return response
		for (int i = 1; i < intervals.length; i++) {
			Interval curr = intervals[i];
			Interval prev = intervals[i - 1];
			// <= not required since we can attend meetings immediately after
			if (curr.start < prev.end) {
				return false;
			}
		}
		return true;
	}

}
