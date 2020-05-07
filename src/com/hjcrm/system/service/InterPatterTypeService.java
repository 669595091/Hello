package com.hjcrm.system.service;

import com.hjcrm.system.entity.PatterType;

import java.util.List;

public interface InterPatterTypeService {
    //查询话术场景
    public List<PatterType> queryPattertype();

    public int updatePatterType(PatterType patterType);

    public int addPatterType(PatterType patterType);

    public int deletepatterType(List<String> list);
}
