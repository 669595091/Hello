package com.hjcrm.system.service;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Subject;

import java.util.List;

public interface InterSubjectService {

    public List<Subject> querySubject(PageBean pageBean);

    public int querySubjectCount();

    public int addSubject(Subject subject);

    public int updateSubject(Subject subject);

    public int deleteSubject(List<String> list);
}
