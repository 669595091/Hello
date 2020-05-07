package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.mapper.DeptDao;
import com.hjcrm.system.mapper.MenuDao;
import com.hjcrm.system.mapper.RoleDao;
import com.hjcrm.system.mapper.UserDao;
import com.hjcrm.system.service.InterDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements InterDeptService {
    @Autowired
    private DeptDao deptDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Dept> queryAllDept() {
        return deptDao.queryAllDept();
    }

    @Override
    public List<Role> queryRoleByDeptId(String deptid) {
        return roleDao.queryRoleByDeptId(deptid);
    }

    @Override
    public List<Dept> queryAllDeptPage(PageBean pageBean) {
        return deptDao.queryAllDeptPage(pageBean);
    }

    @Override
    public int queryDeptCount() {
        return deptDao.queryDeptCount();
    }

    @Override
    public int addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptDao.updateDept(dept);
    }

    @Override
    public int deleteDept(List<String> list) {
        return deptDao.deleteDept(list);
    }
}
