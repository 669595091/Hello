package com.hjcrm.system.mapper;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserDao {//用户接口

	//根据邮箱查询用户互信息
	public User queryUserInfoByEmail(String email);

	//查询密码是否匹配
	public User queryPasswordIsExis(User user);

	//实现用户信息的查询（分页）
	public List<User> queryAllUserInfo(PageBean pageBean);

	//查询用户条数
	public int queryAllUserCount();
	//删除用户
	public int deleteUserByIds(List list);
    //修改操作
    public int updateUserInfo(User user);
    //添加操作
    public int addUserInfo(User user);

	int editPassword(Map<String,Object> map);
}
