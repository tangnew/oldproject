DROP TABLE IF EXISTS account;
CREATE TABLE account(
   id VARCHAR(36)  NOT NULL PRIMARY KEY,
  email VARCHAR(100)  NOT NULL COMMENT '邮箱，用户的登录名，要求唯一索引',
  password VARCHAR(50)  NOT NULL COMMENT '用户密码，要求是md5加密',
  status INT(2) NOT NULL DEFAULT 1 COMMENT '该账号状态：0禁用、1正常、2注销、3删除、4表示未激活，默认是否1',
  type INT(1) NOT NULL COMMENT '该账号的身份类型:1表示老师，2表示学生。通过1可以找到teacher表，通过2可以找到学生；在注册的时候进行了区分。',
   activation_code VARCHAR(100) COMMENT '一串随机数，用户点击该链接，就激活该账号',  
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_email (email)
);


DROP TABLE IF EXISTS role;
CREATE TABLE role (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  name VARCHAR (50) NOT NULL COMMENT '角色名称，要求是唯一',
  description TEXT COMMENT '描述该角色作用，允许为空',
  status INT (2) NOT NULL DEFAULT 1 COMMENT '该角色状态：0禁用、1正常、2删除，默认是1',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_name_role (name)
) ;

DROP TABLE IF EXISTS resources;
CREATE TABLE resources(
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  name VARCHAR (50) NOT NULL COMMENT '资源名称，要求是唯一',
  type INT(1) NOT NULL DEFAULT 1 COMMENT '表示该资源的类型:1表示模块，2表示模块下的子资源。默认是1',
  pid_prefix VARCHAR(200) COMMENT '表示该资源的父资源的id前缀集成，如果为空的话，这表示这是最大模块资源',
  access_path VARCHAR(50) COMMENT '资源访问路径，要求是唯一',
  description TEXT COMMENT '描述该资源作用，允许为空',
  status INT (2) NOT NULL DEFAULT 1 COMMENT '该资源状态：0禁用、1正常、2删除，默认是1',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_name_resources (name),
  UNIQUE KEY index_access_path(access_path)
);


DROP TABLE IF EXISTS rel_role_resources;
CREATE TABLE rel_role_resources (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  fk_role_id VARCHAR (36) NOT NULL COMMENT '角色表id',
  fk_resources_id VARCHAR (36) NOT NULL COMMENT '资源表id',
  status INT (2) NOT NULL DEFAULT 1 COMMENT '该记录状态：0禁用、1正常、2删除，默认是1',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间'
) ;

DROP TABLE IF EXISTS rel_account_role;
CREATE TABLE rel_account_role (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  fk_role_id VARCHAR (36) NOT NULL COMMENT '角色表id',
  fk_account_id VARCHAR (36) NOT NULL COMMENT '账号表id',
  status INT (2) NOT NULL DEFAULT 1 COMMENT '该记录状态：0禁用、1正常、2删除，默认是1',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间'
) ;


DROP TABLE IF EXISTS student;
CREATE TABLE student (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  name VARCHAR (50) NOT NULL COMMENT '学生姓名，默认取账号表中的login_name',
  gender BIT(1) DEFAULT TRUE COMMENT '性别:true表示女，false表示男。默认女',
  age INT (3) DEFAULT 0 COMMENT '年龄，默认0',
  fk_account_id VARCHAR (36) NOT NULL COMMENT '账号表id',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_fk_account_id_student (fk_account_id)
) ;


DROP TABLE IF EXISTS teacher;
CREATE TABLE teacher (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  name VARCHAR (50) NOT NULL COMMENT '教师姓名，默认取账号表中的login_name',
  gender BIT(1) DEFAULT TRUE COMMENT '性别:true表示女，false表示男。默认女',
  age INT (3) DEFAULT 0 COMMENT '年龄，默认0',
  fk_account_id VARCHAR (36) NOT NULL COMMENT '账号表id',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_fk_account_id_teacher (fk_account_id)
) ;


DROP TABLE IF EXISTS invite_code;
CREATE TABLE invite_code (
  id VARCHAR (36)  NOT NULL PRIMARY KEY,
  code VARCHAR (50) NOT NULL COMMENT '随机产生的code，唯一索引',
  created_time DATETIME NOT NULL COMMENT '记录创建时间',
  updated_time DATETIME NOT NULL COMMENT '记录更新时间',
  UNIQUE KEY index_code (code)
) ;
