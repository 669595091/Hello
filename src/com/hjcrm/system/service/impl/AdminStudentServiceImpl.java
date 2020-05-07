package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.Student;
import com.hjcrm.system.mapper.AdminStudentDao;
import com.hjcrm.system.mapper.StudentDao;
import com.hjcrm.system.service.InterAdminStudentService;
import com.hjcrm.system.service.InterStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminStudentService")
public class AdminStudentServiceImpl implements InterAdminStudentService {

    @Autowired
    AdminStudentDao adminStudentDao;


    @Override
    public int returnStudent(Map<String, Object> map) {
        return adminStudentDao.returnStudent(map);
    }
}
