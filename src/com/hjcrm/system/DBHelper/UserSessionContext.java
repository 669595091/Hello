package com.hjcrm.system.DBHelper;

import com.hjcrm.system.entity.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserSessionContext {

    public static final String LOGIN_USER="login_user";
    public static final String LOGIN_NAME="loginName";
    /**
     * 获取请求对象
     * @return
     */
    public static HttpServletRequest getRequest(){
        //RequestContextHolder ,spring提供，可以获取HttpSevletRequest的工具类
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static User getLoginUser(){
        return (User)getRequest().getSession().getAttribute(UserSessionContext.LOGIN_USER);
    }

    public static void setLoginUser(User user){
        getRequest().getSession().setAttribute(UserSessionContext.LOGIN_USER,user);
        getRequest().getSession().setAttribute(UserSessionContext.LOGIN_NAME,user.getUsername());
    }

    public static void clearLoginUser(){
        getRequest().getSession().removeAttribute(UserSessionContext.LOGIN_USER);
    }

}
