package com.restaurant.service.impl;

import com.restaurant.entity.DiningTable;
import com.restaurant.exception.ResourceNotFoundException;
import com.restaurant.mapper.DiningTableMapper;
import com.restaurant.service.DiningTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DiningTableServiceImpl implements DiningTableService {

    private final DiningTableMapper diningTableMapper;

    @Autowired
    public DiningTableServiceImpl(DiningTableMapper diningTableMapper) {
        this.diningTableMapper = diningTableMapper;
    }

    @Override
    public List<DiningTable> findAvailableTables() {
        return diningTableMapper.findAvailableTables();
    }

    @Override
    public int updateStatus(DiningTable diningTable) {
        return diningTableMapper.updateById(diningTable);
    }

    @Override
    public DiningTable findById(Integer id) {
        DiningTable table = diningTableMapper.selectById(id);
        if (table == null) {
            throw new ResourceNotFoundException("DiningTable", "id", id);
        }
        return table;
    }
}