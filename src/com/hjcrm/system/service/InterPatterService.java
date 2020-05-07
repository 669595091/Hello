package com.hjcrm.system.service;

import com.hjcrm.system.entity.Patter;

import java.util.List;

public interface InterPatterService {
    //查询所有话术
    public List<Patter> queryPatter(Patter patter);
    public List<Patter> queryPattertype(Patter patter);

    public int updatePatter(Patter patter);

    public int addPatter(Patter patter);

    public int deletePatter(List<String> list);
    //共享
    public int updatePatterIsShare(Patter patter);
}
