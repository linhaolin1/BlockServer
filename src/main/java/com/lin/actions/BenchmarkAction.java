package com.lin.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;
import com.lin.NettyServer;
import com.lin.nettyserver.http.annotation.HttpHandler;
import com.lin.nettyserver.http.annotation.RequestMapper;
import com.lin.request.BenchmarkReq;
import com.lin.request.req.ProcessReq;
import com.lin.request.resp.ProcessResp;
import com.lin.service.ProcessService;

@HttpHandler
@Component
@BenchmarkMode(Mode.Throughput) // 吞吐量
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 结果所使用的时间单位
@State(Scope.Thread) // 每个测试线程分配一个实例
@Fork(2) // Fork进行的数目
@Warmup(iterations = 4) // 先预热4轮
@Measurement(iterations = 20) // 进行10轮测试
public class BenchmarkAction {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProcessService processService;

	@Param({ "{\"processId\":215,\"object\":{\"SecondCateId\":\"248\"}}",
			"{\"processId\":213,\"object\":{\"SecondCateId\":\"248\",\"PageSize\":4,\"Page\":1}}",
			"{\"processId\":212,\"object\":{\"PId\":\"356\"}}",
			"{\"processId\":220,\"object\":{\"UserName\":\"18676347565\",\"Password\":\"123456\",\"InvitationCode\":\"\",\"RId\":0}}" }) // 定义四个参数，之后会分别对这四个参数进行测试
	private String n;

	@Setup(Level.Trial) // 初始化方法，在全部Benchmark运行之前进行
	public void init() {
		processService=NettyServer.context.getBean(ProcessService.class);
	}

	@Benchmark
	public void arrayTraverse() {
		ProcessReq req = JSON.parseObject(n, ProcessReq.class);
		ProcessResp resp = new ProcessResp();
		try {
			processService.executeProcess(req, resp, Long.valueOf(0L));
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@TearDown(Level.Trial) // 结束方法，在全部Benchmark运行之后进行
	public void arrayRemove() {
	}

	@Subscribe
	@RequestMapper(url = "/block-server/benchmark", codecName = "blockKvDecodec", clazz = BenchmarkReq.class)
	public void benchmark(BenchmarkReq req) {
		Options options = new OptionsBuilder().include(BenchmarkAction.class.getSimpleName()).build();
		try {
			new Runner(options).run();
		} catch (RunnerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
