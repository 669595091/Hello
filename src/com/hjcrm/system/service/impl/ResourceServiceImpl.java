package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.*;
import com.hjcrm.system.mapper.ResourceDao;
import com.hjcrm.system.service.InterResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("resourceService")
public class ResourceServiceImpl implements InterResourceService {
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> queryResource(Map<String, Integer> map) {
        return resourceDao.queryResource(map);
    }
    @Override
    public List<Resource> querySalesResource(Map<String, Integer> map) {
        return resourceDao.querySalesResource(map);
    }

    @Override
    public List<Resource> queryDetailsResource(int resourceId) {
        return resourceDao.queryDetailsResource(resourceId);
    }

    @Override
    public List<Visitrecord> selectVisitrecord() {
        return resourceDao.selectVisitrecord();
    }

    @Override
    public int addDealrecord(Dealrecord dealrecord) {
        return resourceDao.addDealrecord(dealrecord);
    }

    @Override
    public int addResourceStudent(Student student) {
        return resourceDao.addResourceStudent(student);
    }

    @Override
    public int addResourceVisitrecord(Integer userid, String resourceId, String visitRecord) {
        return resourceDao.addResourceVisitrecord(userid,resourceId,visitRecord);
    }

    @Override
    public int queryResourceCount() {
        return resourceDao.queryResourceCount();
    }

    @Override
    public int updateResource(Resource resource) {
        return resourceDao.updateResource(resource);
    }

    @Override
    public int addResource(Resource resource) {
        return resourceDao.addResource(resource);
    }

    @Override
    public int deleteResources(List<String> list) {
        return resourceDao.deleteResources(list);
    }

    @Override
    public List<User> queryAllCreatePerson() {
        return resourceDao.queryAllCreatePerson();
    }

    @Override
    public List<User> queryAllXiaoShou() {
        return resourceDao.queryAllXiaoShou();
    }

    @Override
    public int updateResourceState(List list) {
        return resourceDao.updateResourceState(list);
    }

    @Override
    public List<Resource> queryResourceBySceen(Resource resource) {
        return resourceDao.queryResourceBySceen(resource);
    }



}
