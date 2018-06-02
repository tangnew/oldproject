DROP DATABASE IF EXISTS super_exam ;

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
CREATE TABLE t_user (
  id VARCHAR (36) NOT NULL PRIMARY KEY,
  `name` VARCHAR (100) NOT NULL COMMENT '姓名',
   age INT(3),
   gender BIT(1),
   fk_account_id VARCHAR(36) NOT NULL,
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间'
) ENGINE = INNODB CHARSET = utf8 COLLATE = utf8_bin COMMENT '用户信息' ;
