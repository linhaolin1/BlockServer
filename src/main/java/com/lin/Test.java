package com.lin;

import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws SQLException, IOException {
		Jedis j=new Jedis("10.14.21.133");
		Set<String> keys=j.keys("luban_result-*");
		for( String s:keys){
			j.del(s);
		}
	}
}
