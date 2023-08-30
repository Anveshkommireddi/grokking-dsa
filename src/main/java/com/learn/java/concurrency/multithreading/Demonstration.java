package com.learn.java.concurrency.multithreading;

public class Demonstration {
	public static void main(String... args) throws InterruptedException {
		SumUpExample.runTest();
	}
}

class SumUpExample {

	long startRange;
	long endRange;
	long counter = 0;
	static long maxNum = Integer.MAX_VALUE;

	public SumUpExample(long startRange, long endRange) {
		this.startRange = startRange;
		this.endRange = endRange;
	}

	public void add() {

		for (long i = startRange; i <= endRange; i++) {
			counter += i;
		}

		// counter = LongStream.range(startRange, endRange+1).parallel().sum();
	}

	public static void oneThread() {
		long start = System.currentTimeMillis();
		SumUpExample s = new SumUpExample(1, maxNum);
		s.add();
		long end = System.currentTimeMillis();
		System.out.println("Single thread final count = " + s.counter + " took " + (end - start));
	}

	public static void twoThreads() throws InterruptedException {

		long start = System.currentTimeMillis();
		SumUpExample s1 = new SumUpExample(1, maxNum / 2);
		SumUpExample s2 = new SumUpExample(1 + (maxNum / 2), maxNum);

		Thread t1 = new Thread(s1::add);

		Thread t2 = new Thread(s2::add);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		long finalCount = s1.counter + s2.counter;
		long end = System.currentTimeMillis();
		System.out.println("Two threads final count = " + finalCount + " took " + (end - start));
	}

	public static void runTest() throws InterruptedException {
		oneThread();
		twoThreads();
	}

}