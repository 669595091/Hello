package com.hjcrm.system.mapper;

import com.hjcrm.system.entity.Patter;

import java.util.List;

public interface PatterDao {//话术管理接口

    public List<Patter> queryPatter(Patter patter);

    public List<Patter> queryPattertype(Patter patter);

    public int updatePatter(Patter patter);

    public int addPatter(Patter patter);

    public int deletePatter(List<String> list);
    //共享
    public int updatePatterIsShare(Patter patter);
}
