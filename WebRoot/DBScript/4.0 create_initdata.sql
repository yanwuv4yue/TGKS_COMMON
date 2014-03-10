--
-- 转存表中的数据 `t_tgks_common_module`
--
INSERT INTO `t_tgks_common_module` (`id`, `name`, `sort`) VALUES
('COMM20121101150948000000', 'COMMON公共组件模块', '1'),
('COMM20121101150948000001', 'UMS人员管理系统模块', '2');


--
-- 转存表中的数据 `t_tgks_common_systemconfig`
--

INSERT INTO `t_tgks_common_systemconfig` (`id`, `tag`, `name`, `value`, `type`, `module`, `sort`) VALUES
('COMM20131016153018000000', 'system_time_format', '系统时间标签格式', 'yyyy-MM-dd HH:mm:ss', '1', 'common', '1');


--
-- 转存表中的数据 't_tgks_common_menu'
--
INSERT INTO `t_tgks_common_menu` (`id`, `preid`, `name`, `status`, `url`, `level`, `sort`) VALUES
('COMM20121021021441000000', '0', '系统菜单', '1', '#', '1', '900'),
('COMM20121021021441000011', 'COMM20121021021441000000', '菜单管理', '1', '../common/menuManager.action', '2', '900'),
('COMM20121021021441000012', 'COMM20121021021441000000', '系统设置', '1', '../common/systemConfigManager.action', '2', '900'),
('COMM20121021021441000010', 'COMM20121021021441000000', '账户管理', '1', '../ums/userManager.action', '2', '900'),
('COMM20131021163642000000', 'COMM20121021021441000000', '操作日志', '1', '../common/systemLogManager.action', '2', '900');

--
-- 转存表中的数据 `t_tgks_common_user`
--

INSERT INTO `t_tgks_common_user` (`id`, `username`, `password`, `status`, `type`, `email`, `name`, `sex`, `groupid`, `createtime`) VALUES
('UMSX20130618152052000000', 'admin', 'admin', '0', '0', 'admin@0dunet.com', '零度网络', '0', NULL, '2013-06-17 23:41:59'),
('UMSX20130620140257000000', '0dunet', '2BDaoHao', '0', '0', 'admin@0dunet.com', '零度网络', '0', NULL, '2013-06-19 22:03:20');

--
-- 转存表中的数据 `t_tgks_common_usermenu`
--

INSERT INTO `t_tgks_common_usermenu` (`userid`, `menuid`) VALUES
('UMSX20130618152052000000', 'COMM20121021021441000000,COMM20121021021441000010,COMM20121021021441000011,COMM20121021021441000012'),
('UMSX20130620140257000000', 'COMM20121021021441000000,COMM20121021021441000010,COMM20121021021441000011,COMM20121021021441000012');
