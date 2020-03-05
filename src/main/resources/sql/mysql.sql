create table block
(
    id        int auto_increment
        primary key,
    name      varchar(100) null,
    process   int          null,
    positionY int          null,
    positionX int          null
);

INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('开始		 ', 2, 46, 287);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新增流程', 2, 180, 446);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('结束', 2, 280, 287);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('321', 3, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除流程', 3, 214, 73);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询id是否存在', 1, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除模块', 1, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询id是否存在', 4, 193, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新增模块', null, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('更新模块', null, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('第一个', 7, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('结束', 7, 520, 310);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('321321', null, null, null);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('321321', 7, 340, 88);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('NEW', 7, 306, 560);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 8, 31, 260);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 8, 680, 291);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('没什么', 8, 172, 260);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误 ', 8, 320, 469);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('OK', 8, 286, 100);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('1111', 8, 430, 627);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('2222', 8, 272, 620);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 9, 200, 774);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 9, 300, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品分类', 9, 273, 452);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 10, 109, 126);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 10, 360, 820);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('获取版头', 10, 366, 360);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 11, 140, 168);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 11, 460, 168);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('获取商品', 11, 311, 169);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('修改记录', 8, 460, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新增记录', 8, 460, 171);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 12, 28, 172);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 12, 920, 47);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 12, 251, 169);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误', 12, 472, 40);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息 ', 12, 468, 320);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('计算价格', 12, 280, 774);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('订单', 12, 471, 540);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('订单商品', 12, 646, 540);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('返回订单', 12, 840, 540);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 13, 120, 168);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 13, 554, 166);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 14, 40, 169);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 14, 880, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('付款内容', 13, 320, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 15, 91, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 15, 460, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询数据', 15, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 16, 120, 174);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 16, 900, 280);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询商品', 16, 280, 174);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('返回内容', 16, 440, 174);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('统计数量', 16, 700, 180);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('增加序号', 16, 440, 380);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 17, 26, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 17, 520, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('推荐商品', 17, 168, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置结果', 17, 360, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('特st', 17, 120, 330);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('统计数量', 16, 700, 380);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 18, 70, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 18, 880, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('销量排行', 18, 360, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询种类id', 18, 220, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询商品', 18, 540, 350);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置结果', 18, 740, 352);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('填充数据', 18, 534, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('支付对接', 12, 860, 320);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('计算价格', 12, 640, 320);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 19, 71, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 19, 900, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询用户', 19, 229, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误', 19, 354, 9);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('正常', 19, 360, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询订单', 19, 520, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('订单商品 ', 19, 360, 460);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品数据', 19, 360, 731);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('填充结束', 19, 608, 730);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('处理结束', 19, 806, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('生产订单号', 12, 280, 540);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('验证', 14, 211, 168);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误', 14, 413, 40);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('正常', 14, 411, 380);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('支付成功', 14, 613, 280);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('完成', 14, 740, 280);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('其他情况', 14, 620, 480);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('结束', 14, 749, 480);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 20, 53, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 20, 609, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置内容', 20, 240, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('楼层数据', 20, 410, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('转换', 20, 414, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 21, 140, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 21, 674, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('检查', 21, 273, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('无记录', 21, 440, 60);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('有记录', 21, 440, 230);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 22, 128, 109);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 22, 533, 114);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询主题', 22, 326, 108);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 24, 280, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 25, 280, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 26, 280, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 27, 280, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 28, 280, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 31, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 31, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 32, 60, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 32, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 33, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 33, 447, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 33, 248, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 34, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 34, 410, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 34, 240, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 35, 14, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 35, 706, 140);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('正常', 35, 340, 393);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('检查时间', 35, 320, 791);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('过期', 35, 330, 240);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('jsticket', 35, 507, 790);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('jsticket', 35, 513, 60);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询jsapi', 35, 133, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新申请', 35, 333, 60);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 36, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 36, 740, 180);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询token', 36, 230, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新申请', 36, 432, 71);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('过期', 36, 429, 232);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('保存', 36, 600, 71);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('正常', 36, 429, 367);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 37, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 37, 428, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('获取jsticket', 37, 240, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 38, 60, 32);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 38, 640, 167);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息 ', 38, 100, 329);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息', 38, 373, 328);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('保存', 38, 520, 329);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 39, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 39, 440, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 39, 253, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 40, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 40, 372, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 40, 220, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 41, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 41, 312, 368);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 41, 229, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息', 41, 369, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('保存', 41, 120, 366);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 42, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 42, 672, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('助力信息 ', 42, 232, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息', 42, 387, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置返回', 42, 520, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 43, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 43, 591, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('保存', 43, 320, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 44, -20, 370);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 44, 760, 168);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('微信信息', 44, 260, 740);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('砍价', 44, 267, 193);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('最低价', 44, 560, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('砍价', 44, 560, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息', 43, 327, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('第一次砍价', 44, 253, 534);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('砍价完毕', 44, 560, 491);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 45, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 45, 360, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 45, 220, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('已砍价', 44, 560, 166);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 46, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 46, 573, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('订单信息', 46, 340, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 46, 208, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息 ', 46, 380, 326);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('无用户', 38, 520, 33);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 47, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 47, 600, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 47, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('订单', 47, 420, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('商品信息', 47, 420, 352);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('已分享过', 38, 388, 170);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 43, 188, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('重复订单', 43, 520, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('砍价次数', 44, 180, 366);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 48, 60, 150);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 48, 960, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('检查数据', 48, 233, 152);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误', 48, 389, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('错误', 48, 400, 151);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('检查重复', 48, 400, 286);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('返回', 48, 600, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新增用户', 48, 628, 460);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('跳过检查', 48, 628, 286);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 49, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 49, 614, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('验证用户', 49, 271, 220);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询数据', 49, 487, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('无用户', 49, 474, 50);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 50, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 50, 474, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 50, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 51, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 51, 460, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 51, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 52, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 52, 406, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置', 52, 214, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 53, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 53, 629, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('是否报名', 53, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('重复', 53, 400, 32);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('正常', 53, 400, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 54, 60, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 54, 660, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 55, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 55, 870, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('红包信息', 54, 440, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('计算url', 55, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('继续跳转 ', 55, 440, 20);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('停止跳转', 55, 440, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 54, 320, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 56, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 56, 472, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('编辑', 56, 260, 49);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除', 56, 269, 280);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('增加', 56, 280, 480);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 57, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 57, 567, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('增加', 57, 300, 14);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('编辑', 57, 300, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除', 57, 293, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 58, 73, 174);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 58, 494, 180);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新增', 58, 260, 28);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('修改', 58, 260, 171);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除', 58, 260, 326);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 59, 74, 153);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 59, 480, 153);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新建', 59, 271, 26);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('编辑', 59, 269, 154);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除', 59, 266, 300);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 60, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 60, 469, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('修改', 60, 249, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('获取appid', 54, 193, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 61, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 61, 440, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('查询', 61, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 62, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 62, 440, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('随机链接', 62, 260, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 63, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 63, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置子页面', 55, 668, 40);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置子页面', 55, 669, 280);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('结束计算', 55, 560, 170);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('访问记录', 54, 560, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 64, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 64, 420, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('保存', 64, 246, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('视频页面', 55, 670, 460);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 65, 40, 100);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 65, 620, 100);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('用户信息', 65, 309, 100);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('获取数据', 65, 93, 374);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('VIP数据', 65, 350, 340);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('普通数据', 65, 351, 466);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('分享记录', 48, 820, 560);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 66, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 66, 640, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('设置分享', 66, 240, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('分享次数', 66, 231, 320);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('升级', 66, 410, 414);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 67, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 67, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 68, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 68, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 69, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 69, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 70, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 70, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES (null, 0, 0, 0);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 71, 80, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 71, 280, 160);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程Start', 72, 74, 153);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('流程End', 72, 480, 153);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('新建', 72, 270, 26);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('编辑', 72, 269, 154);
INSERT INTO bricks.block (name, process, positionY, positionX) VALUES ('删除', 72, 266, 300);
create table blockdatasourceparam
(
    id              int auto_increment
        primary key,
    block           int null,
    dataSourceParam int null,
    param           int null
);

INSERT INTO bricks.blockdatasourceparam (block, dataSourceParam, param) VALUES (2, 1, 11);
INSERT INTO bricks.blockdatasourceparam (block, dataSourceParam, param) VALUES (4, 1, 11);
INSERT INTO bricks.blockdatasourceparam (block, dataSourceParam, param) VALUES (5, 1, 11);
create table datasource
(
    id        int auto_increment
        primary key,
    language  int          null,
    name      varchar(100) null,
    className varchar(100) null,
    jdbcUrl   varchar(100) null,
    username  varchar(100) null,
    password  varchar(100) null
);

INSERT INTO bricks.datasource (language, name, className, jdbcUrl, username, password) VALUES (3, 'sqlite', 'org.sqlite.SQLiteDataSource', 'jdbc:sqlite:E:\\blockServer\\src\\main\\resources\\mydatabase.db', null, null);
INSERT INTO bricks.datasource (language, name, className, jdbcUrl, username, password) VALUES (3, 'sqlite', 'org.sqlite.SQLiteDataSource', 'jdbc:sqlite:E:lockServersrcmainesourcesmydatabase.db', null, null);
create table datasourceparam
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    displayName varchar(100) null,
    type        int          null,
    dataSource  int          null
);

INSERT INTO bricks.datasourceparam (name, displayName, type, dataSource) VALUES ('url', '名称', 1, 1);
create table datatable
(
    id   int auto_increment
        primary key,
    name varchar(100) null
);

INSERT INTO bricks.datatable (name) VALUES ('TBL_CATEGORY');
INSERT INTO bricks.datatable (name) VALUES ('TBL_GOODS');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ORDER');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ORDER_GOODS');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ORDER_GOODS_ATTR');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ORDER_OPERATION');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ORDER_PAY');
INSERT INTO bricks.datatable (name) VALUES ('TBL_PAY_TYPE');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHOP');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHOP_CHECK');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHOP_DELIVER');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHOP_INFO');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHOP_SETTLE');
INSERT INTO bricks.datatable (name) VALUES ('TBL_USER');
INSERT INTO bricks.datatable (name) VALUES ('TBL_BANNER');
INSERT INTO bricks.datatable (name) VALUES ('TBL_TOKEN');
INSERT INTO bricks.datatable (name) VALUES ('TBL_TOPIC_CONTENT');
INSERT INTO bricks.datatable (name) VALUES ('TBL_TOPIC');
INSERT INTO bricks.datatable (name) VALUES ('tbl_sharegoods');
INSERT INTO bricks.datatable (name) VALUES ('tbl_wechattoken');
INSERT INTO bricks.datatable (name) VALUES ('tbl_jsapi');
INSERT INTO bricks.datatable (name) VALUES ('tbl_secret');
INSERT INTO bricks.datatable (name) VALUES ('tbl_sharerecord');
INSERT INTO bricks.datatable (name) VALUES ('tbl_assistance_goods');
INSERT INTO bricks.datatable (name) VALUES ('tbl_assistance_record');
INSERT INTO bricks.datatable (name) VALUES ('tbl_assistance_assist');
INSERT INTO bricks.datatable (name) VALUES ('test');
INSERT INTO bricks.datatable (name) VALUES ('tbl_baoming');
INSERT INTO bricks.datatable (name) VALUES ('tbl_shareInfo');
INSERT INTO bricks.datatable (name) VALUES ('tbl_urllist');
INSERT INTO bricks.datatable (name) VALUES ('tbl_advert');
INSERT INTO bricks.datatable (name) VALUES ('tbl_setting');
INSERT INTO bricks.datatable (name) VALUES ('TBL_ACCESS_RECORD');
INSERT INTO bricks.datatable (name) VALUES ('TBL_SHARE_RED_RECORD');
INSERT INTO bricks.datatable (name) VALUES ('TBL_VIDEO');
INSERT INTO bricks.datatable (name) VALUES ('tbl_worth_news');
create table dynamicrequest
(
    id        int auto_increment
        primary key,
    url       varchar(100) null,
    processId int          null
);

INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/13', 13);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/14', 14);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/31', 31);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/32', 32);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/33', 33);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/34', 34);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/35', 35);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/36', 36);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/37', 37);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/38', 38);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/39', 39);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/40', 40);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/41', 41);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/42', 42);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/43', 43);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/44', 44);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/45', 45);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/46', 46);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/47', 47);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/48', 48);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/49', 49);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/50', 50);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/51', 51);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/52', 52);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/53', 53);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/54', 54);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/55', 55);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/56', 56);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/57', 57);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/58', 58);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/59', 59);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/60', 60);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/61', 61);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/62', 62);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/63', 63);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/64', 64);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/65', 65);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/66', 66);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/12', 12);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/67', 67);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/68', 68);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/69', 69);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/70', 70);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/71', 71);
INSERT INTO bricks.dynamicrequest (url, processId) VALUES ('/block-server/dynamic/72', 72);
create table execute
(
    id          int auto_increment
        primary key,
    method      int          null,
    executeName varchar(100) null,
    block       int          null
);

INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '新增流程', 2);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 3);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除', 5);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除模块', 7);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新模块', 10);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 12);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '11111', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 12);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '11', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '111', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'aaaa', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '11', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '321', 11);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, 'query', 16);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '检查账号', 19);
INSERT INTO bricks.execute (method, executeName, block) VALUES (7, '生产TOKEN', 21);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置结果', 21);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '返回错误', 20);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询分类', 26);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置结果', 26);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '获取版头记录', 29);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置结果', 29);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '获取商品', 32);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置结果', 32);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询是否有保存token的记录', 21);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '新增记录', 34);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '修改记录', 33);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询用户信息', 37);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置结果', 38);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置序号', 39);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询货物', 40);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '计算金额', 40);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 40);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '生成订单', 41);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '用户信息', 39);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置序号', 41);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '逐条添加', 42);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 42);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置订单', 43);
INSERT INTO bricks.execute (method, executeName, block) VALUES (8, '生成支付内容', 48);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置返回内容', 48);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 51);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询商品', 54);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置返回内容', 55);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置序号', 54);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置商品名称', 55);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '增加序号', 57);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置图片', 55);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置价格', 55);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置折扣量', 55);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '最多销量商品', 60);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '返回内容', 61);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '商品信息', 60);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '总商品数', 56);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '统计商品总数', 63);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '统计', 66);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询种类', 67);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询商品', 68);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '有销量总商品数', 66);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置', 69);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置序号', 70);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 68);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 68);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '支付宝', 71);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询货物', 72);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '计算金额', 72);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 72);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置错误', 76);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '检查凭证', 75);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '用户信息', 77);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '订单记录', 78);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '商品数据', 79);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设置序号', 78);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '序号+1', 81);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '订单号', 83);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '商品详情', 80);
INSERT INTO bricks.execute (method, executeName, block) VALUES (16, '验证SIGN', 84);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询订单', 87);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新订单状态', 87);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设定结果', 88);
INSERT INTO bricks.execute (method, executeName, block) VALUES (5, '设定返回内容', 90);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '专题数据', 93);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置数据', 93);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 94);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置序号', 94);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置返回内容', 95);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '序号+1', 95);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 98);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置结果', 99);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置结果', 100);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 103);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 117);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 120);
INSERT INTO bricks.execute (method, executeName, block) VALUES (18, 'jsapi', 127);
INSERT INTO bricks.execute (method, executeName, block) VALUES (18, 'jsapi', 126);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '检查是否过期', 128);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 132);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除过期内容', 133);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询secret', 133);
INSERT INTO bricks.execute (method, executeName, block) VALUES (20, '申请', 133);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存token', 135);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置数据', 136);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '获取token', 129);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除老数据', 127);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置数据', 123);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 127);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '获取ticket', 139);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '组装', 139);
INSERT INTO bricks.execute (method, executeName, block) VALUES (21, '加密', 139);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '用户', 142);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 143);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 144);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 147);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 150);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 153);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '商品信息', 154);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 155);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 158);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 159);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '统计', 158);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 160);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存订单', 163);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询secret', 166);
INSERT INTO bricks.execute (method, executeName, block) VALUES (22, '网页', 166);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 168);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 168);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '生成砍价量', 169);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 169);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 169);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 170);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询secret', 175);
INSERT INTO bricks.execute (method, executeName, block) VALUES (22, '网页', 175);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 172);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询是否已砍价', 167);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 176);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 168);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 169);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 179);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 180);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置序号', 179);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 181);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '下一个', 181);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置内容', 182);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 185);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询', 186);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 186);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 187);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '序号+1', 187);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查重', 142);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查重', 170);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 189);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 190);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '统计', 191);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '订单信息', 191);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '商品信息', 191);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 198);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '重复查询', 197);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '新增', 199);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '登录', 199);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 199);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '登录', 200);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 200);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'zhengch', 25);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'cuowu', 25);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 203);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 208);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '查询', 204);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '1', 211);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '1', 214);
INSERT INTO bricks.execute (method, executeName, block) VALUES (1, '查询重复', 217);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '错误', 218);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 219);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 219);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '1', 224);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '随机值', 226);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '查询', 227);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '1', 228);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置share', 227);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 228);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '查询', 229);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 233);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除', 234);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '新增', 235);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 238);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 239);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除', 240);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'add', 243);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, 'update', 244);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除', 245);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'add', 248);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, 'edit', 249);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, 'del', 250);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, '删除老数据', 253);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 253);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询key', 254);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 257);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置结果', 257);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '获取随机值', 226);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, 'sql', 260);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置 ', 260);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 264);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 265);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 267);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, '保存', 270);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 271);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 271);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '查询', 274);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '查询', 276);
INSERT INTO bricks.execute (method, executeName, block) VALUES (30, '查询', 277);
INSERT INTO bricks.execute (method, executeName, block) VALUES (17, '设置', 276);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 281);
INSERT INTO bricks.execute (method, executeName, block) VALUES (14, '调用分享流程', 278);
INSERT INTO bricks.execute (method, executeName, block) VALUES (15, '分享用户信息', 281);
INSERT INTO bricks.execute (method, executeName, block) VALUES (13, '统计', 282);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, '更新', 283);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (null, null, null);
INSERT INTO bricks.execute (method, executeName, block) VALUES (2, 'add', 308);
INSERT INTO bricks.execute (method, executeName, block) VALUES (3, 'edit', 309);
INSERT INTO bricks.execute (method, executeName, block) VALUES (4, 'del', 310);
INSERT INTO bricks.execute (method, executeName, block) VALUES (8, 'apipayTestament', 39);
create table executeparam
(
    id                int auto_increment
        primary key,
    execute           int          null,
    pluginMethodParam varchar(100) null,
    param             varchar(300) null,
    fieldName         varchar(100) null,
    type              int          null
);

INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (2, '7', '4', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (1, '3', '5', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (2, '8', '7', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (2, '9', '8', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (2, '11', '1', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (1, '4', '7', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (1, '5', '8', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (3, '12', '12', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (3, '13', '13', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (4, '12', '14', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (4, '13', '15', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (5, null, null, null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (21, 'arg0', '1112', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (6, '表名', 'process', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (6, 'id', '123', null, null);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (28, 'token', '{MD5code}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (28, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (26, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (26, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (26, 'password', '{密码}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (26, '结果', 'resu', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (27, 'MD5', '{账号}', 'param', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (27, 'jieguo', 'MD5code', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (30, '表名', 'TBL_CATEGORY', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (30, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (31, 'list', '{result}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (31, 'list', 'list', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (32, '表名', 'TBL_BANNER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (32, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (33, 'list', '{result}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (33, 'list', 'list', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (35, 'goods', '{result}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (35, 'goods', 'goods', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (36, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (36, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (36, '结果', 'token记录', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (37, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (37, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (37, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (38, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (38, 'id', 'val({token记录},1).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (38, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (38, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (39, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (39, 'token', '{用户token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (39, '结果', 'tokenList', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (40, '结果', '错误', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (40, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (41, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (41, 'id', 'val({货物表},{序号}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (44, '序号', 'val({序号})+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (44, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (45, '结果', '{商品信息1}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (45, '序号', '{序号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (45, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (45, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (50, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (50, 'username', 'val({tokenList},1).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (50, '结果', '用户信息', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (53, '序号', 'val({序号})+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (53, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (54, '结果', 'val({用户信息},1).id+getTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (54, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (56, '返回表单', '{result}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (56, '返回表单', '返回表单', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (57, '表名', 'TBL_BANNER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (57, '查询数量', '3', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (57, '结果', 'content', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '订单结束链接', '{返回url}', 'returnUrl', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '订单处理链接', '{处理url}', 'notifyUrl', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '订单号', '{订单号}', 'out_trade_no', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '价格/元', '{价格}', 'total_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '标题', '{订单标题}', 'subject', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (55, '表单', 'result', 'formString', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (59, 'goods', '{result}[{序号}].id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (59, 'goods', 'goods[{序号}].id', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (60, 'goods', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (60, 'goods', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (61, 'goods', '{result}[{序号}].name', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (61, 'goods', 'goods[{序号}].name', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (62, 'goods', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (62, 'goods', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (63, 'goods', '{result}[{序号}].picUrl', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (63, 'goods', 'goods[{序号}].imgpath', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (64, 'goods', '{result}[{序号}].price', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (64, 'goods', 'goods[{序号}].price', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (65, 'goods', '{result}[{序号}].price/{result}[{序号}].originPrice', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (65, 'goods', 'goods[{序号}].offpercent', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '表名', 'TBL_ORDER_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '统计内容', 'sum(quantity)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '区分内容', 'goodsId', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '排序内容', 'sum(quantity) desc', 'orderColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '查询数量', '1', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (66, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (68, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (68, 'id', '{result}[0].goodsId', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (68, '结果', 'goods', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (67, '结果', '{goods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (67, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (69, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (69, '统计内容', 'count(id)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (69, 'catId', '{种类}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (69, '结果', 'totalCount', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (70, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (70, '统计内容', 'count(id)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (70, 'catId', '{种类}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (70, '结果', 'totalCount', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (72, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (72, 'catId', '{种类}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (72, '结果', 'ids', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '表名', 'TBL_ORDER_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '统计内容', 'sum(quantity)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '区分内容', 'goodsId', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '排序内容', 'sum(quantity) desc', 'orderColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '查询数量', '{数量}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, 'goodsId', 'arrayValue({ids}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (71, '结果', '销量', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (74, '表名', 'TBL_ORDER_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (74, '统计内容', 'sum(quantity)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (74, '区分内容', 'goodsId', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (74, 'goodsId', 'arrayValue({ids}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (74, '结果', 'totalCount', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (76, 'result', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (76, 'result', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (78, 'result', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (78, 'result', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (75, 'result', '{销量}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (75, 'resultCount', 'count({totalCount})', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (75, 'result', 'result', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (75, 'resultCount', 'resultCount', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (77, 'resultCount', '{result}[0]', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (77, 'resultCount', '销量[{序号}].goodsInfo', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (73, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (73, 'id', '{销量}[{序号}].goodsId', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (73, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, '查询数量', '{数量}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, '页数', '{页数}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, '排序', '{排序}', 'order', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, 'catId', '{种类}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (58, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (34, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (34, 'id', '{goodsId}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (34, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (42, '结果', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (42, '序号', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (42, '结果', '价格', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (42, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (48, '序号', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (48, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (43, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (43, 'id', '{货物表}[{序号}].商品id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (43, '结果', '商品信息[{序号}]', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (47, '结果', '{商品信息}[{序号}][0].price*{货物表}[{序号}].商品数量+{价格}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (47, '结果', '价格', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (80, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (80, 'id', '{货物表}[{序号}].商品id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (80, '结果', '商品信息[{序号}]', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (82, '序号', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (82, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (81, '结果', '{商品信息}[{序号}].price*{货物表}[{序号}].商品数量+{价格}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (81, '结果', '价格', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (29, '错误信息', '错误', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (29, '错误信息', '错误信息', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (84, '错误信息', '无该用户', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (84, '错误信息', '错误信息', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (83, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (83, 'token', '{用户token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (83, '结果', 'token记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (85, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (85, 'token', '{用户token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (85, '结果', 'token记录', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (89, '序号', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (89, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (90, '序号2', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (90, '序号2', '序号2', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (92, '序号2', '{序号2}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (92, '序号2', '序号2', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (93, '序号', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (93, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (86, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (86, 'username', '{token记录}[0].username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (86, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (87, '表名', 'TBL_ORDER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (87, '查询数量', '{数量}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (87, '页数', '{页数}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (87, 'userId', 'val({用户信息}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (87, '结果', '订单', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (94, '结果', 'val({用户信息},1).id+getTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (94, '结果', '订单号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (52, '表名', 'TBL_ORDER_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (52, 'goodsId', '{货物表}[{序号}].商品id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (52, 'orderId', '{订单号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (52, 'quantity', '{货物表}[{序号}].商品数量', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (52, 'price', '{商品信息}[{序号}].price*{货物表}[{序号}].商品数量', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (51, '序号', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (51, '序号', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (91, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (91, 'id', 'arrayValue(订单商品[{序号}]).goodsId', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (91, '结果', '订单商品[{序号}].goodsInfo', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (95, '表名', 'TBL_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (95, 'id', 'arrayValue(订单商品[{序号}].orderGoods).goodsId', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (95, '结果', '订单商品[{序号}].goodsInfo', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, '表名', 'TBL_ORDER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'orderNo', '{订单号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'userId', 'val({用户信息},1).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'orderAmt', '{价格}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'status', '未支付', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'createTime', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'receiver', '{名称}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'phone', '{电话}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (49, 'address', '{地址}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '通知时间', '{notify_time}', 'notify_time', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '通知类型', '{notify_type}', 'notify_type', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '通知校验ID', '{notify_id}', 'notify_id', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '编码格式', '{charset}', 'charset', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '接口版本', '{version}', 'version', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '签名类型', '{sign_type}', 'sign_type', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '签名', '{sign}', 'sign', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '授权方的app_id', '{auth_app_id}', 'auth_app_id', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '支付宝交易号', '{trade_no}', 'trade_no', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, 'APP ID', '{app_id}', 'app_id', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '商户订单号', '{out_trade_no}', 'out_trade_no', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '商户业务号', '{out_biz_no}', 'out_biz_no', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '买家支付宝用户号', '{buyer_id}', 'buyer_id', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '卖家支付宝用户号', '{seller_id}', 'seller_id', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '交易状态', '{trade_status}', 'trade_status', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '订单金额', '{total_amount}', 'total_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '实收金额', '{receipt_amount}', 'receipt_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '开票金额', '{invoice_amount}', 'invoice_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '付款金额', '{buyer_pay_amount}', 'buyer_pay_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '集分宝金额', '{point_amount}', 'point_amount', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '总退款金额', '{refund_fee}', 'refund_fee', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '订单标题', '{subject}', 'subject', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '商品描述', '{body}', 'body', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '交易创建时间', '{gmt_create}', 'gmt_create', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '交易付款时间', '{gmt_payment}', 'gmt_payment', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '交易退款时间', '{gmt_refund}', 'gmt_refund', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '交易结束时间', '{gmt_close}', 'gmt_close', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '支付金额信息', '{fund_bill_list}', 'fund_bill_list', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '优惠券信息', '{voucher_detail_list}', 'voucher_detail_list', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '回传参数', '{passback_params}', 'passback_params', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (96, '验证结果', '结果', 'isOk', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (97, '表名', 'TBL_ORDER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (97, 'orderNo', '{out_trade_no}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (97, '结果', '订单', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (98, '表名', 'TBL_ORDER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (98, 'id', 'val({订单}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (98, 'status', '已支付', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (99, '结果', '完成', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (99, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (100, '结果', '没处理！', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (100, '结果', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (101, '表名', 'TBL_TOPIC', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (101, 'id', '{专题编号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (101, '结果', '专题内容', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (102, '设置数量', '2', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (102, 'Value 1', 'val({专题内容}).主图片', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (102, 'Value 2', 'val({专题内容}).背景图', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (102, 'Key 1', '版头图片', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (102, 'Key 2', '背景图', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (103, '表名', 'TBL_TOPIC_CONTENT', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (103, 'topic', '{专题编号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (103, '结果', '楼层data', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (104, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (104, 'Value 1', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (104, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, '设置数量', '3', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Value 1', '{楼层data}[{序号}].picUrl', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Value 2', '{楼层data}[{序号}].url', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Value 3', '{楼层data}[{序号}].width', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Key 1', '楼层内容[{序号}].楼层图', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Key 2', '楼层内容[{序号}].楼层数据', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (105, 'Key 3', '楼层内容[{序号}].宽度', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (106, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (106, 'Value 1', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (106, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (107, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (107, 'token', '{用户token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (107, '结果', 'token记录', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (108, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (108, 'Value 1', 'ERROR', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (108, 'Key 1', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (110, '表名', 'TBL_TOPIC', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (110, '查询数量', '3', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (110, '结果', '结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (88, '表名', 'TBL_ORDER_GOODS', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (88, 'orderId', '{订单}[{序号}].orderNo', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (88, '结果', '订单商品[{序号}].orderGoods', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (111, '表名', 'tbl_sharegoods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (111, '查询数量', '10', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (111, '结果', '结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (112, '表名', 'tbl_sharegoods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (112, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (112, '结果', 'data', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, 'appid', 'wxb0b2c1f4846e22c5', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, 'appsecret', '0755fc78e819a4fd18d1472e90e037f4', 'appSecret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, 'token', 'token', 'token', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, '申请时间', 'tokenTime', 'time', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (114, '有效时间', 'tokenExpire', 'expire', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (113, '表名', 'tbl_wechattoken', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (113, 'appid', 'wxb0b2c1f4846e22c5', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (113, '结果', '查询结果', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (115, '表名', 'tbl_wechattoken', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (115, 'appid', 'wxb0b2c1f4846e22c5', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (115, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (115, 'applytime', '{tokenTime}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (115, 'expiretime', '{tokenExpire}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (116, 'token', '{token}', 'accessToken', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (116, 'ticket', 'ticket', 'ticket', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (116, '结果', 'js结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (116, '申请时间', 'tickettime', 'time', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (116, '有效时间', 'ticketexpire', 'expire', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (117, 'token', '{查询结果}.token', 'accessToken', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (117, '结果', 'js结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (117, '申请时间', 'tickettime', 'time', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (117, '有效时间', 'ticketexpire', 'expire', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (119, '表名', 'tbl_wechattoken', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (119, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (119, '结果', 'token记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (120, '表名', 'tbl_wechattoken', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (120, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (121, 'appid', '{appid}', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (122, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (122, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (122, '结果', 'secret记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (126, '流程ID', '36', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (126, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (126, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (127, '流程ID', '36', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (127, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (127, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (128, '表名', 'tbl_jsapi', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (128, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (131, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (131, 'Value 1', 'jsapi_ticket={jsapi_ticket}&noncestr={noncestr}&timestamp={timestamp}&url={url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (131, 'Key 1', 'string', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (132, '流程ID', '35', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (132, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (132, 'ticket', 'ticket', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (134, '内容', '{keyString}', 'string', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (134, '结果', 'sign', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (135, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (135, 'token', '{usertoken}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (135, '结果', '用户记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (136, '表名', 'tbl_sharegoods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (136, 'id', '{sharegoods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (136, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (138, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (138, '结果', '结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (140, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (140, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (140, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (141, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (141, 'id', '{goods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (141, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (142, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (142, 'goods', '{goods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (142, 'name', '{用户信息}.username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (142, 'time', 'getTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (125, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (125, 'Value 1', 'val({token记录}).token', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (125, 'Key 1', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, 'appid', '{appid}', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, 'appsecret', 'val({secret记录}).secret', 'appSecret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, 'token', 'token', 'token', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, '结果', '结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, '申请时间', 'tokenTime', 'time', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (123, '有效时间', 'tokenExpire', 'expire', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (129, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (129, 'Value 1', 'val({ticket结果}).ticket', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (129, 'Key 1', 'ticket', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (143, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (143, 'id', '{assistid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (143, '结果', '助力', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (144, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (144, 'id', 'val({助力}).goods', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (144, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (146, '设置数量', '3', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (147, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (147, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (147, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (124, '表名', 'tbl_wechattoken', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (124, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (124, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (124, 'applytime', '{tokenTime}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (124, 'expiretime', '{tokenExpire}*1000', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (130, '表名', 'tbl_jsapi', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (130, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (130, 'ticket', '{ticket}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (130, 'tickettime', '{tickettime}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (130, 'ticketexpire', '{ticketexpire}*1000', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (150, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (150, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (150, '结果', 'secret记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (151, 'appid', '{appid}', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (151, 'appsecret', 'val({secret记录}).secret', 'appSecret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (154, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (154, 'id', 'val({助力}).goods', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (154, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (157, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (157, 'id', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (157, 'nowprice', 'val({商品信息}).lowestprice', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (161, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (161, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (148, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (148, 'goods', '{goodsid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (148, 'name', 'val({用户信息}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (148, 'nowprice', 'val({商品信息}).price', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (148, 'resultid', 'record', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (153, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (153, 'id', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (153, '结果', '助力', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (155, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (155, '统计内容', 'sum(price),count(id)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (155, '区分内容', 'record', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (155, 'record', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (155, '结果', '统计', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (160, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (160, 'id', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (160, 'time', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (160, 'nowprice', 'val({助力}).nowprice-{assistprice}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (152, 'code', '{code}', 'code', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (152, 'appid', '{appid}', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (152, 'secret', 'val({secret记录}).secret', 'secret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (152, 'openid', 'openid', 'openid', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (162, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (162, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (162, '结果', 'secret记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (163, 'code', '{code}', 'code', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (163, 'appid', '{appid}', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (163, 'secret', 'val({secret记录}).secret', 'secret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (163, 'openid', 'openid', 'openid', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (164, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (164, 'Value 1', '已助力完毕', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (164, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (166, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (166, 'Value 1', '您已助力过', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (166, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (170, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (170, 'token', '{usertoken}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (170, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (169, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (169, 'name', 'val({用户信息}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (169, '结果', '订单', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (172, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (172, 'Value 1', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (172, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (173, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (173, 'id', '{订单}[{序号}].goods', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (173, '结果', '商品[{序号}]', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (174, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (174, 'Value 1', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (174, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (175, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (175, 'Value 1', '请重新登录', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (175, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (137, '表名', 'tbl_sharerecord', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (137, 'username', 'val({用户记录}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (137, 'goodsid', '{sharegoods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (137, 'goodsname', 'val({商品信息}).name', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (176, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (176, 'token', '{usertoken}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (176, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (177, '表名', 'tbl_sharerecord', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (177, 'username', 'val({用户信息}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (177, '结果', '订单', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (178, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (178, 'Value 1', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (178, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (180, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (180, 'Value 1', '{序号}+1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (180, 'Key 1', '序号', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (181, '表名', 'tbl_sharerecord', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (181, 'username', 'val({用户记录}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (181, 'goodsid', '{sharegoods}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (181, '结果', '查重', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (179, '表名', 'tbl_sharegoods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (179, 'id', '{订单}[{序号}].goodsid', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (179, '结果', '商品[{序号}]', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (183, '表名', 'tbl_token', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (183, 'token', '{usertoken}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (183, '结果', '用户信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (182, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (182, 'goods', '{goodsid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (182, 'name', 'val({用户信息}).username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (182, '结果', '结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (184, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (184, 'Value 1', '{结果}[0].id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (184, 'Key 1', 'record', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (185, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (185, '统计内容', 'sum(price),count(id)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (185, '区分内容', 'record', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (185, 'record', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (185, '结果', '统计', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (158, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (158, 'Value 1', '(val({商品信息}).price-val({商品信息}).lowestprice)/val({商品信息}).assistcount', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (158, 'Key 1', 'assistprice', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (186, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (186, '结果', '助力', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (187, '表名', 'tbl_assistance_record', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (187, 'id', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (187, '结果', '助力', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (188, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (188, 'id', 'val({助力}).goods', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (188, '结果', '商品信息', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (189, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (189, 'Value 1', '账号密码为空或重复', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (189, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (190, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (190, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (190, '结果', '重复查询', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (191, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (191, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (191, '结果', '重复查询', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (193, '流程ID', '8', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (193, '账号', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (193, '密码', '{密码}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (193, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (193, '错误信息', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (194, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (194, 'Value 1', 'OK', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (194, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (195, '流程ID', '8', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (195, '账号', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (195, '密码', '{密码}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (195, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (195, '错误信息', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (165, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (165, 'record', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (165, 'username', '{username}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (165, '结果', '用户助力记录', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (156, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (156, 'record', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (156, 'username', '{username}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (156, 'price', 'val({助力}).nowprice-val({商品信息}).lowestprice', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (156, 'time', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (159, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (159, 'record', '{record}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (159, 'username', '{username}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (159, 'price', '{assistprice}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (159, 'time', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (139, '表名', 'tbl_assistance_goods', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (139, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (139, '结果', 'data', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (168, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (168, 'Value 1', '成功砍价{assistprice}元！', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (168, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (167, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (167, 'Value 1', '成功砍价！', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (167, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (133, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (133, 'Value 1', 'jsapi_ticket={ticket}&{keyString}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (133, 'Key 1', 'keyString', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (145, '表名', 'tbl_assistance_assist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (145, '统计内容', 'sum(price),count(id)', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (145, '区分内容', 'record', 'groupColumn', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (145, 'record', '{assistid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (145, '结果', '统计', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (197, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (198, '表名', 'TBL_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (198, 'username', 'bu yinggai', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (198, 'password', 'bu yinggai', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (199, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (200, '表名', 'TBL_USER', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (200, 'username', 'gaishan', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (200, 'password', 'gaishan', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (201, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (202, '表名', 'spider_info', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (202, '排序', 'time desc', 'order', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (202, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (204, '表名', 'TBL_TOKEN', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (204, 'token', '{token}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (204, '结果', 'token记录', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (203, '表名', 'spider_info', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (203, '页数', '{page}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (203, '排序', 'time desc', 'order', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (203, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (205, '表名', 'spider_content', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (205, 'infoId', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (205, '结果', 'detail', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '流程ID', '13', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '订单号', '{订单号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '价格', '{价格}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '返回url', 'http://148.70.22.79/template/order.html', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '处理url', 'http://148.70.22.79/block-server/dynamic/14', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '订单标题', '订单{订单号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (79, '返回表单', '表单', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (209, '表名', 'spider_info', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (209, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (209, 'status', 'false', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (206, 'sql', 'select * from spider_info a where exists (select * from spider_content b where b.infoId =a.id) and  a.status is null and a.keywords !=""  order by time desc limit 300', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (206, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (210, '表名', 'tbl_baoming', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (210, 'telephone', '{手机号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (210, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (211, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (211, 'Value 1', '已重复', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (211, 'Key 1', '信息', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (212, '表名', 'tbl_baoming', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (212, 'name', '{名字}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (212, 'telephone', '{手机号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (213, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (213, 'Value 1', '正常', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (213, 'Key 1', '信息', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (215, 'appid', 'wx3d81ca1fd9661e2f', 'appid', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (215, 'appsecret', '18458231bc7bfe3f7d9d147c167635c3', 'appSecret', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (215, 'token', 'token', 'token', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (216, '流程ID', '36', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (216, 'appid', 'wxb0b2c1f4846e22c5', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (216, 'token', 'token', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (217, 'token', '{token}', 'accessToken', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (217, 'ticket', 'ticket', 'ticket', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (217, '结果', 'js结果', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (217, '申请时间', 'tickettime', 'time', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (217, '��效时间', 'ticketexpire', 'expire', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (218, '表名', 'tbl_shareinfo', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (218, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (218, '结果', 'detail', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (118, '表名', 'tbl_jsapi', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (118, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (118, '结果', 'ticket结果', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (222, '表名', 'tbl_urllist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (222, 'type', 'redirect', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (222, '结果', 'detail', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (223, '表名', 'tbl_urllist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (221, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (221, 'Value 1', 'val(Math.random())', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (221, 'Key 1', 'randomKey', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (229, 'sql', 'SELECT * FROM tbl_shareinfo  WHERE id > (SELECT floor(RAND() * (SELECT MAX(id) FROM tbl_shareinfo)))   ORDER BY id LIMIT 1', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (229, '结果', 'detail', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (231, '表名', 'tbl_urllist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (231, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (231, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (231, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (232, '表名', 'tbl_urllist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (232, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (233, '表名', 'tbl_urllist', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (233, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (233, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (233, 'resultid', 'resultId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (234, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (234, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (234, 'secret', '{secret}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (234, 'name', '{name}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (234, 'resultid', 'resultId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (235, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (235, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (235, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (235, 'secret', '{secret}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (235, 'name', '{name}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (236, '表名', 'tbl_secret', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (236, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, '表名', 'tbl_shareinfo', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'title', '{title}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'imgurl', '{imgurl}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'description', '{description}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'shareJump', '{shareJump}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'shareBack', '{shareBack}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'appid', '{appid}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'shareImg', '{shareImg}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (237, 'resultid', 'resultId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, '表名', 'tbl_shareinfo', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'title', '{title}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'imgurl', '{imgurl}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'description', '{description}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'shareJump', '{shareJump}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'shareBack', '{shareBack}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (238, 'shareImg', '{shareImg}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (239, '表名', 'tbl_shareinfo', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (239, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (240, '表名', 'tbl_advert', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (240, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (240, 'comment', '{comment}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (240, 'resultid', 'resultId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (241, '表名', 'tbl_advert', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (241, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (241, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (241, 'comment', '{comment}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (242, '表名', 'tbl_advert', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (242, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (245, '表名', 'tbl_setting', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (245, '结果', 'setting', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, '设置数量', '9', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 1', 'val({setting}).wechat_key', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 2', '{detail}[0].title', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 3', '{detail}[0].imgurl', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 4', '{detail}[0].description', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 5', '{detail}[0].shareJump', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 6', '{detail}[0].shareBack', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 7', '5', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 8', '{detail}[0].url', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Value 9', '{detail}[0].shareImg', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 1', 'appid', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 2', 'title', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 3', 'imgurl', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 4', 'description', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 5', 'shareJump', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 6', 'shareBack', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 7', 'needCount', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 8', 'url', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (219, 'Key 9', 'shareImg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (243, '表名', 'tbl_setting', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (243, 'id', '1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (248, '流程ID', '61', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (248, 'randomNum', 'randomNum', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (249, 'sql', 'SELECT url FROM tbl_advert  WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM tbl_advert)))   ORDER BY id LIMIT 1', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (249, '结果', 'detail', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (250, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (250, 'Value 1', '{detail}[0].url', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (250, 'Key 1', 'advert', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, '表名', 'tbl_setting', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'id', '1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'randomNum', '{random}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'wechat_key', '{key}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'shareCount', '{shareCount}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'shareFriendshipCount', '{shareFriendshipCount}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'shareFriendshipDescription', '{shareFriendshipDescription}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (244, 'shareDescription', '{shareDescription}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, '设置数量', '6', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 1', 'val({detail}).randomNum', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 2', 'val({detail}).wechat_key', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 3', 'val({detail}).shareCount', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 4', 'val({detail}).shareDescription', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 5', 'val({detail}).shareFriendshipCount', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Value 6', 'val({detail}).shareFriendshipDescription', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 1', 'randomNum', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 2', 'wechatKey', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 3', 'shareCount', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 4', 'shareDescription', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 5', 'shareFriendshipCount', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (247, 'Key 6', 'shareFriendshipDescription', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (225, 'sql', 'SELECT * FROM tbl_urllist  WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM tbl_urllist)))  and type!="redirect"  LIMIT 1', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (225, '结果', 'detail', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (224, 'sql', 'SELECT url FROM tbl_urllist  WHERE id >= (SELECT floor(RAND() * (SELECT MAX(id) FROM tbl_urllist where type="redirect")))  LIMIT 1', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (224, '结果', 'detail', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (252, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (252, 'Value 1', 'singlepic.html', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (252, 'Key 1', 'sub', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (253, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (253, 'Value 1', 'red.html', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (253, 'Key 1', 'sub', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, '设置数量', '3', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Value 1', '{detail}[0].type', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Value 2', '{detail}[0].url', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Value 3', '2', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Key 1', 'type', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Key 2', 'next', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (228, 'Key 3', 'shareId', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, '设置数量', '3', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Value 1', 'redirect', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Value 2', '{detail}[0].url', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Value 3', '2', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Key 1', 'type', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Key 2', 'next', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (227, 'Key 3', 'shareId', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (255, '表名', 'TBL_SHARE_RED_RECORD', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (255, 'ip', '{ip}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (255, 'time', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (255, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (255, 'url', '{url}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (254, '表名', 'TBL_ACCESS_RECORD', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (254, 'ip', '{ip}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (254, 'time', 'formatTime()', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (254, 'url', '{accessUrl}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (257, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (257, 'Value 1', 'video.html', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (257, 'Key 1', 'sub', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (258, '表名', 'tbl_video', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (258, 'id', '3', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (258, '结果', 'video', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (246, '表名', 'tbl_setting', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (246, 'id', '{pageId}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (246, '结果', 'detail', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (259, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (259, 'username', '{username}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (259, '结果', 'user', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (260, '表名', 'tbl_worth_news', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (260, '查询数量', '{PageSize}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (260, '页数', '{Page}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (260, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (109, '设置数量', '2', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (109, 'Value 1', 'OK', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (109, 'Value 2', 'username', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (109, 'Key 1', '结果', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (109, 'Key 2', '{token记录}[0].username', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, 'sql', 'select * from tbl_worth_news where date(time)=date(?)', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, '查询数量', '{PageSize}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, '页数', '{Page}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, '1', '{date}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (261, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, 'sql', 'select * from tbl_worth_news where date(time)=date(?) and isVip=0', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, '查询数量', '{PageSize}', 'limitRow', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, '页数', '{Page}', 'page', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, '1', '{date}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (262, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (263, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (263, 'Value 1', '1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (263, 'Key 1', 'isVip', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (196, '设置数量', '1', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (196, 'Value 1', '{msg}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (196, 'Key 1', 'msg', 'outMap', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (192, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (192, 'username', '{账号}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (192, 'password', '{密码}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (192, 'type', '0', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (192, 'resultid', 'userId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (264, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (264, 'id', '{userId}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (264, 'shareUser', '{分享用户}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (266, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (266, 'id', '{userId}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (266, 'shareUser', '{shareUsername}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (267, '流程ID', '66', 'processId', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (267, 'userId', '{userId}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (267, 'shareUsername', '{分享用户}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (268, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (268, 'username', '{shareUsername}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (268, '结果', 'user', 'object', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (269, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (269, '统计内容', 'count(*) as count', 'selectColumns', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (269, 'shareUser', '{shareUsername}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (269, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (270, '表名', 'tbl_user', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (270, 'id', 'val({user}).id', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (270, 'type', '1', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (208, 'sql', 'select * from spider_info a where (exists (select * from spider_content b where b.infoId =a.id and b.content regexp ?) or a.title regexp ?) and a.status is null order by time desc ', 'sql', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (208, '设置数量', '2', 'count', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (208, '1', '{reg}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (208, '2', '{reg}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (208, '结果', 'result', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, '表名', 'tbl_worth_news', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'pic', '{pic}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'title', '{title}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'time', '{time}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'content', '{content}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'isVip', '{isVip}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (293, 'resultid', 'resultId', 'result', 1);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, '表名', 'tbl_worth_news', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'pic', '{pic}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'title', '{title}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'time', '{time}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'content', '{content}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (294, 'isVip', '{isVip}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, '表名', 'tbl_worth_news', 'tableName', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'id', '{id}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'pic', '{pic}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'title', '{title}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'time', '{time}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'type', '{type}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'content', '{content}', 'map', 0);
INSERT INTO bricks.executeparam (execute, pluginMethodParam, param, fieldName, type) VALUES (295, 'isVip', '{isVip}', 'map', 0);
create table htmlparam
(
    id       int auto_increment
        primary key,
    width    int null,
    height   int null,
    top      int null,
    `left`   int null,
    `column` int null,
    row      int null,
    type     int null,
    template int null
);

INSERT INTO bricks.htmlparam (width, height, top, `left`, `column`, row, type, template) VALUES (1, 100, 20, 20, 10, 2, 1, null);
create table next
(
    id       int auto_increment
        primary key,
    block    int          null,
    value    int          null,
    position int          null,
    name     varchar(100) null
);

INSERT INTO bricks.next (block, value, position, name) VALUES (1, 3, null, '遭不住');
INSERT INTO bricks.next (block, value, position, name) VALUES (4, 5, 1, null);
INSERT INTO bricks.next (block, value, position, name) VALUES (6, 7, 1, null);
INSERT INTO bricks.next (block, value, position, name) VALUES (8, 10, 1, null);
INSERT INTO bricks.next (block, value, position, name) VALUES (11, 15, 1, '332321');
INSERT INTO bricks.next (block, value, position, name) VALUES (16, 12, null, '1111');
INSERT INTO bricks.next (block, value, position, name) VALUES (19, 20, null, '不存在用户');
INSERT INTO bricks.next (block, value, position, name) VALUES (19, 21, null, '存在用户');
INSERT INTO bricks.next (block, value, position, name) VALUES (20, 18, null, '错误结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (17, 19, null, '没事');
INSERT INTO bricks.next (block, value, position, name) VALUES (26, 25, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (27, 29, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (29, 28, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (30, 32, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (32, 31, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (21, 33, null, '有token记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (33, 18, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (34, 18, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (21, 34, null, '无token记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (35, 37, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (37, 38, null, '无有效凭证');
INSERT INTO bricks.next (block, value, position, name) VALUES (38, 36, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (37, 39, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (39, 72, 0, '查询货物信息');
INSERT INTO bricks.next (block, value, position, name) VALUES (41, 42, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (42, 42, null, '继续添加');
INSERT INTO bricks.next (block, value, position, name) VALUES (42, 43, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (43, 71, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (44, 48, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (48, 45, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (49, 51, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (51, 50, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (52, 54, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (54, 55, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (57, 55, null, '继续执行');
INSERT INTO bricks.next (block, value, position, name) VALUES (55, 57, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (57, 63, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (57, 56, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (60, 61, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (61, 59, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (58, 60, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (56, 53, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (63, 53, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (64, 67, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (67, 66, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (66, 70, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (69, 65, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (70, 68, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (68, 68, null, '继续处理');
INSERT INTO bricks.next (block, value, position, name) VALUES (68, 69, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (71, 36, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (72, 72, null, '继续处理');
INSERT INTO bricks.next (block, value, position, name) VALUES (72, 83, null, '处理结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (73, 75, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (75, 76, null, '无用户');
INSERT INTO bricks.next (block, value, position, name) VALUES (76, 74, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (75, 77, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (77, 78, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (78, 79, null, '有用户订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (79, 80, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (79, 81, null, '无订单商品');
INSERT INTO bricks.next (block, value, position, name) VALUES (81, 79, null, '存在更多订单内容');
INSERT INTO bricks.next (block, value, position, name) VALUES (80, 81, null, '单订单商品处理结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (81, 82, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (82, 74, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (78, 82, null, '无用户订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (83, 41, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (46, 84, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (84, 85, null, '错误');
INSERT INTO bricks.next (block, value, position, name) VALUES (85, 47, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (84, 86, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (86, 87, null, '交易完成');
INSERT INTO bricks.next (block, value, position, name) VALUES (87, 88, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (88, 47, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (86, 89, null, '其他');
INSERT INTO bricks.next (block, value, position, name) VALUES (89, 90, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (90, 47, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (91, 93, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (93, 94, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (94, 95, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (94, 92, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (95, 95, null, '继续处理');
INSERT INTO bricks.next (block, value, position, name) VALUES (95, 92, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (96, 98, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (98, 99, null, '无记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (98, 100, null, '有记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (100, 97, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (99, 97, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (101, 103, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (103, 102, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (113, 114, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (115, 117, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (117, 116, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (118, 120, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (120, 119, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (121, 128, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (129, 127, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (130, 132, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (134, 133, 0, '重新申请');
INSERT INTO bricks.next (block, value, position, name) VALUES (133, 135, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (135, 131, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (132, 136, null, '有效');
INSERT INTO bricks.next (block, value, position, name) VALUES (136, 131, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (125, 129, null, '重新申请');
INSERT INTO bricks.next (block, value, position, name) VALUES (123, 122, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (127, 122, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (137, 139, null, '设置');
INSERT INTO bricks.next (block, value, position, name) VALUES (139, 138, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (140, 142, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (142, 143, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (143, 144, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (144, 141, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (145, 147, null, '查询');
INSERT INTO bricks.next (block, value, position, name) VALUES (147, 146, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (148, 150, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (150, 149, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (151, 153, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (153, 154, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (154, 155, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (155, 152, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (156, 158, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (158, 159, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (159, 160, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (160, 157, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (161, 189, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (163, 162, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (132, 134, null, '过期');
INSERT INTO bricks.next (block, value, position, name) VALUES (132, 133, null, '无数据');
INSERT INTO bricks.next (block, value, position, name) VALUES (128, 129, null, '无数据');
INSERT INTO bricks.next (block, value, position, name) VALUES (128, 125, null, '过期');
INSERT INTO bricks.next (block, value, position, name) VALUES (128, 123, null, '有效');
INSERT INTO bricks.next (block, value, position, name) VALUES (167, 168, null, '达到次数');
INSERT INTO bricks.next (block, value, position, name) VALUES (168, 165, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (167, 169, null, '未到次数');
INSERT INTO bricks.next (block, value, position, name) VALUES (170, 163, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (169, 165, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (171, 169, null, '砍价');
INSERT INTO bricks.next (block, value, position, name) VALUES (167, 172, 0, '砍价完毕');
INSERT INTO bricks.next (block, value, position, name) VALUES (173, 175, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (175, 174, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (164, 191, 0, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (172, 165, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (167, 176, null, '用户已砍价');
INSERT INTO bricks.next (block, value, position, name) VALUES (176, 165, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (177, 180, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (180, 179, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (179, 181, null, '查询');
INSERT INTO bricks.next (block, value, position, name) VALUES (179, 178, null, '无订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (181, 181, null, '继续查询');
INSERT INTO bricks.next (block, value, position, name) VALUES (181, 178, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (140, 182, 0, '无用户');
INSERT INTO bricks.next (block, value, position, name) VALUES (142, 182, null, '无记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (182, 141, null, '返回');
INSERT INTO bricks.next (block, value, position, name) VALUES (183, 185, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (185, 186, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (186, 187, null, '有订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (186, 184, null, '无订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (187, 187, null, '继续');
INSERT INTO bricks.next (block, value, position, name) VALUES (187, 184, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (188, 141, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (189, 170, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (170, 190, 0, '重复订单');
INSERT INTO bricks.next (block, value, position, name) VALUES (190, 162, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (191, 171, null, '第一次砍价');
INSERT INTO bricks.next (block, value, position, name) VALUES (191, 167, null, '其他');
INSERT INTO bricks.next (block, value, position, name) VALUES (194, 196, null, '密码为空');
INSERT INTO bricks.next (block, value, position, name) VALUES (194, 195, null, '账号为空');
INSERT INTO bricks.next (block, value, position, name) VALUES (194, 197, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (196, 198, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (195, 198, 0, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (198, 193, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (197, 199, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (199, 193, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (192, 194, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (197, 200, null, '登录');
INSERT INTO bricks.next (block, value, position, name) VALUES (197, 200, null, '登录');
INSERT INTO bricks.next (block, value, position, name) VALUES (200, 193, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (142, 188, null, '已分享过');
INSERT INTO bricks.next (block, value, position, name) VALUES (201, 203, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (201, 205, null, '无参数');
INSERT INTO bricks.next (block, value, position, name) VALUES (203, 205, null, '无记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (203, 204, null, '有记录');
INSERT INTO bricks.next (block, value, position, name) VALUES (204, 202, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (205, 202, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (206, 208, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (208, 207, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (209, 211, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (211, 210, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (212, 214, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (214, 213, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (215, 217, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (217, 218, null, '重复');
INSERT INTO bricks.next (block, value, position, name) VALUES (218, 216, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (217, 219, null, '报名');
INSERT INTO bricks.next (block, value, position, name) VALUES (219, 216, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (224, 267, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (222, 226, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (226, 227, null, '随机值小于');
INSERT INTO bricks.next (block, value, position, name) VALUES (226, 228, null, '大于');
INSERT INTO bricks.next (block, value, position, name) VALUES (227, 266, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (220, 254, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (229, 224, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (231, 233, null, '编辑');
INSERT INTO bricks.next (block, value, position, name) VALUES (233, 232, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (231, 234, null, '删除局');
INSERT INTO bricks.next (block, value, position, name) VALUES (234, 232, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (231, 235, null, '增加');
INSERT INTO bricks.next (block, value, position, name) VALUES (235, 232, null, '结束');
INSERT INTO bricks.next (block, value, position, name) VALUES (236, 238, null, 'add');
INSERT INTO bricks.next (block, value, position, name) VALUES (236, 239, null, 'edit');
INSERT INTO bricks.next (block, value, position, name) VALUES (236, 240, null, 'del');
INSERT INTO bricks.next (block, value, position, name) VALUES (240, 237, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (239, 237, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (238, 237, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (241, 244, null, 'edit');
INSERT INTO bricks.next (block, value, position, name) VALUES (241, 243, null, 'add');
INSERT INTO bricks.next (block, value, position, name) VALUES (241, 245, null, 'del');
INSERT INTO bricks.next (block, value, position, name) VALUES (243, 242, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (244, 242, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (245, 242, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (246, 249, null, 'edit');
INSERT INTO bricks.next (block, value, position, name) VALUES (246, 248, null, 'add');
INSERT INTO bricks.next (block, value, position, name) VALUES (246, 250, null, 'del');
INSERT INTO bricks.next (block, value, position, name) VALUES (248, 247, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (249, 247, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (250, 247, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (251, 253, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (253, 252, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (254, 229, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (255, 257, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (257, 256, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (258, 260, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (260, 259, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (264, 223, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (265, 223, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (228, 266, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (266, 264, null, 'pageId=1');
INSERT INTO bricks.next (block, value, position, name) VALUES (266, 265, null, 'pageId=2');
INSERT INTO bricks.next (block, value, position, name) VALUES (267, 221, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (268, 270, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (270, 269, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (266, 271, null, 'pageId=3');
INSERT INTO bricks.next (block, value, position, name) VALUES (271, 223, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (272, 274, null, '用户');
INSERT INTO bricks.next (block, value, position, name) VALUES (274, 277, 0, '无信息');
INSERT INTO bricks.next (block, value, position, name) VALUES (274, 275, null, '正常');
INSERT INTO bricks.next (block, value, position, name) VALUES (275, 276, null, 'VIP');
INSERT INTO bricks.next (block, value, position, name) VALUES (275, 277, null, '普通');
INSERT INTO bricks.next (block, value, position, name) VALUES (276, 273, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (277, 273, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (272, 277, null, '游客');
INSERT INTO bricks.next (block, value, position, name) VALUES (199, 278, null, '来自分享');
INSERT INTO bricks.next (block, value, position, name) VALUES (278, 193, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (279, 281, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (281, 280, null, '已是VIP');
INSERT INTO bricks.next (block, value, position, name) VALUES (281, 282, null, '不是VIP');
INSERT INTO bricks.next (block, value, position, name) VALUES (282, 283, null, '到达5次');
INSERT INTO bricks.next (block, value, position, name) VALUES (282, 280, null, '不足次数');
INSERT INTO bricks.next (block, value, position, name) VALUES (283, 280, null, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (306, 309, 0, 'edit');
INSERT INTO bricks.next (block, value, position, name) VALUES (306, 308, 0, 'add');
INSERT INTO bricks.next (block, value, position, name) VALUES (306, 310, 0, 'del');
INSERT INTO bricks.next (block, value, position, name) VALUES (308, 307, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (309, 307, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (310, 307, 0, '1');
INSERT INTO bricks.next (block, value, position, name) VALUES (35, 40, null, '123');
create table nextrequirement
(
    id      int auto_increment
        primary key,
    next    int          null,
    param1  varchar(100) null,
    method  varchar(100) null,
    param2  varchar(100) null,
    pattern varchar(100) null
);

INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (3, '1', '>', '10', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (4, '1', '>', '10', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (5, '1', '>', '10', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (7, '1', '=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (8, '1', '=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (2, '1', '>', '9', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (10, 'count({resu})', '<', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (11, 'count({resu})', '>=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (13, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (14, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (16, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (17, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (19, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (20, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (21, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (23, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (25, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (26, 'count({token记录})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (22, 'count({token记录})', '>=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (27, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (28, 'count({tokenList})', '<', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (29, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (30, 'count({tokenList})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (31, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (35, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (39, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (40, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (41, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (42, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (43, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (44, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (50, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (53, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (54, '{序号}', '=', '{数量}', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (55, '{序号}', '=', 'count({result})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (52, '{序号}', '<', 'count({result})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (52, '{序号}', '<', '{数量}', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (57, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (58, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (60, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (61, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (62, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (63, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (64, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (65, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (67, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (68, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (69, '{序号}', '<', 'count({销量})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (70, '{序号}', '=', 'count({销量})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (71, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (72, '{序号}', '<', 'count({货物表})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (74, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (76, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (75, 'count({token记录})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (77, 'count({token记录})', '>=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (78, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (87, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (79, 'count({订单})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (88, 'count({订单})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (89, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (73, '{序号}', '=', 'count({货物表})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (86, '{序号}', '>=', 'count({订单})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (83, '{序号}', '<', 'count({订单})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (90, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (92, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (91, '{结果}', '=', 'ERROR', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (94, '{trade_status}', '=', 'TRADE_SUCCESS', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (95, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (96, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (98, '{trade_status}', 'not like', 'TRADE_SUCCESS', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (99, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (100, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (93, '{结果}', '=', 'OK', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (101, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (102, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (103, 'count({楼层data})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (104, 'count({楼层data})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (105, '{序号}', '<', 'count({楼层data})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (106, '{序号}', '>=', 'count({楼层data})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (107, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (108, 'count({token记录})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (109, 'count({token记录})', '>=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (110, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (111, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (112, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (113, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (82, 'count({订单商品}[{序号}])', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (80, 'count({订单商品}[{序号}].orderGoods)', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (84, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (114, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (37, 'count({货物表})', '>', '{序号}', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (38, '{序号}', '>=', 'count({货物表})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (115, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (116, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (117, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (118, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (119, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (127, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (129, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (134, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (135, '{结果}', '=', 'OK', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (136, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (140, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (145, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (150, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (151, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (152, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (153, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (156, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (157, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (158, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (159, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (160, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (161, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (162, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (163, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (164, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (165, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (166, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (167, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (168, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (169, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (170, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (171, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (139, '{token记录}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (139, '(getTime()-val({token记录}).applytime)', '<', 'val({token记录}).expiretime', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (175, '{token记录}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (175, '(getTime()-val({token记录}).applytime)', '>', 'val({token记录}).expiretime', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (176, '{token记录}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (177, '{ticket结果}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (182, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (183, '{统计}[0][''count(id)'']', '=', 'val({商品信息}).assistcount-1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (184, '{统计}[0][''count(id)'']', '=', 'val({商品信息}).assistcount-1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (186, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (187, '{统计}[0][''count(id)'']', '<', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (190, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (193, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (196, '{统计}[0][''count(id)'']', '=', 'val({商品信息}).assistcount', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (197, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (198, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (199, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (200, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (201, 'count({用户助力记录})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (202, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (204, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (205, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (207, 'count({订单})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (206, 'count({订单})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (208, '{序号}', '<', 'count({订单})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (209, 'count({订单})', '=', '{序号]', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (210, '{usertoken}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (212, '{用户记录}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (213, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (154, '{usertoken}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (214, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (215, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (216, 'count({订单})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (217, 'count({订单})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (218, '{序号}', '<', 'count({订单})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (219, '{序号}', '>=', 'count({订单})', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (221, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (155, 'count({查重})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (222, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (223, 'count({结果})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (224, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (189, 'count({结果})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (225, 'count({统计})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (226, 'count({统计})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (185, '{统计}[0][''count(id)'']', '=', 'val({商品信息}).assistcount-1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (185, 'count({用户助力记录})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (188, '{统计}[0][''count(id)'']', '<', 'val({商品信息}).assistcount-1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (188, 'count({用户助力记录})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (227, '{密码}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (228, '{账号}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (229, '{账号}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (229, '{密码}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (230, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (231, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (233, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (234, 'count({重复查询})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (236, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (237, 'count({})', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (238, 'count({重复查询})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (239, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (179, '{ticket结果}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (179, '(getTime()-val({ticket结果}).tickettime)', '<', 'val({ticket结果}).ticketexpire', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (178, '{ticket结果}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (178, '(getTime()-val({ticket结果}).tickettime)  ', '>', 'val({ticket结果}).ticketexpire', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (240, 'count({查重})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (241, '{token}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (242, '{token}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (243, '{token记录}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (244, '{token记录}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (245, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (246, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (247, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (248, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (249, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (250, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (251, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (252, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (253, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (254, 'count({result})', '>', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (255, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (256, 'count({result})', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (257, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (259, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (260, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (261, '{randomKey}', '<=', '0.8', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (265, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (266, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (267, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (268, '{oper}', '=', 'edit', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (269, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (270, '{oper}', '=', 'del', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (271, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (272, '{oper}', '=', 'add', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (273, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (274, '{oper}', '=', 'add', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (275, '{oper}', '=', 'edit', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (276, '{oper}', '=', 'del', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (277, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (278, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (279, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (280, '{oper}', '=', 'edit', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (281, '{oper}', '=', 'add', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (282, '{oper}', '=', 'del', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (283, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (284, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (285, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (286, '{oper}', '=', 'edit', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (287, '{oper}', '=', 'add', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (288, '{oper}', '=', 'del', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (289, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (290, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (291, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (292, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (293, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (294, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (295, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (296, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (262, '{randomKey}', '<=', '{randomNum}', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (263, '{randomKey}', '>', '{randomNum}', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (297, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (298, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (300, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (301, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (302, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (303, '{pageId}', '=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (304, '{pageId}', '=', '2', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (305, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (306, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (307, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (308, '{pageId}', '=', '3', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (309, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (311, '{user}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (312, '{user}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (313, 'val({user}).type', '=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (315, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (316, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (310, '{username}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (317, '{username}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (314, 'val({user}).type', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (235, '{分享用户}', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (318, '{分享用户}', '<>', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (319, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (320, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (321, 'val({user}).type', '=', '1', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (322, 'val({user}).type', '=', '0', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (323, '{result}[0].count', '>=', '5', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (324, '{result}[0].count', '<', '5', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (325, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (326, '{oper}', '=', 'edit', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (327, '{oper}', '=', 'add', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (328, '{oper}', '=', 'del', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (329, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (330, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (331, '', '=', '', null);
INSERT INTO bricks.nextrequirement (next, param1, method, param2, pattern) VALUES (332, '订单', '=', '10', null);
create table param
(
    id         int auto_increment
        primary key,
    paramValue varchar(100) null,
    belong     varchar(100) null
);

INSERT INTO bricks.param (paramValue, belong) VALUES ('{id}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('{id}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('{name}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('process', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('process', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('{startBlock}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('{name}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('{startBlock}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('0', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('0', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('jdbc:sqlite:D:mydatabase-test.db', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('process', '');
INSERT INTO bricks.param (paramValue, belong) VALUES ('{id}', 'request');
INSERT INTO bricks.param (paramValue, belong) VALUES ('block', null);
INSERT INTO bricks.param (paramValue, belong) VALUES ('{id}', 'request');
create table plugin
(
    id           int auto_increment
        primary key,
    type         int          null,
    language     int          null,
    name         varchar(100) null,
    introduction varchar(100) null,
    fileName     varchar(100) null,
    className    varchar(100) null,
    belongType   int          null
);

INSERT INTO bricks.plugin (type, language, name, introduction, fileName, className, belongType) VALUES (1, 1, '示例数据库操作', '', '/home/brick/plugins/exampleDatabaseController-1.0.jar', 'com.lin.database.MainClass', 1);
INSERT INTO bricks.plugin (type, language, name, introduction, fileName, className, belongType) VALUES (1, 1, '流程数据管理', '', '/home/brick/plugins/exampleProcessResult-1.0.jar', 'com.lin.process.MainClass', 1);
INSERT INTO bricks.plugin (type, language, name, introduction, fileName, className, belongType) VALUES (1, 1, '支付宝', '', '/home/brick/plugins/examplePayPlugin-1.0.jar', 'com.lin.process.AlipayClass', 1);
INSERT INTO bricks.plugin (type, language, name, introduction, fileName, className, belongType) VALUES (1, 1, '流程插件', null, null, 'com.lin.plugin.ProcessPlugin', 1);
INSERT INTO bricks.plugin (type, language, name, introduction, fileName, className, belongType) VALUES (1, 1, '微信功能', '', '/home/brick/plugins/exampleWeixinPlugin-1.0.jar', 'com.lin.wechat.WechatClass', 1);
create table pluginmethod
(
    id           int auto_increment
        primary key,
    plugin       int          null,
    name         varchar(100) null,
    methodName   varchar(100) null,
    introduction varchar(100) null,
    type         int          null,
    returnType   int          null
);

INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '查询数据', 'select', '', 1, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '保存数据', 'save', '', 0, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '更新数据', 'update', '', 0, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '删除数据', 'delete', '', 0, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (2, '更新数据', 'setResult', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (2, 'MD5', 'md5', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (3, '支付宝支付内容', 'newPayOrder', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '统计数据', 'stats', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (4, '调用流程', 'executeProcess', null, 1, 1);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '唯一查询', 'selectOne', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (3, '验证支付宝通知', 'checkAlipayNotify', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (2, '设置数据', 'setResult2', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (5, '微信jsapi', 'getJsAPI', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (5, '处理微信支付通知', 'wechatPayRecall', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (5, '微信token', 'getAccessToken', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (2, 'SHA1', 'sha1', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (5, '微信网页授权', 'getWebpageContent', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (6, '读取数据', 'loadLocalFile', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '微信token', 'getAccessToken', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '微信jsapi', 'getJsAPI', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '微信网页授权', 'getWebpageContent', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '处理微信支付通知', 'wechatPayRecall', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '本地小程序码', 'generateWappQrcodeLocal', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '模糊查询', 'selectLike', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (1, '直接SQL', 'directSql', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '检查微信支付通知', 'wechatPayRecallCheck', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (7, '微信H5支付', 'wechatH5Pay', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (3, '支付宝转账', 'transfer', '', null, 0);
INSERT INTO bricks.pluginmethod (plugin, name, methodName, introduction, type, returnType) VALUES (3, '支付宝手机支付', 'newWapPayOrder', '', null, 0);
create table pluginmethodparam
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    type        int          null,
    position    int          null,
    method      int          null,
    displayName varchar(100) null
);

INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('table', 1, 1, 1, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('id', 2, 2, 1, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('table', 1, 1, 2, '表名');
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('name', 1, 2, 2, '流程名');
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('startBlock', 2, 3, 2, '开始模块');
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('response', 2, 4, 2, '回复');
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('table', 1, 1, 3, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('name', 1, 2, 3, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('startBlock', 1, 3, 3, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('response', 1, 4, 3, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('id', 1, 5, 3, null);
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('table', 1, 1, 4, '表名');
INSERT INTO bricks.pluginmethodparam (name, type, position, method, displayName) VALUES ('id', 1, 2, 4, '主键');
create table process
(
    id         int auto_increment
        primary key,
    name       varchar(100) null,
    startBlock int          null,
    endBlock   int          null,
    intro      varchar(100) null,
    dataSource int          null
);

INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('单点登录', 17, 18, '登录流程', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取商品分类', 24, 25, '获取商品分类', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取版头', 27, 28, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取商品', 30, 31, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('创建订单', 35, 36, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取付款二维码', 44, 45, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('支付宝支付通知流程', 46, 47, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取版头数据', 49, 50, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('首页新商品数据', 52, 53, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('推荐商品包', 58, 59, '推荐商品包', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('按销量排序商品', 64, 65, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取订单信息', 73, 74, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取专题数据', 91, 92, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('检查登录状态', 96, 97, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('主题推荐', 101, 102, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('1111', 111, 112, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('555', 113, 114, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('分享即送商品', 115, 116, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('分享即送商品详情', 118, 119, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('微信jsapi', 121, 122, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('微信token', 130, 131, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('微信页面初始化内容', 137, 138, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('保存分享记录', 140, 141, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('助力砍价商品', 145, 146, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('助力砍价商品详情', 148, 149, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('助力砍价记录', 151, 152, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('朋友助力记录', 156, 157, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('创建助力申请', 161, 162, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('进行砍价', 164, 165, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('换取网页openid', 173, 174, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('助力订单记录', 177, 178, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('分享订单记录', 183, 184, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('注册', 192, 193, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('爬虫数据', 201, 202, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('线报内容', 206, 207, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('爬虫数据-正则筛选', 209, 210, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('设置无效', 212, 213, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('报名', 215, 216, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('红包信息', 220, 221, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('跳转信息', 222, 223, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('编辑urllist', 231, 232, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('编辑微信key', 236, 237, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('编辑分享内容', 241, 242, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('编辑广告', 246, 247, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('基础设置', 251, 252, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('获取基础设置', 255, 256, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('广告链接', 258, 259, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('保存分享设定', 261, 262, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('分享记录', 268, 269, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('价值信息数据', 272, 273, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('分享升级用户', 279, 280, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES (null, 284, 285, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES (null, 286, 287, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES (null, 288, 289, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES (null, 295, 296, null, null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('NUll', 304, 305, '', null);
INSERT INTO bricks.process (name, startBlock, endBlock, intro, dataSource) VALUES ('编辑价值信息', 306, 307, '', null);
create table processargument
(
    id        int auto_increment
        primary key,
    name      varchar(100) null,
    type      int          null,
    process   int          null,
    necessary int          null,
    complex   int          null,
    mutitype  int          null
);

INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('ahahaha', 1, 2, 0, null, null);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('账号', 0, 8, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('密码', 0, 8, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('token', 1, 8, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('list', 1, 9, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('list', 1, 10, 0, 0, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('goods', 1, 11, 0, 0, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('货物表', 0, 12, 0, 1, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('用户token', 0, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('序号', 1, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单号', 0, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('价格', 0, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('返回url', 0, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('处理url', 0, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单标题', 0, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('返回表单', 1, 13, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('content', 1, 15, 0, 1, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('goods', 1, 16, 0, 1, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('数量', 0, 16, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('种类', 0, 16, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 17, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('totalCount', 1, 16, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('页数', 0, 16, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('数量', 0, 18, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('result', 1, 18, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('种类', 0, 18, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultCount', 1, 18, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('排序', 0, 16, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('goodsId', 0, 11, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('表单', 1, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('错误信息', 1, 8, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('用户token', 0, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('页数', 0, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('错误信息', 1, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('数量', 0, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单商品', 1, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单', 1, 19, 0, 0, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('序号', 1, 19, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('名称', 0, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('电话', 0, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('地址', 0, 12, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('notify_time', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('notify_type', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('notify_id', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('charset', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('sign_type', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('sign', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('auth_app_id', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('trade_no', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('app_id', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('out_trade_no', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('out_biz_no', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('buyer_id', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('seller_id', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('trade_status', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('total_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('receipt_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('invoice_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('invoice_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('buyer_pay_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('point_amount', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('refund_fee', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('subject', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('body', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('gmt_create', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('gmt_payment', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('gmt_refund', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('gmt_close', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('fund_bill_list', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('voucher_detail_list', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('passback_params', 0, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 14, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('版头图片', 1, 20, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('专题编号', 0, 20, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('背景图', 1, 20, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('楼层内容', 1, 20, 0, 1, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('用户token', 0, 21, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 21, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 22, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('321', 0, 32, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('123', 1, 32, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 33, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 34, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('data', 1, 34, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 35, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 36, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('token', 1, 36, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('ticket', 1, 35, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 37, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('sign', 1, 37, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('usertoken', 0, 38, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('sharegoods', 0, 38, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('结果', 1, 39, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 40, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('data', 1, 40, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('goods', 0, 41, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('usertoken', 0, 41, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('assistid', 0, 42, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('助力', 1, 42, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('统计', 1, 42, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('商品信息', 1, 42, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('usertoken', 0, 43, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('goodsid', 0, 43, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('record', 1, 43, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('record', 0, 44, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 44, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('code', 0, 45, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 45, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('openid', 1, 45, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('msg', 1, 44, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('usertoken', 0, 46, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单', 1, 46, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('商品', 1, 46, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('msg', 1, 38, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('usertoken', 0, 47, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('订单', 1, 47, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('商品', 1, 47, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('账号', 0, 48, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('密码', 0, 48, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('msg', 1, 48, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('token', 1, 48, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('username', 0, 44, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('ticket结果', 1, 35, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('keyString', 0, 37, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('result', 1, 49, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('token', 0, 49, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('page', 0, 49, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 50, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('detail', 1, 50, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('reg', 0, 51, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('result', 1, 51, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 52, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('手机号', 0, 53, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('名字', 0, 53, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('信息', 1, 53, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('title', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('imgurl', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('description', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareJump', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareBack', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('next', 1, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('type', 1, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('needCount', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareId', 1, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('url', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('sub', 1, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareImg', 1, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('url', 0, 56, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('type', 0, 56, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 56, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('oper', 0, 56, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultId', 1, 56, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('appid', 0, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('secret', 0, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('oper', 0, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('name', 0, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultId', 1, 57, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('oper', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('title', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('imgurl', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('description', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareJump', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareBack', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('url', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareImg', 0, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultId', 1, 58, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('oper', 0, 59, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('url', 0, 59, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('comment', 0, 59, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 59, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultId', 1, 59, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('random', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('key', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('randomNum', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('wechatKey', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('advert', 1, 62, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareCount', 0, 63, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipCount', 0, 63, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareDescription', 0, 63, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipCount', 0, 63, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareCount', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareDescription', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipCount', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipDescription', 0, 60, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareCount', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareDescription', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipCount', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareFriendshipDescription', 1, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('pageId', 0, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('type', 0, 64, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('url', 0, 64, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('accessUrl', 0, 54, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('video', 1, 55, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('pageId', 0, 61, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('username', 0, 65, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('result', 1, 65, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('username', 1, 21, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('date', 0, 65, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('isVip', 1, 65, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('分享用户', 0, 48, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('userId', 0, 66, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('shareUsername', 0, 66, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('oper', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('id', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('resultId', 1, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('pic', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('title', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('time', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('type', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('content', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('isVip', 0, 72, 0, 0, 0);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('货物表', 0, 12, 0, 1, 1);
INSERT INTO bricks.processargument (name, type, process, necessary, complex, mutitype) VALUES ('1234表单', 1, 12, 0, 0, 0);
create table processargumentcomplex
(
    id       int auto_increment
        primary key,
    argument int          not null,
    name     varchar(100) null
);

INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (8, '商品id	');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (8, '商品数量');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (18, 'img');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (18, 'url');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (19, 'id');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (19, 'url');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (19, 'name');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (19, 'price');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (19, 'offpercent');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (84, '楼层图');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (84, '楼层数据');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (84, '宽度');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (264, '商品id');
INSERT INTO bricks.processargumentcomplex (argument, name) VALUES (264, '商品数量');
create table sequencerecord
(
    id        int auto_increment
        primary key,
    name      varchar(200) not null,
    seqNum    int          not null,
    time      float        not null,
    processId int          null,
    blockId   int          null,
    executeId int          null,
    remark    text         null
);


create table tbl_access_record
(
    id   int auto_increment
        primary key,
    ip   varchar(100) null,
    time varchar(100) null,
    url  varchar(200) null
);

INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-07 23:03:19', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-07 23:03:32', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:18:20', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:18:23', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:22:45', 'http://share1.pinhuomao.xyz/red/share.html?shareType=redirect');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:23:11', 'http://share1.pinhuomao.xyz/red/share.html?shareType=redirect');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:24:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=redirect');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:24:48', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:25:03', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:25:10', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:25:10', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:25:49', 'http://localhost/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:26:31', 'http://localhost/red/share.html?shareType=share');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:26:42', 'http://localhost/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:26:47', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:27:43', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 07:27:48', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:29:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:30:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:30:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:30:36', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:30:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:32:11', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:32:28', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:32:50', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:33:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:33:33', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:33:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:34:14', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:34:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:34:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:35:00', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:35:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:35:11', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:35:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:35:22', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:35:22', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:35:33', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:35:34', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:36:32', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:08', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:09', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:37:14', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:14', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:24', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:25', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:37:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:38:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:38:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:38:15', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:38:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:39:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:39:35', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:39:36', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:39:59', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:40:09', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:40:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:40:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:40:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:40:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:40:28', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:40:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 07:40:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:40:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:40:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:40:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 07:41:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 07:41:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:19', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:19', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:27', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:27', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.33.6', '2019-08-08 07:56:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 12:25:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 12:25:15', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 12:25:15', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 12:25:16', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 14:59:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 14:59:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 14:59:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 14:59:46', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 14:59:46', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 15:08:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:08:42', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:08:42', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:09:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:09:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:09:42', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:09:42', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:10:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.240.229.2', '2019-08-08 15:11:36', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:15:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:15:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.17.115.194', '2019-08-08 15:16:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.17.115.194', '2019-08-08 15:16:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('117.136.79.159', '2019-08-08 15:16:46', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('117.136.79.159', '2019-08-08 15:16:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 15:25:17', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('114.91.159.71', '2019-08-08 15:25:44', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:28:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:28:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:28:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:28:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:29:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:30:08', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:30:08', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 15:36:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 15:36:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 15:36:44', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:36:52', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 15:36:54', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:44:18', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:44:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:44:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:45:28', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 15:45:28', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 15:57:11', 'http://localhost/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('117.136.79.105', '2019-08-08 15:57:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('61.151.178.175', '2019-08-08 16:00:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.231.48', '2019-08-08 16:00:32', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 16:01:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.231.48', '2019-08-08 16:07:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 16:07:49', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 16:07:49', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:10:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:11:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:11:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:11:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:12:05', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:12:11', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:12:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:12:48', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:12:52', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:13:15', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 16:13:44', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 16:16:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.231.48', '2019-08-08 16:17:58', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.110', '2019-08-08 16:20:09', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.110', '2019-08-08 16:20:09', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 16:21:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 16:21:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 16:26:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 16:26:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 16:28:20', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 16:28:20', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.109.205.82', '2019-08-08 16:28:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.109.205.82', '2019-08-08 16:28:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 16:33:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 16:33:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 16:33:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:35:52', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:35:52', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:36:15', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:36:28', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:52:31', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 16:54:54', 'http://localhost/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 17:01:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 17:02:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 17:02:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 17:02:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 17:02:44', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:13:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:13:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:13:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:13:55', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.29.217', '2019-08-08 17:14:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.29.217', '2019-08-08 17:14:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:18:44', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:19:36', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:19:36', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 17:41:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 17:41:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:44:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:44:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 17:45:44', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 17:46:26', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 17:46:32', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 17:46:32', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:53:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:54:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.63.135', '2019-08-08 17:54:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.64.169', '2019-08-08 17:55:53', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.64.169', '2019-08-08 17:57:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.64.169', '2019-08-08 17:57:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 17:58:11', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 17:58:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 18:03:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.148.125', '2019-08-08 18:03:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.64.169', '2019-08-08 18:37:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.104.64.169', '2019-08-08 18:37:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:15:04', 'http://localhost/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:19:51', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:19:51', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:20:25', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:20:27', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:20:27', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-08 19:20:50', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 19:21:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 22:58:21', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 22:59:33', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 22:59:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:01:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:01:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:01:12', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:01:14', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:03:02', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:03:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:03:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 23:03:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:03:26', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:03:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 23:06:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:06:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:06:57', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:06:59', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:09:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:09:53', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:10:04', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:10:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.246', '2019-08-08 23:10:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:11:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:11:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('59.42.73.221', '2019-08-08 23:11:46', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 23:12:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 23:12:23', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-08 23:12:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.201.112', '2019-08-08 23:12:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:12:46', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.201.112', '2019-08-08 23:12:59', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.201.112', '2019-08-08 23:13:55', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.201.112', '2019-08-08 23:14:22', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:18:28', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:18:43', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:18:49', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:19:08', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:20:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:22:31', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:22:43', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:22:56', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:22:56', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('121.33.59.1', '2019-08-08 23:23:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:36:16', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:36:16', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:36:28', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:36:32', 'http://localhost/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:36:38', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 02:36:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 02:36:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 02:36:48', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:38:39', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:38:40', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:38:40', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:06', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:06', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:11', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:17', 'http://localhost/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:17', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:39:22', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 02:41:15', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 02:41:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 02:41:22', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 02:41:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:41:56', 'http://localhost/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:43:29', 'http://localhost/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:43:29', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:43:53', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:43:53', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:44:12', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 02:44:12', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:10:34', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:10:34', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:13:11', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:13:11', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:17:36', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:17:36', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:17:50', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:17:50', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:18:17', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:18:17', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:19:07', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:19:07', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:19:32', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:19:36', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:25:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:25:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:27:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:27:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:28:31', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:28:32', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:29:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:29:35', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:29:53', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:29:53', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:30:51', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:32:14', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:32:14', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:33:48', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:33:48', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:38:10', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:38:10', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:38:41', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:38:57', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:39:57', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:39:57', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:40:02', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:40:07', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:40:28', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:40:28', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:57:25', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:57:46', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:57:47', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:58:08', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:58:08', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:58:55', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 03:58:56', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 04:07:48', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 04:07:48', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 04:17:36', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 04:17:36', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('127.0.0.1', '2019-08-11 04:20:00', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:26:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 04:28:00', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:30:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:30:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:33:08', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:33:08', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:33:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:33:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:34:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:34:19', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 04:35:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:35:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 04:36:05', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.73.120.116', '2019-08-11 07:02:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.73.120.116', '2019-08-11 07:02:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.154.103', '2019-08-11 12:05:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.154.103', '2019-08-11 12:05:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 13:54:00', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 13:54:03', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 13:54:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 13:56:56', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 13:57:05', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 16:14:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 16:14:58', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.85.208.162', '2019-08-11 16:39:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.85.208.162', '2019-08-11 16:39:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.200.89', '2019-08-11 18:21:21', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.200.89', '2019-08-11 18:21:21', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.200.89', '2019-08-11 18:23:04', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('43.250.200.89', '2019-08-11 18:23:04', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 18:23:49', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 18:23:50', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 18:24:08', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 18:33:31', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.232.175.96', '2019-08-11 18:39:45', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.232.175.96', '2019-08-11 18:39:45', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.232.175.96', '2019-08-11 18:42:54', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.236.203.215', '2019-08-11 18:43:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('120.236.203.215', '2019-08-11 18:43:37', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.123', '2019-08-11 18:44:59', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 18:44:59', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 18:45:18', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.111.108.107', '2019-08-11 21:39:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 21:41:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-11 21:41:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 21:41:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.25.98', '2019-08-11 21:41:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-13 05:48:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-13 05:48:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.109', '2019-08-13 05:48:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.193', '2019-08-13 08:53:34', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.193', '2019-08-13 08:53:34', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-13 08:54:05', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.193', '2019-08-13 08:54:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.109', '2019-08-13 08:54:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-13 08:54:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.193', '2019-08-14 09:33:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.193', '2019-08-14 09:33:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.82.2', '2019-08-14 09:33:56', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.220.26', '2019-08-14 09:34:13', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.220.26', '2019-08-14 09:34:13', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.220.26', '2019-08-14 09:35:10', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.109', '2019-08-14 10:05:55', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-15 12:25:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:25:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:25:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-15 12:25:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:25:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:25:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:26:14', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 12:26:14', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-15 12:26:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-15 12:32:33', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-15 12:32:33', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-15 12:33:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-15 12:33:06', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-15 13:35:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-15 13:35:45', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-15 13:38:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-15 13:38:44', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.24.130.242', '2019-08-15 13:40:52', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.24.130.242', '2019-08-15 13:41:34', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.24.130.242', '2019-08-15 13:41:34', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-15 13:45:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-15 13:47:45', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:18:18', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:18:18', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.115.68', '2019-08-15 14:20:11', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:20:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:20:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:21:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:27:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:27:27', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:28:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:28:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:28:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('218.19.221.246', '2019-08-15 14:30:42', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 04:31:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:34', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:49', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:52', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:54', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:31:57', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:32:55', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:33:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 04:33:01', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 04:33:08', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 04:33:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 04:33:13', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 06:40:53', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 06:40:53', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 06:40:55', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:02:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:02:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:03:05', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:19:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:19:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:19:33', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:19:33', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:19:43', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:20:15', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:20:54', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:20:54', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:21:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:21:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:21:29', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:22:07', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:22:11', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:22:32', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:22:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:22:51', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:23:02', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:23:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:23:23', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:24:11', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:24:25', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:24:38', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:24:39', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:25:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:25:04', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:25:24', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:25:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:25:40', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:25:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:25:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:25:46', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:26:07', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:26:07', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:26:38', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:27:13', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:30:11', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:33:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.28.168.113', '2019-08-16 08:33:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 08:34:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:34:16', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 08:34:18', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 08:45:25', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.62.37', '2019-08-16 09:47:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.62.37', '2019-08-16 09:47:12', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.62.37', '2019-08-16 17:32:30', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.146', '2019-08-16 21:07:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 21:07:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 21:07:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.16.145', '2019-08-16 21:07:26', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('116.21.62.37', '2019-08-16 21:13:21', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.221', '2019-08-16 21:46:53', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.109', '2019-08-17 07:32:50', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.237', '2019-08-17 07:32:50', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.182.186', '2019-08-17 08:28:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.198.69', '2019-08-17 10:17:45', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.198.69', '2019-08-17 10:17:55', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.198.69', '2019-08-17 10:37:19', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.198.69', '2019-08-17 10:56:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.198.69', '2019-08-17 10:56:43', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:34:16', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:41:05', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:42:10', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:42:36', 'http://share1.pinzhongxiang.xyz/red/prize-new.html#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:45:57', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:46:23', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:47:25', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:47:37', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:48:21', 'http://share1.pinzhongxiang.xyz/red/prize-new.html#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:48:35', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('112.96.67.44', '2019-08-17 11:48:35', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.27.48.250', '2019-08-17 11:52:43', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('14.27.48.250', '2019-08-17 11:53:13', null);
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.73.119.121', '2019-08-17 12:30:56', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.73.119.121', '2019-08-17 12:30:56', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('223.73.119.121', '2019-08-17 12:31:11', 'http://share1.pinzhongxiang.xyz/red/prize-new.html');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('119.130.240.109', '2019-08-17 23:09:15', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.183.237', '2019-08-19 23:27:00', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('113.67.182.186', '2019-08-20 08:48:26', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('61.151.178.236', '2019-09-24 10:15:17', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('183.39.130.245', '2020-02-23 07:33:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&from=timeline#');
INSERT INTO bricks.tbl_access_record (ip, time, url) VALUES ('183.39.130.245', '2020-02-23 07:33:47', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&from=timeline');
create table tbl_advert
(
    id      int auto_increment
        primary key,
    url     varchar(100) null,
    comment varchar(100) null
);

INSERT INTO bricks.tbl_advert (url, comment) VALUES ('http://www.baidu.com', '123');
create table tbl_assistance_assist
(
    id       int auto_increment
        primary key,
    record   varchar(100) null,
    username varchar(100) null,
    price    varchar(100) null,
    time     varchar(100) null
);

INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('15', null, '10.0', '2019-03-11 02:24:06');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('16', null, '63.333333333333336', '2019-03-11 03:42:14');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('15', 'aaa', '10.0', '2019-03-11 03:46:34');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('19', 'lin', '10.0', '2019-03-11 05:12:51');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('19', '5555', '10.0', '2019-03-11 05:16:02');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('16', '123', '63.333333333333336', '2019-03-11 11:09:21');
INSERT INTO bricks.tbl_assistance_assist (record, username, price, time) VALUES ('20', '啊aa', '10.0', '2019-03-15 18:17:42');
create table tbl_assistance_goods
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    price       varchar(100) null,
    description varchar(100) null,
    stock       varchar(100) null,
    picurl      varchar(100) null,
    detailpics  varchar(100) null,
    lowestprice varchar(100) null,
    assistcount varchar(200) null
);

INSERT INTO bricks.tbl_assistance_goods (name, price, description, stock, picurl, detailpics, lowestprice, assistcount) VALUES ('荣耀7 测试商品', '100', '没有描述', '10', 'images/new/honor7_1.jpg,images/new/honor7_2.jpg,images/new/honor7_3.jpg,images/new/honor7_4.jpg', 'images/new/honor7_1.jpg,images/new/honor7_2.jpg,images/new/honor7_3.jpg,images/new/honor7_4.jpg', '0', '10');
INSERT INTO bricks.tbl_assistance_goods (name, price, description, stock, picurl, detailpics, lowestprice, assistcount) VALUES ('咖啡机 测试商品', '2000', '没有描述', '10', 'images/new/coffee1.jpg,images/new/coffee2.jpg', '', '100', '30');
create table tbl_assistance_record
(
    id       int auto_increment
        primary key,
    goods    varchar(100) null,
    name     varchar(100) null,
    time     varchar(100) null,
    nowprice varchar(200) null
);

INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('1', '123', '2019-03-11 03:46:34', 'NaN');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('2', '123', '2019-03-11 11:09:21', '-26.66666666666667');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('1', 'val(null).username', null, '100');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('2', 'val(null).username', null, '100');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('1', 'lin', '2019-03-11 05:16:02', '80.0');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('1', '啊aa', '2019-03-15 18:17:42', '90.0');
INSERT INTO bricks.tbl_assistance_record (goods, name, time, nowprice) VALUES ('1', 'yangdajiang93', null, '100');
create table tbl_banner
(
    id      int auto_increment
        primary key,
    picurl  varchar(100) null,
    urlpath varchar(100) null
);

INSERT INTO bricks.tbl_banner (picurl, urlpath) VALUES ('http://localhost/template/images/4.jpg', 'http://localhost/template/vegetables.html');
INSERT INTO bricks.tbl_banner (picurl, urlpath) VALUES (null, 'http://localhost/management/datamanager.html#');
INSERT INTO bricks.tbl_banner (picurl, urlpath) VALUES (null, 'http://localhost/management/datamanager.html#');
INSERT INTO bricks.tbl_banner (picurl, urlpath) VALUES (null, 'http://localhost/management/datamanager.html#');
INSERT INTO bricks.tbl_banner (picurl, urlpath) VALUES ('http://148.70.22.79:8888/group1/M00/00/00/rBsADFwuCIiAbSPxAACMX91EzGA908.png', 'http://localhost/management/datamanager.html#');
create table tbl_baoming
(
    id        int auto_increment
        primary key,
    name      varchar(100) null,
    telephone varchar(200) null
);

INSERT INTO bricks.tbl_baoming (name, telephone) VALUES ('lion', '1.8676347565E10');
create table tbl_category
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    status      varchar(100) null,
    parentId    varchar(100) null,
    createdDate varchar(100) null,
    createdUser varchar(100) null,
    updatedDate varchar(100) null,
    updatedUser varchar(100) null
);

INSERT INTO bricks.tbl_category (name, status, parentId, createdDate, createdUser, updatedDate, updatedUser) VALUES ('测试分类A', '可用', '', '', '', '', '');
INSERT INTO bricks.tbl_category (name, status, parentId, createdDate, createdUser, updatedDate, updatedUser) VALUES ('测试分类B', '可用', '', '', '', '', '');
INSERT INTO bricks.tbl_category (name, status, parentId, createdDate, createdUser, updatedDate, updatedUser) VALUES ('测试分类C', '可用', '', '', '', '', '');
INSERT INTO bricks.tbl_category (name, status, parentId, createdDate, createdUser, updatedDate, updatedUser) VALUES ('测试分类D', '可用', '测试分类A', '', '', '', '');
INSERT INTO bricks.tbl_category (name, status, parentId, createdDate, createdUser, updatedDate, updatedUser) VALUES ('测试分类E', '可用', '测试分类A', '', '', '', '');
create table tbl_goods
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    description varchar(100) null,
    introduce   varchar(100) null,
    price       varchar(100) null,
    catId       varchar(100) null,
    shopId      varchar(100) null,
    stock       varchar(100) null,
    status      varchar(100) null,
    createTime  varchar(100) null,
    picUrl      varchar(100) null,
    salesAmount varchar(100) null,
    originPrice varchar(100) null
);

INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('测试商品1', '测试用1', '测试用1', '10.00', 'men', '主店铺', '100', '可用', '2018-11-05', 'images/pi4.jpg', '0', '20.00');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('测试商品2', '测试用2', null, '5.00', 'collection', null, null, null, null, 'images/13.png,images/pi5.jpg,images/pi6.jpg,images/pi4.jpg', '5', '10');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/pi6.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('meijiu', 'meijiudesc', null, '50.00', 'women', null, null, null, null, 'images/pi5.jpg', null, '150');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('meijiu', 'meijiudesc', null, '50.00', 'men', null, null, null, null, 'images/pi5.jpg', null, '150');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('meijiu', 'meijiudesc', null, '50.00', 'men', null, null, null, null, 'images/pi5.jpg', null, '150');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/pi6.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/pi6.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/pi6.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/po3.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', null, '10.00', 'collection', '', null, null, null, 'images/po2.jpg', null, '15');
INSERT INTO bricks.tbl_goods (name, description, introduce, price, catId, shopId, stock, status, createTime, picUrl, salesAmount, originPrice) VALUES ('test', 'tst', '', '10.00', 'collection', '', null, null, null, 'images/po1.jpg', null, '15');
create table tbl_jsapi
(
    id           int auto_increment
        primary key,
    appid        varchar(100) null,
    ticket       varchar(100) null,
    tickettime   varchar(100) null,
    ticketexpire varchar(100) null
);

INSERT INTO bricks.tbl_jsapi (appid, ticket, tickettime, ticketexpire) VALUES ('wx3d81ca1fd9661e2f', 'LIKLckvwlJT9cWIhEQTwfPEtcy4iKbOR4fk08R3Ud9mYTaocLgdHrt3zR0Na3uaF2qa0ZuzaUlNRZ707c6JMaA', '1560811105323', '7200000');
INSERT INTO bricks.tbl_jsapi (appid, ticket, tickettime, ticketexpire) VALUES ('wx4400678f45d863ee', 'sM4AOVdWfPE4DxkXGEs8VBFC5Nx5EiuXf5LnHhsVZeBCRHEBV-H1-Uxzz-pvsYKEN8YVg32ljdm3Wx2q_P6x8A', '1562301136894', '7200000');
INSERT INTO bricks.tbl_jsapi (appid, ticket, tickettime, ticketexpire) VALUES ('wxb0b2c1f4846e22c5', 'LIKLckvwlJT9cWIhEQTwfHP6akrACJnK0UFJQ0V-fjR1PYoFjXb31_lQ8dpg6fSy1mVdxh1JnH5fSy_k19rOqA', '1565998519925', '7200000');
INSERT INTO bricks.tbl_jsapi (appid, ticket, tickettime, ticketexpire) VALUES ('wx5bcd6f3c74ee5887', null, null, '*1000');
create table tbl_order
(
    id         int auto_increment
        primary key,
    orderNo    varchar(100) null,
    userId     varchar(100) null,
    shopId     varchar(100) null,
    orderAmt   varchar(100) null,
    status     varchar(100) null,
    remark     varchar(100) null,
    createTime varchar(100) null,
    receiver   varchar(100) null,
    phone      varchar(100) null,
    address    varchar(100) null
);

INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11546192877933', '1', null, '40.0', '未支付', null, '2018-12-31 02:01:18', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11546196645296', '1', null, '200.0', '未支付', null, '2018-12-31 03:04:05', '123', '321', '123');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11546202957263', '1', null, '200.0', '未支付', null, '2018-12-31 04:49:17', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11546203281487', '1', null, '45.0', '已支付', null, '2018-12-31 04:54:41', '321', '321', '321');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11547669572992', '1', null, '270.0', '未支付', null, '2019-01-17 04:12:53', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11547669986448', '1', null, '270.0', '未支付', null, '2019-01-17 04:19:46', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11547670047688', '1', null, '610.0', '未支付', null, '2019-01-17 04:20:47', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11547670136187', '1', null, '610.0', '未支付', null, '2019-01-17 04:22:16', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('11547682215614', '1', null, '790.0', '未支付', null, '2019-01-17 07:43:35', '1', '2', '3');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('81552644514329', '8', null, '40.0', '未支付', null, '2019-03-15 18:08:34', '123', '321', '12346');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('81552644663785', '8', null, '30.0', '未支付', null, '2019-03-15 18:11:03', '11', '22', '2333');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('141558793234368', '14', null, '100', '未支付', null, '2019-05-25 22:07:14', '123', '321', '123');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('141558793731424', '14', null, '100', '已支付', null, '2019-05-25 22:15:31', '123', '321', '5555');
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('21573630403223', '2', null, '30', '未支付', null, '2019-11-13 15:33:23', null, null, null);
INSERT INTO bricks.tbl_order (orderNo, userId, shopId, orderAmt, status, remark, createTime, receiver, phone, address) VALUES ('21573630427453', '2', null, '300', '未支付', null, '2019-11-13 15:33:47', null, null, null);
create table tbl_order_goods
(
    id       int auto_increment
        primary key,
    goodsId  varchar(100) null,
    orderId  varchar(100) null,
    quantity varchar(100) null,
    price    varchar(100) null,
    snapshot varchar(100) null
);

INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11546163783030', '4', '200.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546163783030', '4', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11546164725616', '4', '200.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546164725616', '4', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546174680378', '3', '15.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11546174680378', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11546174680378', '2', '100.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '11546174680378', '3', '30.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11546175377853', '2', '100.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11546175472325', '1', '50.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11546175472325', '1', '50.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11546175472325', '2', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546177086128', '3', '15.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('21', '11546177086128', '1', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('22', '11546177086128', '1', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('24', '11546177086128', '1', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('23', '11546177086128', '1', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '11546192877933', '3', '30.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546192877933', '2', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11546196645296', '4', '200.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11546202957263', '4', '200.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '11546203281487', '3', '15.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '11546203281487', '3', '30.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11547669572992', '2', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11547669572992', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11547669572992', '2', '100.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11547669986448', '2', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11547669986448', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11547669986448', '2', '100.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11547670047688', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11547670047688', '5', '250.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11547670047688', '6', '60.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11547670047688', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11547670136187', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11547670136187', '5', '250.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11547670136187', '6', '60.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11547670136187', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('16', '11547682215614', '8', '400.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '11547682215614', '3', '150.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('9', '11547682215614', '4', '40.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '11547682215614', '4', '200.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '81552644514329', '2', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '81552644514329', '3', '30.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '81552644663785', '2', '20.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '81552644663785', '2', '10.0', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '141558793234368', '2', '100', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '141558793731424', '1', '50', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '141558793731424', '1', '50', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('10', '21573630403223', '2', '10', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('15', '21573630403223', '2', '20', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('17', '21573630427453', '3', '150', null);
INSERT INTO bricks.tbl_order_goods (goodsId, orderId, quantity, price, snapshot) VALUES ('18', '21573630427453', '3', '150', null);
create table tbl_order_goods_attr
(
    id             int auto_increment
        primary key,
    orderGoodsId   varchar(100) null,
    attrName       varchar(100) null,
    attrDetailName varchar(100) null
);


create table tbl_order_operation
(
    id           int auto_increment
        primary key,
    orderId      varchar(100) null,
    userId       varchar(100) null,
    operation    varchar(100) null,
    beforeStatus varchar(100) null,
    createTime   varchar(100) null
);


create table tbl_order_pay
(
    id       int auto_increment
        primary key,
    orderId  varchar(100) null,
    payType  varchar(100) null,
    payAmt   varchar(100) null,
    payOrder varchar(100) null
);


create table tbl_pay_type
(
    id   int auto_increment
        primary key,
    name varchar(100) null
);


create table tbl_secret
(
    id      int auto_increment
        primary key,
    appid   varchar(100) null,
    secret  varchar(100) null,
    name    varchar(255) null,
    `using` varchar(200) null
);

INSERT INTO bricks.tbl_secret (appid, secret, name, `using`) VALUES ('wxb0b2c1f4846e22c5', '0755fc78e819a4fd18d1472e90e037f4', null, null);
INSERT INTO bricks.tbl_secret (appid, secret, name, `using`) VALUES ('wx3d81ca1fd9661e2f', '18458231bc7bfe3f7d9d147c167635c3', '众享', null);
INSERT INTO bricks.tbl_secret (appid, secret, name, `using`) VALUES ('wx4400678f45d863ee', '60772fcf9e3af18b36719271fc159216', '愚蠢的喵楼', null);
INSERT INTO bricks.tbl_secret (appid, secret, name, `using`) VALUES ('wx5bcd6f3c74ee5887', 'bdf3ccd6c913c6044744bc95e9b7db74', '今日优读', null);
INSERT INTO bricks.tbl_secret (appid, secret, name, `using`) VALUES ('wxb05adbef26cd2920', '9b74e0367d39ad3b71b754b9573ad680', '月亮妈妈亲子课', null);
create table tbl_setting
(
    id                         int auto_increment
        primary key,
    randomNum                  varchar(100)  null,
    wechat_key                 varchar(100)  null,
    shareCount                 varchar(200)  null,
    shareFriendshipCount       varchar(200)  null,
    shareFriendshipDescription varchar(1000) null,
    shareDescription           varchar(1000) null
);

INSERT INTO bricks.tbl_setting (randomNum, wechat_key, shareCount, shareFriendshipCount, shareFriendshipDescription, shareDescription) VALUES ('0.5', 'wx5bcd6f3c74ee5887', '1', '1', '再分享一次到你的朋友圈！马上领取！,', '分享一次给你的好友，就可以领取礼品！,');
INSERT INTO bricks.tbl_setting (randomNum, wechat_key, shareCount, shareFriendshipCount, shareFriendshipDescription, shareDescription) VALUES ('0.5', 'wx5bcd6f3c74ee5887', '1', '1', '再分享一次到你的朋友圈！马上领取！,', '分享一次给你的好友，就可以领取礼品！,');
INSERT INTO bricks.tbl_setting (randomNum, wechat_key, shareCount, shareFriendshipCount, shareFriendshipDescription, shareDescription) VALUES ('0.5', 'wx5bcd6f3c74ee5887', '1', '1', '再分享一次到你的朋友圈！继续观看！,', '分享一次给你的好友，就可以继续观看！,');
create table tbl_share_red_record
(
    id   int auto_increment
        primary key,
    ip   varchar(100) null,
    time varchar(100) null,
    type varchar(200) null,
    url  varchar(200) null
);

INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-08 07:26:55', 'friend', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-08 07:27:48', 'friendships', 'http://localhost/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:32:19', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:32:27', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:35:05', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:35:10', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:35:28', 'friend', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:35:33', 'friendships', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:36:37', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:37:08', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:37:18', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:37:24', 'friendships', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:38:10', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:38:15', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1&from=singlemessage');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:39:31', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:39:35', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:40:05', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 07:40:09', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 07:41:19', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:41:32', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 07:41:43', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=1#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 15:09:49', 'friend', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 22:58:36', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 22:58:55', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 22:59:32', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:01:07', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:01:12', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:02:58', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:03:02', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:03:22', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:03:26', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:06:53', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.25.246', '2019-08-08 23:06:57', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:09:31', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:09:59', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:10:01', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:10:03', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:11:41', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('59.42.73.221', '2019-08-08 23:11:46', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 23:12:19', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.123', '2019-08-08 23:12:23', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('43.250.201.112', '2019-08-08 23:14:09', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('43.250.201.112', '2019-08-08 23:14:21', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:18:34', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:18:43', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:18:55', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:19:08', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:20:09', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:20:22', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:22:37', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:22:42', 'friendships', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:23:02', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:23:06', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:23:34', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('121.33.59.1', '2019-08-08 23:23:40', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=2');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 03:58:04', 'friend', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 03:58:12', 'friendships', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 03:59:03', 'friend', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 03:59:05', 'friendships', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 04:17:44', 'friend', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 04:17:47', 'friendships', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 04:20:33', 'friend', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('127.0.0.1', '2019-08-11 04:20:36', 'friendships', 'http://localhost/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 04:36:01', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('223.73.120.116', '2019-08-11 07:03:28', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('223.73.120.116', '2019-08-11 07:03:49', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 13:54:15', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 13:54:20', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 13:57:10', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 13:57:14', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 16:15:03', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 16:15:06', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('120.85.208.162', '2019-08-11 16:39:47', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('43.250.200.89', '2019-08-11 18:23:39', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('43.250.200.89', '2019-08-11 18:23:48', 'friendships', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 18:23:59', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-11 18:24:04', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('119.130.240.109', '2019-08-13 05:48:31', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('119.130.240.109', '2019-08-13 05:48:35', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.193', '2019-08-13 08:53:43', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.193', '2019-08-13 08:53:47', 'friendships', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('119.130.240.109', '2019-08-13 08:54:24', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('119.130.240.109', '2019-08-14 09:33:37', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.82.2', '2019-08-14 09:34:07', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.82.2', '2019-08-14 09:34:17', 'friendships', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-15 12:32:46', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-15 12:32:50', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('218.19.221.246', '2019-08-15 14:27:41', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('218.19.221.246', '2019-08-15 14:28:13', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-16 08:02:58', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3#');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.16.145', '2019-08-16 08:03:11', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('14.28.168.113', '2019-08-16 08:19:28', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.16.145', '2019-08-16 08:24:22', 'friend', 'http://share1.pinhuomao.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('119.130.240.221', '2019-08-16 08:25:12', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('113.67.183.146', '2019-08-16 08:25:33', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('14.28.168.113', '2019-08-16 08:26:28', 'friend', 'http://share1.zhongxiangpin.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('14.28.168.113', '2019-08-16 08:34:00', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('14.28.168.113', '2019-08-16 08:34:06', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.62.37', '2019-08-16 09:47:49', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.62.37', '2019-08-16 09:48:00', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.62.37', '2019-08-16 17:32:42', 'friend', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
INSERT INTO bricks.tbl_share_red_record (ip, time, type, url) VALUES ('116.21.62.37', '2019-08-16 17:32:56', 'friendships', 'http://share1.pinzhongxiang.xyz/red/share.html?shareType=share&pageId=3');
create table tbl_sharegoods
(
    id          int auto_increment
        primary key,
    name        varchar(100) null,
    description varchar(100) null,
    price       varchar(100) null,
    stock       varchar(100) null,
    status      varchar(100) null,
    picurl      varchar(100) null,
    salesamount varchar(100) null,
    starttime   varchar(100) null,
    endtime     varchar(100) null,
    detailpics  varchar(100) null
);

INSERT INTO bricks.tbl_sharegoods (name, description, price, stock, status, picurl, salesamount, starttime, endtime, detailpics) VALUES ('荣耀7 测试商品', '没有描述', '10', '100', '', 'images/new/honor7.jpg', '', '2017-01-01 00:00:00', '2019-12-31 00:00:00', 'images/new/honor7_1.jpg,images/new/honor7_2.jpg,images/new/honor7_3.jpg,images/new/honor7_4.jpg');
INSERT INTO bricks.tbl_sharegoods (name, description, price, stock, status, picurl, salesamount, starttime, endtime, detailpics) VALUES ('mate20 测试商品', '	没有描述', '0.1', '10', '', 'images/new/mate20.jpg', '', '2017-01-01 00:00:00', '2019-12-31 00:00:00', null);
INSERT INTO bricks.tbl_sharegoods (name, description, price, stock, status, picurl, salesamount, starttime, endtime, detailpics) VALUES ('matebook 测试商品', 'matebook', '10', '1000', '', 'images/new/matebook.jpg', '', '2017-01-01 00:00:00', '2019-12-31 00:00:00', null);
INSERT INTO bricks.tbl_sharegoods (name, description, price, stock, status, picurl, salesamount, starttime, endtime, detailpics) VALUES ('matebookpro 测试商品', 'matebookpro', '10', '10', '', 'images/new/matebookpro.jpg', '', '2017-01-01 00:00:00', '2019-12-31 00:00:00', null);
create table tbl_shareinfo
(
    id          int auto_increment
        primary key,
    title       varchar(100) null,
    imgurl      varchar(100) null,
    description varchar(100) null,
    shareJump   varchar(300) null,
    shareBack   varchar(300) null,
    appid       varchar(200) null,
    url         varchar(200) null,
    shareImg    varchar(200) null
);

INSERT INTO bricks.tbl_shareinfo (title, imgurl, description, shareJump, shareBack, appid, url, shareImg) VALUES ('回馈用户活动', 'http://share1.pinzhongxiang.xyz/red/images/red_packet_result_bg.png', '回馈用户，免费赠礼', 'prize.html', 'http://share2.pinhuomao.xyz/red/share.html?shareType=advert', null, 'http://share1.pinhuomao.xyz/red/tempRedirect.html?shareType=redirect', 'images/red_packet_result_bg.png');
INSERT INTO bricks.tbl_shareinfo (title, imgurl, description, shareJump, shareBack, appid, url, shareImg) VALUES ('回馈用户活动', 'http://share1.pinzhongxiang.xyz/red/images/red_packet_result_bg.png', '回馈用户，免费赠礼', 'prize.html', 'http://share2.pinhuomao.xyz/red/share.html?shareType=advert', null, 'http://share1.pinhuomao.xyz/red/tempRedirect.html?shareType=redirect', 'images/red_packet_result_bg.png');
create table tbl_sharerecord
(
    id        int auto_increment
        primary key,
    username  varchar(100) null,
    userid    varchar(100) null,
    goodsid   varchar(100) null,
    goodsname varchar(100) null
);

INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('123', null, '1', '荣耀7');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('123', null, '2', 'mate20');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('123', null, '3', 'matebook');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('bbb', null, '1', '荣耀7');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('lin', null, '1', '荣耀7');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('lin', null, '1', '荣耀7');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('lin', null, '2', 'mate20');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('lin', null, '2', 'mate20');
INSERT INTO bricks.tbl_sharerecord (username, userid, goodsid, goodsname) VALUES ('啊aa', null, '1', '荣耀7 测试商品');
create table tbl_shop
(
    id            int auto_increment
        primary key,
    shopId        varchar(100) null,
    userId        varchar(100) null,
    name          varchar(100) null,
    email         varchar(100) null,
    phone         varchar(100) null,
    serviceQq     varchar(100) null,
    servicePhone  varchar(100) null,
    type          varchar(100) null,
    majorBusiness varchar(100) null,
    createTime    varchar(100) null,
    applyDate     varchar(100) null,
    auditStatus   varchar(100) null
);


create table tbl_shop_bank_info
(
    id       int auto_increment
        primary key,
    shopId   varchar(100) null,
    bankType varchar(100) null,
    bankCode varchar(100) null,
    bankName varchar(100) null
);


create table tbl_shop_check
(
    id           int auto_increment
        primary key,
    shopId       varchar(100) null,
    adminId      varchar(100) null,
    operation    varchar(100) null,
    beforeStatus varchar(100) null,
    createTime   varchar(100) null,
    remark       varchar(100) null
);


create table tbl_shop_deliver
(
    id         int auto_increment
        primary key,
    shopId     varchar(100) null,
    deliverId  varchar(100) null,
    deliverFee varchar(100) null
);


create table tbl_shop_info
(
    id                 int auto_increment
        primary key,
    shopId             varchar(100) null,
    creditType         varchar(100) null,
    creditNumber       varchar(100) null,
    enterpriseName     varchar(100) null,
    enterpriseProvince varchar(100) null,
    enterpriseCity     varchar(100) null,
    enterpriseDistrict varchar(100) null,
    enterpriseAddress  varchar(100) null,
    enterpriseUser     varchar(100) null,
    enterpriseAreaCode varchar(100) null,
    enterprisePhone    varchar(100) null,
    enterpriseLicense  varchar(100) null
);


create table tbl_shop_settle
(
    id            int auto_increment
        primary key,
    shopId        varchar(100) null,
    settleMonth   varchar(100) null,
    saleAmt       varchar(100) null,
    commissionAmt varchar(100) null,
    settleAmt     varchar(100) null,
    settleStatus  varchar(100) null,
    settleDate    varchar(100) null,
    startDate     varchar(100) null,
    endDate       varchar(100) null,
    adminUserId   varchar(100) null
);


create table tbl_token
(
    id       int auto_increment
        primary key,
    username varchar(100) null,
    token    varchar(100) null
);

INSERT INTO bricks.tbl_token (username, token) VALUES ('123', '202cb962ac59075b964b07152d234b70');
INSERT INTO bricks.tbl_token (username, token) VALUES ('linhao', '0c7e6863fb8768c7404e42da320b7391');
INSERT INTO bricks.tbl_token (username, token) VALUES ('aaa', '47bce5c74f589f4867dbd57e9ca9f808');
INSERT INTO bricks.tbl_token (username, token) VALUES ('lin', 'c93169f1eb9be7246f990690b5e66b2d');
INSERT INTO bricks.tbl_token (username, token) VALUES ('bbb', '08f8e0260c64418510cefb2b06eee5cd');
INSERT INTO bricks.tbl_token (username, token) VALUES ('333', '310dcbbf4cce62f762a2aaa148d556bd');
INSERT INTO bricks.tbl_token (username, token) VALUES ('444', '550a141f12de6341fba65b0ad0433500');
INSERT INTO bricks.tbl_token (username, token) VALUES ('555', '15de21c670ae7c3f6f3f1f37029303c9');
INSERT INTO bricks.tbl_token (username, token) VALUES ('啊aa', '36ba468e8316fe292682037a3fb0b804');
INSERT INTO bricks.tbl_token (username, token) VALUES ('yangdajiang96', '07819b33c77255e547ea0685a90f0e2c');
INSERT INTO bricks.tbl_token (username, token) VALUES ('zen', '7e9aedd97b5ec4590edb8281ff12b168');
INSERT INTO bricks.tbl_token (username, token) VALUES ('yangdajiang92', 'a72e3b3659ef0f1cb069b562825ac586');
INSERT INTO bricks.tbl_token (username, token) VALUES ('yangdajiang93', '0c654dccad95e093e2e7f413f5e1cf9a');
INSERT INTO bricks.tbl_token (username, token) VALUES ('yangdajiang91', 'b1618de3262d048135d0d91380fe8a7f');
INSERT INTO bricks.tbl_token (username, token) VALUES ('yangdajiang94', 'ce1d8da6c4b1759cfea633537734abbd');
INSERT INTO bricks.tbl_token (username, token) VALUES ('linhao1', '4a588a883bf0b9087ead7e5b743d7447');
INSERT INTO bricks.tbl_token (username, token) VALUES ('linhao2', '89c558d20d3127d953460b8a36ad6144');
create table tbl_topic
(
    id   int auto_increment
        primary key,
    name varchar(100) null,
    主图片  varchar(100) null,
    背景图  varchar(100) null
);

INSERT INTO bricks.tbl_topic (name, 主图片, 背景图) VALUES ('没有', 'images/vip2.jpg', 'images/testback.png');
INSERT INTO bricks.tbl_topic (name, 主图片, 背景图) VALUES ('jd', 'images/jd1.jpg', 'images/jd2.png');
create table tbl_topic_content
(
    id       int auto_increment
        primary key,
    picUrl   varchar(100) null,
    url      varchar(100) null,
    position varchar(100) null,
    width    varchar(100) null,
    topic    varchar(100) null
);

INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/vip1.png', 'single.html?id=9', '1', '100', '1');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/vip3.png', 'single.html?id=9', '2', '33', '1');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/vip4.png', 'single.html?id=9', '3', '33', '1');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/vip5.png', 'single.html?id=9', '4', '33', '1');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb3.png', 'single.html?id=10', '1', '100', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb4.png', 'single.html?id=17', '2', '50', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb5.png', 'single.html?id=19', '3', '50', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb6.png', 'single.html?id=9', '4', '16', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb7.png', 'single.html?id=9', '5', '16', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb8.png', 'single.html?id=9', '6', '16', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb9.png', 'single.html?id=9', '7', '16', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb10.png', 'single.html?id=9', '8', '16', '3');
INSERT INTO bricks.tbl_topic_content (picUrl, url, position, width, topic) VALUES ('images/tb11.png', 'single.html?id=9', '9', '16', '3');
create table tbl_urllist
(
    id   int auto_increment
        primary key,
    url  varchar(100) null,
    type varchar(100) null
);

INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share3.pinhuomao.xyz/red/tempRedirect.html', 'redirect');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share2.pinhuomao.xyz/red/tempRedirect.html', 'redirect');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share1.pinhuomao.xyz/red/share.html', 'share');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share1.pinzhongxiang.xyz/red/share.html', 'share');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share2.pinzhongxiang.xyz/red/tempRedirect.html', 'redirect');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share3.pinzhongxiang.xyz/red/tempRedirect.html', 'redirect');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share1.zhongxiangpin.xyz/red/share.html', 'share');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share2.zhongxiangpin.xyz/red/tempRedirect.html', 'redirect');
INSERT INTO bricks.tbl_urllist (url, type) VALUES ('http://share3.zhongxiangpin.xyz/red/tempRedirect.html', 'redirect');
create table tbl_user
(
    id        int auto_increment
        primary key,
    username  varchar(100) null,
    password  varchar(100) null,
    email     varchar(100) null,
    mobile    varchar(100) null,
    type      varchar(100) null,
    shareUser varchar(200) null
);

INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('123', 'wwwaaaa', '', '', '1', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('linhao', '1q2w3e4r', null, null, '0', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('aaa', 'aaa', null, null, null, null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('tim', '1q2w3e4r', null, null, null, null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('zen', '1q2w3e4r', null, null, null, null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('datauser', 'welcome1234', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('yangdajiang96', 'ydj96', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('yangdajiang93', 'ydj93', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('yangdajiang92', 'ydj92', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('yangdajiang91', 'ydj91', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('yangdajiang94', 'ydj94', '', '', '', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('linhao1', '123123', null, null, '0', null);
INSERT INTO bricks.tbl_user (username, password, email, mobile, type, shareUser) VALUES ('linhao2', '123', null, null, '0', 'linhao1');
create table tbl_video
(
    id        int auto_increment
        primary key,
    name      varchar(100) null,
    url       varchar(100) null,
    shareTime varchar(100) null
);

INSERT INTO bricks.tbl_video (name, url, shareTime) VALUES ('来自缤纷世界', 'iro.mp4', '300');
INSERT INTO bricks.tbl_video (name, url, shareTime) VALUES ('利兹与青鸟', 'liz.mp4', '300');
INSERT INTO bricks.tbl_video (name, url, shareTime) VALUES ('hk', 'video/hk.mp4', '20');
INSERT INTO bricks.tbl_video (name, url, shareTime) VALUES ('homo', 'video/homo.mp4', '20');
create table tbl_wechattoken
(
    id         int auto_increment
        primary key,
    appid      varchar(100) null,
    token      varchar(200) null,
    applytime  varchar(100) null,
    expiretime varchar(100) null
);

INSERT INTO bricks.tbl_wechattoken (appid, token, applytime, expiretime) VALUES ('wx3d81ca1fd9661e2f', '22_qXia-MRMEFW24CAeZlOoggwkzbjjNxsG5JpPMfTROVlYqLoZwFeXFK3MnGmUqqcCPfUYcwbccGrbZkLOsuXkgRZCBBmvk7W2pAyPjUort5ysWw6pYSmPShSjD18jcCGqUHr-hTXia3cTp21rWOAeAAAPHT', '1560811105017', '7200000');
INSERT INTO bricks.tbl_wechattoken (appid, token, applytime, expiretime) VALUES ('wx4400678f45d863ee', '23_0AyL5u-tqLVy4K799oTDi2ehXXo0T3uBkeVfmknETh8JoLX8wb_zyRecIT3RCqmNb6HPIGiU_UC49VqFx-hYe-V02lOK__Ij8jfC539afas8985vQCPfjTCEr18KGBbAEAWSN', '1562301136618', '7200000');
INSERT INTO bricks.tbl_wechattoken (appid, token, applytime, expiretime) VALUES ('wxb0b2c1f4846e22c5', '24_48k8j-9peo70wMFZ4NZ03Zq89Sw0vWxJqbn0jX4xi2IBhkgNfriOijVSHg9pOzAOQp-URMJ4VqD0iB2znUU5Ee_BjAmTrRw-GIuhy_skjEKIr1wEPZtcNT5PXH3d-Mkc7exL1qSYSLXYGJsWKFDfACACXV', '1565998519674', '7200000');
create table tbl_worth_news
(
    id      int auto_increment
        primary key,
    pic     varchar(200) null,
    title   varchar(100) null,
    time    timestamp    null,
    type    varchar(100) null,
    content varchar(100) null,
    isVip   int(10)      null
);

INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245/template/images/13.png', '测试福利1', '2019-10-07 23:23:23', '福利信息', 'http://106.52.110.245/normal/single.html?id=159299', 0);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245/template/images/13.png', '测试福利2', '2019-10-07 23:23:23', '福利信息', 'http://106.52.110.245/normal/single.html?id=159330', 0);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245/template/images/13.png', '测试福利3', '2019-10-07 23:23:23', '福利信息', 'http://106.52.110.245/normal/single.html?id=159266', 0);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245/template/images/13.png', '测试福利4', '2019-10-07 23:23:23', '福利信息', 'http://106.52.110.245/normal/single.html?id=151477', 0);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245/template/images/13.png', '测试福利5', '2019-10-06 23:23:23', '福利信息', 'http://106.52.110.245/normal/single.html?id=121363', 0);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245:8888/group1/M00/06/21/rBEAAl2gqy6AcT7mAACQ1KIFNUY91.jpeg', '测试221', '2018-08-08 14:14:14', '福利', 'http://106.52.110.245/normal/single.html?id=159299', 1);
INSERT INTO bricks.tbl_worth_news (pic, title, time, type, content, isVip) VALUES ('http://106.52.110.245:8888/group1/M00/06/21/rBEAAl2gq_6ActT8AACQ1KIFNUY55.jpeg', '测试221', '2018-08-08 14:14:14', '福利', 'http://106.52.110.245/normal/single.html?id=159299', 1);