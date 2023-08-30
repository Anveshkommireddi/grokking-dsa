package com.learn.java.merge.intervals;

public class Job {

	int start;
	int end;
	int cpuLoad;

	public Job(int start, int end, int cpuLoad) {
		this.start = start;
		this.end = end;
		this.cpuLoad = cpuLoad;
	}

	private Job(JobBuilder jobBuilder) {
		this.start = jobBuilder.start;
		this.end = jobBuilder.end;
		this.cpuLoad = jobBuilder.cpuLoad;
	}

	public static class JobBuilder {

		int start;
		int end;
		int cpuLoad;
		
		public static JobBuilder builder () {
			return new JobBuilder();
		}

		public JobBuilder start(int start) {
			this.start = start;
			return this;
		}

		public JobBuilder end(int end) {
			this.end = end;
			return this;
		}

		public JobBuilder cpuLoad(int cpuLoad) {
			this.cpuLoad = cpuLoad;
			return this;
		}

		public Job build() {
			Job job = new Job(this);
			return job;
		}
	}
}
