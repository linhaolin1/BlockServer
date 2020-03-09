package com.lin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		Stream<Path> paths= Files.list(Paths.get("/Users/linhao.lion/java-project/BlockServer/output/docker"));
		paths.forEach(new Consumer<Path>(){
			@Override
			public void accept(Path path) {
				System.out.println(path.toString());
			}
		});
	}
}
