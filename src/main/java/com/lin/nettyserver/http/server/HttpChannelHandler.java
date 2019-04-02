package com.lin.nettyserver.http.server;

import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.lin.nettyserver.http.bean.Propertyable;
import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.codec.json.JsonDecodec;
import com.lin.nettyserver.http.codec.kv.KvDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedReq;
import com.lin.nettyserver.http.codec.xml.XmlDecodec;
import com.lin.nettyserver.http.config.IoMapperConfig;
import com.lin.nettyserver.http.config.UrlMapperConfig;
import com.lin.nettyserver.http.util.UrlUtil;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.CharsetUtil;

@ChannelHandler.Sharable
public class HttpChannelHandler extends ChannelInboundHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(HttpChannelHandler.class);
	private UrlMapperConfig config;
	private IoMapperConfig ioConfig;
	private Executor excutorService;
	// private EventBus eventBus;
	private String IP_KEY = "ip";
	private String CHANNEL_KEY = "channel";
	private String KEEP_ALIVE_KEY = "keepAlive";
	private final StringBuilder buf = new StringBuilder();
	private HttpRequest httpRequest;

	public HttpChannelHandler(IoMapperConfig ioConfig, UrlMapperConfig config, Executor excutorService) {
		// this.eventBus = eventBus;
		this.config = config;
		this.ioConfig = ioConfig;
		this.excutorService = excutorService;
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if ((msg instanceof HttpRequest)) {
			HttpRequest request = this.httpRequest = (HttpRequest) msg;
			if (HttpHeaders.is100ContinueExpected(request)) {
				send100Continue(ctx);
			}
			this.buf.setLength(0);
			if ((!this.httpRequest.getMethod().equals(HttpMethod.POST))
					&& (!this.httpRequest.getMethod().equals(HttpMethod.GET))) {
				logger.error("unsupported request method:{} request.", request.getUri());
				ctx.channel().close();
				return;
			}
		}
		
		if ((msg instanceof HttpContent)) {

			HttpContent httpContent = (HttpContent) msg;

			ByteBuf content = httpContent.content();
			if (content.isReadable()) {
				this.buf.append(content.toString(CharsetUtil.UTF_8));
			}
			if ((msg instanceof LastHttpContent)) {
				QueryStringDecoder queryStringDecoder = new QueryStringDecoder(this.httpRequest.getUri());
				String url = queryStringDecoder.path();

				if (!this.config.contains(url)) {
					logger.error("unsupported url:{} request.", url);
					ctx.channel().close();
					return;
				}
				HttpDecodec decodec = this.config.getHttpDecodec(url);
				Class clazz = this.config.getClass(url);
				Object requestEvent = null;
				
				if (decodec instanceof KvDecodec) {
					requestEvent = postKvDecode(decodec, queryStringDecoder, clazz);
				} else if (decodec instanceof JsonDecodec) {
					requestEvent = decodec.decode(this.buf.toString(), clazz);
				} else if (decodec instanceof XmlDecodec) {
					requestEvent = decodec.decode(this.buf.toString(), clazz);
				} else if (decodec instanceof UnspecifiedDecodec) {
					UnspecifiedReq req = new UnspecifiedReq();
					requestEvent = req;
					req.setUrl(url);
					Map<String, List<String>> params = null;
					if (this.httpRequest.getMethod().equals(HttpMethod.GET)) {
						params = queryStringDecoder.parameters();
						req.setObject(params);
					} else {
						HttpHeaders headers = this.httpRequest.headers();
						String contentType = headers.get(HttpHeaders.Names.CONTENT_TYPE);
						try {

							if (contentType.toLowerCase().indexOf("form") != -1) {
								Map<String, List<String>> queryParams = kvParams(queryStringDecoder);
								
								Map<String, Object> objectMap = new HashMap<String, Object>();
								for (Entry<String, List<String>> entry : queryParams.entrySet()) {

									if (entry.getValue() == null || entry.getValue().size() == 0) {

									} else if (entry.getValue().size() == 1) {
										objectMap.put(entry.getKey(), entry.getValue().get(0));
									} else {
										objectMap.put(entry.getKey(), entry.getValue());
									}
								}
								req.setObject(objectMap);
							} else if (contentType.toLowerCase().indexOf("json") != -1) {
								req.setObject((Map) JSON.parse(URLDecoder.decode(this.buf.toString(), "utf-8")));
							} else if (contentType.toLowerCase().indexOf("xml") != -1) {
								req.setObject(UrlUtil.parseXmlParam(URLDecoder.decode(this.buf.toString(), "utf-8")));
							}
						} catch (Exception e) {
							
							e.printStackTrace();
						}
					}

				}

				
				if (null != requestEvent) {
					if ((requestEvent instanceof Propertyable)) {
						Propertyable propertyable = (Propertyable) requestEvent;
						InetSocketAddress remoteAddress = (InetSocketAddress) ctx.channel().remoteAddress();
						propertyable.setProperty(this.IP_KEY, remoteAddress.getAddress().getHostAddress());
						propertyable.setProperty(this.CHANNEL_KEY, ctx.channel());
						propertyable.setProperty(this.KEEP_ALIVE_KEY,
								Boolean.valueOf(HttpHeaders.isKeepAlive(this.httpRequest)));
						sendEvent(requestEvent);
					}

					// this.eventBus.post(requestEvent);
				} else {
					logger.warn("decodec params:{} to clazz:{} is null...", this.buf, clazz);
				}
			}
		}
	}

	private Object postKvDecode(HttpDecodec decodec, QueryStringDecoder queryStringDecoder, Class clazz) {
		Object requestEvent = null;
		Map<String, List<String>> params = kvParams(queryStringDecoder);
		requestEvent = decodec.decode(params, clazz);
		return requestEvent;
	}

	private Map<String, List<String>> kvParams(QueryStringDecoder queryStringDecoder) {
		Map<String, List<String>> params = null;
		if (this.httpRequest.getMethod().equals(HttpMethod.POST)) {
			params = UrlUtil.decodeParams(this.buf.toString(), CharsetUtil.UTF_8);

			Map<String, List<String>> params1 = queryStringDecoder.parameters();
			if (null != params) {
				if (null != params1) {
					params.putAll(params1);
				}
			} else {
				params = params1;
			}
		} else if (this.httpRequest.getMethod().equals(HttpMethod.GET)) {
			params = queryStringDecoder.parameters();
		}

		return params;
	}

	private void sendEvent(final Object requestEvent) {
		excutorService.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ioConfig.getMethod(requestEvent.getClass()).invoke(ioConfig.getClass(requestEvent.getClass()),
							requestEvent);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	private static void send100Continue(ChannelHandlerContext ctx) {
		FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.CONTINUE);
		ctx.write(response);
	}

	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.warn("Unexpected exception from downstream,cause:{}.", cause);
		ctx.close();
	}

	public void setIP_KEY(String IP_KEY) {
		this.IP_KEY = IP_KEY;
	}

	public void setKEEP_ALIVE_KEY(String KEEP_ALIVE_KEY) {
		this.KEEP_ALIVE_KEY = KEEP_ALIVE_KEY;
	}

	public void setCHANNEL_KEY(String CHANNEL_KEY) {
		this.CHANNEL_KEY = CHANNEL_KEY;
	}
}
