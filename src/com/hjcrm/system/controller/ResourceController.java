package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.JsonUtil;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.*;
import com.hjcrm.system.service.InterCourseService;
import com.hjcrm.system.service.InterResourceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ResourceController {
    @Autowired
    private InterResourceService resourceService;


    /**
     * 跳转主页面
     */
    @RequestMapping(value="/resource/resourcesMang.do",method=RequestMethod.GET)
    public String resourcesMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.OPERATE_RESOURCE;
        }

        return JumpView.LOGIN_VIEW;
    }
    //查询资源管理
    @RequestMapping(value="/resource/queryResource.do")
    public @ResponseBody String queryResource(Integer userid,Integer deptid,int roleid,Integer currentPage,Integer pageSize){
        Map<String,Integer> map=new HashMap<>();
        map.put("currentPage",( (currentPage-1)*pageSize) );
        map.put("pageSize",pageSize);
        map.put("userId",userid);
        List<Resource> list=resourceService.queryResource(map);
        if(list.size()>0){
            PageBean pageBean=new PageBean();
            pageBean.setCurrentPage(currentPage);
            pageBean.setPageSize(resourceService.queryResourceCount());
            return PageBean.jsonToPage(list,pageBean);
        }
        return JumpView.LOGIN_VIEW;
    }

    //添加资源信息
    @RequestMapping(value="/resource/addResource.do")
    public @ResponseBody
    String addOrUpdateResource(Resource resource, Visitrecord visitrecord){
        if(resource!=null){
            if(resource.getResourceId()!=0){
                int i = resourceService.updateResource(resource);
                System.out.println("修改资源信息："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = resourceService.addResource(resource);
                System.out.println("添加资源信息："+i);
                return ReturnConstants.SUCCESS;
            }

        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除资源信息
    @RequestMapping(value = "/resource/deleteResources.do")
    public @ResponseBody String deleteResources(String resourceId) {
        System.out.println("删除资源ids： "+resourceId);
        if(StringUtils.isNotBlank(resourceId)){
            List<String> list = new ArrayList<>();
            for ( String id:resourceId.split(",")
                    ) {
                list.add(id);
            }
            int i = resourceService.deleteResources(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

    //查询资源管理
    @RequestMapping(value="/resource/queryAllCreatePerson.do")
    public @ResponseBody String queryAllCreatePerson(){
        List<User> list = resourceService.queryAllCreatePerson();
        String personJson = JsonUtil.jsonToPage(list,null);
        return personJson;
    }
    //查询销售员
    @RequestMapping(value="/resource/queryAllXiaoShou.do")
    public @ResponseBody String queryAllXiaoShou(){
        List<User> list = resourceService.queryAllXiaoShou();
        for (User u:list
             ) {
            System.out.println("userList: "+u);
        }
        String XiaoShouJson = PageBean.jsonToPage(list,null);
        System.out.println("XiaoShouJson: "+XiaoShouJson);
        return XiaoShouJson;
    }

    //添加资源信息
    @RequestMapping(value="/resource/assigntoResource.do")
    public @ResponseBody
    String assigntoResource(String resourceIds){
        System.out.println("resourceIds:  "+resourceIds);
        if(StringUtils.isNotBlank(resourceIds)){
            List<String> list = new ArrayList<>();
            for ( String id:resourceIds.split(",")
                    ) {
                list.add(id);
            }
            int i = resourceService.updateResourceState(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }
        return ReturnConstants.PARAM_NULL;
    }
/*
    //查询资源管理
    @RequestMapping(value="/resource/queryResourceBySceen.do")
    public @ResponseBody String queryResourceBySceen(Resource resource,Integer pageSize,Integer currentPage){
        System.out.println("Resource:"+resource);

        return JumpView.LOGIN_VIEW;
    }*/


}
