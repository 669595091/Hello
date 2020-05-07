package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.entity.PatterType;
import com.hjcrm.system.service.InterPatterTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatterTypeController {

    @Autowired
    private InterPatterTypeService patterTypeService;


    @RequestMapping("/system/patterType.do")
    public String menuManger(){
        if(UserSessionContext.getLoginUser()!=null){
            //用户登陆状态
            return JumpView.PATTER_PATTERTYPE;//handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        //跳回登陆页面
        return JumpView.LOGIN_VIEW;
    }
    //查询话术场景
    @RequestMapping("/course/queryPattertype.do")
    public @ResponseBody
    String queryPattertype(){
            List<PatterType> list = patterTypeService.queryPattertype();
            for (PatterType p:list
                    ) {
                System.out.println("查询话术场景："+p);
            }
            String pattertypeJson = PageBean.jsonToPage(list,null);
            return pattertypeJson;
    }

    //添加话术场景
    @RequestMapping("/course/addPattertype.do")
    public @ResponseBody
    String addPattertype(PatterType patterType){
        if(patterType!=null){
            if(patterType.getPatterTypeId()!=0){
                int i = patterTypeService.updatePatterType(patterType);
                System.out.println("修改课程："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = patterTypeService.addPatterType(patterType);
                System.out.println("添加课程："+i);
                return ReturnConstants.SUCCESS;
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除话术课程
    @RequestMapping(value = "/course/deletepatterType.do")
    public @ResponseBody String deletepatterType(String patterTypeIds) {
        System.out.println("删除话术课程ids： "+patterTypeIds);
        if(StringUtils.isNotBlank(patterTypeIds)){
            List<String> list = new ArrayList<>();
            for ( String id:patterTypeIds.split(",")
                    ) {
                list.add(id);
            }
            int i = patterTypeService.deletepatterType(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

}
