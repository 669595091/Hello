package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class welcome {
    @Autowired
    private InterUserService service;

    /**
     * 跳转登陆页面
     */
    @RequestMapping(value="/login.do",method=RequestMethod.GET)
    public String loginView(){
        return "system/login";
    }

    /**
     * 处理登录页面
     * @param request
     * @param email
     * @param password
     * @return
     */
    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    public String login(HttpServletRequest request,String email,String password,String sign,Model model){
        System.err.println(email);
        System.err.println(password);
        //判断接受参数是否未NULL
        if(StringUtils.isNotBlank(email+"@qq.com") && StringUtils.isNotBlank(password)){
            //1.判断邮箱是否存在
            User user = service.queryUserInfoByEmail(email+sign);
            if(user==null){
                System.out.println(user);
                model.addAttribute("msg",ReturnConstants.USER_ISNULL);
                return JumpView.LOGIN_VIEW;
            }

            //2.判断密码是否匹配
            User passwordIsExis = service.queryPasswordIsExis(new User(user.getUserid(),password));
            if(passwordIsExis==null){
                model.addAttribute("msg",ReturnConstants.PSSWORD_ERROR);
                return JumpView.LOGIN_VIEW;
            }
            //操作Session/cookie
            UserSessionContext.setLoginUser(user);//将user对象添加到session中
            //返回主页面
            System.out.println("嗷嗷嗷");
            return "redirect:main.do";
        }
        return ReturnConstants.PARAM_NULL;
    }


    @RequestMapping(value="/main.do")
    public String index(Model model) {

      if(UserSessionContext.getLoginUser()!=null){

          // 1. 根据当前用户角色信息，查询当前角色所分配的菜单列表
          List<Menu> list = service.queryMenuByRoleId(UserSessionContext.getLoginUser().getRoleid()+"");
          System.out.println("返回主页面的list："+list.size());
          for (int i=0;i<list.size();i++){
              System.out.println("一级菜单："+list.get(i));
          }
          model.addAttribute("menus",list);

          //model.addAttribute("","");
          System.out.println(model.toString());
          return JumpView.MAIN_VIEW;
      }

        return JumpView.LOGIN_VIEW;
    }

    @RequestMapping("/logout.do")
    public String logout(Model model){
        //1.清空session数据和cookie数据

        UserSessionContext.clearLoginUser();
        //清空cookie中的数据

        //跳转登陆页面
        return JumpView.LOGIN_VIEW;
    }
    /*修改密码*/
    @RequestMapping("system/editPassword.do")
    public String editPassword(String newPassword,String oldPassword,int userid){
        Map<String,Object> map = new HashMap<>();
        map.put("newPassword",newPassword);
        map.put("userid",userid);
        map.put("oldPassword",oldPassword);
            int i = service.editPassword(map);
            System.out.println("修改密码： "+i);
            if(i>0){
                return JumpView.LOGIN_VIEW;
            }
        return ReturnConstants.PARAM_NULL;
    }

}
