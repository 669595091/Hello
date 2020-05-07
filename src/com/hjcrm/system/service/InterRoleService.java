package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;

import java.util.List;

public interface InterRoleService {
    //查询所有角色信息
    public List<Role> queryAllRole(PageBean pageBean);
    //查询所有角色个数
    public int queryRoleCount();
    //添加角色
    public int addRole(Role role);
    //修改角色
    public int updateRole(Role role);
    //删除角色
    public int deleteRole(String ids);

    //删除原角色和菜单的关系
    public int deleteRoleAndMenuByRoleId(String roleid);

    //更新关系表（用户和菜单的联系）
    public int addRoleAndMenu(Role_menu rm);
}
