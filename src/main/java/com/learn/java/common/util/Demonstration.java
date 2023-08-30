package com.learn.java.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demonstration {

	private static final Logger LOGGER = LoggerFactory.getLogger(Demonstration.class);
	private static final String CONST_INTERRUPTED_THREAD = "Interruped Exception Occured for the Thread :: {}";

	public static void main(String[] args) throws Exception {

		final BlockingQueue<Integer> q = new BlockingQueue<>(1);

		Thread t1 = new Thread(() -> {
			try {
				for (int i = 0; i < 50; i++) {
					q.enqueue(Integer.valueOf(i));
					LOGGER.error("Thread 1 enqueued {}", i);
				}
			} catch (InterruptedException ie) {
				LOGGER.error(CONST_INTERRUPTED_THREAD, Thread.currentThread().getName());
				Thread.currentThread().interrupt();
			}
		});

		Thread t2 = new Thread(() -> {
			try {
				for (int i = 0; i < 25; i++) {
					LOGGER.error("Thread 2 dequeued: {}", q.dequeue());
				}
			} catch (InterruptedException ie) {
				LOGGER.error(CONST_INTERRUPTED_THREAD, Thread.currentThread().getName());
				Thread.currentThread().interrupt();
			}
		});

		Thread t3 = new Thread(() -> {
			try {
				for (int i = 0; i < 25; i++) {
					LOGGER.error("Thread 3 dequeued: {}", q.dequeue());
				}
			} catch (InterruptedException ie) {
				LOGGER.error(CONST_INTERRUPTED_THREAD, Thread.currentThread().getName());
				Thread.currentThread().interrupt();
			}
		});

		t1.start();
		Thread.sleep(4000);

		t2.start();

		t2.join();

		t3.start();
		t1.join();
		t3.join();

	}
}
