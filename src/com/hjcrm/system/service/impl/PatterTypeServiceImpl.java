package com.hjcrm.system.service.impl;

import com.hjcrm.system.entity.PatterType;
import com.hjcrm.system.mapper.PatterTypeDao;
import com.hjcrm.system.service.InterPatterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("patterTypeService")
public class PatterTypeServiceImpl implements InterPatterTypeService {
    @Autowired
    private PatterTypeDao patterTypeDao;


    @Override
    public List<PatterType> queryPattertype() {

        return patterTypeDao.queryPattertype();
    }

    @Override
    public int updatePatterType(PatterType patterType) {
        return patterTypeDao.updatePatterType(patterType);
    }

    @Override
    public int addPatterType(PatterType patterType) {
        return patterTypeDao.addPatterType(patterType);
    }

    @Override
    public int deletepatterType(List<String> list) {
        return patterTypeDao.deletepatterType(list);
    }
}
