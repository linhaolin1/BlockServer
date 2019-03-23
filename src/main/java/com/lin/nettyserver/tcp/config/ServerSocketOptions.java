package com.lin.nettyserver.tcp.config;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "com.lin.common:class=network,name=serverSocketOptions")
public class ServerSocketOptions extends CommonSocketOptions<ServerSocketOptions> {
	private int backlog = 1000;
	private boolean reuseAddr = true;

	@ManagedAttribute
	public int getBacklog() {
		return this.backlog;
	}

	@ManagedAttribute
	public void setBacklog(int backlog) {
		this.backlog = backlog;
	}

	@ManagedAttribute
	public boolean isReuseAddr() {
		return this.reuseAddr;
	}

	@ManagedAttribute
	public void setReuseAddr(boolean reuseAddr) {
		this.reuseAddr = reuseAddr;
	}
}