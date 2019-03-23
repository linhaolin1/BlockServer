package com.lin.nettyserver.tcp.config;

import org.springframework.jmx.export.annotation.ManagedAttribute;

public abstract class CommonSocketOptions<SO extends CommonSocketOptions<? super SO>> {
	private int timeout = 30000;
	private boolean keepAlive = true;
	private int linger = 30000;
	private boolean tcpNoDelay = true;
	private int rcvbuf = 2048000;
	private int sndbuf = 2048000;

	@ManagedAttribute
	public int getTimeout() {
		return this.timeout;
	}

	@ManagedAttribute
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	@ManagedAttribute
	public boolean isKeepAlive() {
		return this.keepAlive;
	}

	@ManagedAttribute
	public void setKeepAlive(boolean keepAlive) {
		this.keepAlive = keepAlive;
	}

	@ManagedAttribute
	public int getLinger() {
		return this.linger;
	}

	@ManagedAttribute
	public void setLinger(int linger) {
		this.linger = linger;
	}

	@ManagedAttribute
	public boolean isTcpNoDelay() {
		return this.tcpNoDelay;
	}

	@ManagedAttribute
	public void setTcpNoDelay(boolean tcpNoDelay) {
		this.tcpNoDelay = tcpNoDelay;
	}

	@ManagedAttribute
	public int getRcvbuf() {
		return this.rcvbuf;
	}

	@ManagedAttribute
	public void setRcvbuf(int rcvbuf) {
		this.rcvbuf = rcvbuf;
	}

	@ManagedAttribute
	public int getSndbuf() {
		return this.sndbuf;
	}

	@ManagedAttribute
	public void setSndbuf(int sndbuf) {
		this.sndbuf = sndbuf;
	}
}