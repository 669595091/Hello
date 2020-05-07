package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.mapper.CourseDao;
import com.hjcrm.system.service.InterCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseService")
public class CourseServiceImpl implements InterCourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> queryCourse(PageBean pageBean) {
        return courseDao.queryCourse(pageBean);
    }

    @Override
    public int queryCourseCount() {
        return courseDao.queryCourseCount();
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public int deleteCourse(List<String> list) {
        return courseDao.deleteCourse(list);
    }


    @Override
    public List<Course> queryAllCourseInfo() {
        return courseDao.queryAllCourseInfo();
    }
}
