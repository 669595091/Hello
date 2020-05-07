package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.Match;
import com.hjcrm.system.entity.Student;
import com.hjcrm.system.mapper.AdminStudentDao;
import com.hjcrm.system.mapper.MoneyDao;
import com.hjcrm.system.service.InterAdminStudentService;
import com.hjcrm.system.service.InterMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("moneyService")
public class MoneyServiceImpl implements InterMoneyService {

    @Autowired
    MoneyDao moneyDao;


    @Override
    public List<Student> queryMoneyStudent(Student student) {
        return moneyDao.queryMoneyStudent(student);
    }

    @Override
    public List<Match> queryMatchinfo(Match match) {
        return moneyDao.queryMatchinfo(match);
    }
}
