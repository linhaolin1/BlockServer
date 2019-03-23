package com.lin.nettyserver.http.statistic;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract interface Statisable {
	@JsonIgnore
	public abstract long getTimeMillis();
}