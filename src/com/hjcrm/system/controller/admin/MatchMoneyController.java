package com.hjcrm.system.controller.admin;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Match;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.InterAdminStudentService;
import com.hjcrm.system.service.InterMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MatchMoneyController {
    @Autowired
    InterMoneyService moneyService;


    /**
     * 跳转主页面
     */
    @RequestMapping(value="/executive/matchMoney.do")
    public String studentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.EXECUTIVE_MATCHMONEY;
        }

        return JumpView.LOGIN_VIEW;
    }

    //查询销售学员管理
    @RequestMapping(value="/student/queryStudnetMatchs.do")
    public @ResponseBody
    String queryStudents(Student student){
        System.out.println("Student:"+student);
        if(student!=null){
            List<Student> list = moneyService.queryMoneyStudent(student);
            String studentJson = PageBean.jsonToPage(list,null);
            System.out.println("studentJson:"+studentJson);

            return studentJson;

        }
        return JumpView.LOGIN_VIEW;
    }
    //查询财务学员管理
    @RequestMapping(value="/student/queryMatchinfo.do")
    public @ResponseBody
    String queryMatchinfo(Match match){
        System.out.println("match:"+match);
        if(match!=null){
            List<Match> list = moneyService.queryMatchinfo(match);
            String matchJson = PageBean.jsonToPage(list,null);
            System.out.println("matchJson:"+matchJson);

            return matchJson;

        }
        return JumpView.LOGIN_VIEW;
    }
}
