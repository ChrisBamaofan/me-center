/**
 秒杀成功表
 */
 drop table `seckill_success`;

 CREATE TABLE `seckill_success`(
 `pid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '自增id',
 `productId` INTEGER NOT NULL COMMENT '商品id',
 `phoneNumber` VARCHAR(15) NOT NULL COMMENT '手机号码',
 `status` INTEGER NOT NULL COMMENT '状态标识 -1：无效；0：秒杀成功待付款；1：已付款；2：已配送；3：已签收；4：拒签',
 `createTime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
	PRIMARY KEY (productId,phoneNumber),
	 KEY (pid)

 )ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '秒杀成功记录表';

INSERT INTO seckill_success (productId, phoneNumber, STATUS)VALUES (1001,'15026969417',0),(1002,'13162708803',0);