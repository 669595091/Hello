package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Subject;
import com.hjcrm.system.mapper.SubjectDao;
import com.hjcrm.system.service.InterSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("subjectService")
public class SubjectServiceImpl implements InterSubjectService {
    @Autowired
    private SubjectDao subjectDao;

    @Override
    public List<Subject> querySubject(PageBean pageBean) {
        return subjectDao.querySubject(pageBean);
    }

    @Override
    public int querySubjectCount() {
        return subjectDao.querySubjectCount();
    }

    @Override
    public int addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    @Override
    public int updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    @Override
    public int deleteSubject(List<String> list) {
        return subjectDao.deleteSubject(list);
    }
}
