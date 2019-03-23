package com.lin.nettyserver.http.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;

import com.lin.nettyserver.tcp.config.NamedDaemonThreadFactory;
import com.lin.nettyserver.tcp.config.ServerSocketOptions;

@ManagedResource(objectName = "com.lin.common:class=network,name=nettyHttpServer")
public class NettyHttpServer {
	private final Logger logger = LoggerFactory.getLogger(NettyHttpServer.class);
	private ServerBootstrap bootstrap;
	private final ServerSocketOptions options;
	private final EventLoopGroup selectorGroup;
	private final EventLoopGroup ioGroup;
	private ChannelHandler channelHandler;
	private int maxInitialLineLength = 4096;
	private int maxHeaderSize = 8192;
	private int maxChunkSize = 8192;
	private InetSocketAddress listenAddress;

	protected NettyHttpServer(@Nonnull InetSocketAddress listenAddress, @Nonnull ServerSocketOptions opts,
			@Nonnull ChannelHandler handler) {
		this.options = opts;
		this.channelHandler = handler;

		int selectThreadCount = Integer.parseInt(System.getProperty("netty.tcp.selectThreadCount",
				String.valueOf(Runtime.getRuntime().availableProcessors() / 2)));

		int ioThreadCount = Integer.parseInt(System.getProperty("netty.tcp.ioThreadCount",
				String.valueOf(Runtime.getRuntime().availableProcessors())));

		this.selectorGroup = new NioEventLoopGroup(selectThreadCount, new NamedDaemonThreadFactory("netty-tcp-select"));
		this.ioGroup = new NioEventLoopGroup(ioThreadCount, new NamedDaemonThreadFactory("netty-tcp-io"));

		this.listenAddress = listenAddress;
	}

	public void start() {
		this.bootstrap = ((ServerBootstrap) ((ServerBootstrap) ((ServerBootstrap) ((ServerBootstrap) ((ServerBootstrap) ((ServerBootstrap) new ServerBootstrap()
				.group(this.selectorGroup, this.ioGroup).channel(NioServerSocketChannel.class))
						.option(ChannelOption.SO_BACKLOG, Integer.valueOf(this.options.getBacklog())))
								.option(ChannelOption.SO_RCVBUF, Integer.valueOf(this.options.getRcvbuf()))).option(
										ChannelOption.SO_SNDBUF, Integer.valueOf(this.options.getSndbuf()))).option(
												ChannelOption.SO_REUSEADDR,
												Boolean.valueOf(this.options.isReuseAddr()))).localAddress(
														null == this.listenAddress ? new InetSocketAddress(8000)
																: this.listenAddress)).childHandler(
																		new ChannelInitializer<SocketChannel>() {
																			@Override
																			protected void initChannel(SocketChannel ch)
																					throws Exception {
																				SocketChannelConfig config = ch
																						.config();
																				config.setReceiveBufferSize(
																						NettyHttpServer.this.options
																								.getRcvbuf());
																				config.setSendBufferSize(
																						NettyHttpServer.this.options
																								.getSndbuf());
																				config.setKeepAlive(
																						NettyHttpServer.this.options
																								.isKeepAlive());
																				config.setReuseAddress(
																						NettyHttpServer.this.options
																								.isReuseAddr());
																				config.setSoLinger(
																						NettyHttpServer.this.options
																								.getLinger());
																				config.setTcpNoDelay(
																						NettyHttpServer.this.options
																								.isTcpNoDelay());

																				NettyHttpServer.this.logger.debug(
																						"connect {}",
																						ch.remoteAddress());

																				ch.pipeline().addLast("logger",
																						new LoggingHandler());
																				ch.pipeline().addLast("codec",
																						new HttpServerCodec(
																								NettyHttpServer.this.maxInitialLineLength,
																								NettyHttpServer.this.maxHeaderSize,
																								NettyHttpServer.this.maxChunkSize));
																				ch.pipeline().addLast("handler",
																						NettyHttpServer.this.channelHandler);
																			}

																		});
		ChannelFuture bindFuture = this.bootstrap.bind();
		bindFuture.addListener(new ChannelFutureListener() {
			public void operationComplete(ChannelFuture future) throws Exception {
				NettyHttpServer.this.logger.info("bind {}", future.channel().localAddress());
			}
		});

	}

	public void close() {
		try {
			if (null != this.selectorGroup) {
				this.selectorGroup.shutdownGracefully();
			}
			if (null != this.ioGroup) {
				this.ioGroup.shutdownGracefully();
			}
		} catch (Exception e) {
			this.logger.warn("close netty tcp server failure.exception:{}", ExceptionUtils.getMessage(e));
		}
	}

	@ManagedAttribute
	public int getMaxChunkSize() {
		return this.maxChunkSize;
	}

	@ManagedAttribute
	public void setMaxChunkSize(int maxChunkSize) {
		this.maxChunkSize = maxChunkSize;
	}

	@ManagedAttribute
	public int getMaxHeaderSize() {
		return this.maxHeaderSize;
	}

	@ManagedAttribute
	public void setMaxHeaderSize(int maxHeaderSize) {
		this.maxHeaderSize = maxHeaderSize;
	}

	@ManagedAttribute
	public int getMaxInitialLineLength() {
		return this.maxInitialLineLength;
	}

	@ManagedAttribute
	public void setMaxInitialLineLength(int maxInitialLineLength) {
		this.maxInitialLineLength = maxInitialLineLength;
	}
}