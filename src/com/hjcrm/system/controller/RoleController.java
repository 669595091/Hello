package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.JsonUtil;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Menu;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.entity.Role_menu;
import com.hjcrm.system.service.InterMenuService;
import com.hjcrm.system.service.InterRoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {
    @Autowired
    private InterRoleService roleService;
    @Autowired
    private InterMenuService menuService;

    /**
     * 跳转主页面
     */
    @RequestMapping(value="/system/roleMang.do",method=RequestMethod.GET)
    public String roleMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SYSTEM_ROLE_MANAGER;
        }
        return JumpView.LOGIN_VIEW;
    }
    //显示角色信息
    @RequestMapping(value="/role/queryAllRole.do")
    public @ResponseBody
    String queryRole(Integer pageSize,Integer currentPage){
            //封装分页查询实体类
            PageBean pageBean=new PageBean();
            pageBean.setPageSize(pageSize);//设置每页记录条数
            pageBean.setCurrentPage( (currentPage-1)*pageSize );//设置当前页
            //分页查询角色信息数据
            List<Role> list = roleService.queryAllRole(pageBean);
            //设置返回分页数据的json字符串(pageBean的三个key：countResult,total,rows);
            int count = roleService.queryRoleCount();
            String roleJson = PageBean.jsonUserInfoToPage(list,count,currentPage);
            System.out.println("roleJson:"+roleJson);
            return roleJson;
        }

    //添加或修改角色
    @RequestMapping(value="/role/addOrUpdateRole.do")
    public @ResponseBody
    String addOrUpdateRole(Role role){
        System.out.println("role: "+role);
        if(role!=null){
            if(role.getRoleid()==0){

                if(roleService.addRole(role)>0){
                   return ReturnConstants.SUCCESS;
                }

            }else {

                if (roleService.updateRole(role) > 0) {
                    return ReturnConstants.SUCCESS;
                }

            }
        }

        return ReturnConstants.PARAM_NULL;
    }

    //删除角色
    @RequestMapping(value="/role/deleteRole.do")
    public @ResponseBody
    String addOrUpdateRole(String ids){
        System.out.println("ids: "+ids);
        if(StringUtils.isNotBlank(ids)){
            int deleteResult = roleService.deleteRole(ids);
            System.out.println("role删除结果："+deleteResult);
            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }


    /**
     * 查询所有菜单，按照等级封装
     * 判断用户是否选中，设置选中状态
     * 分配角色权限
     * @return
     */
    /*@RequestMapping(value="/rolemenu/queryAllMenuAndSelected.do")
    public @ResponseBody
    String queryAllMenuAndSelected(String roleid){
        System.out.println("角色权限分配： "+roleid);

        //1. 查询所有菜单（按照等级划分：children）
        List<Menu> menuList = menuService.queryAllMenu();
        //2. 查询所有用户角色拥有的菜单
        List<Menu> roleMenuList = menuService.roleHaveMenu(roleid);

        if(menuList!=null && roleMenuList.size()>0){
            //3. 遍历菜单设置选中状态
            for (int i=0; i<menuList.size();i++){//遍历所有菜单
                for(int j=0; j<roleMenuList.size();j++){//遍历所有用户选择的菜单
                    if(roleMenuList.get(j)!=null){
                        if(menuList.get(i).getMenuid() == roleMenuList.get(j).getMenuid()){//定位到用户已经拥有的菜单
                            menuList.get(i).setSelected(true);
                            break;
                        }
                    }
                }
            }
            //4.循环遍历二级菜单，设置选中状态
            for (int i=0; i<menuList.size();i++){//循环一级菜单
                List<Menu> secondaryMenuList = menuList.get(i).getChildMenu();//循环获取一级菜单的子菜单（二级菜单）
                if(secondaryMenuList!=null && secondaryMenuList.size()>0){//如果二级菜单不为空且长度大于0
                    for (int j=0; j<secondaryMenuList.size();j++){//遍历二级菜单
                        for (int k=0; k<roleMenuList.size();k++){//遍历所有用户的菜单
                            if(roleMenuList.get(k)!=null){//如果用户选择的菜单不为空
                                if(roleMenuList.get(k).getMenuid() == secondaryMenuList.get(j).getMenuid()){//如果用户选择的菜单和二级菜单相匹配
                                    secondaryMenuList.get(j).setSelected(true);//设置二级菜单
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(menuList);
        return JsonUtil.jsonToPage(menuList,null);
    }*/

    @RequestMapping("/rolemenu/queryAllMenuAndSelected.do")
    public @ResponseBody
    String queryAllMenuAndSelectedStatu(String roleid) {
        System.out.println("权限分配：" + roleid);
        //1. 查询所有菜单（按照等级划分：children）
        List<Menu> listMenu = menuService.queryAllMenu();

        //2. 查询所有用户角色拥有的菜单
        List<Menu> listMenuRole = menuService.roleHaveMenu(roleid);

        //3. 变量菜单设置选中状态
        if (listMenuRole != null && listMenuRole.size() > 0) {
            for (int i = 0; i < listMenu.size(); i++) {
                //遍历所有菜单

                for (int j = 0; j < listMenuRole.size(); j++) {
                    //遍历所有用户选择的菜单
                    if (listMenuRole.get(j).getMenuid() == listMenu.get(i).getMenuid()) {
                        //定位到用户已经拥有的菜单
                        listMenu.get(i).setSelected(true);
                        break;
                    }
                }
            }
            //循环遍历二级菜单，设置选中状态
            for (int i = 0; i < listMenu.size(); i++) {
                List<Menu> secondaryMenuList = listMenu.get(i).getChildren();
                if (secondaryMenuList != null && secondaryMenuList.size() > 0) {
                    //遍历二级
                    for (int j = 0; j < secondaryMenuList.size(); j++) {
                        for (int z = 0; z < listMenuRole.size(); z++) {
                            //遍历所有用户选择的菜单
                            if (listMenuRole.get(z).getMenuid() == secondaryMenuList.get(j).getMenuid()) {
                                //定位到用户已经拥有的菜单
                                secondaryMenuList.get(j).setSelected(true);//设置二级菜单
                                break;
                            }
                        }
                    }
                }
            }
        }
        //4. 返回代用用户选中状态的菜单列表
        return PageBean.jsonToPage(listMenu, null);
    }


    //分配角色权限
    /*@RequestMapping(value="/rolemenu/assignMenu.do")
    public @ResponseBody
    String assignMenu(String roleid,String menuid){
        System.out.println("分配角色权限更新： roleid: "+roleid+"    ,menuid: "+menuid);

        if(StringUtils.isNotBlank(roleid)){
            roleService.deleteRoleAndMenuByRoleId(roleid);//先删除原用户和菜单的对应关系
            if(StringUtils.isNotBlank(menuid)){//操作菜单和角色关系表,添加新的对应关系
                for ( String mid:menuid.split(",")
                     ) {
                    Role_menu rm = new Role_menu();
                    rm.setRoleid(Integer.parseInt(roleid));
                    rm.setMenuid(Integer.parseInt(mid));
                    roleService.addRoleAndMenu(rm);
                }
            }
            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }*/
    @RequestMapping("/rolemenu/assignMenu.do")
    public @ResponseBody
    String assignMenu(String roleid, String menuid) { //57,58,15,16,17,62,80,96
        if (StringUtils.isNotBlank(roleid)) {
            System.out.println("更新菜单：" + roleid + "," + menuid);
            //先删除原用户和菜单的对应关系
            //操作菜单和角色关系表
            roleService.deleteRoleAndMenuByRoleId(roleid);
            //添加新的对应关系
            if (StringUtils.isNotBlank(menuid)) {
                for (String mid : menuid.split(",")) {
                    Role_menu role_menu = new Role_menu();
                    role_menu.setRoleid(Integer.parseInt(roleid));
                    role_menu.setMenuid(Integer.parseInt(mid));
                    roleService.addRoleAndMenu(role_menu);
                }
            }

            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }
}
