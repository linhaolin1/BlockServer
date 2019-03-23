package com.lin.nettyserver.http.statistic.event;

public class HttpProcessStatisEvent {
	private String name;
	private long processTime;

	public HttpProcessStatisEvent(String name, long processTime) {
		this.name = name;
		this.processTime = processTime;
	}

	public String getName() {
		return this.name;
	}

	public long getProcessTime() {
		return this.processTime;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:").append(this.name);
		sb.append("|processTime:").append(this.processTime);
		return sb.toString();
	}
}
