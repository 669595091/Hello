package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;

import java.util.List;

public interface InterCourseService {
    //查询所有课程信息
    public List<Course> queryCourse(PageBean pageBean);
    //计数课程信息
    public int queryCourseCount();
    //添加课程信息
    public int addCourse(Course course);
    //修改课程
    public int updateCourse(Course course);
    //删除课程
    public int deleteCourse(List<String> list);
    //查询所属课程

    List<Course> queryAllCourseInfo();
}
