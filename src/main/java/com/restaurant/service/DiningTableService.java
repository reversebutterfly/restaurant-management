package com.restaurant.service;

import com.restaurant.entity.DiningTable;
import java.util.List;

public interface DiningTableService {

    List<DiningTable> findAvailableTables();

    int updateStatus(DiningTable diningTable);

    DiningTable findById(Integer id);
}