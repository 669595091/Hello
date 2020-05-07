package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.InterCourseService;
import com.hjcrm.system.service.InterStudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private InterStudentService studentService;

    /**
     * 跳转主页面
     */
    @RequestMapping(value="/student/studentMang.do")
    public String courseMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.OPERATE_STUDENT;
        }

        return JumpView.LOGIN_VIEW;
    }

    //查询学员管理
    @RequestMapping(value="/student/queryStudents.do")
    public @ResponseBody String queryStudents(int userid,int deptid,Integer currentPage,Integer pageSize){
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage((currentPage-1)*pageSize);
        pageBean.setPageSize(pageSize);
        List<Student> list=null;
        if(deptid==4){
            System.out.println("查询所有行政学员");
            list=studentService.queryAdminStudents(pageBean);
        }else{
            System.out.println("查询所有销售学员");
            list=studentService.querySalesStudents(pageBean);
        }
        if(list!=null){
            if(list.size()>0){
                pageBean.setCountResult(studentService.queryStudentCount());
                pageBean.setCurrentPage(currentPage);
                return PageBean.jsonToPage(list,pageBean);
            }
        }
        return JumpView.LOGIN_VIEW;
    }

}
