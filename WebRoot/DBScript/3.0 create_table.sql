--
-- 表的结构 `t_tgks_common_admin`
--
DROP TABLE IF EXISTS `t_tgks_common_admin`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_admin` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `uid` varchar(30) NOT NULL COMMENT '用户ID',
  `level` varchar(2) NOT NULL,
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uid` (`uid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

--
-- 表的结构 `t_tgks_common_user`
--
DROP TABLE IF EXISTS `t_tgks_common_user`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_user` (
  `id` varchar(30) NOT NULL COMMENT '用户表唯一主键',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `password` varchar(30) NOT NULL COMMENT '用户密码',
  `status` varchar(2) NOT NULL COMMENT '账号状态（0 停止；1 启用）',
  `type` varchar(2) NOT NULL COMMENT '账号类型（0 普通）',
  `email` varchar(50) default NULL COMMENT '邮箱',
  `name` varchar(40) default NULL COMMENT '姓名',
  `sex` varchar(2) default NULL COMMENT '性别（0 男；1 女）',
  `groupid` varchar(300) default NULL COMMENT '用户组ID',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='公共用户信息表';



--
-- 表的结构 `t_tgks_common_usermenu`
--
DROP TABLE IF EXISTS `t_tgks_common_usermenu`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_usermenu` (
  `userid` varchar(30) NOT NULL COMMENT '账号ID',
  `menuid` varchar(1000) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY  (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户菜单配置表';



--
-- 表的结构 `t_tgks_common_menu`
--
DROP TABLE IF EXISTS `t_tgks_common_menu`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_menu` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `preid` varchar(30) NOT NULL COMMENT '上级菜单ID',
  `name` varchar(50) NOT NULL COMMENT '菜单名',
  `status` varchar(2) NOT NULL COMMENT '状态（0 未启动；1 启用）',
  `url` varchar(200) NOT NULL COMMENT '菜单链接',
  `level` varchar(2) NOT NULL COMMENT '菜单级别',
  `sort` varchar(5) NOT NULL COMMENT '展示顺序',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统菜单表';

--
-- 表的结构 `t_tgks_common_systemconfig`
--
DROP TABLE IF EXISTS `t_tgks_common_systemconfig`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_systemconfig` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `tag` varchar(50) NOT NULL COMMENT '参数标签',
  `name` varchar(100) NOT NULL COMMENT '参数名',
  `value` varchar(256) NOT NULL COMMENT '参数值',
  `type` varchar(2) NOT NULL COMMENT '参数类型（1:简短|2:下拉|3:文本|4:单选|5:多选|6:图片）',
  `module` varchar(30) NOT NULL COMMENT '所属模块',
  `sort` varchar(5) NOT NULL COMMENT '展示顺序',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统参数表';

--
-- 表的结构 `t_tgks_common_module`
--
DROP TABLE IF EXISTS `t_tgks_common_module`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_module` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `name` varchar(50) NOT NULL COMMENT '模块名称',
  `sort` varchar(5) NOT NULL COMMENT '展示顺序',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='模块信息表';


--
-- 表的结构 `t_tgks_common_systemlog`
--
DROP TABLE IF EXISTS `t_tgks_common_systemlog`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_systemlog` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `uid` varchar(30) NOT NULL COMMENT '用户ID',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `type` varchar(2) NOT NULL COMMENT '操作类型（0 查询；1 新增；2 修改；3 删除）',
  `action` varchar(100) NOT NULL COMMENT '动作',
  `result` varchar(2) NOT NULL COMMENT '结果（0 成功；1 失败）',
  `info` varchar(500) COMMENT '详细信息',
  `ip` varchar(30) COMMENT 'IP地址',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='系统操作日志表';


--
-- 表的结构 `t_tgks_common_note`
--
DROP TABLE IF EXISTS `t_tgks_common_note`;
CREATE TABLE IF NOT EXISTS `t_tgks_common_note` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `uid` varchar(30) NOT NULL COMMENT '用户ID',
  `content` varchar(500) default NULL COMMENT '记录内容',
  `level` varchar(3) default NULL COMMENT '优先级',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='记事本表';