package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.User;

import java.util.List;

public interface InterDeptService {
    //查询所有部门
    public List<Dept> queryAllDept();


    //查询某部门下的所有角色
    public List<Role> queryRoleByDeptId(String deptid);

    //分页查询所有部门
    public List<Dept> queryAllDeptPage(PageBean pageBean);
    //分页查询所有部门个数
    public int queryDeptCount();
    //添加部门
    public int addDept(Dept dept);
    //修改部门
    public int updateDept(Dept dept);
    //删除本部门
    public int deleteDept(List<String> list);
}
