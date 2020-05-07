package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Match;
import com.hjcrm.system.entity.Student;

import java.util.List;

public interface MoneyDao {//行政到账接口

    public List<Student> queryMoneyStudent(Student student);

    public List<Match> queryMatchinfo(Match match);
}
