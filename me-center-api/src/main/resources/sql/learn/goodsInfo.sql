--商品表
CREATE TABLE `goodsInfo` (
`pid` INTEGER NOT NULL AUTO_INCREMENT COMMENT '自增id',
`productName` VARCHAR(20) NOT NULL COMMENT '商品名称',
`goodsType` VARCHAR(10) NOT NULL COMMENT '商品类型',
`price` DECIMAL(6,2) NOT NULL COMMENT '商品价格',
`sourceId` INTEGER NOT NULL COMMENT '商品源id',
`address` VARCHAR(30) NOT NULL COMMENT '产地',
`passedQualified` BOOLEAN NOT NULL COMMENT '通过检验',
`pop` INTEGER NOT NULL COMMENT '热度',
PRIMARY KEY (`pid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '商品表';

insert into `goodsinfo` (productName,goodsType,price,sourceId,address,passedQualified,pop) values
('加多宝','解暑饮料',4.20,10010,'上海金山区春虹路100号102室上海金山区春虹路100号',true,80),
('冰淇淋','解暑冷饮',2.50,10011,'上海金山区春虹路100号102室',true,55),
('雪碧','解暑饮料',3.20,10012,'上海金山区春虹路100号102室',true,70),
('加多宝加多宝加多宝加多宝加多宝加多宝20','解暑饮料',4.20,10010,'上海金山区春虹路100号102室上海金山区春虹路100',true,80);
