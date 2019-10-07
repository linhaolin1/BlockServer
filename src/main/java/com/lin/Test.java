package com.lin;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;

public class Test {

	public static void main(String[] args) throws SQLException {

		// TODO Auto-generated constructor stub
//		DruidDataSource cpSource = new DruidDataSource();
//		cpSource.setUrl("jdbc:mysql://106.52.110.245:3306/xianggou_business?useUnicode=true&characterEncoding=UTF-8");
//		cpSource.setDriverClassName("com.mysql.jdbc.Driver");
//		cpSource.setUsername("linhaolin1");
//		cpSource.setPassword("Angel929");
//		cpSource.setInitialSize(5);
//		cpSource.setMaxActive(10);
//
//		MainClass mc = new MainClass();
//		mc.setConn(cpSource.getConnection());
//
//		String s = "select tpa.id as ActivityId,tps.PId,p.Name,tpa.LimitCount,tpa.StartTime,tpa.EndTime,tpa.AInstructions,tpa.Title,tpa.Details,tpa.Icon,tpa.DisplayOrder,tpa.State from xb_timeproductactivity tpa INNER JOIN xb_timeproductsku tps on tpa.id = tps.AId INNER JOIN xb_products p on tps.PId = p.id where tpa.id=1956 group by tpa.id";
//
//		DirectSqlReq req = new DirectSqlReq();
//		req.setSql(s);
//		req.setLimitRow("10");
//		req.setPage("1");
//
//		DirectSqlResp resp = new DirectSqlResp();
//		mc.directSql(req, resp);
//		JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
//		System.out.println(JSON.toJSONStringWithDateFormat(resp.getResult(), "yyyy-MM-dd HH:mm:ss"));

		// JsDataLoader dl = new JsDataLoader("e:\\test.js");
		// dl.put("test", resp.getResult());
		// System.out.println(dl.get("test"));

	}

	// public static void main(String[] args) throws IOException {
	//
	// ConsulClient client = new ConsulClient("148.70.22.79");
	// byte[] binaryData = new byte[] {1,2,3,4,5,6,7};
	// client.setKVBinaryValue("someKey", binaryData);
	//
	// client.setKVValue("com.my.app.foo", "foo");
	// client.setKVValue("com.my.app.bar", "bar");
	// client.setKVValue("com.your.app.foo", "hello");
	// client.setKVValue("com.your.app.bar", "world");
	//
	// // get single KV for key
	// Response<GetValue> keyValueResponse =
	// client.getKVValue("com.my.app.foo");
	// System.out.println(keyValueResponse.getValue().getKey() + ": " +
	// keyValueResponse.getValue().getDecodedValue()); // prints
	// "com.my.app.foo: foo"
	//
	// // get list of KVs for key prefix (recursive)
	// Response<List<GetValue>> keyValuesResponse =
	// client.getKVValues("com.my");
	// keyValuesResponse.getValue().forEach(value ->
	// System.out.println(value.getKey() + ": " + value.getDecodedValue())); //
	// prints "com.my.app.foo: foo" and "com.my.app.bar: bar"
	//
	// //list known datacenters
	// Response<List<String>> response = client.getCatalogDatacenters();
	// System.out.println("Datacenters: " + response.getValue());
	//
	// // register new service
	// NewService newService = new NewService();
	// newService.setId("myapp_01");
	// newService.setName("block-server/dynamic/14");
	// newService.setTags(Arrays.asList("EU-West", "EU-East"));
	// newService.setPort(8080);
	// client.agentServiceRegister(newService);
	//
	// // register new service with associated health check
	// newService = new NewService();
	// newService.setId("myapp_02");
	// newService.setTags(Collections.singletonList("EU-East"));
	// newService.setName("block-server/dynamic/13");
	// newService.setPort(8080);
	//
	// client.agentServiceRegister(newService);
	//
	// // query for healthy services based on name (returns myapp_01 and
	// myapp_02 if healthy)
	// HealthServicesRequest request = HealthServicesRequest.newBuilder()
	// .setPassing(true)
	// .setQueryParams(QueryParams.DEFAULT)
	// .build();
	// Response<List<HealthService>> healthyServices =
	// client.getHealthServices("block-server/dynamic/14", request);
	// System.out.println(healthyServices.getValue().size());

	// String s="value 2";
	// System.out.println(s.replaceAll("([a-z]+[ ])([\\d])", "$2"));

	// }
}
