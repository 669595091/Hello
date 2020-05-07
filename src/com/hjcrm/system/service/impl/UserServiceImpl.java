package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.mapper.MenuDao;
import com.hjcrm.system.mapper.UserDao;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements InterUserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private MenuDao menuDao;

    //根据邮箱查询用户互信息
    @Override
    public User queryUserInfoByEmail(String email) {
        try {
            User user = userDao.queryUserInfoByEmail(email);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询密码是否匹配
    @Override
    public User queryPasswordIsExis(User user) {
        try {
            User passwordIsExis = userDao.queryPasswordIsExis(user);
            return passwordIsExis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //查询一级菜单
    @Override
    public List<Menu> queryMenuByRoleId(String roleid) {
        HashMap<String,String> hashmap = new HashMap<>();
        hashmap.put("roleid",roleid);
        hashmap.put("menuparaid","-1");
        System.out.println("hashmap:"+hashmap.size());
        List<Menu> list = menuDao.queryMenuByRoleId(hashmap);
        //查询一级菜单下的二级菜单
        for (Menu m: list) {
            System.out.println("一级菜单："+m);
            HashMap<String,String> menuMap = new HashMap<>();
            menuMap.put("roleid",roleid);
            menuMap.put("menuparaid",m.getMenuid()+"");

    List<Menu> menusSecondary = menuDao.queryMenuByRoleId(menuMap);
            for (Menu m1:menusSecondary
                 ) {
                System.out.println("二级菜单："+m1);
            }
            System.out.println("二级菜单："+menusSecondary.size());

            m.setChildren(menusSecondary);  // 将查询到的二级菜单添加到一级菜单上
}
        return list;
                }
    //查询所有用户
/*    @Cacheable(value = "baseCache" , key = "'queryAllUserInfo'")*/
    @Override
    public List<User> queryAllUserInfo(PageBean pageBean) {
        return userDao.queryAllUserInfo(pageBean);
    }
    //分页计数
    @Override
    public int queryAllUserCount() {
        return userDao.queryAllUserCount();
    }

    @Override
    public int deleteUserByIds(String ids) {
        if(StringUtils.isNotBlank(ids)){
            List<String> list = new ArrayList<>();
            for (String id: ids.split(",")) {
                list.add(id);
            }
            return userDao.deleteUserByIds(list);
        }
        return -1;
    }

    @Override
    public int saveOrUpdateUserInfo(User user) {
        if(user!=null){
            if(user.getUserid()!=0){
                //修改操作
                return userDao.updateUserInfo(user);
            }else{
                return userDao.addUserInfo(user);
            }
        }
        return -1;
    }


    @Override
    public int editPassword(Map<String, Object> map) {
        return userDao.editPassword(map);
    }


}
