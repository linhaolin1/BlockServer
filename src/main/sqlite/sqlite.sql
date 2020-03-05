BEGIN TRANSACTION;
CREATE TABLE htmlParam (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`width`	INTEGER,
	`height`	INTEGER,
	`top`	INTEGER,
	`left`	INTEGER,
	`column`	INTEGER,
	`row`	INTEGER,
	`type`	INTEGER,
	`template`	INTEGER
);
INSERT INTO htmlParam VALUES (1,1,100,20,20,10,2,1,NULL);
CREATE TABLE ’dataTable’ (
	`id`	INTEGER,
	`name`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO dataTable VALUES (4,TBL_CATEGORY);
INSERT INTO dataTable VALUES (5,'TBL_COMMENT_TAG');
INSERT INTO dataTable VALUES (6,'TBL_COMMENT_TAG_VAL');
INSERT INTO dataTable VALUES (7,'TBL_DELIVERY');
INSERT INTO dataTable VALUES (8,'TBL_DICT_TYPE');
INSERT INTO dataTable VALUES (9,'TBL_DICT_VAL');
INSERT INTO dataTable VALUES (10,'TBL_GOODS');
INSERT INTO dataTable VALUES (11,'TBL_GOODS_ATTR');
INSERT INTO dataTable VALUES (12,'TBL_GOODS_ATTR_DETAIL');
INSERT INTO dataTable VALUES (13,'TBL_GOODS_COLLECT');
INSERT INTO dataTable VALUES (14,'TBL_GOODS_COMMENT');
INSERT INTO dataTable VALUES (15,'TBL_GOODS_PIC');
INSERT INTO dataTable VALUES (16,'TBL_GOODS_SNAPSHOT');
INSERT INTO dataTable VALUES (17,'TBL_HELP');
INSERT INTO dataTable VALUES (18,TBL_HELP_TYPE);
INSERT INTO dataTable VALUES (19,'TBL_ORDER');
INSERT INTO dataTable VALUES (20,'TBL_ORDER_GOODS');
INSERT INTO dataTable VALUES (21,TBL_ORDER_GOODS_ATTR);
INSERT INTO dataTable VALUES (22,TBL_ORDER_OPERATION);
INSERT INTO dataTable VALUES (23,TBL_ORDER_PAY);
INSERT INTO dataTable VALUES (24,TBL_PAY_TYPE);
INSERT INTO dataTable VALUES (25,TBL_SHOP);
INSERT INTO dataTable VALUES (26,TBL_SHOP_BANK_INFO);
INSERT INTO dataTable VALUES (27,TBL_SHOP_CHECK);
INSERT INTO dataTable VALUES (28,TBL_SHOP_DELIVER);
INSERT INTO dataTable VALUES (29,TBL_SHOP_INFO);
INSERT INTO dataTable VALUES (30,'TBL_SHOP_SETTLE');
INSERT INTO dataTable VALUES (31,'TBL_USER');
INSERT INTO dataTable VALUES (32,'TBL_USER_ADDRESS');
INSERT INTO dataTable VALUES (33,TBL_BANNER);
INSERT INTO dataTable VALUES (34,'TBL_TOKEN');
INSERT INTO dataTable VALUES (35,'TBL_TOPIC_CONTENT');
INSERT INTO dataTable VALUES (36,'TBL_TOPIC');
CREATE TABLE 'TBL_USER_ADDRESS' (
		`id` INTEGER,
		   
			userId varchar(100)
		 , 
			userName varchar(100)
		 , 
			province varchar(100)
		 , 
			city varchar(100)
		 , 
			district varchar(100)
		 , 
			detail varchar(100)
		 , 
			phone varchar(100)
		 , 
			createTime varchar(100)
		 , 
			isDefault varchar(100)
		 , 
			country varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE 'TBL_USER' (
		`id` INTEGER,
		   
			username varchar(100)
		 , 
			password varchar(100)
		 , 
			email varchar(100)
		 , 
			mobile varchar(100)
		 , 
			type varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
INSERT INTO `TBL_USER` VALUES (1,'123','123','','','');
CREATE TABLE ’TBL_TOPIC_CONTENT’ (
	`id`	INTEGER,
	`picUrl`	varchar(100),
	`url`	varchar(100),
	`position`	varchar(100),
	`width`	varchar(100),
	`topic`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO TBL_TOPIC_CONTENT VALUES (1,'images/vip1.png','single.html?id=9','1','100','1');
INSERT INTO TBL_TOPIC_CONTENT VALUES (2,'images/vip3.png','single.html?id=9','2','33','1');
INSERT INTO TBL_TOPIC_CONTENT VALUES (3,'images/vip4.png','single.html?id=9','3','33','1');
INSERT INTO TBL_TOPIC_CONTENT VALUES (4,'images/vip5.png','single.html?id=9','4','33','1');
INSERT INTO TBL_TOPIC_CONTENT VALUES (5,'images/tb3.png','single.html?id=10','1','100','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (6,'images/tb4.png','single.html?id=17','2','50','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (7,'images/tb5.png','single.html?id=19','3','50','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (8,'images/tb6.png','single.html?id=9','4','16','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (9,'images/tb7.png','single.html?id=9','5','16','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (10,'images/tb8.png','single.html?id=9','6','16','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (11,'images/tb9.png','single.html?id=9','7','16','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (12,'images/tb10.png','single.html?id=9','8','16','3');
INSERT INTO TBL_TOPIC_CONTENT VALUES (13,'images/tb11.png','single.html?id=9','9','16','3');
CREATE TABLE ’TBL_TOPIC’ (
	`id`	INTEGER,
	`name`	varchar(100),
	`主图片`	varchar(100),
	`背景图`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO TBL_TOPIC VALUES (1,'没有','images/vip2.jpg','http://localhost/template/images/testback.png');
INSERT INTO TBL_TOPIC VALUES (2,'jd','images/jd1.jpg','images/jd2.png');
INSERT INTO TBL_TOPIC VALUES (3,'tn','images/tb1.png','images/tb2.png');
CREATE TABLE 'TBL_TOKEN' (
		`id` INTEGER,
		   
			username	 varchar(100)
		 , 
			token varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
INSERT INTO TBL_TOKEN VALUES (123,'123','202cb962ac59075b964b07152d234b70');
CREATE TABLE 'TBL_SHOP_SETTLE' (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			settleMonth varchar(100)
		 , 
			saleAmt varchar(100)
		 , 
			commissionAmt varchar(100)
		 , 
			settleAmt varchar(100)
		 , 
			settleStatus varchar(100)
		 , 
			settleDate varchar(100)
		 , 
			startDate varchar(100)
		 , 
			endDate varchar(100)
		 , 
			adminUserId varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_SHOP_INFO (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			creditType varchar(100)
		 , 
			creditNumber varchar(100)
		 , 
			enterpriseName varchar(100)
		 , 
			enterpriseProvince varchar(100)
		 , 
			enterpriseCity varchar(100)
		 , 
			enterpriseDistrict varchar(100)
		 , 
			enterpriseAddress varchar(100)
		 , 
			enterpriseUser varchar(100)
		 , 
			enterpriseAreaCode varchar(100)
		 , 
			enterprisePhone varchar(100)
		 , 
			enterpriseLicense varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_SHOP_DELIVER (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			deliverId varchar(100)
		 , 
			deliverFee varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_SHOP_CHECK (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			adminId varchar(100)
		 , 
			operation varchar(100)
		 , 
			beforeStatus varchar(100)
		 , 
			createTime varchar(100)
		 , 
			remark varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_SHOP_BANK_INFO (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			bankType varchar(100)
		 , 
			bankCode varchar(100)
		 , 
			bankName varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_SHOP (
		`id` INTEGER,
		   
			shopId varchar(100)
		 , 
			userId varchar(100)
		 , 
			name varchar(100)
		 , 
			email varchar(100)
		 , 
			phone varchar(100)
		 , 
			serviceQq varchar(100)
		 , 
			servicePhone varchar(100)
		 , 
			type varchar(100)
		 , 
			majorBusiness varchar(100)
		 , 
			createTime varchar(100)
		 , 
			applyDate varchar(100)
		 , 
			auditStatus varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_PAY_TYPE (
		`id` INTEGER,
		   
			name varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_ORDER_PAY (
		`id` INTEGER,
		   
			orderId varchar(100)
		 , 
			payType varchar(100)
		 , 
			payAmt varchar(100)
		 , 
			payOrder varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_ORDER_OPERATION (
		`id` INTEGER,
		   
			orderId varchar(100)
		 , 
			userId varchar(100)
		 , 
			operation varchar(100)
		 , 
			beforeStatus varchar(100)
		 , 
			createTime varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_ORDER_GOODS_ATTR (
		`id` INTEGER,
		   
			orderGoodsId varchar(100)
		 , 
			attrName varchar(100)
		 , 
			attrDetailName varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
CREATE TABLE TBL_ORDER_GOODS (
	`id`	INTEGER,
	`goodsId`	varchar(100),
	`orderId`	varchar(100),
	`quantity`	varchar(100),
	`price`	varchar(100),
	`snapshot`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO TBL_ORDER_GOODS VALUES (1,'17','11546163783030','4','200.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (2,'10','11546163783030','4','20.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (3,'17','11546164725616','4','200.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (4,'10','11546164725616','4','20.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (5,'10','11546174680378','3','15.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (6,'16','11546174680378','3','150.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (7,'17','11546174680378','2','100.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (8,'15','11546174680378','3','30.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (9,'16','11546175377853','2','100.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (10,'17','11546175472325','1','50.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (11,'18','11546175472325','1','50.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (12,'9','11546175472325','2','20.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (13,'10','11546177086128','3','15.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (14,'21','11546177086128','1','10.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (15,'22','11546177086128','1','10.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (16,'24','11546177086128','1','10.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (17,'23','11546177086128','1','10.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (18,'15','11546192877933','3','30.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (19,'10','11546192877933','2','10.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (20,'17','11546196645296','4','200.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (21,'16','11546202957263','4','200.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (22,'10','11546203281487','3','15.0',NULL);
INSERT INTO TBL_ORDER_GOODS VALUES (23,'15','11546203281487','3','30.0',NULL);
CREATE TABLE TBL_ORDER(
	`id`	INTEGER,
	`orderNo`	varchar(100),
	`userId`	varchar(100),
	`shopId`	varchar(100),
	`orderAmt`	varchar(100),
	`status`	varchar(100),
	`remark`	varchar(100),
	`createTime`	varchar(100),
	`receiver`	varchar(100),
	`phone`	varchar(100),
	`address`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO TBL_ORDER VALUES (6,'11546192877933','1',NULL,'40.0','未支付',NULL,'2018-12-31 02:01:18','1','2','3');
INSERT INTO TBL_ORDER VALUES (7,'11546196645296','1',NULL,'200.0','未支付',NULL,'2018-12-31 03:04:05','123','321','123');
INSERT INTO TBL_ORDER VALUES (8,'11546202957263','1',NULL,'200.0','未支付',NULL,'2018-12-31 04:49:17','1','2','3');
INSERT INTO TBL_ORDER VALUES (9,'11546203281487','1',NULL,'45.0','已支付',NULL,'2018-12-31 04:54:41','321','321','321');

CREATE TABLE TBL_GOODS (
	`id`	INTEGER,
	`name`	varchar(100),
	`description`	varchar(100),
	`introduce`	varchar(100),
	`price`	varchar(100),
	`catId`	varchar(100),
	`shopId`	varchar(100),
	`stock`	varchar(100),
	`status`	varchar(100),
	`createTime`	varchar(100),
	`picUrl`	varchar(100),
	`salesAmount`	varchar(100),
	`originPrice`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO TBL_GOODS VALUES (9,'测试商品1','测试用1','测试用1','10.00','men','主店铺','100','可用','2018-11-05','images/pi4.jpg','0','20.00');
INSERT INTO TBL_GOODS VALUES (10,'测试商品2','测试用2',NULL,'5.00','collection',NULL,NULL,NULL,NULL,'images/13.png,images/pi5.jpg,images/pi6.jpg,images/pi4.jpg','5','10');
INSERT INTO TBL_GOODS VALUES (15,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/pi6.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (16,'meijiu','meijiudesc',NULL,'50.00','women',NULL,NULL,NULL,NULL,'images/pi5.jpg',NULL,'150');
INSERT INTO TBL_GOODS VALUES (17,'meijiu','meijiudesc',NULL,'50.00','men',NULL,NULL,NULL,NULL,'images/pi5.jpg',NULL,'150');
INSERT INTO TBL_GOODS VALUES (18,'meijiu','meijiudesc',NULL,'50.00','men',NULL,NULL,NULL,NULL,'images/pi5.jpg',NULL,'150');
INSERT INTO TBL_GOODS VALUES (19,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/pi6.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (20,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/pi6.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (21,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/pi6.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (22,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/po3.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (23,'test','tst',NULL,'10.00','collection','',NULL,NULL,NULL,'images/po2.jpg',NULL,'15');
INSERT INTO TBL_GOODS VALUES (24,'test','tst','','10.00','collection','',NULL,NULL,NULL,'images/po1.jpg',NULL,'15');

CREATE TABLE TBL_CATEGORY (
		`id` INTEGER,
		   
			name varchar(100)
		 , 
			status varchar(100)
		 , 
			parentId varchar(100)
		 , 
			createdDate varchar(100)
		 , 
			createdUser varchar(100)
		 , 
			updatedDate varchar(100)
		 , 
			updatedUser varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
INSERT INTO `TBL_CATEGORY` VALUES (1,'测试分类A','可用','','','','','');
INSERT INTO `TBL_CATEGORY` VALUES (2,'测试分类B','可用','','','','','');
INSERT INTO `TBL_CATEGORY` VALUES (3,'测试分类C','可用','','','','','');
INSERT INTO `TBL_CATEGORY` VALUES (4,'测试分类D','可用','测试分类A','','','','');
INSERT INTO `TBL_CATEGORY` VALUES (5,'测试分类E','可用','测试分类A','','','','');
CREATE TABLE TBL_BANNER (
		`id` INTEGER,
		   
			picurl	 varchar(100)
		 , 
			urlpath varchar(100)
		 , 
		PRIMARY KEY(`id`)
		);
INSERT INTO `TBL_BANNER` VALUES (1,'http://localhost/template/images/4.jpg','http://localhost/template/vegetables.html');
INSERT INTO `TBL_BANNER` VALUES (2,NULL,'http://localhost/management/datamanager.html#');
INSERT INTO `TBL_BANNER` VALUES (3,NULL,'http://localhost/management/datamanager.html#');
INSERT INTO `TBL_BANNER` VALUES (4,NULL,'http://localhost/management/datamanager.html#');
INSERT INTO `TBL_BANNER` VALUES (5,'http://148.70.22.79:8888/group1/M00/00/00/rBsADFwuCIiAbSPxAACMX91EzGA908.png','http://localhost/management/datamanager.html#');
CREATE TABLE `ProcessArgumentComplex` (
	`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	`argument`	INTEGER NOT NULL,
	`name`	varchar(100)
);
INSERT INTO `ProcessArgumentComplex` VALUES (6,8,'商品id	');
INSERT INTO `ProcessArgumentComplex` VALUES (7,8,'商品数量');
INSERT INTO `ProcessArgumentComplex` VALUES (8,18,'img');
INSERT INTO `ProcessArgumentComplex` VALUES (9,18,'url');
INSERT INTO `ProcessArgumentComplex` VALUES (10,19,'id');
INSERT INTO `ProcessArgumentComplex` VALUES (11,19,'url');
INSERT INTO `ProcessArgumentComplex` VALUES (12,19,'name');
INSERT INTO `ProcessArgumentComplex` VALUES (13,19,'price');
INSERT INTO `ProcessArgumentComplex` VALUES (14,19,'offpercent');
INSERT INTO `ProcessArgumentComplex` VALUES (19,84,'楼层图');
INSERT INTO `ProcessArgumentComplex` VALUES (20,84,'楼层数据');
INSERT INTO `ProcessArgumentComplex` VALUES (21,84,'宽度');
CREATE TABLE ’ProcessArgument’ (
	`id`	INTEGER,
	`name`	varchar(100),
	`type`	INTEGER,
	`process`	INTEGER,
	`necessary`	INTEGER,
	`complex`	INTEGER,
	`mutitype`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `ProcessArgument` VALUES (1,'ahahaha',1,2,0,NULL,NULL);
INSERT INTO `ProcessArgument` VALUES (2,'账号',0,8,0,0,0);
INSERT INTO `ProcessArgument` VALUES (3,'密码',0,8,0,0,0);
INSERT INTO `ProcessArgument` VALUES (4,'token',1,8,0,0,0);
INSERT INTO `ProcessArgument` VALUES (5,'list',1,9,0,0,0);
INSERT INTO `ProcessArgument` VALUES (6,'list',1,10,0,0,1);
INSERT INTO `ProcessArgument` VALUES (7,'goods',1,11,0,0,1);
INSERT INTO `ProcessArgument` VALUES (8,'货物表',0,12,0,1,1);
INSERT INTO `ProcessArgument` VALUES (9,'用户token',0,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (10,'结果',1,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (11,'序号',1,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (12,'订单号',0,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (13,'价格',0,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (14,'返回url',0,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (15,'处理url',0,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (16,'订单标题',0,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (17,'返回表单',1,13,0,0,0);
INSERT INTO `ProcessArgument` VALUES (18,'content',1,15,0,1,1);
INSERT INTO `ProcessArgument` VALUES (19,'goods',1,16,0,1,1);
INSERT INTO `ProcessArgument` VALUES (22,'数量',0,16,0,0,0);
INSERT INTO `ProcessArgument` VALUES (23,'种类',0,16,0,0,0);
INSERT INTO `ProcessArgument` VALUES (24,'结果',1,17,0,0,0);
INSERT INTO `ProcessArgument` VALUES (25,'totalCount',1,16,0,0,0);
INSERT INTO `ProcessArgument` VALUES (26,'页数',0,16,0,0,0);
INSERT INTO `ProcessArgument` VALUES (27,'数量',0,18,0,0,0);
INSERT INTO `ProcessArgument` VALUES (28,'result',1,18,0,0,0);
INSERT INTO `ProcessArgument` VALUES (29,'种类',0,18,0,0,0);
INSERT INTO `ProcessArgument` VALUES (30,'resultCount',1,18,0,0,0);
INSERT INTO `ProcessArgument` VALUES (31,'排序',0,16,0,0,0);
INSERT INTO `ProcessArgument` VALUES (33,'goodsId',0,11,0,0,0);
INSERT INTO `ProcessArgument` VALUES (34,'表单',1,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (35,'错误信息',1,8,0,0,0);
INSERT INTO `ProcessArgument` VALUES (36,'用户token',0,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (37,'页数',0,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (40,'错误信息',1,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (41,'数量',0,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (42,'订单商品',1,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (43,'订单',1,19,0,0,1);
INSERT INTO `ProcessArgument` VALUES (44,'序号',1,19,0,0,0);
INSERT INTO `ProcessArgument` VALUES (45,'名称',0,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (46,'电话',0,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (47,'地址',0,12,0,0,0);
INSERT INTO `ProcessArgument` VALUES (48,'notify_time',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (49,'notify_type',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (50,'notify_id',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (51,'charset',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (52,'sign_type',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (53,'sign',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (54,'auth_app_id',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (55,'trade_no',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (56,'app_id',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (57,'out_trade_no',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (58,'out_biz_no',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (59,'buyer_id',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (60,'seller_id',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (61,'trade_status',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (62,'total_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (63,'receipt_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (64,'invoice_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (65,'invoice_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (66,'buyer_pay_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (67,'point_amount',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (68,'refund_fee',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (69,'subject',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (70,'body',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (71,'gmt_create',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (72,'gmt_payment',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (73,'gmt_refund',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (74,'gmt_close',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (75,'fund_bill_list',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (76,'voucher_detail_list',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (77,'passback_params',0,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (78,'结果',1,14,0,0,0);
INSERT INTO `ProcessArgument` VALUES (79,'版头图片',1,20,0,0,0);
INSERT INTO `ProcessArgument` VALUES (82,'专题编号',0,20,0,0,0);
INSERT INTO `ProcessArgument` VALUES (83,'背景图',1,20,0,0,0);
INSERT INTO `ProcessArgument` VALUES (84,'楼层内容',1,20,0,1,0);
INSERT INTO `ProcessArgument` VALUES (85,'用户token',0,21,0,0,0);
INSERT INTO `ProcessArgument` VALUES (86,'结果',1,21,0,0,0);
INSERT INTO `ProcessArgument` VALUES (87,'结果',1,22,0,0,0);
CREATE TABLE ’Process’ (
	`id`	INTEGER,
	`name`	varchar(100),
	`startBlock`	INTEGER,
	`endBlock`	INTEGER,
	`intro`	varchar(100),
	`dataSource`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `Process` VALUES (8,'单点登录',17,18,'登录流程',NULL);
INSERT INTO `Process` VALUES (9,'获取商品分类',24,25,'获取商品分类',NULL);
INSERT INTO `Process` VALUES (10,'获取版头',27,28,NULL,NULL);
INSERT INTO `Process` VALUES (11,'获取商品',30,31,NULL,NULL);
INSERT INTO `Process` VALUES (12,'创建订单',35,36,NULL,NULL);
INSERT INTO `Process` VALUES (13,'获取付款二维码',44,45,'',NULL);
INSERT INTO `Process` VALUES (14,'支付宝支付通知流程',46,47,'',NULL);
INSERT INTO `Process` VALUES (15,'获取版头数据',49,50,NULL,NULL);
INSERT INTO `Process` VALUES (16,'首页新商品数据',52,53,NULL,NULL);
INSERT INTO `Process` VALUES (17,'推荐商品包',58,59,'推荐商品包',NULL);
INSERT INTO `Process` VALUES (18,'按销量排序商品',64,65,NULL,NULL);
INSERT INTO `Process` VALUES (19,'获取订单信息',73,74,NULL,NULL);
INSERT INTO `Process` VALUES (20,'获取专题数据',91,92,NULL,NULL);
INSERT INTO `Process` VALUES (21,'检查登录状态',96,97,NULL,NULL);
INSERT INTO `Process` VALUES (22,'主题推荐',101,102,NULL,NULL);
CREATE TABLE ’PluginMethodParam’ (
	`id`	INTEGER,
	`name`	varchar(100),
	`type`	INTEGER,
	`position`	INTEGER,
	`method`	INTEGER,
	`displayName`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO `PluginMethodParam` VALUES (1,'table',1,1,1,NULL);
INSERT INTO `PluginMethodParam` VALUES (2,'id',2,2,1,NULL);
INSERT INTO `PluginMethodParam` VALUES (3,'table',1,1,2,'表名');
INSERT INTO `PluginMethodParam` VALUES (4,'name',1,2,2,'流程名');
INSERT INTO `PluginMethodParam` VALUES (5,'startBlock',2,3,2,'开始模块');
INSERT INTO `PluginMethodParam` VALUES (6,'response',2,4,2,'回复');
INSERT INTO `PluginMethodParam` VALUES (7,'table',1,1,3,NULL);
INSERT INTO `PluginMethodParam` VALUES (8,'name',1,2,3,NULL);
INSERT INTO `PluginMethodParam` VALUES (9,'startBlock',1,3,3,NULL);
INSERT INTO `PluginMethodParam` VALUES (10,'response',1,4,3,NULL);
INSERT INTO `PluginMethodParam` VALUES (11,'id',1,5,3,NULL);
INSERT INTO `PluginMethodParam` VALUES (12,'table',1,1,4,'表名');
INSERT INTO `PluginMethodParam` VALUES (13,'id',1,2,4,'主键');
CREATE TABLE PluginMethod( id INTEGER PRIMARY KEY ASC,plugin INTEGER,name INTEGER,methodName varchar(100),introduction varchar(100),type INTEGER,returnType INTEGER);
INSERT INTO `PluginMethod` VALUES (1,1,'查询数据','select','',1,0);
INSERT INTO `PluginMethod` VALUES (2,1,'保存数据','save','',0,0);
INSERT INTO `PluginMethod` VALUES (3,1,'更新数据','update','',0,0);
INSERT INTO `PluginMethod` VALUES (4,1,'删除数据','delete','',0,0);
INSERT INTO `PluginMethod` VALUES (5,2,'更新数据','setResult','',NULL,0);
INSERT INTO `PluginMethod` VALUES (7,2,'MD5','md5','',NULL,0);
INSERT INTO `PluginMethod` VALUES (8,3,'支付宝支付内容','newPayOrder','',NULL,0);
INSERT INTO `PluginMethod` VALUES (13,1,'统计数据','stats','',NULL,0);
INSERT INTO `PluginMethod` VALUES (14,0,'调用流程','executeProcess',NULL,1,1);
INSERT INTO `PluginMethod` VALUES (15,1,'唯一查询','selectOne','',NULL,0);
INSERT INTO `PluginMethod` VALUES (16,3,'验证支付宝通知','checkAlipayNotify','',NULL,0);
INSERT INTO `PluginMethod` VALUES (17,2,'设置数据','setResult2','',NULL,0);
CREATE TABLE Plugin( id INTEGER PRIMARY KEY ASC,type INTEGER,language INTEGER,name varchar(100),introduction varchar(100),fileName varchar(100),className varchar(100),belongType INTEGER);
INSERT INTO `Plugin` VALUES (0,1,1,'流程插件',NULL,NULL,'com.lin.plugin.ProcessPlugin',1);
INSERT INTO `Plugin` VALUES (1,1,1,'示例数据库操作','','E:\exampleDatabaseController\target\exampleDatabaseController-1.0.jar','com.lin.database.MainClass',1);
INSERT INTO `Plugin` VALUES (2,1,1,'流程数据管理','','D:\Users\lion\workspace\exampleProcessResult\target\exampleProcessResult-1.0.jar','com.lin.process.MainClass',1);
INSERT INTO `Plugin` VALUES (3,1,1,'支付宝','','D:\Users\lion\workspace\examplePayPlugin\target\examplePayPlugin-1.0.jar','com.lin.process.AlipayClass',1);
CREATE TABLE Param( id INTEGER PRIMARY KEY ASC,paramValue varchar(100),belong varchar(100));
INSERT INTO `Param` VALUES (1,'{id}','request');
INSERT INTO `Param` VALUES (2,'{id}','request');
INSERT INTO `Param` VALUES (3,'{name}','request');
INSERT INTO `Param` VALUES (4,'process',NULL);
INSERT INTO `Param` VALUES (5,'process',NULL);
INSERT INTO `Param` VALUES (6,'{startBlock}','request');
INSERT INTO `Param` VALUES (7,'{name}','request');
INSERT INTO `Param` VALUES (8,'{startBlock}','request');
INSERT INTO `Param` VALUES (9,'0',NULL);
INSERT INTO `Param` VALUES (10,'0',NULL);
INSERT INTO `Param` VALUES (11,'jdbc:sqlite:D:\mydatabase-test.db',NULL);
INSERT INTO `Param` VALUES (12,'process','');
INSERT INTO `Param` VALUES (13,'{id}','request');
INSERT INTO `Param` VALUES (14,'block',NULL);
INSERT INTO `Param` VALUES (15,'{id}','request');
CREATE TABLE NextRequirement( id INTEGER PRIMARY KEY ASC,next INTEGER,param1 INTEGER,method varchar(100),param2 INTEGER,pattern varchar(100));
INSERT INTO `NextRequirement` VALUES (3,3,1,'>',10,NULL);
INSERT INTO `NextRequirement` VALUES (4,4,1,'>',10,NULL);
INSERT INTO `NextRequirement` VALUES (5,5,1,'>',10,NULL);
INSERT INTO `NextRequirement` VALUES (7,7,1,'=',1,NULL);
INSERT INTO `NextRequirement` VALUES (10,8,1,'=',1,NULL);
INSERT INTO `NextRequirement` VALUES (11,2,1,'>',9,NULL);
INSERT INTO `NextRequirement` VALUES (13,10,'count({resu})','<',1,NULL);
INSERT INTO `NextRequirement` VALUES (14,11,'count({resu})','>=',1,NULL);
INSERT INTO `NextRequirement` VALUES (16,13,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (17,14,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (18,15,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (19,16,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (20,17,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (21,18,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (22,19,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (23,20,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (24,21,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (26,23,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (27,24,'count({token记录})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (28,25,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (29,26,'count({token记录})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (30,22,'count({token记录})','>=',1,NULL);
INSERT INTO `NextRequirement` VALUES (31,27,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (32,28,'count({tokenList})','<',1,NULL);
INSERT INTO `NextRequirement` VALUES (33,29,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (34,30,'count({tokenList})','>',0,NULL);
INSERT INTO `NextRequirement` VALUES (38,31,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (43,35,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (44,36,'count({货物表})','>','{序号}',NULL);
INSERT INTO `NextRequirement` VALUES (45,37,'count({货物表})','>=','{序号}',NULL);
INSERT INTO `NextRequirement` VALUES (47,39,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (48,38,'{序号}','>','count({货物表})',NULL);
INSERT INTO `NextRequirement` VALUES (49,40,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (50,41,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (51,42,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (52,43,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (53,44,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (64,50,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (68,53,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (69,54,'{序号}','=','{数量}',NULL);
INSERT INTO `NextRequirement` VALUES (70,55,'{序号}','=','count({result})',NULL);
INSERT INTO `NextRequirement` VALUES (71,52,'{序号}','<','count({result})',NULL);
INSERT INTO `NextRequirement` VALUES (72,52,'{序号}','<','{数量}',NULL);
INSERT INTO `NextRequirement` VALUES (74,57,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (75,58,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (76,59,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (77,60,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (78,61,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (79,62,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (80,63,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (81,64,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (82,65,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (84,67,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (85,68,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (86,69,'{序号}','<','count({销量})',NULL);
INSERT INTO `NextRequirement` VALUES (87,70,'{序号}','=','count({销量})',NULL);
INSERT INTO `NextRequirement` VALUES (88,71,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (91,72,'{序号}','<','count({货物表})',NULL);
INSERT INTO `NextRequirement` VALUES (93,74,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (95,76,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (96,75,'count({token记录})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (97,77,'count({token记录})','>=',1,NULL);
INSERT INTO `NextRequirement` VALUES (98,78,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (107,85,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (109,87,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (111,79,'count({订单})','>',0,NULL);
INSERT INTO `NextRequirement` VALUES (112,88,'count({订单})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (113,89,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (114,73,'{序号}','=','count({货物表})',NULL);
INSERT INTO `NextRequirement` VALUES (115,86,'{序号}','>=','count({订单})',NULL);
INSERT INTO `NextRequirement` VALUES (116,83,'{序号}','<','count({订单})',NULL);
INSERT INTO `NextRequirement` VALUES (117,90,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (119,92,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (120,91,'{结果}','=','ERROR',NULL);
INSERT INTO `NextRequirement` VALUES (122,94,'{trade_status}','=','TRADE_SUCCESS',NULL);
INSERT INTO `NextRequirement` VALUES (123,95,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (124,96,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (125,97,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (126,98,'{trade_status}','not like','TRADE_SUCCESS',NULL);
INSERT INTO `NextRequirement` VALUES (127,99,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (128,100,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (129,93,'{结果}','=','OK',NULL);
INSERT INTO `NextRequirement` VALUES (130,101,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (131,102,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (132,103,'count({楼层data})','>',0,NULL);
INSERT INTO `NextRequirement` VALUES (133,104,'count({楼层data})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (134,105,'{序号}','<','count({楼层data})',NULL);
INSERT INTO `NextRequirement` VALUES (135,106,'{序号}','>=','count({楼层data})',NULL);
INSERT INTO `NextRequirement` VALUES (136,107,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (137,108,'count({token记录})','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (138,109,'count({token记录})','>=',1,NULL);
INSERT INTO `NextRequirement` VALUES (139,110,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (140,111,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (141,112,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (142,113,'','=','',NULL);
INSERT INTO `NextRequirement` VALUES (144,82,'count({订单商品}[{序号}])','=',0,NULL);
INSERT INTO `NextRequirement` VALUES (145,80,'count({订单商品}[{序号}].orderGoods)','>',0,NULL);
INSERT INTO `NextRequirement` VALUES (146,84,'','=','',NULL);
CREATE TABLE ’Next’ (
	`id`	INTEGER,
	`block`	INTEGER,
	`value`	INTEGER,
	`position`	INTEGER,
	`name`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO `Next` VALUES (2,1,3,NULL,'遭不住');
INSERT INTO `Next` VALUES (3,4,5,1,NULL);
INSERT INTO `Next` VALUES (4,6,7,1,NULL);
INSERT INTO `Next` VALUES (5,8,10,1,NULL);
INSERT INTO `Next` VALUES (7,11,15,1,'332321');
INSERT INTO `Next` VALUES (8,16,12,NULL,'1111');
INSERT INTO `Next` VALUES (10,19,20,NULL,'不存在用户');
INSERT INTO `Next` VALUES (11,19,21,NULL,'存在用户');
INSERT INTO `Next` VALUES (13,20,18,NULL,'错误结束');
INSERT INTO `Next` VALUES (14,17,19,NULL,'没事');
INSERT INTO `Next` VALUES (15,24,26,NULL,'正常');
INSERT INTO `Next` VALUES (16,26,25,NULL,'正常');
INSERT INTO `Next` VALUES (17,27,29,NULL,'正常');
INSERT INTO `Next` VALUES (18,29,28,NULL,'正常');
INSERT INTO `Next` VALUES (19,29,28,NULL,'正常');
INSERT INTO `Next` VALUES (20,30,32,NULL,'正常');
INSERT INTO `Next` VALUES (21,32,31,NULL,'正常');
INSERT INTO `Next` VALUES (22,21,33,NULL,'有token记录');
INSERT INTO `Next` VALUES (23,33,18,NULL,'结束');
INSERT INTO `Next` VALUES (24,21,34,NULL,'无记录');
INSERT INTO `Next` VALUES (25,34,18,NULL,'结束');
INSERT INTO `Next` VALUES (26,21,34,NULL,'无token记录');
INSERT INTO `Next` VALUES (27,35,37,NULL,'正常');
INSERT INTO `Next` VALUES (28,37,38,NULL,'无有效凭证');
INSERT INTO `Next` VALUES (29,38,36,0,'结束');
INSERT INTO `Next` VALUES (30,37,39,NULL,'正常');
INSERT INTO `Next` VALUES (31,39,72,0,'查询货物信息');
INSERT INTO `Next` VALUES (35,41,42,NULL,'正常');
INSERT INTO `Next` VALUES (36,42,42,NULL,'继续添加');
INSERT INTO `Next` VALUES (37,42,42,NULL,'继续添加');
INSERT INTO `Next` VALUES (38,42,43,NULL,'结束');
INSERT INTO `Next` VALUES (39,43,71,0,'结束');
INSERT INTO `Next` VALUES (40,44,48,NULL,'正常');
INSERT INTO `Next` VALUES (41,48,45,NULL,'正常');
INSERT INTO `Next` VALUES (42,49,51,NULL,'正常');
INSERT INTO `Next` VALUES (43,51,50,NULL,'正常');
INSERT INTO `Next` VALUES (44,52,54,NULL,'正常');
INSERT INTO `Next` VALUES (50,54,55,NULL,'正常');
INSERT INTO `Next` VALUES (52,57,55,NULL,'继续执行');
INSERT INTO `Next` VALUES (53,55,57,NULL,'正常');
INSERT INTO `Next` VALUES (54,57,63,0,'结束');
INSERT INTO `Next` VALUES (55,57,56,NULL,'结束');
INSERT INTO `Next` VALUES (57,60,61,NULL,'正常');
INSERT INTO `Next` VALUES (58,61,59,NULL,'正常');
INSERT INTO `Next` VALUES (59,58,60,NULL,'1');
INSERT INTO `Next` VALUES (60,58,60,NULL,'正常');
INSERT INTO `Next` VALUES (61,56,53,NULL,'结束');
INSERT INTO `Next` VALUES (62,63,53,NULL,'结束');
INSERT INTO `Next` VALUES (63,64,67,0,'正常');
INSERT INTO `Next` VALUES (64,67,66,NULL,'正常');
INSERT INTO `Next` VALUES (65,66,70,0,'正常');
INSERT INTO `Next` VALUES (67,69,65,NULL,'正常');
INSERT INTO `Next` VALUES (68,70,68,NULL,'正常');
INSERT INTO `Next` VALUES (69,68,68,NULL,'继续处理');
INSERT INTO `Next` VALUES (70,68,69,NULL,'结束');
INSERT INTO `Next` VALUES (71,71,36,NULL,'结束');
INSERT INTO `Next` VALUES (72,72,72,NULL,'继续处理');
INSERT INTO `Next` VALUES (73,72,83,NULL,'处理结束');
INSERT INTO `Next` VALUES (74,73,75,NULL,'正常');
INSERT INTO `Next` VALUES (75,75,76,NULL,'无用户');
INSERT INTO `Next` VALUES (76,76,74,NULL,'结束');
INSERT INTO `Next` VALUES (77,75,77,NULL,'正常');
INSERT INTO `Next` VALUES (78,77,78,NULL,'正常');
INSERT INTO `Next` VALUES (79,78,79,NULL,'有用户订单');
INSERT INTO `Next` VALUES (80,79,80,NULL,'正常');
INSERT INTO `Next` VALUES (82,79,81,NULL,'无订单商品');
INSERT INTO `Next` VALUES (83,81,79,NULL,'存在更多订单内容');
INSERT INTO `Next` VALUES (84,80,81,NULL,'单订单商品处理结束');
INSERT INTO `Next` VALUES (85,81,82,NULL,'结束');
INSERT INTO `Next` VALUES (86,81,82,NULL,'结束');
INSERT INTO `Next` VALUES (87,82,74,NULL,'正常');
INSERT INTO `Next` VALUES (88,78,82,NULL,'无用户订单');
INSERT INTO `Next` VALUES (89,83,41,NULL,'正常');
INSERT INTO `Next` VALUES (90,46,84,NULL,'正常');
INSERT INTO `Next` VALUES (91,84,85,NULL,'错误');
INSERT INTO `Next` VALUES (92,85,47,NULL,'结束');
INSERT INTO `Next` VALUES (93,84,86,NULL,'正常');
INSERT INTO `Next` VALUES (94,86,87,NULL,'交易完成');
INSERT INTO `Next` VALUES (95,87,88,NULL,'结束');
INSERT INTO `Next` VALUES (96,88,47,NULL,'结束');
INSERT INTO `Next` VALUES (97,86,89,NULL,'其他');
INSERT INTO `Next` VALUES (98,86,89,NULL,'其他');
INSERT INTO `Next` VALUES (99,89,90,NULL,'结束');
INSERT INTO `Next` VALUES (100,90,47,NULL,'结束');
INSERT INTO `Next` VALUES (101,91,93,NULL,'正常');
INSERT INTO `Next` VALUES (102,93,94,0,'正常');
INSERT INTO `Next` VALUES (103,94,95,NULL,'正常');
INSERT INTO `Next` VALUES (104,94,92,NULL,'结束');
INSERT INTO `Next` VALUES (105,95,95,NULL,'继续处理');
INSERT INTO `Next` VALUES (106,95,92,NULL,'结束');
INSERT INTO `Next` VALUES (107,96,98,NULL,'正常');
INSERT INTO `Next` VALUES (108,98,99,NULL,'无记录');
INSERT INTO `Next` VALUES (109,98,100,NULL,'有记录');
INSERT INTO `Next` VALUES (110,100,97,NULL,'结束');
INSERT INTO `Next` VALUES (111,99,97,NULL,'结束');
INSERT INTO `Next` VALUES (112,101,103,NULL,'正常');
INSERT INTO `Next` VALUES (113,103,102,NULL,'正常');
CREATE TABLE ’ExecuteParam’ (
	`id`	INTEGER,
	`execute`	INTEGER,
	`pluginMethodParam`	INTEGER,
	`param`	varchar(100),
	`fieldName`	varchar(100),
	`type`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `ExecuteParam` VALUES (1,2,7,'4',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (2,1,3,'5',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (3,2,8,'7',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (4,2,9,'8',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (5,2,11,'1',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (6,1,4,'7',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (7,1,5,'8',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (8,3,12,'12',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (9,3,13,'13',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (10,4,12,'14',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (11,4,13,'15',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (12,5,NULL,NULL,NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (13,21,'arg0','1112',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (14,6,'表名','process',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (15,6,'id','123',NULL,NULL);
INSERT INTO `ExecuteParam` VALUES (46,28,'token','{MD5code}','map',0);
INSERT INTO `ExecuteParam` VALUES (47,28,'token','token','outMap',1);
INSERT INTO `ExecuteParam` VALUES (53,26,'表名','TBL_USER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (54,26,'username','{账号}','map',0);
INSERT INTO `ExecuteParam` VALUES (55,26,'password','{密码}','map',0);
INSERT INTO `ExecuteParam` VALUES (56,26,'结果','resu','result',1);
INSERT INTO `ExecuteParam` VALUES (57,27,'MD5','{账号}','param',0);
INSERT INTO `ExecuteParam` VALUES (58,27,'jieguo','MD5code','result',1);
INSERT INTO `ExecuteParam` VALUES (61,30,'表名',TBL_CATEGORY,'tableName',0);
INSERT INTO `ExecuteParam` VALUES (62,30,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (63,31,'list','{result}','map',0);
INSERT INTO `ExecuteParam` VALUES (64,31,'list','list','outMap',1);
INSERT INTO `ExecuteParam` VALUES (65,32,'表名',TBL_BANNER,'tableName',0);
INSERT INTO `ExecuteParam` VALUES (66,32,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (67,33,'list','{result}','map',0);
INSERT INTO `ExecuteParam` VALUES (68,33,'list','list','outMap',1);
INSERT INTO `ExecuteParam` VALUES (71,35,'goods','{result}','map',0);
INSERT INTO `ExecuteParam` VALUES (72,35,'goods','goods','outMap',1);
INSERT INTO `ExecuteParam` VALUES (73,36,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (74,36,'username','{账号}','map',0);
INSERT INTO `ExecuteParam` VALUES (75,36,'结果','token记录','result',1);
INSERT INTO `ExecuteParam` VALUES (76,37,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (77,37,'username','{账号}','map',0);
INSERT INTO `ExecuteParam` VALUES (78,37,'token','{token}','map',0);
INSERT INTO `ExecuteParam` VALUES (79,38,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (80,38,'id','val({token记录},1).id','map',0);
INSERT INTO `ExecuteParam` VALUES (81,38,'username','{账号}','map',0);
INSERT INTO `ExecuteParam` VALUES (82,38,'token','{token}','map',0);
INSERT INTO `ExecuteParam` VALUES (83,39,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (84,39,'token','{用户token}','map',0);
INSERT INTO `ExecuteParam` VALUES (85,39,'结果','tokenList','result',1);
INSERT INTO `ExecuteParam` VALUES (86,40,'结果','错误','map',0);
INSERT INTO `ExecuteParam` VALUES (87,40,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (88,41,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (89,41,'id','val({货物表},{序号}).id','map',0);
INSERT INTO `ExecuteParam` VALUES (94,44,'序号','val({序号})+1','map',0);
INSERT INTO `ExecuteParam` VALUES (95,44,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (111,45,'结果','{商品信息1}','map',0);
INSERT INTO `ExecuteParam` VALUES (112,45,'序号','{序号}','map',0);
INSERT INTO `ExecuteParam` VALUES (113,45,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (114,45,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (137,50,'表名','TBL_USER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (138,50,'username','val({tokenList},1).username','map',0);
INSERT INTO `ExecuteParam` VALUES (139,50,'结果','用户信息','result',1);
INSERT INTO `ExecuteParam` VALUES (146,53,'序号','val({序号})+1','map',0);
INSERT INTO `ExecuteParam` VALUES (147,53,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (153,54,'结果','val({用户信息},1).id+getTime()','map',0);
INSERT INTO `ExecuteParam` VALUES (154,54,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (161,56,'返回表单','{result}','map',0);
INSERT INTO `ExecuteParam` VALUES (162,56,'返回表单','返回表单','outMap',1);
INSERT INTO `ExecuteParam` VALUES (163,57,'表名',TBL_BANNER,'tableName',0);
INSERT INTO `ExecuteParam` VALUES (164,57,'查询数量','3','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (165,57,'结果','content','result',1);
INSERT INTO `ExecuteParam` VALUES (166,55,'订单结束链接','{返回url}','returnUrl',0);
INSERT INTO `ExecuteParam` VALUES (167,55,'订单处理链接','{处理url}','notifyUrl',0);
INSERT INTO `ExecuteParam` VALUES (168,55,'订单号','{订单号}','out_trade_no',0);
INSERT INTO `ExecuteParam` VALUES (169,55,'价格/元','{价格}','total_amount',0);
INSERT INTO `ExecuteParam` VALUES (170,55,'标题','{订单标题}','subject',0);
INSERT INTO `ExecuteParam` VALUES (171,55,'表单','result','formString',1);
INSERT INTO `ExecuteParam` VALUES (181,59,'goods','{result}[{序号}].id','map',0);
INSERT INTO `ExecuteParam` VALUES (182,59,'goods','goods[{序号}].id','outMap',1);
INSERT INTO `ExecuteParam` VALUES (186,60,'goods','0','map',0);
INSERT INTO `ExecuteParam` VALUES (187,60,'goods','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (188,61,'goods','{result}[{序号}].name','map',0);
INSERT INTO `ExecuteParam` VALUES (189,61,'goods','goods[{序号}].name','outMap',1);
INSERT INTO `ExecuteParam` VALUES (190,62,'goods','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (191,62,'goods','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (192,63,'goods','{result}[{序号}].picUrl','map',0);
INSERT INTO `ExecuteParam` VALUES (193,63,'goods','goods[{序号}].imgpath','outMap',1);
INSERT INTO `ExecuteParam` VALUES (194,64,'goods','{result}[{序号}].price','map',0);
INSERT INTO `ExecuteParam` VALUES (195,64,'goods','goods[{序号}].price','outMap',1);
INSERT INTO `ExecuteParam` VALUES (196,65,'goods','{result}[{序号}].price/{result}[{序号}].originPrice','map',0);
INSERT INTO `ExecuteParam` VALUES (197,65,'goods','goods[{序号}].offpercent','outMap',1);
INSERT INTO `ExecuteParam` VALUES (210,66,'表名','TBL_ORDER_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (211,66,'统计内容','sum(quantity)','selectColumns',0);
INSERT INTO `ExecuteParam` VALUES (212,66,'区分内容','goodsId','groupColumn',0);
INSERT INTO `ExecuteParam` VALUES (213,66,'排序内容','sum(quantity) desc','orderColumns',0);
INSERT INTO `ExecuteParam` VALUES (214,66,'查询数量','1','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (215,66,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (220,68,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (221,68,'id','{result}[0].goodsId','map',0);
INSERT INTO `ExecuteParam` VALUES (222,68,'结果','goods','result',1);
INSERT INTO `ExecuteParam` VALUES (223,67,'结果','{goods}','map',0);
INSERT INTO `ExecuteParam` VALUES (224,67,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (225,69,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (226,69,'统计内容','count(id)','selectColumns',0);
INSERT INTO `ExecuteParam` VALUES (227,69,'catId','{种类}','map',0);
INSERT INTO `ExecuteParam` VALUES (228,69,'结果','totalCount','result',1);
INSERT INTO `ExecuteParam` VALUES (229,70,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (230,70,'统计内容','count(id)','selectColumns',0);
INSERT INTO `ExecuteParam` VALUES (231,70,'catId','{种类}','map',0);
INSERT INTO `ExecuteParam` VALUES (232,70,'结果','totalCount','result',1);
INSERT INTO `ExecuteParam` VALUES (242,72,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (243,72,'catId','{种类}','map',0);
INSERT INTO `ExecuteParam` VALUES (244,72,'结果','ids','result',1);
INSERT INTO `ExecuteParam` VALUES (264,71,'表名','TBL_ORDER_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (265,71,'统计内容','sum(quantity)','selectColumns',0);
INSERT INTO `ExecuteParam` VALUES (266,71,'区分内容','goodsId','groupColumn',0);
INSERT INTO `ExecuteParam` VALUES (267,71,'排序内容','sum(quantity) desc','orderColumns',0);
INSERT INTO `ExecuteParam` VALUES (268,71,'查询数量','{数量}','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (269,71,'goodsId','arrayValue({ids}).id','map',0);
INSERT INTO `ExecuteParam` VALUES (270,71,'结果','销量','result',1);
INSERT INTO `ExecuteParam` VALUES (274,74,'表名','TBL_ORDER_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (275,74,'统计内容','sum(quantity)','selectColumns',0);
INSERT INTO `ExecuteParam` VALUES (276,74,'区分内容','goodsId','groupColumn',0);
INSERT INTO `ExecuteParam` VALUES (277,74,'goodsId','arrayValue({ids}).id','map',0);
INSERT INTO `ExecuteParam` VALUES (278,74,'结果','totalCount','result',1);
INSERT INTO `ExecuteParam` VALUES (281,76,'result','0','map',0);
INSERT INTO `ExecuteParam` VALUES (282,76,'result','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (290,78,'result','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (291,78,'result','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (292,75,'result','{销量}','map',0);
INSERT INTO `ExecuteParam` VALUES (293,75,'resultCount','count({totalCount})','map',0);
INSERT INTO `ExecuteParam` VALUES (294,75,'result','result','outMap',1);
INSERT INTO `ExecuteParam` VALUES (295,75,'resultCount','resultCount','outMap',1);
INSERT INTO `ExecuteParam` VALUES (296,77,'resultCount','{result}[0]','map',0);
INSERT INTO `ExecuteParam` VALUES (297,77,'resultCount','销量[{序号}].goodsInfo','outMap',1);
INSERT INTO `ExecuteParam` VALUES (298,73,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (299,73,'id','{销量}[{序号}].goodsId','map',0);
INSERT INTO `ExecuteParam` VALUES (300,73,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (301,58,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (302,58,'查询数量','{数量}','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (303,58,'页数','{页数}','page',0);
INSERT INTO `ExecuteParam` VALUES (304,58,'排序','{排序}','order',0);
INSERT INTO `ExecuteParam` VALUES (305,58,'catId','{种类}','map',0);
INSERT INTO `ExecuteParam` VALUES (306,58,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (307,34,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (308,34,'id','{goodsId}','map',0);
INSERT INTO `ExecuteParam` VALUES (309,34,'结果','result','result',1);
INSERT INTO `ExecuteParam` VALUES (333,42,'结果','0','map',0);
INSERT INTO `ExecuteParam` VALUES (334,42,'序号','0','map',0);
INSERT INTO `ExecuteParam` VALUES (335,42,'结果','价格','outMap',1);
INSERT INTO `ExecuteParam` VALUES (336,42,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (342,48,'序号','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (343,48,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (353,43,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (354,43,'id','{货物表}[{序号}].商品id','map',0);
INSERT INTO `ExecuteParam` VALUES (355,43,'结果','商品信息[{序号}]','result',1);
INSERT INTO `ExecuteParam` VALUES (356,47,'结果','{商品信息}[{序号}][0].price*{货物表}[{序号}].商品数量+{价格}','map',0);
INSERT INTO `ExecuteParam` VALUES (357,47,'结果','价格','outMap',1);
INSERT INTO `ExecuteParam` VALUES (372,80,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (373,80,'id','{货物表}[{序号}].商品id','map',0);
INSERT INTO `ExecuteParam` VALUES (374,80,'结果','商品信息[{序号}]','object',1);
INSERT INTO `ExecuteParam` VALUES (377,82,'序号','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (378,82,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (386,81,'结果','{商品信息}[{序号}].price*{货物表}[{序号}].商品数量+{价格}','map',0);
INSERT INTO `ExecuteParam` VALUES (387,81,'结果','价格','outMap',1);
INSERT INTO `ExecuteParam` VALUES (393,29,'错误信息','错误','map',0);
INSERT INTO `ExecuteParam` VALUES (394,29,'错误信息','错误信息','outMap',1);
INSERT INTO `ExecuteParam` VALUES (397,84,'错误信息','无该用户','map',0);
INSERT INTO `ExecuteParam` VALUES (398,84,'错误信息','错误信息','outMap',1);
INSERT INTO `ExecuteParam` VALUES (399,83,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (400,83,'token','{用户token}','map',0);
INSERT INTO `ExecuteParam` VALUES (401,83,'结果','token记录','object',1);
INSERT INTO `ExecuteParam` VALUES (402,85,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (403,85,'token','{用户token}','map',0);
INSERT INTO `ExecuteParam` VALUES (404,85,'结果','token记录','result',1);
INSERT INTO `ExecuteParam` VALUES (414,89,'序号','0','map',0);
INSERT INTO `ExecuteParam` VALUES (415,89,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (419,90,'序号2','0','map',0);
INSERT INTO `ExecuteParam` VALUES (420,90,'序号2','序号2','outMap',1);
INSERT INTO `ExecuteParam` VALUES (424,92,'序号2','{序号2}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (425,92,'序号2','序号2','outMap',1);
INSERT INTO `ExecuteParam` VALUES (426,93,'序号','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (427,93,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (436,86,'表名','TBL_USER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (437,86,'username','{token记录}[0].username','map',0);
INSERT INTO `ExecuteParam` VALUES (438,86,'结果','用户信息','object',1);
INSERT INTO `ExecuteParam` VALUES (439,87,'表名','TBL_ORDER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (440,87,'查询数量','{数量}','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (441,87,'页数','{页数}','page',0);
INSERT INTO `ExecuteParam` VALUES (442,87,'userId','val({用户信息}).id','map',0);
INSERT INTO `ExecuteParam` VALUES (443,87,'结果','订单','result',1);
INSERT INTO `ExecuteParam` VALUES (447,94,'结果','val({用户信息},1).id+getTime()','map',0);
INSERT INTO `ExecuteParam` VALUES (448,94,'结果','订单号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (453,52,'表名','TBL_ORDER_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (454,52,'goodsId','{货物表}[{序号}].商品id','map',0);
INSERT INTO `ExecuteParam` VALUES (455,52,'orderId','{订单号}','map',0);
INSERT INTO `ExecuteParam` VALUES (456,52,'quantity','{货物表}[{序号}].商品数量','map',0);
INSERT INTO `ExecuteParam` VALUES (457,52,'price','{商品信息}[{序号}].price*{货物表}[{序号}].商品数量','map',0);
INSERT INTO `ExecuteParam` VALUES (458,51,'序号','0','map',0);
INSERT INTO `ExecuteParam` VALUES (459,51,'序号','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (463,91,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (464,91,'id','arrayValue(订单商品[{序号}]).goodsId','map',0);
INSERT INTO `ExecuteParam` VALUES (465,91,'结果','订单商品[{序号}].goodsInfo','object',1);
INSERT INTO `ExecuteParam` VALUES (469,95,'表名','TBL_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (470,95,'id','arrayValue(订单商品[{序号}].orderGoods).goodsId','map',0);
INSERT INTO `ExecuteParam` VALUES (471,95,'结果','订单商品[{序号}].goodsInfo','result',1);
INSERT INTO `ExecuteParam` VALUES (472,49,'表名','TBL_ORDER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (473,49,'orderNo','{订单号}','map',0);
INSERT INTO `ExecuteParam` VALUES (474,49,'userId','val({用户信息},1).id','map',0);
INSERT INTO `ExecuteParam` VALUES (475,49,'orderAmt','{价格}','map',0);
INSERT INTO `ExecuteParam` VALUES (476,49,'status','未支付','map',0);
INSERT INTO `ExecuteParam` VALUES (477,49,'createTime','formatTime()','map',0);
INSERT INTO `ExecuteParam` VALUES (478,49,'receiver','{名称}','map',0);
INSERT INTO `ExecuteParam` VALUES (479,49,'phone','{电话}','map',0);
INSERT INTO `ExecuteParam` VALUES (480,49,'address','{地址}','map',0);
INSERT INTO `ExecuteParam` VALUES (481,96,'通知时间','{notify_time}','notify_time',0);
INSERT INTO `ExecuteParam` VALUES (482,96,'通知类型','{notify_type}','notify_type',0);
INSERT INTO `ExecuteParam` VALUES (483,96,'通知校验ID','{notify_id}','notify_id',0);
INSERT INTO `ExecuteParam` VALUES (484,96,'编码格式','{charset}','charset',0);
INSERT INTO `ExecuteParam` VALUES (485,96,'接口版本','{version}','version',0);
INSERT INTO `ExecuteParam` VALUES (486,96,'签名类型','{sign_type}','sign_type',0);
INSERT INTO `ExecuteParam` VALUES (487,96,'签名','{sign}','sign',0);
INSERT INTO `ExecuteParam` VALUES (488,96,'授权方的app_id','{auth_app_id}','auth_app_id',0);
INSERT INTO `ExecuteParam` VALUES (489,96,'支付宝交易号','{trade_no}','trade_no',0);
INSERT INTO `ExecuteParam` VALUES (490,96,'APP ID','{app_id}','app_id',0);
INSERT INTO `ExecuteParam` VALUES (491,96,'商户订单号','{out_trade_no}','out_trade_no',0);
INSERT INTO `ExecuteParam` VALUES (492,96,'商户业务号','{out_biz_no}','out_biz_no',0);
INSERT INTO `ExecuteParam` VALUES (493,96,'买家支付宝用户号','{buyer_id}','buyer_id',0);
INSERT INTO `ExecuteParam` VALUES (494,96,'卖家支付宝用户号','{seller_id}','seller_id',0);
INSERT INTO `ExecuteParam` VALUES (495,96,'交易状态','{trade_status}','trade_status',0);
INSERT INTO `ExecuteParam` VALUES (496,96,'订单金额','{total_amount}','total_amount',0);
INSERT INTO `ExecuteParam` VALUES (497,96,'实收金额','{receipt_amount}','receipt_amount',0);
INSERT INTO `ExecuteParam` VALUES (498,96,'开票金额','{invoice_amount}','invoice_amount',0);
INSERT INTO `ExecuteParam` VALUES (499,96,'付款金额','{buyer_pay_amount}','buyer_pay_amount',0);
INSERT INTO `ExecuteParam` VALUES (500,96,'集分宝金额','{point_amount}','point_amount',0);
INSERT INTO `ExecuteParam` VALUES (501,96,'总退款金额','{refund_fee}','refund_fee',0);
INSERT INTO `ExecuteParam` VALUES (502,96,'订单标题','{subject}','subject',0);
INSERT INTO `ExecuteParam` VALUES (503,96,'商品描述','{body}','body',0);
INSERT INTO `ExecuteParam` VALUES (504,96,'交易创建时间','{gmt_create}','gmt_create',0);
INSERT INTO `ExecuteParam` VALUES (505,96,'交易付款时间','{gmt_payment}','gmt_payment',0);
INSERT INTO `ExecuteParam` VALUES (506,96,'交易退款时间','{gmt_refund}','gmt_refund',0);
INSERT INTO `ExecuteParam` VALUES (507,96,'交易结束时间','{gmt_close}','gmt_close',0);
INSERT INTO `ExecuteParam` VALUES (508,96,'支付金额信息','{fund_bill_list}','fund_bill_list',0);
INSERT INTO `ExecuteParam` VALUES (509,96,'优惠券信息','{voucher_detail_list}','voucher_detail_list',0);
INSERT INTO `ExecuteParam` VALUES (510,96,'回传参数','{passback_params}','passback_params',0);
INSERT INTO `ExecuteParam` VALUES (511,96,'验证结果','结果','isOk',1);
INSERT INTO `ExecuteParam` VALUES (519,97,'表名','TBL_ORDER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (520,97,'orderNo','{out_trade_no}','map',0);
INSERT INTO `ExecuteParam` VALUES (521,97,'结果','订单','object',1);
INSERT INTO `ExecuteParam` VALUES (522,98,'表名','TBL_ORDER','tableName',0);
INSERT INTO `ExecuteParam` VALUES (523,98,'id','val({订单}).id','map',0);
INSERT INTO `ExecuteParam` VALUES (524,98,'status','已支付','map',0);
INSERT INTO `ExecuteParam` VALUES (525,99,'结果','完成','map',0);
INSERT INTO `ExecuteParam` VALUES (526,99,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (527,100,'结果','没处理！','map',0);
INSERT INTO `ExecuteParam` VALUES (528,100,'结果','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (529,79,'流程ID','13','processId',0);
INSERT INTO `ExecuteParam` VALUES (530,79,'订单号','{订单号}','map',0);
INSERT INTO `ExecuteParam` VALUES (531,79,'价格','{价格}','map',0);
INSERT INTO `ExecuteParam` VALUES (532,79,'返回url','http://localhost/template/index.html','map',0);
INSERT INTO `ExecuteParam` VALUES (533,79,'处理url','http://148.70.22.79:8088/dynamic/test','map',0);
INSERT INTO `ExecuteParam` VALUES (534,79,'订单标题','订单{订单号}','map',0);
INSERT INTO `ExecuteParam` VALUES (535,79,'返回表单','表单','outMap',1);
INSERT INTO `ExecuteParam` VALUES (536,101,'表名','TBL_TOPIC','tableName',0);
INSERT INTO `ExecuteParam` VALUES (537,101,'id','{专题编号}','map',0);
INSERT INTO `ExecuteParam` VALUES (538,101,'结果','专题内容','object',1);
INSERT INTO `ExecuteParam` VALUES (539,102,'设置数量','2','count',0);
INSERT INTO `ExecuteParam` VALUES (540,102,'Value 1','val({专题内容}).主图片','map',0);
INSERT INTO `ExecuteParam` VALUES (541,102,'Value 2','val({专题内容}).背景图','map',0);
INSERT INTO `ExecuteParam` VALUES (542,102,'Key 1','版头图片','outMap',1);
INSERT INTO `ExecuteParam` VALUES (543,102,'Key 2','背景图','outMap',1);
INSERT INTO `ExecuteParam` VALUES (544,103,'表名','TBL_TOPIC_CONTENT','tableName',0);
INSERT INTO `ExecuteParam` VALUES (545,103,'topic','{专题编号}','map',0);
INSERT INTO `ExecuteParam` VALUES (546,103,'结果','楼层data','result',1);
INSERT INTO `ExecuteParam` VALUES (547,104,'设置数量','1','count',0);
INSERT INTO `ExecuteParam` VALUES (548,104,'Value 1','0','map',0);
INSERT INTO `ExecuteParam` VALUES (549,104,'Key 1','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (550,105,'设置数量','3','count',0);
INSERT INTO `ExecuteParam` VALUES (551,105,'Value 1','{楼层data}[{序号}].picUrl','map',0);
INSERT INTO `ExecuteParam` VALUES (552,105,'Value 2','{楼层data}[{序号}].url','map',0);
INSERT INTO `ExecuteParam` VALUES (553,105,'Value 3','{楼层data}[{序号}].width','map',0);
INSERT INTO `ExecuteParam` VALUES (554,105,'Key 1','楼层内容[{序号}].楼层图','outMap',1);
INSERT INTO `ExecuteParam` VALUES (555,105,'Key 2','楼层内容[{序号}].楼层数据','outMap',1);
INSERT INTO `ExecuteParam` VALUES (556,105,'Key 3','楼层内容[{序号}].宽度','outMap',1);
INSERT INTO `ExecuteParam` VALUES (557,106,'设置数量','1','count',0);
INSERT INTO `ExecuteParam` VALUES (558,106,'Value 1','{序号}+1','map',0);
INSERT INTO `ExecuteParam` VALUES (559,106,'Key 1','序号','outMap',1);
INSERT INTO `ExecuteParam` VALUES (560,107,'表名','TBL_TOKEN','tableName',0);
INSERT INTO `ExecuteParam` VALUES (561,107,'token','{用户token}','map',0);
INSERT INTO `ExecuteParam` VALUES (562,107,'结果','token记录','result',1);
INSERT INTO `ExecuteParam` VALUES (563,108,'设置数量','1','count',0);
INSERT INTO `ExecuteParam` VALUES (564,108,'Value 1','ERROR','map',0);
INSERT INTO `ExecuteParam` VALUES (565,108,'Key 1','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (566,109,'设置数量','1','count',0);
INSERT INTO `ExecuteParam` VALUES (567,109,'Value 1','OK','map',0);
INSERT INTO `ExecuteParam` VALUES (568,109,'Key 1','结果','outMap',1);
INSERT INTO `ExecuteParam` VALUES (569,110,'表名','TBL_TOPIC','tableName',0);
INSERT INTO `ExecuteParam` VALUES (570,110,'查询数量','3','limitRow',0);
INSERT INTO `ExecuteParam` VALUES (571,110,'结果','结果','result',1);
INSERT INTO `ExecuteParam` VALUES (572,88,'表名','TBL_ORDER_GOODS','tableName',0);
INSERT INTO `ExecuteParam` VALUES (573,88,'orderId','{订单}[{序号}].orderNo','map',0);
INSERT INTO `ExecuteParam` VALUES (574,88,'结果','订单商品[{序号}].orderGoods','result',1);
CREATE TABLE ’Execute’ (
	`id`	INTEGER,
	`method`	INTEGER,
	`executeName`	varchar(100),
	`block`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `Execute` VALUES (1,2,'新增流程',2);
INSERT INTO `Execute` VALUES (2,3,'更新',3);
INSERT INTO `Execute` VALUES (3,4,'删除',5);
INSERT INTO `Execute` VALUES (4,4,'删除模块',7);
INSERT INTO `Execute` VALUES (5,3,'更新模块',10);
INSERT INTO `Execute` VALUES (6,2,'321',12);
INSERT INTO `Execute` VALUES (7,4,'321',11);
INSERT INTO `Execute` VALUES (8,3,'321',11);
INSERT INTO `Execute` VALUES (9,1,'321',11);
INSERT INTO `Execute` VALUES (10,3,'321',11);
INSERT INTO `Execute` VALUES (11,3,'321',11);
INSERT INTO `Execute` VALUES (12,2,'321',11);
INSERT INTO `Execute` VALUES (13,2,'11111',11);
INSERT INTO `Execute` VALUES (14,2,'321',11);
INSERT INTO `Execute` VALUES (15,2,'321',11);
INSERT INTO `Execute` VALUES (16,2,'321',11);
INSERT INTO `Execute` VALUES (17,2,'321',11);
INSERT INTO `Execute` VALUES (18,2,'321',12);
INSERT INTO `Execute` VALUES (19,2,'11',11);
INSERT INTO `Execute` VALUES (20,2,'111',11);
INSERT INTO `Execute` VALUES (21,2,'aaaa',11);
INSERT INTO `Execute` VALUES (22,2,'11',11);
INSERT INTO `Execute` VALUES (23,2,'321',11);
INSERT INTO `Execute` VALUES (24,2,'321',11);
INSERT INTO `Execute` VALUES (25,1,'query',16);
INSERT INTO `Execute` VALUES (26,1,'检查账号',19);
INSERT INTO `Execute` VALUES (27,7,'生产TOKEN',21);
INSERT INTO `Execute` VALUES (28,5,'设置结果',21);
INSERT INTO `Execute` VALUES (29,5,'返回错误',20);
INSERT INTO `Execute` VALUES (30,1,'查询分类',26);
INSERT INTO `Execute` VALUES (31,5,'设置结果',26);
INSERT INTO `Execute` VALUES (32,1,'获取版头记录',29);
INSERT INTO `Execute` VALUES (33,5,'设置结果',29);
INSERT INTO `Execute` VALUES (34,1,'获取商品',32);
INSERT INTO `Execute` VALUES (35,5,'设置结果',32);
INSERT INTO `Execute` VALUES (36,1,'查询是否有保存token的记录',21);
INSERT INTO `Execute` VALUES (37,2,'新增记录',34);
INSERT INTO `Execute` VALUES (38,3,'修改记录',33);
INSERT INTO `Execute` VALUES (39,1,'查询用户信息',37);
INSERT INTO `Execute` VALUES (40,5,'设置结果',38);
INSERT INTO `Execute` VALUES (42,5,'设置序号',39);
INSERT INTO `Execute` VALUES (43,1,'查询货物',40);
INSERT INTO `Execute` VALUES (47,5,'计算金额',40);
INSERT INTO `Execute` VALUES (48,5,'序号+1',40);
INSERT INTO `Execute` VALUES (49,2,'生成订单',41);
INSERT INTO `Execute` VALUES (50,1,'用户信息',39);
INSERT INTO `Execute` VALUES (51,5,'设置序号',41);
INSERT INTO `Execute` VALUES (52,2,'逐条添加',42);
INSERT INTO `Execute` VALUES (53,5,'序号+1',42);
INSERT INTO `Execute` VALUES (54,5,'设置订单',43);
INSERT INTO `Execute` VALUES (55,8,'生成支付内容',48);
INSERT INTO `Execute` VALUES (56,5,'设置返回内容',48);
INSERT INTO `Execute` VALUES (57,1,'查询',51);
INSERT INTO `Execute` VALUES (58,1,'查询商品',54);
INSERT INTO `Execute` VALUES (59,5,'设置返回内容',55);
INSERT INTO `Execute` VALUES (60,5,'设置序号',54);
INSERT INTO `Execute` VALUES (61,5,'设置商品名称',55);
INSERT INTO `Execute` VALUES (62,5,'增加序号',57);
INSERT INTO `Execute` VALUES (63,5,'设置图片',55);
INSERT INTO `Execute` VALUES (64,5,'设置价格',55);
INSERT INTO `Execute` VALUES (65,5,'设置折扣量',55);
INSERT INTO `Execute` VALUES (66,13,'最多销量商品',60);
INSERT INTO `Execute` VALUES (67,5,'返回内容',61);
INSERT INTO `Execute` VALUES (68,1,'商品信息',60);
INSERT INTO `Execute` VALUES (69,13,'总商品数',56);
INSERT INTO `Execute` VALUES (70,13,'统计商品总数',63);
INSERT INTO `Execute` VALUES (71,13,'统计',66);
INSERT INTO `Execute` VALUES (72,1,'查询种类',67);
INSERT INTO `Execute` VALUES (73,1,'查询商品',68);
INSERT INTO `Execute` VALUES (74,13,'有销量总商品数',66);
INSERT INTO `Execute` VALUES (75,5,'设置',69);
INSERT INTO `Execute` VALUES (76,5,'设置序号',70);
INSERT INTO `Execute` VALUES (77,5,'序号+1',68);
INSERT INTO `Execute` VALUES (78,5,'序号+1',68);
INSERT INTO `Execute` VALUES (79,14,'支付宝',71);
INSERT INTO `Execute` VALUES (80,15,'查询货物',72);
INSERT INTO `Execute` VALUES (81,5,'计算金额',72);
INSERT INTO `Execute` VALUES (82,5,'序号+1',72);
INSERT INTO `Execute` VALUES (84,5,'设置错误',76);
INSERT INTO `Execute` VALUES (85,1,'检查凭证',75);
INSERT INTO `Execute` VALUES (86,15,'用户信息',77);
INSERT INTO `Execute` VALUES (87,1,'订单记录',78);
INSERT INTO `Execute` VALUES (88,1,'商品数据',79);
INSERT INTO `Execute` VALUES (89,5,'设置序号',78);
INSERT INTO `Execute` VALUES (93,5,'序号+1',81);
INSERT INTO `Execute` VALUES (94,5,'订单号',83);
INSERT INTO `Execute` VALUES (95,1,'商品详情',80);
INSERT INTO `Execute` VALUES (96,16,'验证SIGN',84);
INSERT INTO `Execute` VALUES (97,15,'查询订单',87);
INSERT INTO `Execute` VALUES (98,3,'更新订单状态',87);
INSERT INTO `Execute` VALUES (99,5,'设定结果',88);
INSERT INTO `Execute` VALUES (100,5,'设定返回内容',90);
INSERT INTO `Execute` VALUES (101,15,'专题数据',93);
INSERT INTO `Execute` VALUES (102,17,'设置数据',93);
INSERT INTO `Execute` VALUES (103,1,'查询',94);
INSERT INTO `Execute` VALUES (104,17,'设置序号',94);
INSERT INTO `Execute` VALUES (105,17,'设置返回内容',95);
INSERT INTO `Execute` VALUES (106,17,'序号+1',95);
INSERT INTO `Execute` VALUES (107,1,'查询',98);
INSERT INTO `Execute` VALUES (108,17,'设置结果',99);
INSERT INTO `Execute` VALUES (109,17,'设置结果',100);
INSERT INTO `Execute` VALUES (110,1,'查询',103);
CREATE TABLE `DynamicRequest` (
	`id`	INTEGER,
	`url`	varchar(100),
	`processId`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `DynamicRequest` VALUES (1,'/block-server/dynamic/9',13);
INSERT INTO `DynamicRequest` VALUES (2,'/block-server/dynamic/14',14);
CREATE TABLE DataSourceParam( id INTEGER PRIMARY KEY ASC,name varchar(100),displayName varchar(100),type INTEGER,dataSource INTEGER);
INSERT INTO `DataSourceParam` VALUES (1,'url','名称',1,1);
CREATE TABLE ’DataSource’ (
	`id`	INTEGER,
	`language`	INTEGER,
	`name`	varchar(100),
	`className`	varchar(100),
	`jdbcUrl`	varchar(100),
	`username`	varchar(100),
	`password`	varchar(100),
	PRIMARY KEY(`id`)
);
INSERT INTO `DataSource` VALUES (1,3,'sqlite','org.sqlite.SQLiteDataSource','jdbc:sqlite:E:\\blockServer\\src\\main\\resources\\mydatabase.db',NULL,NULL);
INSERT INTO `DataSource` VALUES (2,3,'sqlite','org.sqlite.SQLiteDataSource','jdbc:sqlite:E:\blockServer\src\main\resources\mydatabase.db',NULL,NULL);
CREATE TABLE BlockDataSourceParam( id INTEGER PRIMARY KEY ASC,block INTEGER,dataSourceParam INTEGER,param INTEGER);
INSERT INTO `BlockDataSourceParam` VALUES (1,2,1,11);
INSERT INTO `BlockDataSourceParam` VALUES (2,4,1,11);
INSERT INTO `BlockDataSourceParam` VALUES (3,5,1,11);
CREATE TABLE ’Block’ (
	`id`	INTEGER,
	`name`	varchar(100),
	`process`	INTEGER,
	`positionY`	INTEGER,
	`positionX`	INTEGER,
	PRIMARY KEY(`id`)
);
INSERT INTO `Block` VALUES (1,'开始		 ',2,46,287);
INSERT INTO `Block` VALUES (2,'新增流程',2,180,446);
INSERT INTO `Block` VALUES (3,'结束',2,280,287);
INSERT INTO `Block` VALUES (4,'321',3,NULL,NULL);
INSERT INTO `Block` VALUES (5,'删除流程',3,214,73);
INSERT INTO `Block` VALUES (6,'查询id是否存在',1,NULL,NULL);
INSERT INTO `Block` VALUES (7,'删除模块',1,NULL,NULL);
INSERT INTO `Block` VALUES (8,'查询id是否存在',4,193,300);
INSERT INTO `Block` VALUES (9,'新增模块',NULL,NULL,NULL);
INSERT INTO `Block` VALUES (10,'更新模块',NULL,NULL,NULL);
INSERT INTO `Block` VALUES (11,'第一个',7,80,160);
INSERT INTO `Block` VALUES (12,'结束',7,520,310);
INSERT INTO `Block` VALUES (13,'321','',NULL,NULL);
INSERT INTO `Block` VALUES (14,'321321',NULL,NULL,NULL);
INSERT INTO `Block` VALUES (15,'321321',7,340,88);
INSERT INTO `Block` VALUES (16,'NEW',7,306,560);
INSERT INTO `Block` VALUES (17,'流程Start',8,31,260);
INSERT INTO `Block` VALUES (18,'流程End',8,680,291);
INSERT INTO `Block` VALUES (19,'没什么',8,172,260);
INSERT INTO `Block` VALUES (20,'错误 ',8,286,420);
INSERT INTO `Block` VALUES (21,'OK',8,286,100);
INSERT INTO `Block` VALUES (22,'1111',8,430,627);
INSERT INTO `Block` VALUES (23,'2222',8,272,620);
INSERT INTO `Block` VALUES (24,'流程Start',9,70,173);
INSERT INTO `Block` VALUES (25,'流程End',9,474,173);
INSERT INTO `Block` VALUES (26,'商品分类',9,267,173);
INSERT INTO `Block` VALUES (27,'流程Start',10,171,187);
INSERT INTO `Block` VALUES (28,'流程End',10,460,187);
INSERT INTO `Block` VALUES (29,'获取版头',10,312,188);
INSERT INTO `Block` VALUES (30,'流程Start',11,140,168);
INSERT INTO `Block` VALUES (31,'流程End',11,460,168);
INSERT INTO `Block` VALUES (32,'获取商品',11,311,169);
INSERT INTO `Block` VALUES (33,'修改记录',8,460,20);
INSERT INTO `Block` VALUES (34,'新增记录',8,460,171);
INSERT INTO `Block` VALUES (35,'流程Start',12,40,167);
INSERT INTO `Block` VALUES (36,'流程End',12,920,47);
INSERT INTO `Block` VALUES (37,'用户信息',12,251,168);
INSERT INTO `Block` VALUES (38,'错误',12,472,40);
INSERT INTO `Block` VALUES (39,'商品信息 ',12,468,320);
INSERT INTO `Block` VALUES (40,'计算价格',12,280,774);
INSERT INTO `Block` VALUES (41,'订单',12,471,540);
INSERT INTO `Block` VALUES (42,'订单商品',12,646,540);
INSERT INTO `Block` VALUES (43,'返回订单',12,840,540);
INSERT INTO `Block` VALUES (44,'流程Start',13,120,167);
INSERT INTO `Block` VALUES (45,'流程End',13,554,166);
INSERT INTO `Block` VALUES (46,'流程Start',14,40,169);
INSERT INTO `Block` VALUES (47,'流程End',14,880,160);
INSERT INTO `Block` VALUES (48,'付款内容',13,320,167);
INSERT INTO `Block` VALUES (49,'流程Start',15,91,160);
INSERT INTO `Block` VALUES (50,'流程End',15,460,160);
INSERT INTO `Block` VALUES (51,'查询数据',15,280,160);
INSERT INTO `Block` VALUES (52,'流程Start',16,120,174);
INSERT INTO `Block` VALUES (53,'流程End',16,900,280);
INSERT INTO `Block` VALUES (54,'查询商品',16,280,174);
INSERT INTO `Block` VALUES (55,'返回内容',16,440,174);
INSERT INTO `Block` VALUES (56,'统计数量',16,700,180);
INSERT INTO `Block` VALUES (57,'增加序号',16,440,380);
INSERT INTO `Block` VALUES (58,'流程Start',17,26,140);
INSERT INTO `Block` VALUES (59,'流程End',17,520,140);
INSERT INTO `Block` VALUES (60,'推荐商品',17,168,140);
INSERT INTO `Block` VALUES (61,'设置结果',17,360,140);
INSERT INTO `Block` VALUES (62,'特st',17,120,330);
INSERT INTO `Block` VALUES (63,'统计数量',16,700,380);
INSERT INTO `Block` VALUES (64,'流程Start',18,70,160);
INSERT INTO `Block` VALUES (65,'流程End',18,880,160);
INSERT INTO `Block` VALUES (66,'销量排行',18,360,160);
INSERT INTO `Block` VALUES (67,'查询种类id',18,220,160);
INSERT INTO `Block` VALUES (68,'查询商品',18,540,350);
INSERT INTO `Block` VALUES (69,'设置结果',18,740,352);
INSERT INTO `Block` VALUES (70,'填充数据',18,534,160);
INSERT INTO `Block` VALUES (71,'支付对接',12,860,320);
INSERT INTO `Block` VALUES (72,'计算价格',12,640,320);
INSERT INTO `Block` VALUES (73,'流程Start',19,71,160);
INSERT INTO `Block` VALUES (74,'流程End',19,900,20);
INSERT INTO `Block` VALUES (75,'查询用户',19,229,160);
INSERT INTO `Block` VALUES (76,'错误',19,354,9);
INSERT INTO `Block` VALUES (77,'正常',19,360,300);
INSERT INTO `Block` VALUES (78,'查询订单',19,520,300);
INSERT INTO `Block` VALUES (79,'订单商品 ',19,360,460);
INSERT INTO `Block` VALUES (80,'商品数据',19,360,731);
INSERT INTO `Block` VALUES (81,'填充结束',19,608,730);
INSERT INTO `Block` VALUES (82,'处理结束',19,806,300);
INSERT INTO `Block` VALUES (83,'生产订单号',12,280,540);
INSERT INTO `Block` VALUES (84,'验证',14,211,168);
INSERT INTO `Block` VALUES (85,'错误',14,413,40);
INSERT INTO `Block` VALUES (86,'正常',14,411,380);
INSERT INTO `Block` VALUES (87,'支付成功',14,613,280);
INSERT INTO `Block` VALUES (88,'完成',14,740,280);
INSERT INTO `Block` VALUES (89,'其他情况',14,620,480);
INSERT INTO `Block` VALUES (90,'结束',14,749,480);
INSERT INTO `Block` VALUES (91,'流程Start',20,53,160);
INSERT INTO `Block` VALUES (92,'流程End',20,609,160);
INSERT INTO `Block` VALUES (93,'设置内容',20,240,160);
INSERT INTO `Block` VALUES (94,'楼层数据',20,410,160);
INSERT INTO `Block` VALUES (95,'转换',20,414,340);
INSERT INTO `Block` VALUES (96,'流程Start',21,140,140);
INSERT INTO `Block` VALUES (97,'流程End',21,674,140);
INSERT INTO `Block` VALUES (98,'检查',21,273,140);
INSERT INTO `Block` VALUES (99,'无记录',21,440,60);
INSERT INTO `Block` VALUES (100,'有记录',21,440,230);
INSERT INTO `Block` VALUES (101,'流程Start',22,128,109);
INSERT INTO `Block` VALUES (102,'流程End',22,533,114);
INSERT INTO `Block` VALUES (103,'查询主题',22,326,108);
COMMIT;
