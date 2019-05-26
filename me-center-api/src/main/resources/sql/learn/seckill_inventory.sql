--秒杀库存表
create table  if not exists `seckill_inventory` (
  `pid` integer not null auto_increment comment '自增id',
	`productId` integer not null comment'商品id',
	`productName` varchar (6000) not null default '默认名称'comment'商品名称',
	`productNumber` integer not null comment'商品剩余数量',
	`price` double(6,2) not null comment '商品价格',
	`secStartTime` datetime not null default current_timestamp comment'秒杀开始时间',
	`secEndTime` datetime not null default current_timestamp comment'秒杀结束时间',
	`createTime` datetime not null default current_timestamp comment'创建时间',
	`modifyTime` datetime not null default current_timestamp comment'更新时间',
	primary key (`pid`),
	key index_productid (`productId`),
	key index_starttime (`secStartTime`),
	key index_endtime (`secEndTime`),
	key index_createtime (`createTime`)
)ENGINE=InnoDB AUTO_INCREMENT=1000 default charset=utf8 comment '秒杀库存表';

-- 插入库存数据
insert into seckill_inventory (productId,productName,productNumber,price,secStartTime,secEndTime)
values (1000,'2000抢华为mate20',100,2000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
(1001,'1000抢 华为mate10',200,1000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
(1002,'3000抢 iphoneXR',300,3000.00,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
(1003,'1699抢 ipad Pro',400,1699.98,'2019-02-01 11:30:00','2019-02-02 23:59:59'),
(1004,'200抢 iwatch2',300,200.99,'2019-02-01 11:30:00','2019-02-02 23:59:59');

INSERT INTO dev.userInfo (userId,username,PASSWORD)VALUES(1,"jack","12345678");