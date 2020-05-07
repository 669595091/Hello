package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface InterStudentService {
    //查询销售学生
    public List<Student> querySalesStudents(PageBean pageBean);
    //计数学生
    public int queryStudentCount();
    //添加
    public int addStudent(Student student);
    //提交学生
    public int studentCommit(List<String> list);
    //查询学员详情
    public List<Student> queryStudentDetails(Student student);
    //查询行政学生
    List<Student> queryAdminStudents(PageBean pageBean);

    int updateStudent(Student student);
}
