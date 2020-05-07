package com.hjcrm.system.service;

import com.hjcrm.system.entity.*;

import java.util.List;
import java.util.Map;

public interface InterResourceService {
    //查询资源管理
    public List<Resource> queryResource(Map<String, Integer> map);
    //查询资源管理个数
    public int queryResourceCount();

    public int updateResource(Resource resource);

    public int addResource(Resource resource);

    public int deleteResources(List<String> list);

    public List<User> queryAllCreatePerson();

    public List<User> queryAllXiaoShou();

    public int updateResourceState(List list);

    public List<Resource> queryResourceBySceen(Resource resource);

    public List<Resource> querySalesResource(Map<String,Integer> map);

    public List<Resource> queryDetailsResource(int resourceId);
    //查询回访信息
    public List<Visitrecord> selectVisitrecord();
    //添加成交信息
    public int addDealrecord(Dealrecord dealrecord);
    //添加成交信息
    public int addResourceStudent(Student student);
    //添加回访信息
    public int addResourceVisitrecord(Integer userid, String resourceId, String visitRecord);
}
