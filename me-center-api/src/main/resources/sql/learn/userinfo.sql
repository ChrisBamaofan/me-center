/**
建测试表
 */
create table if not exists  `userinfo` (
  `pid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '自增id',
	`userId` integer,
	`username` varchar (200),
	`password` varchar (200),
	primary key (`pid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户数据表';
/**
插入测试数据
 */
INSERT INTO dev.userInfo (userId,username,PASSWORD)VALUES(1,"jack","12345678");

 CREATE TABLE `testchar` (
  `varcharStr` varchar(5) DEFAULT NULL,
  `charStr4` char(4) default null,
  `charStr8` char(8) default null,
  `charStrX` char default null
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into testchar (varcharStr, charStr4, charStr8,charStrX)VALUES('我是中国人','我是','我是中','pingshi wp manzuoaiduoe '),
('我是中国人','我是中国','我是中国人，你呢？'),
('我是中国人','我是中国','我是中国人，你呢？'),