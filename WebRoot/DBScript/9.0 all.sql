-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2013 年 08 月 31 日 08:20
-- 服务器版本: 5.0.90-community-nt
-- PHP 版本: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- 数据库: `db_tgks`
--

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_admin`
--

CREATE TABLE IF NOT EXISTS `t_tgks_common_admin` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `uid` varchar(30) NOT NULL COMMENT '用户ID',
  `level` varchar(2) NOT NULL,
  `createtime` date NOT NULL COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `uid` (`uid`),
  UNIQUE KEY `id` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='管理员信息表';

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_menu`
--

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
-- 转存表中的数据 `t_tgks_common_menu`
--

INSERT INTO `t_tgks_common_menu` (`id`, `preid`, `name`, `status`, `url`, `level`, `sort`) VALUES
('COMM20121021021441000000', '0', '系统菜单', '1', '#', '1', '900'),
('COMM20121021021441000011', 'COMM20121021021441000010', '菜单管理', '1', 'common/menuManager.action', '2', '991'),
('COMM20121021021441000012', 'COMM20121021021441000010', '系统设置', '1', 'common/systemConfigManager.action', '2', '992'),
('COMM20121021021441000010', 'COMM20121021021441000010', '账户管理', '1', '../ums/userManager.action', '2', '900');

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_module`
--

CREATE TABLE IF NOT EXISTS `t_tgks_common_module` (
  `id` varchar(30) NOT NULL COMMENT '表唯一主键',
  `name` varchar(50) NOT NULL COMMENT '模块名称',
  `sort` varchar(5) NOT NULL COMMENT '展示顺序',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='模块信息表';

--
-- 转存表中的数据 `t_tgks_common_module`
--

INSERT INTO `t_tgks_common_module` (`id`, `name`, `sort`) VALUES
('COMM20121101150948000000', 'COMMON公共组件模块', '1'),
('COMM20121101150948000001', 'UMS人员管理系统模块', '2');

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_systemconfig`
--

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

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_user`
--

CREATE TABLE IF NOT EXISTS `t_tgks_common_user` (
  `id` varchar(30) NOT NULL COMMENT '用户表唯一主键',
  `username` varchar(30) NOT NULL COMMENT '用户账号',
  `password` varchar(30) NOT NULL COMMENT '用户密码',
  `status` varchar(2) NOT NULL COMMENT '账号状态（0 未启动；1 启用）',
  `type` varchar(2) NOT NULL COMMENT '账号类型',
  `email` varchar(50) default NULL COMMENT '邮箱',
  `name` varchar(40) default NULL COMMENT '姓名',
  `sex` varchar(2) default NULL COMMENT '性别',
  `groupid` varchar(300) default NULL COMMENT '用户组ID',
  `createtime` timestamp NOT NULL default CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='公共用户信息表';

--
-- 转存表中的数据 `t_tgks_common_user`
--

INSERT INTO `t_tgks_common_user` (`id`, `username`, `password`, `status`, `type`, `email`, `name`, `sex`, `groupid`, `createtime`) VALUES
('UMSX20130618152052000000', 'admin', 'admin', '0', '0', 'admin@0dunet.com', '零度网络', '0', NULL, '2013-06-17 23:41:59'),
('UMSX20130620140257000000', '0dunet', '2BDaoHao', '0', '0', 'admin@0dunet.com', '零度网络', '0', NULL, '2013-06-19 22:03:20');

-- --------------------------------------------------------

--
-- 表的结构 `t_tgks_common_usermenu`
--

CREATE TABLE IF NOT EXISTS `t_tgks_common_usermenu` (
  `userid` varchar(30) NOT NULL COMMENT '账号ID',
  `menuid` varchar(1000) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY  (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='用户菜单配置表';

--
-- 转存表中的数据 `t_tgks_common_usermenu`
--

INSERT INTO `t_tgks_common_usermenu` (`userid`, `menuid`) VALUES
('UMSX20130618152052000000', 'COMM20130528171646000001,COMM20130528171622000000,COMM20130529155727000000,COMM20130530141217000001,COMM20130530151821000000,COMM20130530141217000000,COMM20130613152004000000,COMM20130613152116000001,COMM20130613161916000006,COMM20121021021441000000,COMM20121021021441000010,COMM20121021021441000011,COMM20121021021441000012'),
('UMSX20130620140257000000', 'COMM20130528171646000001,COMM20130528171622000000,COMM20130529155727000000,COMM20130530141217000001,COMM20130530151821000000,COMM20130530141217000000,COMM20130613152004000000,COMM20130613152116000001,COMM20130613161916000006,COMM20121021021441000000,COMM20121021021441000010,COMM20121021021441000011,COMM20121021021441000012');
