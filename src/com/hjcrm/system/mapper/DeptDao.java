package com.hjcrm.system.mapper;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Menu;

import java.util.HashMap;
import java.util.List;


public interface DeptDao {//部门接口
	//查询所有部门
	public List<Dept> queryAllDept();

	//分页查询所有部门
	public List<Dept> queryAllDeptPage(PageBean pageBean);
	//分页查询所有部门个数
	public int queryDeptCount();
	//添加部门
	public int addDept(Dept dept);
	//修改部门
	public int updateDept(Dept dept);
	//删除部门
	public int deleteDept(List<String> list);
}
