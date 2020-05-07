package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.mapper.MenuDao;
import com.hjcrm.system.mapper.UserDao;
import com.hjcrm.system.service.InterMenuService;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements InterMenuService {

    @Autowired
    private MenuDao menuDao;

    //查询所有菜单
    @Override
    public List<Menu> queryAllMenu() {

        HashMap<String,String> paramMap = new HashMap<>();
        paramMap.put("menuparaid","-1"); //查询所有一级菜单
        List<Menu> parentMenu = menuDao.queryAllMenu(paramMap);

        for (Menu m: parentMenu) {
            paramMap.put("menuparaid",m.getMenuid()+"");
            List<Menu> sonMenu = menuDao.queryAllMenu(paramMap);//查询所有的二级菜单
            for (Menu me: sonMenu
                 ) {
                System.out.println("二级菜单："+me);
            }
            m.setChildren(sonMenu);
        }
        return parentMenu;
    }
    //查询角色用户有的菜单
    /*@Override
    public List<Menu> roleHaveMenu(String roleid) {
        HashMap<String,String> map = new HashMap<>();
        map.put("roleid",roleid);//查询所有一级菜单
        List<Menu> list = menuDao.queryMenuByRoleId(map);
        return list;
    }*/
    @Override
    public List<Menu> roleHaveMenu(String roleid) {
        HashMap<String, String> paraMap = new HashMap<>();
        paraMap.put("roleid", roleid);
        List<Menu> menus = menuDao.queryMenuByRoleId(paraMap);
        return menus;
    }
    //添加菜单
    @Override
    public int addMenu(Menu menu) {
        if(menu!=null){
            return menuDao.addMenu(menu);
        }
        return -1;
    }
    //修改菜单
    @Override
    public int updateMenu(Menu menu) {
        if(menu!=null){
            return menuDao.updateMenu(menu);
        }
        return -1;
    }
    //判断一级菜单是否有子菜单
    @Override
    public boolean hasSecondaryChild(String id) {
        if(StringUtils.isNotBlank(id)){
            return menuDao.hasSecondaryChild( Integer.parseInt(id) ).size()>0?true:false;
        }
        return false;
    }
    //判断菜单是否被分配
    @Override
    public boolean hasRoles(String id) {
        if(StringUtils.isNotBlank(id)){
            return menuDao.hasRoles( Integer.parseInt(id) ).size()>0?true:false;
        }
        return false;
    }
    //删除菜单
    @Override
    public int deleteMenuById(String id) {
        if(StringUtils.isNotBlank(id)){
            return menuDao.deleteMenuById(Integer.parseInt(id));
        }
        return -1;
    }

}
