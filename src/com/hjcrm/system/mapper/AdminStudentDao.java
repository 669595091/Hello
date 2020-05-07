package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Student;

import java.util.List;
import java.util.Map;

public interface AdminStudentDao {//行政部学生接口

    //按条件查询学员
    public List<Student> queryAdminStudent(Student student);

    public int returnStudent(Map<String,Object> map);
}
