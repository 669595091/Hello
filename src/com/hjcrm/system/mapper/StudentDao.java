package com.hjcrm.system.mapper;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface StudentDao {//学员管理接口

    //查询销售学生
    public List<Student> querySalesStudents(PageBean pageBean);
    //计数学生
    public int queryStudentCount();
    //添加学员
    public int addStudent(Student student);
    //提交学生
    public int studentCommit(List<String> list);

    public List<Student> queryStudentDetails(Student student);

    public List<Student> queryAdminStudents(PageBean pageBean);

    int updateStudent(Student student);
}
