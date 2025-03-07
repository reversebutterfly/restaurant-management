package com.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.restaurant.entity.Meal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface MealMapper extends BaseMapper<Meal> {

    @Select("SELECT COUNT(*) FROM other_table WHERE meal_name = #{mealName}")
    int countReferences(@Param("mealName") String mealName);

    @Update("UPDATE meal SET is_deleted = #{isDeleted} WHERE meal_name = #{mealName}")
    int updateDeleteStatus(@Param("mealName") String mealName, @Param("isDeleted") boolean isDeleted);

    @Select("SELECT * FROM meal WHERE meal_name = #{mealName}")
    Meal findByMealName(@Param("mealName") String mealName);
}