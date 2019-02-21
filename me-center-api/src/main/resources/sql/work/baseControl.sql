/**
 * 控件表
 */
create table if not exists `baseControl`(
  `pid` integer not null auto_increment comment '主键',
  `templateID` integer not null default 0 comment '模板id',
  `labelName` nvarchar(600) not null default '' comment '控件名称',
  `controlID` integer not null default 0 comment '控件id',
  `controlType` varchar(600) not null default '' comment '控件类型',
  `controlValue` nvarchar(1000) not null default '' comment '控件值',
  `defaultValue` nvarchar(1000) default '' comment '控件默认值',
  `props` nvarchar(1000) default  '' comment '其他属性值',
  `options` nvarchar(1000) default '' comment 'select的options数据源',
  `placeholder` nvarchar(1000) default '' comment '占位提示文字',
  `readOnly` boolean default false comment '只读',
  `required` boolean default false comment '必填',
  `createTime` timestamp not null default current_timestamp comment '创建时间',
  `createUser` varchar(100) not null default 'system' comment '创建人',
  primary key (`pid`),
  key idx_createTime(`createTime`)
)ENGINE=InnoDB AUTO_INCREMENT=1 default charset =utf8 comment '控件表';

/**
 插入控件表
 */
insert into baseControl (templateID, labelName, controlID, controlType, controlValue, defaultValue, props, options, placeholder, readOnly, required, createUser)
values ('1','处理人',1,'input','张三','里斯','testList','[1,2,3]','请输入',false,true,'system'),
       ('2','输入',2,'input','电话号码','15026969417','testList','[1,2,3]','请输入电话号码',false,true,'system');
