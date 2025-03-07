package com.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restaurant.entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BusinessMapper extends BaseMapper<Business> {

    @Select("SELECT * FROM business WHERE username = #{username} AND password = #{password}")
    Business login(@Param("username") String username, @Param("password") String password);
}