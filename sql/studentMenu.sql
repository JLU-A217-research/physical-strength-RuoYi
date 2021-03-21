-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 ', '3', '1', '/system/student', 'C', '0', 'system:student:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '学生信息 菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 查询', @parentId, '1',  '#',  'F', '0', 'system:student:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 新增', @parentId, '2',  '#',  'F', '0', 'system:student:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 修改', @parentId, '3',  '#',  'F', '0', 'system:student:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 删除', @parentId, '4',  '#',  'F', '0', 'system:student:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生信息 导出', @parentId, '5',  '#',  'F', '0', 'system:student:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
