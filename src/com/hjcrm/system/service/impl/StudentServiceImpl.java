package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.mapper.CourseDao;
import com.hjcrm.system.mapper.StudentDao;
import com.hjcrm.system.service.InterCourseService;
import com.hjcrm.system.service.InterStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements InterStudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> querySalesStudents(PageBean pageBean) {
        return studentDao.querySalesStudents(pageBean);
    }

    @Override
    public int queryStudentCount() {
        return studentDao.queryStudentCount();
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.addStudent(student);
    }

    @Override
    public int studentCommit(List<String> list) {
        return studentDao.studentCommit(list);
    }

    @Override
    public List<Student> queryStudentDetails(Student student) {
        return studentDao.queryStudentDetails(student);
    }

    @Override
    public List<Student> queryAdminStudents(PageBean pageBean) {
        return studentDao.queryAdminStudents(pageBean);
    }

    @Override
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }
}
