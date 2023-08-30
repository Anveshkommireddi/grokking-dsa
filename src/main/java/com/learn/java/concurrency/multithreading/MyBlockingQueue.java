package com.learn.java.concurrency.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<E> {

	Queue<E> queue;
	int max;
	ReentrantLock lock = new ReentrantLock(true);
	Condition notFull = lock.newCondition();
	Condition notEmpty = lock.newCondition();

	public MyBlockingQueue(int size) {
		queue = new LinkedList<>();
		this.max = size;
	}

	public void enqueue(E item) throws InterruptedException {
		lock.lock();
		try {
			while (queue.size() == max) {
				notFull.await();
			}
			queue.add(item);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public E dequeue() throws InterruptedException {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notEmpty.await();
			}
			E item = queue.remove();
			notFull.signalAll();
			return item;
		} finally {
			lock.unlock();
		}
	}
}
