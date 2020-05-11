package com.lin.nettyserver.http.server;

import com.alibaba.fastjson.JSON;
import com.lin.NettyServer;
import com.lin.constants.BlockConstant;
import com.lin.nettyserver.http.bean.Propertyable;
import com.lin.nettyserver.http.codec.HttpDecodec;
import com.lin.nettyserver.http.codec.json.JsonDecodec;
import com.lin.nettyserver.http.codec.kv.KvDecodec;
import com.lin.nettyserver.http.codec.mutipart.MutipartDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedDecodec;
import com.lin.nettyserver.http.codec.unspecified.UnspecifiedReq;
import com.lin.nettyserver.http.codec.xml.XmlDecodec;
import com.lin.nettyserver.http.config.IoMapperConfig;
import com.lin.nettyserver.http.config.UrlMapperConfig;
import com.lin.nettyserver.http.util.UrlUtil;
import com.lin.service.SequenceService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.CharsetUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

@ChannelHandler.Sharable
public class HttpChannelHandler extends ChannelHandlerAdapter {
	private static final Logger logger = LoggerFactory.getLogger(HttpChannelHandler.class);
	private UrlMapperConfig config;
	private IoMapperConfig ioConfig;
	private Executor excutorService;
	// private EventBus eventBus;
	private String IP_KEY = "ip";
	private String CHANNEL_KEY = "channel";
	private String KEEP_ALIVE_KEY = "keepAlive";
	private final StringBuilder buf = new StringBuilder();
	private HttpPostRequestDecoder mutiDecoder;
	private HttpRequest httpRequest;

	public HttpChannelHandler(IoMapperConfig ioConfig, UrlMapperConfig config, Executor excutorService) {
		// this.eventBus = eventBus;
		this.config = config;
		this.ioConfig = ioConfig;
		this.excutorService = excutorService;
	}

	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		SequenceService sequenceService= NettyServer.context.getBean(SequenceService.class);


		if ((msg instanceof HttpRequest)) {
			HttpRequest request = this.httpRequest = (HttpRequest) msg;

			if (HttpHeaderUtil.is100ContinueExpected(request)) {
				send100Continue(ctx);
			}
			this.mutiDecoder=new HttpPostRequestDecoder(request);
			this.buf.setLength(0);
			if (this.httpRequest != null && this.httpRequest.method().equals(HttpMethod.OPTIONS)) {
				FullHttpResponse response;
				response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
				response.headers().set("Access-Control-Allow-Origin", "*");
				response.headers().set("Access-Control-Allow-Headers", "*");
				ChannelFuture channelFuture = ctx.channel().writeAndFlush(response);
				ctx.channel().close();
				return;
			}

			if ((!this.httpRequest.method().equals(HttpMethod.POST))
					&& (!this.httpRequest.method().equals(HttpMethod.GET))) {
				logger.error("unsupported request method:{} request.", request.uri());
				ctx.channel().close();
				return;
			}
		}


		if ((msg instanceof HttpContent)) {
			Long time = System.currentTimeMillis();

			HttpContent httpContent = (HttpContent) msg;

			ByteBuf content = httpContent.content();
			if (content.isReadable()) {
				this.buf.append(content.toString(CharsetUtil.UTF_8));
				mutiDecoder.offer(httpContent);
			}
			content.release();
			if ((msg instanceof LastHttpContent)) {
				QueryStringDecoder queryStringDecoder = new QueryStringDecoder(this.httpRequest.uri());
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
				} else if (decodec instanceof JsonDecodec||decodec instanceof XmlDecodec) {
					requestEvent = decodec.decode(this.buf.toString(), clazz);
				} else if (decodec instanceof MutipartDecodec) {
					requestEvent = decodec.decode(mutiDecoder, clazz);
				}else if (decodec instanceof UnspecifiedDecodec) {
					UnspecifiedReq req = new UnspecifiedReq();
					requestEvent = req;
					req.setUrl(url);
					Map<String, List<String>> params = null;
					if (this.httpRequest.method().equals(HttpMethod.GET)) {
						params = queryStringDecoder.parameters();
						req.setObject(params);
					} else {
						HttpHeaders headers = this.httpRequest.headers();
						String contentType = headers.get(HttpHeaderNames.CONTENT_TYPE).toString();
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

				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_DECODEMSG, 0L, System.currentTimeMillis() - time,
						0, null, null, JSON.toJSONString(requestEvent));
				time = System.currentTimeMillis();

				if (null != requestEvent) {
					if ((requestEvent instanceof Propertyable)) {
						Propertyable propertyable = (Propertyable) requestEvent;
						InetSocketAddress remoteAddress = (InetSocketAddress) ctx.channel().remoteAddress();

						if (!StringUtils.isBlank(httpRequest.headers().get("X-Forwarded-For"))) {
							propertyable.setProperty(this.IP_KEY,
									httpRequest.headers().get("X-Forwarded-For").toString().split(",")[0].split(":")[0]);
						} else {
							propertyable.setProperty(this.IP_KEY, remoteAddress.getAddress().getHostAddress());
						}

						propertyable.setProperty(this.CHANNEL_KEY, ctx.channel());
						propertyable.setProperty(this.KEEP_ALIVE_KEY,
								Boolean.valueOf(HttpHeaderUtil.isKeepAlive(this.httpRequest)));
						sendEvent(requestEvent);
					}

					// this.eventBus.post(requestEvent);
				} else {
					logger.warn("decodec params:{} to clazz:{} is null...", this.buf, clazz);
				}
				sequenceService.save(BlockConstant.PROCESS_SEQUENCE_SENDEVENT, 0L, System.currentTimeMillis() - time,
						0, null, null, JSON.toJSONString(requestEvent));
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
		if (this.httpRequest.method().equals(HttpMethod.POST)) {
			params = UrlUtil.decodeParams(this.buf.toString(), CharsetUtil.UTF_8);

			Map<String, List<String>> params1 = queryStringDecoder.parameters();
			if (null != params) {
				if (null != params1) {
					params.putAll(params1);
				}
			} else {
				params = params1;
			}
		} else if (this.httpRequest.method().equals(HttpMethod.GET)) {
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
