-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 ', '3', '1', '/system/score', 'C', '0', 'system:score:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '学生成绩 菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 查询', @parentId, '1',  '#',  'F', '0', 'system:score:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 新增', @parentId, '2',  '#',  'F', '0', 'system:score:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 修改', @parentId, '3',  '#',  'F', '0', 'system:score:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 删除', @parentId, '4',  '#',  'F', '0', 'system:score:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('学生成绩 导出', @parentId, '5',  '#',  'F', '0', 'system:score:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
