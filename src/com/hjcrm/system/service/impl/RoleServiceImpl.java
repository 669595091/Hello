package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;
import com.hjcrm.system.mapper.RoleDao;
import com.hjcrm.system.service.InterRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements InterRoleService {

    @Autowired
    private RoleDao roleDao;

    //查询所有角色
    @Override
    public List<Role> queryAllRole(PageBean pageBean) {
        return roleDao.queryAllRole(pageBean);
    }
    //查询所有角色个数
    @Override
    public int queryRoleCount() {
        return roleDao.queryRoleCount();
    }

    @Override
    public int addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public int deleteRole(String ids) {
        if(StringUtils.isNotBlank(ids)){
            List<String> list = new ArrayList<>();
            for ( String id: ids.split(",")
                 ) {
                list.add(id);
            }
            return roleDao.deleteRole(list);
        }
        return -1;
    }

    @Override
    public int deleteRoleAndMenuByRoleId(String roleid) {
        if(StringUtils.isNotBlank(roleid)){
            return roleDao.deleteRoleAndMenuByRoleId(roleid);
        }
        return -1;
    }

    @Override
    public int addRoleAndMenu(Role_menu rm) {
        if(rm!=null){
            return roleDao.addRoleAndMenu(rm);
        }
        return -1;
    }
}
