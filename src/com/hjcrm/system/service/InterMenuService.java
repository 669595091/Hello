package com.hjcrm.system.service;

import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;

import java.util.List;

public interface InterMenuService {

    //查询所有角色匹配菜单列表
    public List<Menu> queryAllMenu();

    //查询某一角色拥有的菜单
    public List<Menu> roleHaveMenu(String roleid);

    //添加菜单
    public int addMenu(Menu menu);

    //修改菜单
    public int updateMenu(Menu menu);


    //查询一级菜单是否存在二级菜单
    public boolean hasSecondaryChild(String id);
    //查询菜单是否被分配
    public boolean hasRoles(String id);
    //删除菜单
    public int deleteMenuById(String id);
}
