package com.util;

public final class Chronometer {

	private static long startValue;
	private static long stopValue;
	private static long timeDiff;

	public void start() {
		startValue = System.currentTimeMillis();
		stopValue = 0;
		timeDiff = 0;
	}

	public void stop() {
		stopValue = System.currentTimeMillis();
		timeDiff = stopValue - startValue;
	}

	public long elapsedTime() {
		return timeDiff;
	}
}