package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InterUserService {
    //根据邮箱查询用户互信息
    public User queryUserInfoByEmail(String email);

    //查询密码是否匹配
    public User queryPasswordIsExis(User user);

    //查询当前角色匹配菜单列表
    public List<Menu> queryMenuByRoleId(String roleid);

    //实现用户信息的查询（分页）
    public List<User> queryAllUserInfo(PageBean pageBean);

    //查询用户条数
    public int queryAllUserCount();
    //批量删除用户
    public int deleteUserByIds(String ids);
    //修改用户
    public int saveOrUpdateUserInfo(User user);

    int editPassword(Map<String,Object> map);
}
