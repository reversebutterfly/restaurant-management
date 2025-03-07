package com.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restaurant.entity.DiningTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DiningTableMapper extends BaseMapper<DiningTable> {

    @Select("SELECT * FROM diningtable WHERE status = 0")
    List<DiningTable> findAvailableTables();
}