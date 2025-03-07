package com.restaurant.service.impl;

import com.restaurant.entity.DiningTable;
import com.restaurant.mapper.DiningTableMapper;
import com.restaurant.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningTableServiceImpl implements DiningTableService {

    @Autowired
    private DiningTableMapper diningTableMapper;

    @Override
    public List<DiningTable> findAvailableTables() {
        return diningTableMapper.findAvailableTables();
    }

    @Override
    public int updateStatus(DiningTable diningTable) {
        return diningTableMapper.updateById(diningTable);
    }
}