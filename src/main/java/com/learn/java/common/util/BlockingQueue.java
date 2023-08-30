package com.learn.java.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlockingQueue<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlockingQueue.class);
	private static final String CONST_JUST_BEFORE_WAIT = "{} Just Before Wait";
	private static final String CONST_JUST_AFTER_WAIT = "{} Just After Wait";

	T[] array;
	int size;
	int capacity;
	int head;
	int tail;
	Object lock = new Object();

	@SuppressWarnings("unchecked")
	public BlockingQueue(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.head = 0;
		this.tail = 0;
		this.array = (T[]) new Object[capacity];
	}

	public void enqueue(T item) throws InterruptedException {

		synchronized (lock) {

			while (size == capacity) {
				LOGGER.info(CONST_JUST_BEFORE_WAIT, Thread.currentThread().getName());
				lock.wait();
				LOGGER.info(CONST_JUST_AFTER_WAIT, Thread.currentThread().getName());
			}

			if (tail == capacity) {
				tail = 0;
			}

			array[tail] = item;
			size++;
			tail++;

			lock.notifyAll();
		}
	}

	public T dequeue() throws InterruptedException {

		synchronized (lock) {

			T item = null;

			while (size == 0) {
				LOGGER.info(CONST_JUST_BEFORE_WAIT, Thread.currentThread().getName());
				lock.wait();
				LOGGER.info(CONST_JUST_AFTER_WAIT, Thread.currentThread().getName());
			}

			if (head == capacity) {
				head = 0;
			}

			item = array[head];
			array[head] = null;
			head++;
			size--;

			lock.notifyAll();
			return item;
		}

	}

}
