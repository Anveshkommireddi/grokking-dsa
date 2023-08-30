package com.learn.java.merge.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

//We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running. 
//Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
public class MaximumCPULoad {

	private static final Logger LOG = LoggerFactory.getLogger(MaximumCPULoad.class);
	private static final String CONST_RESPONSE = "Maximum CPU load at any time: {}";

	public static void main(String[] args) {
		
		Job job1 = Job.JobBuilder.builder().start(1).end(4).cpuLoad(3).build();
		Job job2 = Job.JobBuilder.builder().start(2).end(5).cpuLoad(4).build();
		Job job3 = Job.JobBuilder.builder().start(7).end(9).cpuLoad(6).build();
		List<Job> input = new ArrayList<>(Arrays.asList(job1, job2, job3));
		int response = findMaxCPULoad(input);
		LOG.info(CONST_RESPONSE, response);

		Job job4 = Job.JobBuilder.builder().start(6).end(7).cpuLoad(10).build();
		Job job5 = Job.JobBuilder.builder().start(2).end(4).cpuLoad(11).build();
		Job job6 = Job.JobBuilder.builder().start(8).end(12).cpuLoad(15).build();
		input = new ArrayList<>(Arrays.asList(job4, job5, job6));
		response = findMaxCPULoad(input);
		LOG.info(CONST_RESPONSE, response);

		Job job7 = Job.JobBuilder.builder().start(1).end(4).cpuLoad(2).build();
		Job job8 = Job.JobBuilder.builder().start(2).end(4).cpuLoad(1).build();
		Job job9 = Job.JobBuilder.builder().start(3).end(6).cpuLoad(5).build();
		input = new ArrayList<>(Arrays.asList(job7, job8, job9));
		response = findMaxCPULoad(input);
		LOG.info(CONST_RESPONSE, response);
	}

	private static int findMaxCPULoad(List<Job> cpuJobsLst) {
		int result = 0;
		int currLoad = 0;
		Collections.sort(cpuJobsLst, (job1, job2) -> Integer.compare(job1.start, job2.start));
		PriorityQueue<Job> minHeap = new PriorityQueue<>((job1, job2) -> Integer.compare(job1.end, job2.end));
		for (int i = 0; i < cpuJobsLst.size(); i++) {
			Job currJob = cpuJobsLst.get(i);
			while (!minHeap.isEmpty() && currJob.start >= minHeap.peek().end) {
				Job oldJob = minHeap.poll();
				currLoad -= oldJob.cpuLoad;
			}
			minHeap.offer(currJob);
			currLoad += currJob.cpuLoad;
			result = Math.max(result, currLoad);
		}
		return result;
	}
}
