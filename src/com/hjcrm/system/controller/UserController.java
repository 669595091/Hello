package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.JsonUtil;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.ibm.wsdl.util.StringUtils.*;

@Controller
public class UserController {
    @Autowired
    private InterUserService service;

    /**
     * 加载用户管理页面到主页面
     */
    @RequestMapping(value="/system/userMang.do")
    public String userMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SYSTEM_USER_MANAGER;
        }
        return JumpView.LOGIN_VIEW;
        }

    /**
     * 加载用户管理页面到主页面
     */
    @RequestMapping(value="/system/userlist.do")
    public @ResponseBody String queryUserInfo(Integer pageSize,Integer currentPage){
        if(UserSessionContext.getLoginUser()!=null){
            //用户登录状态
            //查询所有用户信息

            System.out.println("请求用户信息："+pageSize+"/"+currentPage);

            PageBean pageBean = new PageBean();
            pageBean.setCurrentPage((currentPage-1)*pageSize );
            pageBean.setPageSize(pageSize);
            System.out.println(pageBean);
            List<User> list =  service.queryAllUserInfo(pageBean);
            for (User user:list) {
                System.out.println("查询到的用户信息："+user);
            }
            pageBean.setCurrentPage(currentPage);
            pageBean.setCountResult(service.queryAllUserCount());
            String userJsonResult =  JsonUtil.jsonToPage(list,pageBean);
            System.out.println("userJsonResult："+userJsonResult);
            return userJsonResult;


        }
        return ReturnConstants.PARAM_NULL;
    }



    //删除
    @RequestMapping(value="/system/deleteUser.do")
    public @ResponseBody String deleteUserById(String ids){
        if(StringUtils.isNotBlank(ids)){
            System.out.println("需要删除的用户信息字符串：" + ids);
            //请求service实现删除
            int delResult = service.deleteUserByIds(ids); //批量删除
            System.out.println("删除的结果：" + delResult);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

    //添加和修改用户信息
    @RequestMapping(value="/system/saveOrUpdate.do")
    public @ResponseBody String saveOrUpdateUserInfo(User user){
        if(user!=null){
            System.out.println("需要添加和修改的用户信息："+user);
            //请求service实现用户添加
            service.saveOrUpdateUserInfo(user);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

}
