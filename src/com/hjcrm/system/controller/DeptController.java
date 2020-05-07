package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.JsonUtil;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Dept;
import com.hjcrm.system.entity.Role;
import com.hjcrm.system.service.InterDeptService;
import com.hjcrm.system.service.InterUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DeptController {
    @Autowired
    private InterDeptService deptService;

    /**
     * 请求部门页面
     */
    @RequestMapping(value = "/system/deptMang.do", method = RequestMethod.GET)
    public String deptMang() {
        if (UserSessionContext.getLoginUser() != null) {
            return JumpView.SYSTEM_DEPT_MANAGER;
        }
        return JumpView.LOGIN_VIEW;
    }

    /*//查询部门列表
    @RequestMapping(value = "/dept/queryDept.do")
    public @ResponseBody String queryAllDept() {
        List<Dept> depts = deptService.queryAllDept();
        System.out.println("查询部门,depts："+depts.size());
        //将查询到的数据封装成json数据返回
        String jsonResult = PageBean.jsonToPage(depts,null);

        System.out.println("查询所有部门信息：json:"+jsonResult);
        return jsonResult;
    }*/


    //查询部门下的所有角色
    @RequestMapping(value = "/role/queryRoleByDeptid.do")
    public @ResponseBody String queryRoleByDeptId(String deptid) {
        if(StringUtils.isNotBlank(deptid)) {

            //查询属于当前部门下的所有角色
            List<Role> list = deptService.queryRoleByDeptId(deptid);
            for (Role r: list ) {
                System.out.println("查询部门下的所有角色："+r );
            }
            //请求RoleService
            String roleResult = PageBean.jsonToPage(list,null);
            System.out.println("查询具体角色JSON："+roleResult);
            return  roleResult;

        }

       return ReturnConstants.PARAM_NULL;
    }

    //查询部门列表
    @RequestMapping(value = "/dept/queryDept.do")
    public @ResponseBody String queryAllDeptPage(Integer pageSize,Integer currentPage) {
        System.out.println("查询所有部门   pageSize: "+pageSize+",currentPage："+currentPage);
        if(pageSize!=null && currentPage!=null){
            PageBean pageBean = new PageBean();
            pageBean.setPageSize(pageSize);
            pageBean.setCurrentPage((currentPage - 1) * pageSize);
            List<Dept> deptList = deptService.queryAllDeptPage(pageBean);
            int count = deptService.queryDeptCount();
            String deptJson = PageBean.jsonUserInfoToPage(deptList, count, currentPage);
            return deptJson;
        }else {
            List<Dept> depts = deptService.queryAllDept();
            System.out.println("查询部门,depts："+depts.size());
            //将查询到的数据封装成json数据返回
            String jsonResult = PageBean.jsonToPage(depts,null);

            System.out.println("查询所有部门信息：json:"+jsonResult);
            return jsonResult;
        }
    }

    //查询部门下的所有角色
    @RequestMapping(value = "/dept/saveOrUpdate.do")
    public @ResponseBody String saveOrUpdate(Dept dept) {
        System.out.println("查询部门dept： "+dept);
        if (dept != null) {
            if(dept.getDeptid()==0){//添加操作
                System.out.println("添加操作");
                int i = deptService.addDept(dept);
                System.out.println("添加操作： "+i);
                return ReturnConstants.SUCCESS;
            }else{//修改操作
                if(dept.getDeptparaid()!=-1){
                    System.out.println("修改操作");
                    int i = deptService.updateDept(dept);
                    System.out.println("修改操作： "+i);
                    return ReturnConstants.SUCCESS;
                }

            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除部门
    @RequestMapping(value = "/dept/delete.do")
    public @ResponseBody String deleteDept(String ids) {
        System.out.println("删除部门ids： "+ids);
        if(StringUtils.isNotBlank(ids)){
            List<String> list = new ArrayList<>();
            for ( String id:ids.split(",")
                 ) {
                list.add(id);
            }
            int i = deptService.deleteDept(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

}
