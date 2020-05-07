package com.hjcrm.system.controller;

import com.hjcrm.system.DBHelper.JumpView;
import com.hjcrm.system.DBHelper.ReturnConstants;
import com.hjcrm.system.DBHelper.UserSessionContext;
import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.service.InterCourseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private InterCourseService courseService;

    /**
     * 跳转主页面
     */
    @RequestMapping(value="/system/courseMang.do",method=RequestMethod.GET)
    public String courseMang(){
        if(UserSessionContext.getLoginUser()!=null){
            return JumpView.SYSTEM_COURSE;
        }

        return JumpView.LOGIN_VIEW;
    }
    //分页查询显示课程信息
    @RequestMapping(value="/course/queryCourse.do")
    public @ResponseBody
    String queryCourse(Integer pageSize,Integer currentPage){
        System.out.println("pagesizeCourse:"+pageSize);
        if(pageSize!=null && currentPage!=null){
            //封装分页查询实体类
            PageBean pageBean=new PageBean();
            pageBean.setPageSize(pageSize);//设置每页记录条数
            pageBean.setCurrentPage( (currentPage-1)*pageSize );//设置当前页
            //分页查询角色信息数据
            List<Course> list = courseService.queryCourse(pageBean);
            //设置返回分页数据的json字符串(pageBean的三个key：countResult,total,rows);
            int count = courseService.queryCourseCount();
            String courseJson = PageBean.jsonUserInfoToPage(list,count,currentPage);
            System.out.println("courseJson:"+courseJson);
            return courseJson;
        }else{
            List<Course> courseList = courseService.queryAllCourseInfo();
            String courseJson = PageBean.jsonToPage(courseList, null);
            return courseJson;
        }
    }

    //添加课程
    @RequestMapping(value="/course/addCourse.do")
    public @ResponseBody
    String addCourse(Course course){
        if(course!=null){
            if(course.getCourseid()==0){
                int i = courseService.addCourse(course);
                System.out.println("添加课程："+i);
                return ReturnConstants.SUCCESS;
            }else{
                int i = courseService.updateCourse(course);
                System.out.println("修改课程："+i);
                return ReturnConstants.SUCCESS;
            }

        }
        return ReturnConstants.PARAM_NULL;
    }

    //删除课程
    @RequestMapping(value = "/course/deleteCourse.do")
    public @ResponseBody String deleteCourse(String courseids) {
        System.out.println("删除课程ids： "+courseids);
        if(StringUtils.isNotBlank(courseids)){
            List<String> list = new ArrayList<>();
            for ( String id:courseids.split(",")
                    ) {
                list.add(id);
            }
            int i = courseService.deleteCourse(list);
            System.out.println("删除结果： "+i);
            return ReturnConstants.SUCCESS;
        }

        return ReturnConstants.PARAM_NULL;
    }

}
