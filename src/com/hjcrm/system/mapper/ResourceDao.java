package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ResourceDao {//资源管理接口

    public List<Resource> queryResource(Map<String, Integer> map);

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

    public int addDealrecord(Dealrecord dealrecord);

    public int addResourceStudent(Student student);

    public List<Visitrecord> selectVisitrecord();

    public int addResourceVisitrecord(@Param("userid") Integer userid,@Param("resourceId") String resourceId,@Param("visitRecord") String visitRecord);
}
