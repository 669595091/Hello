package com.hjcrm.system.service;

import com.hjcrm.system.entity.Match;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface InterMoneyService {
    //按条件查询销售学员
    public List<Student> queryMoneyStudent(Student student);
    //查询财务学员
    public List<Match> queryMatchinfo(Match match);
}
