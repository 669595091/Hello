package com.hjcrm.system.controller.admin;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.InterAdminStudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminStudentController {
    @Autowired
    InterAdminStudentService adminStudentService;


    /**
     * 跳转主页面
     */
    @RequestMapping(value="/executive/studentMang.do")
    public String studentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.EXECUTIVE_STUDENTMANG;
        }

        return JumpView.LOGIN_VIEW;
    }
    @RequestMapping(value="/student/returnStudent.do")
    public @ResponseBody String returnStudent(int userid,String resourceIds,String studentIds,String returnNote){
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isNotBlank(studentIds)){
            List<String> list = new ArrayList<>();
            for ( String id:studentIds.split(",")
                    ) {
                list.add(id);
            }
            System.out.println("list: "+list.size());
            map.put("studentIdList",list);
            map.put("returnNote",returnNote);
            int i = adminStudentService.returnStudent(map);
            System.out.println("回退结果： "+i);
            return ReturnConstants.SUCCESS;
        }


        return JumpView.LOGIN_VIEW;
    }

}
