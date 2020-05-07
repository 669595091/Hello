package com.hjcrm.system.controller.sales;


import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.service.InterStudentService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SaleStudentController {
    @Autowired
    private InterStudentService studentService;

    /**
     * 跳转主页面
     */
    @RequestMapping(value="/sales/studentMang.do")
    public String studentMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SALES_STUDENTMANG;
        }

        return JumpView.LOGIN_VIEW;
    }


    //添加学生
    @RequestMapping(value="/student/addStudent.do")
    public @ResponseBody
    String addStudent(Student student){
        System.out.println("student: "+student);
                if(student.getStudentId()!=0){
                    int i = studentService.updateStudent(student);
                    System.out.println("修改学生：" + i);
                    return ReturnConstants.SUCCESS;
                }else {
                    int i = studentService.addStudent(student);
                    System.out.println("添加学生：" + i);
                    return ReturnConstants.SUCCESS;
                }
    }
    //学生详情
    @RequestMapping(value="/student/studentDetails.do")
    public String studentDetails(Student student,HttpServletRequest request){
        if(student!=null){
            List<Student> liststudent = studentService.queryStudentDetails(student);
            request.setAttribute("liststudent",liststudent);
            return JumpView.SALES_STUDENTDETAILS;
        }

        return JumpView.LOGIN_VIEW;
    }
    //学生提交
    @RequestMapping(value="/student/studentCommit.do")
    public @ResponseBody String studentCommit(String studentIds){
        System.out.println("学生批量提交ids： "+studentIds);
        if(StringUtils.isNotBlank(studentIds)){
            List<String> list = new ArrayList<>();
            for ( String id:studentIds.split(",")
                    ) {
                list.add(id);
            }
            int i = studentService.studentCommit(list);
            System.out.println("提交结果： "+i);
            return ReturnConstants.SUCCESS;
        }
        return JumpView.LOGIN_VIEW;
    }


}
