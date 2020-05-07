package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.UserSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatterDeptController {


    //AFP custom/AFPStudentMang.do
    @RequestMapping("/custom/AFPStudentMang.do")
    public String AFPStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/AFPStudentMang";
        }
        return "system/login";
    }
    //CFP custom/CFPStudentMang.do
    @RequestMapping("/custom/CFPStudentMang.do")
    public String CFPStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/CFPStudentMang";
        }
        return "system/login";
    }

    //基金从业 custom/jiJinStudentMang.do
    @RequestMapping("/custom/jiJinStudentMang.do")
    public String jiJinStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/jiJinStudentMang";
        }
        return "system/login";
    }
    //银行从业 custom/yinCongStudentMang.do
    @RequestMapping("/custom/yinCongStudentMang.do")
    public String yinCongStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/yinCongStudentMang";
        }
        return "system/login";
    }
    //中级经济师 custom/zhongJiStudentMang.do
    @RequestMapping("/custom/zhongJiStudentMang.do")
    public String zhongJiStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/zhongJiStudentMang";
        }
        return "system/login";
    }
    //证卷从业 /custom/zhengQuanStudentMang.do
    @RequestMapping("/custom/zhengQuanStudentMang.do")
    public String zhengQuanStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/zhengQuanStudentMang";
        }
        return "system/login";
    }
    //期货从业 custom/qiHuoStudentMang.do
    @RequestMapping("/custom/qiHuoStudentMang.do")
    public String qiHuoStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/qiHuoStudentMang";
        }
        return "system/login";
    }
    //会计从业 custom/kjcyStudentMang.do
    @RequestMapping("/custom/kjcyStudentMang.do")
    public String kjcyStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/kjcyStudentMang";
        }
        return "system/login";
    }
    //初级会计 custom/cjkjStudentMang.do
    @RequestMapping("/custom/cjkjStudentMang.do")
    public String cjkjStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/cjkjStudentMang";
        }
        return "system/login";
    }
    //通过学员 custom/passStudentMang.do
    @RequestMapping("/custom/passStudentMang.do")
    public String passStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/passStudentMang";
        }
        return "system/login";
    }

    //特殊情况学员 custom/specialStudentMang.do
    @RequestMapping("/custom/specialStudentMang.do")
    public String specialStudentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return "custom/specialStudentMang";
        }
        return "system/login";
    }
}
