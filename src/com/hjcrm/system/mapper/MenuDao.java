package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;

import java.util.HashMap;
import java.util.List;


public interface MenuDao {//菜单接口

	//查询一级菜单下的二级菜单，参数为HashMap类型，需传入一个id和一个状态（一级菜单的菜单ID(menuparaid)为-1）
	public List<Menu> queryMenuByRoleId(HashMap<String,String> hashmap);

	//查询所有的角色菜单，参数为HashMap类型，需传入一个id和一个状态（一级菜单的菜单ID(menuparaid)为-1）
	public List<Menu> queryAllMenu(HashMap<String,String> hashmap);


	//添加菜单
	public int addMenu(Menu menu);
	//修改菜单
	public int updateMenu(Menu menu);

	//查询一级菜单是否存在二级菜单
	public List<Menu> hasSecondaryChild(int id);
	//查询菜单是否被分配
	public List<Menu> hasRoles(int id);
	//删除菜单
	public int deleteMenuById(int id);

}
