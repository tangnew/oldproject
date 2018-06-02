DROP DATABASE IF EXISTS super_exam;

CREATE DATABASE IF NOT EXISTS super_exam CHARSET utf8 COLLATE utf8_bin;

USE super_exam;

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  id VARCHAR (36) NOT NULL PRIMARY KEY,
  login_name VARCHAR (100) NOT NULL COMMENT '登录名,唯一',
  `password` VARCHAR (50) NOT NULL COMMENT '密码',
  `status` INT (2) NOT NULL COMMENT '该账号状态',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE INDEX index_login_name (login_name)
) ENGINE = INNODB CHARSET = utf8 COLLATE = utf8_bin COMMENT '用户账号信息' ;


DROP TABLE IF EXISTS t_user;
CREATE TABLE `t_user` (
  `id` varchar(36) COLLATE utf8_bin NOT NULL,
  `email` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '姓名',
  `age` int(3) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `fk_account_id` varchar(36) COLLATE utf8_bin NOT NULL,
  `created_time` datetime NOT NULL COMMENT '记录创建时间',
  `updated_time` datetime NOT NULL COMMENT '记录更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户信息';


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
) ENGINE = INNODB CHARSET = utf8 COLLATE = utf8_bin COMMENT '菜单信息表' ;
