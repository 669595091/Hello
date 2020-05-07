package com.hjcrm.system.service.impl;

import com.hjcrm.system.DBHelper.util.PageBean;
import com.hjcrm.system.entity.Course;
import com.hjcrm.system.entity.Patter;
import com.hjcrm.system.mapper.CourseDao;
import com.hjcrm.system.mapper.PatterDao;
import com.hjcrm.system.service.InterCourseService;
import com.hjcrm.system.service.InterPatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patterService")
public class PatterServiceImpl implements InterPatterService {

    @Autowired
    PatterDao patterDao;

    @Override
    public List<Patter> queryPatter(Patter patter) {
        return patterDao.queryPatter(patter);
    }
    @Override
    public List<Patter> queryPattertype(Patter patter) {
        return patterDao.queryPattertype(patter);
    }

    @Override
    public int updatePatter(Patter patter) {
        return patterDao.updatePatter(patter);
    }

    @Override
    public int addPatter(Patter patter) {
        return patterDao.addPatter(patter);
    }

    @Override
    public int deletePatter(List<String> list) {
        return patterDao.deletePatter(list);
    }

    @Override
    public int updatePatterIsShare(Patter patter) {
        return patterDao.updatePatterIsShare(patter);
    }
}
