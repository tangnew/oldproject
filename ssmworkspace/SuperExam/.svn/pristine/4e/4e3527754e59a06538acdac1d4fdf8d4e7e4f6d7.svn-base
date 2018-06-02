DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id VARCHAR (36) NOT NULL PRIMARY KEY,
  login_name VARCHAR (100) NOT NULL COMMENT '登录名,唯一',
  `password` VARCHAR (50) NOT NULL COMMENT '密码',
  `status` INT (2) NOT NULL COMMENT '该账号状态',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE INDEX index_login_name (login_name)
);


DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `id` varchar(36)  NOT NULL,
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `fk_account_id` varchar(36) NOT NULL,
  `created_time` datetime NOT NULL COMMENT '记录创建时间',
  `updated_time` datetime NOT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_email` (`email`)
) ;


DROP TABLE IF EXISTS menu;
CREATE TABLE menu(
  id VARCHAR(36) NOT NULL PRIMARY KEY,
  menu_name VARCHAR(100) NOT NULL,
  module_name VARCHAR(100) NOT NULL UNIQUE,
  description TEXT,  
  seq INT(3),
  created_time DATETIME,
  updated_time DATETIME,
  status int(2) default 0,
  style_class varchar(50) default 'icon-cog',
  UNIQUE INDEX index_module_name (module_name)
) ;

insert into `menu` (`id`, `menu_name`, `module_name`, `description`, `seq`, `created_time`, `updated_time`) values('1','菜单管理','menu',NULL,'1','2016-11-14 16:33:33','2016-11-16 10:03:39');
insert into `menu` (`id`, `menu_name`, `module_name`, `description`, `seq`, `created_time`, `updated_time`) values('6cba4abe-17ac-4a50-b7ab-6c94aea5eed3','班级管理','class',NULL,'2','2016-11-15 17:12:56','2016-11-15 17:13:34');
insert into `menu` (`id`, `menu_name`, `module_name`, `description`, `seq`, `created_time`, `updated_time`) values('aee01b09-deb9-4d40-83d9-ea12ba468818','问题管理','question',NULL,'3','2016-11-15 17:14:01','2016-11-15 17:14:01');

