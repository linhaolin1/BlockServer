package com.lin.nettyserver.http.statistic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.google.common.eventbus.Subscribe;
import com.lin.nettyserver.http.statistic.event.HttpProcessStatisEvent;

@ManagedResource(objectName = "com.yunva.common:class=biz,name=httpStatistics")
public class HttpStatistcs {
	private ConcurrentHashMap<String, AtomicLong> bizCount = new ConcurrentHashMap();
	private ConcurrentHashMap<String, AtomicLong> bizTime = new ConcurrentHashMap();
	private ConcurrentHashMap<String, AtomicLong> minTime = new ConcurrentHashMap();
	private ConcurrentHashMap<String, AtomicLong> maxTime = new ConcurrentHashMap();
	private boolean turnOn = true;

	@Subscribe
	public void onProcessStatisEvent(HttpProcessStatisEvent event) {
		if (this.turnOn) {
			if (null == this.bizCount.get(event.getName())) {
				this.bizCount.putIfAbsent(event.getName(), new AtomicLong(0L));
			}
			((AtomicLong) this.bizCount.get(event.getName())).incrementAndGet();
			if (null == this.bizTime.get(event.getName())) {
				this.bizTime.putIfAbsent(event.getName(), new AtomicLong(0L));
			}
			((AtomicLong) this.bizTime.get(event.getName())).addAndGet(event.getProcessTime());
			if (null == this.minTime.get(event.getName())) {
				this.minTime.putIfAbsent(event.getName(), new AtomicLong(0L));
			}
			long min = ((AtomicLong) this.minTime.get(event.getName())).get();
			if ((0L == min) || (min > event.getProcessTime())) {
				((AtomicLong) this.minTime.get(event.getName())).compareAndSet(min, event.getProcessTime());
			}
			if (null == this.maxTime.get(event.getName())) {
				this.maxTime.putIfAbsent(event.getName(), new AtomicLong(0L));
			}
			long max = ((AtomicLong) this.maxTime.get(event.getName())).get();
			if (max < event.getProcessTime()) {
				((AtomicLong) this.maxTime.get(event.getName())).compareAndSet(max, event.getProcessTime());
			}
		}
	}

	@ManagedOperation
	public boolean isTurnOn() {
		return this.turnOn;
	}

	@ManagedOperation
	public void setTurnOn(boolean turnOn) {
		if (turnOn) {
			this.bizCount.clear();
			this.bizTime.clear();
			this.minTime.clear();
			this.maxTime.clear();
			this.turnOn = turnOn;
		} else {
			this.turnOn = turnOn;
			this.bizCount.clear();
			this.bizTime.clear();
			this.minTime.clear();
			this.maxTime.clear();
		}
	}

	@ManagedAttribute
	public ConcurrentHashMap<String, AtomicLong> getBizCount() {
		return this.bizCount;
	}

	@ManagedAttribute
	public ConcurrentHashMap<String, AtomicLong> getBizTime() {
		return this.bizTime;
	}

	@ManagedAttribute
	public ConcurrentHashMap<String, AtomicLong> getMinTime() {
		return this.minTime;
	}

	@ManagedAttribute
	public ConcurrentHashMap<String, AtomicLong> getMaxTime() {
		return this.maxTime;
	}

	@ManagedAttribute
	public List<String> getAvgTime() {
		List<String> string = new ArrayList();
		for (Map.Entry<String, AtomicLong> entry : this.bizTime.entrySet()) {
			try {
				long count = ((AtomicLong) this.bizCount.get(entry.getKey())).get();
				long time = ((AtomicLong) entry.getValue()).get();
				string.add((String) entry.getKey() + ":" + time / count);
			} catch (Exception e) {
			}
		}
		return string;
	}
}