package com.lin.nettyserver.tcp.config;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedDaemonThreadFactory implements ThreadFactory {
	private static final AtomicInteger COUNTER = new AtomicInteger(0);
	private final String prefix;

	public NamedDaemonThreadFactory(String prefix) {
		this.prefix = prefix;
	}

	public Thread newThread(Runnable runnable) {
		Thread t = new Thread(runnable);
		t.setName(this.prefix + "-" + COUNTER.incrementAndGet());
		t.setDaemon(true);
		return t;
	}
}
