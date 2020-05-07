package com.hjcrm.system.mapper;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;

import java.util.List;


public interface RoleDao {//角色管理接口
	//查询部门下的角色
	public List<Role> queryRoleByDeptId(String deptid);

	//查询所有角色信息
	public List<Role> queryAllRole(PageBean pageBean);
	//查询所有角色个数
	public int queryRoleCount();
	//添加角色
	public int addRole(Role role);
	//修改角色
	public int updateRole(Role role);
	//删除角色
	public int deleteRole(List list);



	//删除用户所有功能菜单
	public int deleteRoleAndMenuByRoleId(String roleid);

	//添加用户功能菜单
	public int addRoleAndMenu(Role_menu rm);
}
