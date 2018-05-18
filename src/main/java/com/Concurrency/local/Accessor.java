package com.Concurrency.local;

public class Accessor implements Runnable{
	
	public Accessor(int id) {
		super();
		this.id = id;
	}
	private final int id;

	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	@Override
	public String toString() {
		return "#" + id + ": " + ThreadLocalVariableHolder.get();
	}

}
