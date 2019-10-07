package com.lin.nettyserver.http.util;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.CharsetUtil;

import org.apache.commons.lang3.StringUtils;

import com.google.common.eventbus.EventBus;
import com.lin.nettyserver.http.bean.Propertyable;
import com.lin.nettyserver.http.statistic.event.HttpProcessStatisEvent;

public class ResponseUtil {
	private static final String CHANNEL_KEY = "channel";
	private static final String KEEP_ALIVE_KEY = "keepAlive";

	public static void response(Propertyable req, String resp) {
		Channel channel = (Channel) req.getProperty("channel");
		Boolean keepAlive = (Boolean) req.getProperty("keepAlive");

		long processTime = System.currentTimeMillis() - req.getTimeMillis();
		// eventBus.post(new HttpProcessStatisEvent(
		// req.getClass().getSimpleName(), processTime));
		FullHttpResponse response;
		if (StringUtils.isNotEmpty(resp)) {
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
					Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(resp, CharsetUtil.UTF_8)));
		} else {
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
		}

		if (null != response) {
			response.headers().set("Content-Type", "application/json; charset=UTF-8");
			response.headers().set("Access-Control-Allow-Origin", "*");
			response.headers().set("Access-Control-Allow-Headers", "*");
			if (keepAlive.booleanValue()) {
				response.headers().set("Content-Length", Integer.valueOf(response.content().readableBytes()));
				response.headers().set("Connection", "keep-alive");
			}
			ChannelFuture channelFuture = channel.writeAndFlush(response);
			if (!keepAlive.booleanValue()) {
				channelFuture.addListener(ChannelFutureListener.CLOSE);
			}
		}
	}

	public static void responseOk(Propertyable req) {
		String resp = new String("{\"result\":\"0\"}");

		Channel channel = (Channel) req.getProperty("channel");
		Boolean keepAlive = (Boolean) req.getProperty("keepAlive");

		long processTime = System.currentTimeMillis() - req.getTimeMillis();
		// eventBus.post(new HttpProcessStatisEvent(
		// req.getClass().getSimpleName(), processTime));
		FullHttpResponse response;
		if (StringUtils.isNotEmpty(resp)) {
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
					Unpooled.unreleasableBuffer(Unpooled.copiedBuffer(resp, CharsetUtil.UTF_8)));
		} else {
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
		}
		if (null != response) {
			response.headers().set("Content-Type", "application/json; charset=UTF-8");
			if (keepAlive.booleanValue()) {
				response.headers().set("Content-Length", Integer.valueOf(response.content().readableBytes()));

				response.headers().set("Connection", "keep-alive");
			}
			ChannelFuture channelFuture = channel.writeAndFlush(response);
			if (!keepAlive.booleanValue()) {
				channelFuture.addListener(ChannelFutureListener.CLOSE);
			}
		}
	}
}