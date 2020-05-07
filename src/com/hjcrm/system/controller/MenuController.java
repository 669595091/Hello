package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.User;
import com.hjcrm.system.service.InterMenuService;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private InterMenuService menuService;


    @RequestMapping("/system/menuMang.do")
    public String menuManger(){
        if(UserSessionContext.getLoginUser()!=null){
            //用户登陆状态
            return JumpView.SYSTEM_MEUN_MANAGER; //handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        //跳回登陆页面
        return JumpView.LOGIN_VIEW;
    }
    //查询所有菜单
    @RequestMapping("/menu/queryAllMenu.do")
    public @ResponseBody String queryAllMenu(){
        List<Menu> menuList = menuService.queryAllMenu();
        String menuJson = PageBean.jsonToPage(menuList, null);
        System.out.println("菜单信息："+menuJson);
        return menuJson;
    }
    //添加和修改菜单
    @RequestMapping("/menu/addOrUpdateMenu.do")
    public @ResponseBody String addOrUpdateMenu(Menu menu){
        if(menu!=null){
            if(menu.getMenuid()==0){
                int i = menuService.addMenu(menu);
                if(i>0){
                    return ReturnConstants.SUCCESS;
                }
            }else{
                int i = menuService.updateMenu(menu);
                if(i>0){
                    return ReturnConstants.SUCCESS;
                }
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    /**
     * 删除菜单
     * @param ids
     * @return
     */
    @RequestMapping("/menu/delete.do")
    public @ResponseBody String deleteMenuByIds(String ids){
        System.out.println("删除菜单： "+ids);
        if(StringUtils.isNotBlank(ids)){
            StringBuilder sb = new StringBuilder();//封装结果数据
            boolean isDelete = false;
            //1. 判断菜单是否是一级菜单
            for (String id: ids.split(",") ) {
                if(menuService.hasSecondaryChild(id)){
                    sb.append("当前菜单是一级菜单，存在二级菜单");
                    continue;
                }
                //2. 判断菜单是否被分配
                if(menuService.hasRoles(id)){
                    sb.append("此菜单已经被分配角色");
                    continue;
                }
                isDelete = true;
                int i = menuService.deleteMenuById(id);
                System.out.println("删除结果: "+i);
            }
            if(isDelete){
                return ReturnConstants.SUCCESS;
            }else{
                return sb.toString();
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

}
