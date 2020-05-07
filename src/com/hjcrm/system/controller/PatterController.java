package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.service.InterPatterService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PatterController {
    @Autowired
    private InterPatterService patterService;



    @RequestMapping("/patter/myPatter.do")
    public String menuManger(){
        if(UserSessionContext.getLoginUser()!=null){
            //用户登陆状态
            return JumpView.PATTER_MYPATTER; //handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        //跳回登陆页面
        return JumpView.LOGIN_VIEW;
    }


    @RequestMapping("/patter/queryPattertype.do")
    public @ResponseBody
    String queryPattert(Patter patter){
        System.out.println("queryPattertype-userid： "+patter.getUserid());
        System.out.println("queryPattertype-courseid： "+patter.getCourseid());
        if(patter.getUserid()!=0){
            List<Patter> list = patterService.queryPatter(patter);
            for (Patter p:list
                 ) {
                System.out.println("查询话术："+p);
            }
            String patterJson = PageBean.jsonToPage(list,null);
            return patterJson; //handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        return ReturnConstants.PARAM_NULL;
    }
    @RequestMapping("/patter/queryPatter.do")
    public @ResponseBody
    String queryPatter(Patter patter){
        System.out.println("queryPatter-userid： "+patter.getUserid());
        System.out.println("queryPatter-courseid： "+patter.getCourseid());
        System.out.println("queryPatter-patterTypeId： "+patter.getPatterTypeId());
        if(patter.getUserid()!=0){
            List<Patter> list = patterService.queryPattertype(patter);
            for (Patter p:list
                    ) {
                System.out.println("查询话术："+p);
            }

            String patterJson = PageBean.jsonToPage(list,null);
            return patterJson; //handlermapping ---> /web-inf/jsp/system/courseMang.jsp
        }
        return ReturnConstants.PARAM_NULL;
    }

    //添加课程
    @RequestMapping(value="/patter/saveOrUpdatePatter.do")
    public @ResponseBody
    String addOrUpdateSubject(Patter patter){
        if(patter!=null){
            if(patter.getPatterid()!=0){
                int i = patterService.updatePatter(patter);
                System.out.println("修改话术："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = patterService.addPatter(patter);
                System.out.println("添加话术："+i);
                return ReturnConstants.SUCCESS;
            }
        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除话术
    @RequestMapping(value = "/patter/deletePatter.do")
    public @ResponseBody String deletePatter(String patterids) {
        System.out.println("删除话术ids： "+patterids);
        if(StringUtils.isNotBlank(patterids)){
            List<String> list = new ArrayList<>();
            for ( String id:patterids.split(",")
                    ) {
                list.add(id);
            }
            int i = patterService.deletePatter(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }
    //共享
    @RequestMapping(value="/patter/updatePatterIsShare.do")
    public @ResponseBody
    String updatePatterIsShare(Patter patter){
        if(patter!=null){
            if(patter.getPatterid()!=0){
                if(patter.getIsshare()==0){
                    patter.setIsshare(1);
                    int i = patterService.updatePatterIsShare(patter);
                    System.out.println("共享信息："+i);
                    return ReturnConstants.SUCCESS;
                }else if(patter.getIsshare()==1){
                    patter.setIsshare(0);
                    int i = patterService.updatePatterIsShare(patter);
                    System.out.println("共享信息："+i);
                    return ReturnConstants.SUCCESS;
                }

            }
        }
        return ReturnConstants.PARAM_NULL;
    }

}
